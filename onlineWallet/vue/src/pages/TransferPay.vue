<template>
  <form @submit.prevent="onSubmit">
    <input type="number" placeholder="amount" v-model="amount">
    <input type="text" placeholder="your phone" v-model="receiverCard">
    <br>
    <button type="submit">Transfer money</button>
  </form>
</template>
