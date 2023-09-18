import { createApp } from 'vue'
import { createStore } from 'vuex'
import App from './App.vue'
import router from './router'
import VueCookies from 'vue-cookies';

const app = createApp(App)
app.use(VueCookies)
app.use(router)

const store = createStore({
    state: {
        user: null,
        userId: null
    },
    mutations: {
        setUser(state, user) {
            state.user = user;
            console.log("User set in store");
        },
        setUserId(state, userId) {
            state.userId = userId;
            localStorage.setItem('token', userId);
            console.log("User ID set in store");
        }
    },
    getters: {
        getUser: state => {
            console.log('Retrieving user...')
            return state.user;
        },
        getUserId: state => {
            console.log('Retrieving user...')
            return state.userId;
        }
    },
    actions: {
        async login(store, credentials) {
            store.commit('setUserId', credentials.userId);
            localStorage.setItem('token', credentials.userId);
            return false;
        },
    },
});
    
// We can chain use() functions, so our app is now using a router and our Vuex store
app.use(router).use(store).mount('#app')