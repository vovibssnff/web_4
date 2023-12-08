<template>
  <app-header/>
  <input-fields/>
  <vovi-plot
    :dots="dots"
    @create="createDot"
  />
  <h1>LOL kek u succeed</h1>
</template>

<script>
import AppHeader from "@/components/AppHeader.vue";
import InputFields from "@/components/InputFields.vue";
import VoviPlot from "@/components/VoviPlot.vue";

export default {
  components: {
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

</style>