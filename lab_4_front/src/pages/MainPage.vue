<template>
  <div>
    <app-header />
    <div class="container">
      <div class="content">
        <input-fields />
      </div>
      <div class="content">
        <vovi-plot ref="plot" />
      </div>
    </div>
    <div class="table">
      <vovi-table ref="table" />
    </div>
  </div>
</template>

<script>
import AppHeader from "@/components/AppHeader.vue";
import InputFields from "@/components/InputFields.vue";
import VoviPlot from "@/components/VoviPlot.vue";
import VoviTable from "@/components/VoviTable.vue";

export default {
  components: {
    VoviTable,
    VoviPlot,
    InputFields,
    AppHeader
  }
};
</script>

<style scoped>
.container {
  display: flex;
}

.content {
  width: 50%;
  padding: 4%;
}

/* For screens 1259 pixels and above (desktop) */
@media only screen and (min-width: 1259px) {
  .content {
    width: 30%;
  }
}

/* For screens between 694 and 1259 pixels (tablet) */
@media only screen and (min-width: 694px) and (max-width: 1258px) {
  .container {
    flex-direction: column;
  }

  .content {
    width: 100%;
  }
}

/* For screens below 694 pixels (mobile) */
@media only screen and (max-width: 693px) {
  .content {
    width: 100%;
  }
}
</style>
