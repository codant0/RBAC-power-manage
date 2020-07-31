<template>

  <el-main>
    <el-form class="login-page" action="/test" method="post">
      <div class="form">
        <h3>账户登录</h3>
        <el-col :span="4" :push="10">
          <el-input placeholder="请输入用户名" id="username" name="username"
                    required="required" v-model="username" clearable></el-input>
          <br/> <br/>
          <el-input placeholder="请输入密码" id="password" name="password"
                    required="required" v-model="password" show-password></el-input>
          <br/> <br/>
          <el-button id="loginBtn" type="primary" @click="login" round>登录</el-button>
        </el-col>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
<!--        <div>{{username}}</div>-->
<!--        <div>{{password}}</div>-->
      </div>
    </el-form>
  </el-main>

</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      message: 'This is Login Message',
      username: '',
      password: ''
    }
  },
  methods: {
    login() {
      console.log("login");
      this.$axios({
        method: "post",
        url: "http://localhost:8081/test",
        data: {
          username: this.username,
          password: this.password
        },
        crossDomain: true,
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
        }
      })
      .then(response => {
        console.log(response, "success");
        alert("success");
      })
      .catch(error => {
        console.log(error, "error");
        alert("fail")
      })
    }
  }
}

</script>

<style scoped>

</style>
