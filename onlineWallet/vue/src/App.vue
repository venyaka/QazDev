<template>
  <div id="app">

    <h1>Online Wallet</h1>
    <router-view></router-view>
  </div>
</template><!--    <router-view></router-view>-->


<script>
import RegistrationForm from '@/components/registration-form.vue'
export default {
  name: 'Registration',
  components: {
    RegistrationForm
  },
  data: function () {
    return {
      phone: ''
    };
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
  margin-top: 60px;
}
</style>
