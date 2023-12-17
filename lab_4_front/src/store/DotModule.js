
import axios from "axios";

const state = {
    dots: [],
    isAuthorized: false,
    dot: {
        id: Date.now(),
        current_x: '',
        current_y: '',
        current_r: '',
    }
}
const getters = {
    getDots: (state) => state.dots,
    getDot: (state) => state.dot,
    getCurrentX: (state) => state.dot.current_x,
    getCurrentY: (state) => state.dot.current_y,
    getCurrentR: (state) => state.dot.current_r
}

const mutations = {
    setDots(state, dots) {
        state.dots = dots
    },
    setAuthorized(state, authorized) {
        state.isAuthorized = authorized
    },
    setCurrentX(state, x) {
        state.dot.current_x = x
    },
    setCurrentY(state, y) {
        state.dot.current_y = y
    },
    setCurrentR(state, r) {
        state.dot.current_r = r
    },

}
const actions = {
    fetchDots({state}) {
        axios.get('/dots/fetch')
            .then(res=> {
                state.dots = res.data;
            })
            .catch(error => {
                alert("Error fetching dots: " + error);
            });
    }
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}
