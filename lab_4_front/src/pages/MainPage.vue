<template>
  <app-header/>
  <div class="container">
    <div class="content">
      <input-fields/>
    </div>
    <div class="content">
      <vovi-plot
        :dots="dots"
        @create="createDot"
      />
    </div>
  </div>
  <vovi-table/>
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
  },
  data() {
    return {
      // dot: {
      //   val_x: '',
      //   val_y: '',
      //   val_r: '',
      //   xPlot: '',
      //   yPlot: '',
      // },
      dots: []
    }
  },
  methods: {
    createDot(dot) {
      console.log(dot);
    }
  }
}
</script>

<style scoped>
  .container {
    display: flex;
  }

  .content {
    width: 50%;
    padding: 4%;
  }
</style>