package com.boss.rbacpowermanage.security;

import com.boss.rbacpowermanage.entity.domain.UserDO;
import com.boss.rbacpowermanage.service.UserService;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义登录验证
 * @author 黄杰峰
 */
@Component
public class LoginValidateAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private UserService userService;

    @Resource
    private PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取输入表单
        String username = authentication.getName();
        String rawPassword = (String) authentication.getCredentials();

        //查询用户是否存在
        UserDO user = (UserDO) userService.loadUserByUsername(username);

        if (user.isEnabled()) {
            throw new DisabledException("该账户已被禁用，请联系管理员");

        } else if (user.isAccountNonLocked()) {
            throw new LockedException("该账号已被锁定");

        } else if (user.isAccountNonExpired()) {
            throw new AccountExpiredException("该账号已过期，请联系管理员");

        } else if (user.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException("该账户的登录凭证已过期，请重新登录");
        }

        //验证密码
        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new BadCredentialsException("输入密码错误!");
        }

        //设置权限信息
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Resource resource : user.getRole().getResources()) {
            //资源key作为权限标识
            grantedAuthorities.add(new SimpleGrantedAuthority(resource.getResourceKey()));
            user.setAuthorities(grantedAuthorities);
        }


        return new UsernamePasswordAuthenticationToken(user, rawPassword, user.getAuthorities());
    }


    @Override
    public boolean supports(Class<?> authentication) {
        //确保authentication能转成该类
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
