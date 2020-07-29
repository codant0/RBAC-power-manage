package com.boss.rbacpowermanage.security;

import com.boss.rbacpowermanage.security.handler.LoginFailureHandler;
import com.boss.rbacpowermanage.security.handler.LoginSuccessHandler;
import com.boss.rbacpowermanage.security.handler.MyAuthenticationSuccessHandler;
import com.boss.rbacpowermanage.security.handler.PerAccessDeniedHandler;
import com.boss.rbacpowermanage.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @Author 黄杰峰
 * @Description Spring Security配置
 **/

@Configuration
@EnableWebSecurity
/**
 * 以下注解配置开启了三个注解，分别是：
 *  @PreAuthorize：方法执行前进行权限检查
 *  @PostAuthorize：方法执行后进行权限检查
 *  @Secured：类似于 @PreAuthorize
 */
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 数据源
     */
    private final DataSource dataSource;

    /**
     * 用户业务层
     */
    private final UserService userService;

    /**
     * 自定义认证
     */
    private final LoginValidateAuthenticationProvider loginValidateAuthenticationProvider;

    /**
     * 登录成功handler
     */
    private final LoginSuccessHandler loginSuccessHandler;

    /**
     * 登录失败handler
     */
    private final LoginFailureHandler loginFailureHandler;

    /**
     * 权限不足handler
     */
//    private final PerAccessDeniedHandler perAccessDeniedHandler;

//    private final MyAuthenticationSuccessHandler authenticationSuccessHandler;

    /**
     * BCrypt加密方式
     * @return
     */
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(DataSource dataSource,
                          UserService userService,
                          LoginValidateAuthenticationProvider loginValidateAuthenticationProvider,
                          LoginSuccessHandler loginSuccessHandler,
                          LoginFailureHandler loginFailureHandler,
                          PerAccessDeniedHandler perAccessDeniedHandler,
                          PasswordEncoder passwordEncoder
                          /*MyAuthenticationSuccessHandler authenticationSuccessHandler*/) {
        this.dataSource = dataSource;
        this.userService = userService;
        this.loginValidateAuthenticationProvider = loginValidateAuthenticationProvider;
        this.loginSuccessHandler = loginSuccessHandler;
//        this.authenticationSuccessHandler = authenticationSuccessHandler;
        this.loginFailureHandler = loginFailureHandler;
//        this.perAccessDeniedHandler = perAccessDeniedHandler;
        this.passwordEncoder = passwordEncoder;
    }


    /**
     * 权限核心配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //基础设置
        http/*.httpBasic()//配置HTTP基本身份验证
            .and()*/
                .authorizeRequests()
                //所有请求都需要认证
                .anyRequest().authenticated()
            .and()
                //登录表单
                .formLogin()
                //登录页面url
                .loginPage("/login")
                //登录验证url
                .loginProcessingUrl("/login")
                //成功登录跳转
                .defaultSuccessUrl("/index")
                //成功登录处理器
                .successHandler(loginSuccessHandler)
                //失败登录处理器
                .failureHandler(loginFailureHandler)
                //登录成功后有权限访问所有页面
                .permitAll()
//            .and()
//                //设置权限不足handler
//                .exceptionHandling().accessDeniedHandler(perAccessDeniedHandler)
            .and()
//                记住我功能
                .rememberMe()
                //设置用户业务层
                .userDetailsService(userService)
//                设置持久化token
                .tokenRepository(persistentTokenRepository())
//                记住登录1天(24小时 * 60分钟 * 60秒)
                .tokenValiditySeconds(24 * 60 * 60);

        //关闭csrf跨域攻击防御
        http.csrf().disable();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这里要设置自定义认证
        auth.authenticationProvider(loginValidateAuthenticationProvider);
    }




    /**
     * 记住我功能，持久化的token服务
     * @return*/

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        //数据源设置
        tokenRepository.setDataSource(dataSource);
        //启动的时候创建表，这里只执行一次，第二次就注释掉，否则每次启动都重新创建表
        //tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

}
