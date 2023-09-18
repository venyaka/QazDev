import { createWebHashHistory, createRouter } from 'vue-router'
import Registration from '@/pages/Registration.vue'
import Deposit from "@/pages/Deposit.vue";

export default createRouter({
    history: createWebHashHistory(),
    routes: [
        { path: '/registration', name: 'Registration', component: Registration, alias: '/'},
        { path: '/deposit', name: 'DepositPage', component: Deposit },
    ]
})
