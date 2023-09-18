<template>
  <registration-form></registration-form>
  <br><br>
  <a href="#/Deposit">Deposit</a>
<!--  <a href="#/Deposit">Home</a>-->
</template>


<script>
import RegistrationForm from '@/components/registration-form.vue'
export default {
  name: 'Registration',
  components: {
    RegistrationForm
  }
}
</script>