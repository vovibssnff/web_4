import AuthPage from "@/pages/AuthPage.vue";
import MainPage from "@/pages/MainPage.vue";
import { createRouter, createWebHistory } from "vue-router";
import store from "@/store"

const routes = [
    {
        path: '/',
        name: 'home',
        component: MainPage,
    },
    {
        path: '/main',
        name: 'main',
        component: MainPage,
    },
    {
        path: '/login',
        name: 'login',
        component: AuthPage
    }
];

const router = createRouter({
    routes,
    history: createWebHistory(process.env.BASE_URL)
});

router.beforeEach((to, from, next) => {
    console.log(to, from);
    if (to.name !== 'login' && !store.getters["dotModule/getAuthorized"]) {
        next('/login');
    } else {
        console.log("next page");
        next();
    }
});

export default router;
