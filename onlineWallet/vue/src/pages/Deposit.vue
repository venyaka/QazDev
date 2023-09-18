<template>
  <div>
    <form @submit.prevent="onSubmit" v-if="token != null">
      <input type="number" placeholder="amount" v-model="amount">
      <br>
      <input type="number" placeholder="phone" v-model="phone">
      <br>
      <input type="text" placeholder="Description" v-model="description">
      <br>
      <button type="submit">Open bank page</button>
    </form>
    <div v-if="token == null">
      <p>Вы не зарегестрированы!</p>
      <a href="http://localhost:8081/#/Registration">На страницу регистрации</a>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { epayParams } from '@/config/epayParams.js';

export default {
  data() {
    return {
      amount: '',
      phone: '',
      description: '',
      token: this.$cookies.get("token"), //this.$store.getters.getUserId,
    }
  },
  methods: {
    async onSubmit(e) {
      const token = this.token
      console.log(token)
      if (this.token == null) {
        return console.error("User is not authorize");
      }

      console.log('Getting auth')
      console.log("UserId: ", token)

      let invoiceId = Math.floor(1000000000 + Math.random() * 9999999999 - 100000000);
      console.log("invoiceId: ", invoiceId)
      let createPaymentObject = function(auth, invoiceId, amount) {
        let paymentObject = {
          invoiceId: invoiceId,
          invoiceIdAlt: epayParams.invoiceIdAlt,
          backLink: epayParams.backLink,
          failureBackLink: epayParams.failureBackLink,
          postLink: epayParams.postLink,
          failurePostLink: epayParams.failureBackLink,
          language: epayParams.language,
          description: epayParams.description,
          accountId: epayParams.accountId,
          terminal: epayParams.terminal,
          amount: amount,
          data: "THIS is data",
          currency: epayParams.currency,
          phone: epayParams.phone,//this.phone,
          email: epayParams.email,
          cardSave: true //Параметр должен передаваться как Boolean
        };
        paymentObject.auth = auth;
        return paymentObject;
      };

      const formData = new FormData();

      formData.append('grant_type', epayParams.grant_type);
      formData.append('scope', epayParams.scope);
      formData.append('client_id', epayParams.client_id);
      formData.append('client_secret', epayParams.client_secret);
      formData.append('invoiceID', invoiceId);
      formData.append('amount', this.amount);
      formData.append('currency', epayParams.currency);
      formData.append('terminal', epayParams.terminal);
      formData.append('postLink', epayParams.postLink);
      formData.append('failurePostLink', epayParams.failurePostLink);

      await axios.post(epayParams.AUTH_TEST_URL, formData)
          .then((response) => {
                console.log('Ответ сервера', response.data);
                // console.log(response);
                if (response) {
                  halyk.pay(createPaymentObject(response.data, invoiceId, this.amount));
                }
              },
              (error) => {
                console.log('ОШИБКА В ЗАПРОСЕ');
                console.error(error);
                this.errorMessage = error.message;
              }
          )
          .catch(error => {
            console.log('ОШИБКА ОТПРАВКИ ЗАПРОСА');
            console.error("There was an error!", error);
          });

      // this.phone = '';
    }

  }
}
</script>
