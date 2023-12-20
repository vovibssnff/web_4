<template>
  <div>
    <app-header />
    <auth-form />
  </div>
</template>

<script>
import AppHeader from "@/components/AppHeader.vue";
import AuthForm from "@/components/AuthForm.vue";

export default {
  components: {
    AppHeader,
    AuthForm
  }
};
</script>

<style scoped>
/* For screens 1259 pixels and above (desktop) */
@media only screen and (min-width: 1259px) {
  .app-header {
    font-size: 24px;
  }

  .auth-form {
    width: 50%;
    margin: 0 auto;
  }
}

/* For screens between 694 and 1259 pixels (tablet) */
@media only screen and (min-width: 694px) and (max-width: 1258px) {
  .app-header {
    font-size: 20px;
  }

  .auth-form {
    width: 70%;
    margin: 0 auto;
  }
}

/* For screens below 694 pixels (mobile) */
@media only screen and (max-width: 693px) {
  .app-header {
    font-size: 18px;
  }

  .auth-form {
    width: 90%;
    margin: 0 auto;
  }
}
</style>
