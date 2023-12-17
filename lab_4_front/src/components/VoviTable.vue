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
<!--      <tbody align="center" v-if="dots.length>0">-->
<!--      <tr v-for="dot in dots" :key="dot.id">-->
<!--          <td>{{dot.val_x}}</td>-->
<!--          <td>{{dot.val_y}}</td>-->
<!--          <td>{{dot.val_r}}</td>-->
<!--          <td>{{dot.is_inside}}</td>-->
<!--        </tr>-->
<!--      </tbody>-->
<!--      <h2 v-else>Список точек пуст</h2>-->
    </table>
  </div>
</template>

<script>

export default {
}
</script>

<style scoped>
  tr {
    font-family: "DejaVu Sans Mono", sans-serif;
  }
</style>