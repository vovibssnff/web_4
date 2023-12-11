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
  import router from "@/router/router";
  export default {
    data() {
      return {
        usr: {
          login: '',
          password: '',
          authorized: false
        }
      }
    },
    methods: {
      try_auth() {
        if (this.check()) {
          axios.post('/api/login', {
            login: this.usr.login,
            password: this.usr.password
          }).then(res => {
            if (res.data==="ok") {
              router.push("/main");
            }
            console.log(res.data);
          }).catch(
            err => {
              console.log(err);
            }
          );
        }
      },
      try_register() {
        if (this.check()) {
          axios.post('/api/register', {
            login: this.usr.login,
            password: this.usr.password
          }).then(res => {
            if (res.data==="ok") {
              alert("Registration successful, now u can log in!");
            } else {
              alert("Registration failed, username " + this.usr.login + " is already taken");
            }
          }).catch(
            err => {
              console.log(err);
            }
          );
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
