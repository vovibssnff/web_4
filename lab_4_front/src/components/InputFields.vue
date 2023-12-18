<template>
  <form @submit.prevent>
    <div>X: {{currentX}}</div>
    <select
      class="input"
      v-model="currentX"
    >
      <option disabled value="">Please select one</option>
      <option>-2</option>
      <option>-1,5</option>
      <option>-1</option>
      <option>-0,5</option>
      <option>-0</option>
      <option>0,5</option>
      <option>1</option>
      <option>1,5</option>
      <option>2</option>
    </select>

    <p>Y: {{currentY}}</p>
    <input
      class="input"
      v-model="currentY"
      placeholder="(-5;5)"
    />

    <div>R: {{currentR}}</div>
    <select
      class="input"
      v-model="currentR"
    >
      <option disabled value="">Please select one</option>
      <option>-2</option>
      <option>-1,5</option>
      <option>-1</option>
      <option>-0,5</option>
      <option>-0</option>
      <option>0,5</option>
      <option>1</option>
      <option>1,5</option>
      <option>2</option>
    </select>

    <button
        class="btn"
        @click="send"
    >send</button>
  </form>
</template>

<script>
import axios from "axios";
import {mapActions, mapGetters, mapMutations} from "vuex";

export default {
  computed: {
    ...mapGetters('dotModule', ['getCurrentX', 'getCurrentY', 'getCurrentR', 'getDots']),
    currentX: {
      get() {
        return this.getCurrentX;
      },
      set(val) {
        this.$store.commit('dotModule/setCurrentX', val);
      }
    },
    currentY: {
      get() {
        return this.getCurrentY;
      },
      set(val) {
        this.$store.commit('dotModule/setCurrentY', val);
      }
    },
    currentR: {
      get() {
        return this.getCurrentR;
      },
      set(val) {
        this.$store.commit('dotModule/setCurrentR', val);
      }
    },
    dots: {
      get() {
        return this.getDots;
      },
      set(val) {
        this.$store.commit('dotModule/setDots', val);
      }
    }
  },
  methods: {
    ...mapActions('dotModule', ['fetchDots']),
    ...mapMutations('dotModule', ['setCurrentX', 'setCurrentY', 'setCurrentR', 'setDots']),
    send() {
      if (this.check()) {
        axios.post('/dots/check', {
          x: this.getCurrentX.replace(',', '.'),
          y: this.getCurrentY.replace(',', '.'),
          r: this.getCurrentR.replace(',', '.')
        }).then(res => {
            console.log(res);
            this.fetchDots();
          }
        );
        // this.$emit('fetchDotsSignal');
      }
    },
    check() {
      if (!this.getCurrentX || !this.getCurrentY || !this.getCurrentR) {
        alert("Please, set all fields");
        return false;
      }
      return true;
    }
  }
}
</script>


<style scoped>
  .input {
    padding: 8px;
    width: 50%;
    font-family: "DejaVu Sans Mono", sans-serif;
  }
</style>