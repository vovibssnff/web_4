<template>
  <form @submit.prevent>
    <div>X: {{ dot.val_x }}</div>
    <select
      v-model.trim="dot.val_x"
      class="input"
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

    <p>Y: {{ dot.val_y }}</p>
    <input
      v-model="dot.val_y"
      class="input"
      placeholder="(-5;5)"
    />

    <div>R: {{ dot.val_r }}</div>
    <select
      v-model="dot.val_r"
      class="input"
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

  export default {
    data() {
      return {
        dot: {
          val_x: '',
          val_y: '',
          val_r: ''
        }
      }
    },
    methods: {
      send() {
        if (this.check()) {
          axios.post('/dots/get_res', {
            x: this.dot.val_x,
            y: this.dot.val_y,
            z: this.dot.val_r
          }).then(res => {
            if (res.data==="ok") {
              //TODO рисуем точку
              //TODO эмитим фетч в таблице
              this.$emit('create', this.dot);
              this.dot.val_x = '';
              this.dot.val_y = '';
              this.dot.val_r = '';
            }

          });
        }
      },
      check() {
        if (!this.dot.val_x || !this.dot.val_y || !this.dot.val_r) {
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
    //margin-bottom: 10px;
    padding: 8px;
    width: 50%;
    font-family: "DejaVu Sans Mono", sans-serif;
  }
</style>