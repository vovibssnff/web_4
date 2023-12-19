import {createStore} from "vuex";
import dotModule from "@/store/DotModule";
import createPersistedState from "vuex-plugin-persistedstate";

export default createStore({
    modules: {
        dotModule
    },
    plugins: [createPersistedState]
});
