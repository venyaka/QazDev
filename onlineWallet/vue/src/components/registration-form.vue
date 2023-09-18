<template>
  <form @submit.prevent="onSubmit" v-if="openRegister">
    <p>{{errorMessage}}</p>
    <input type="text" placeholder="your phone" v-model="phone">
    <br><br>
    <button type="submit">Save</button>
  </form>
  <form @submit.prevent="onSubmitConfirm" v-if="openConfirm">
    <p>{{errorMessage}}</p>
    <input minlength="3" maxlength="4" type="number" placeholder="authorization code" v-model="code">
    <br><br>
    <button type="submit">Submit</button>
  </form>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      phone: '',
      code: '',
      errorMessage: '',
      openRegister: true,
      openConfirm: false,
    }
  },
  methods: {
    onSubmit(e) {
      const article = {phone: this.phone};

      console.log('Отправка JSON данных', article)
      axios.post(`http://localhost:8080/sign-in`, article)
          .then((response) => {
                console.log('Ответ сервера', response.data);
                if (!response.data.ok) {
                  this.errorMessage = "Uncorrected phone number";
                } else {
                  this.errorMessage = " ";
                  this.openConfirm = true;
                  this.openRegister = false;
                }
              },
              (error) => {
                console.error(error);
                this.errorMessage = error.message;
                this.phone = '';
              }
          )
          .catch(error => {
            console.log('ОШИБКА БЛИН');
            console.error("There was an error!", error);
            this.phone = '';
          });
    },

    onSubmitConfirm(e) {
      const article = {phone: this.phone, code: this.code};

      console.log('Отправка JSON данных', article)
      axios.post(`http://localhost:8080/confirm-sign-in`, article)
          .then((response) => {

              console.log('Ответ сервера', response.data);
              // console.log("Cookie in response", response.headers)
              const token = response.data.token//this.$cookies.get("token")
              console.log("token: ", token)
                if (token == null) {
                  this.errorMessage = "Uncorrected code";
                  this.code = '';
                } else {
                  this.errorMessage = "Done!";
                  // localStorage.setItem('token', response.data.token);
                  this.$cookies.set("token", token, "1h")
                  // this.$store.dispatch('login', {userId: response.data.token})
                  console.log("cookie token in vue: ", token)
                  this.phone = '';
                  this.code = '';
                }
              },
              (error) => {
                console.error("Кароче у тебя ошибка на стороне сервера:", error);
                this.errorMessage = error.message;
              }
          )
          .catch(error => {
            console.error("Кароче у тебя ошибка в запросе:", error);
          });

      // this.$router.push('/');
      // location.reload();
    },
  }
}
</script>