<template>
  <div id="result-table-container" align="center">
    <table id="result-table">
      <thead>
      <tr>
        <th>X</th>
        <th>Y</th>
        <th>R</th>
        <th>Result</th>
      </tr>
      </thead>
      <tbody align="center">
      <tr v-for="dot in this.dots" :key="dot.id">
        <td>{{ dot.x }}</td>
        <td>{{ dot.y }}</td>
        <td>{{ dot.r }}</td>
        <td>{{ dot.inside }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import {mapActions, mapGetters} from "vuex";

export default {
  computed: {
    ...mapGetters('dotModule', ['getDots']),
    dots() {
      return this.getDots;
    }
  },
  methods: {
    ...mapActions('dotModule', ['fetchDots']),
  },
  mounted() {
    this.fetchDots();
  }
}
</script>

<style scoped>
tr {
  font-family: "DejaVu Sans Mono", sans-serif;
}
</style>
