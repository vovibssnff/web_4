import AuthPage from "@/pages/AuthPage.vue";
import MainPage from "@/pages/MainPage.vue";
import {createRouter, createWebHistory} from "vue-router"

const routes = [
    {
        path: '/',
        component: MainPage
    },
    {
        path: '/main',
        component: MainPage
    },
    {
        path: '/login',
        component: AuthPage
    },
]

const router = createRouter({
    routes,
    history:createWebHistory(process.env.BASE_URL)
})

export default router;

