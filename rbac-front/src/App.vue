<template>
  <div id="app">
    <Manage></Manage>
    <div id="nav">
      <router-link to="/">Login</router-link> |
      <router-link to="/about">About</router-link> |
      <router-link to="/index">Index</router-link>
    </div>
    <router-view/>
  </div>
</template>

<script>
  import Manage from "./components/Manage";

  export default {
    components: {
      Manage
    }
  }
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
