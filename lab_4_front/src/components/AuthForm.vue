<template>
  <form @submit.prevent>
    <input
      v-model.trim="usr.login"
      class="input"
      type="text"
      placeholder="login"
    />
    <input
      v-model.trim="usr.password"
      class="input"
      type="password"
      placeholder="password"
    />
    <div class="btn_container">
      <button
          class="btn"
          @click="try_register"
      >register</button>
      <button
          class="btn"
          @click="try_auth"
      >submit</button>
    </div>
  </form>
</template>

<script>
  import axios from 'axios'
  export default {
    data() {
      return {
        usr: {
          login: '',
          password: ''
        }
      }
    },
    methods: {
      try_auth() {
        if (this.check()) {
          axios.post('/api/login', {
            params: {
              login: this.usr.login,
              password: this.usr.password
            }
          }).then(res => {
            console.log(res);
          }).catch(
            err => {
              console.log(err);
            }
          );
        }
      },
      try_register() {
        if (this.check()) {
          //TODO registration
          this.usr.login='';
          this.usr.password='';
        }
      },
      check() {
        if (!this.usr.login || !this.usr.password) {
          alert("Fields can't be empty");
          return false;
        }
        return true;
      }
    }
  }
</script>

<style>

form {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 10%;
}

.btn_container {
  display: flex;
  width: 20%;
  justify-content: center;
}

.btn {
  width: 40%;
  background-color: #ff2f2f;
  color: white;
  padding: 10px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-family: "DejaVu Sans Mono", sans-serif;
  margin: 0 10px;
}

.input {
  margin-bottom: 10px;
  padding: 8px;
  width: 20%;
  font-family: "DejaVu Sans Mono", sans-serif;
}

.btn:hover {
  background-color: #ff5258;
}
</style>
