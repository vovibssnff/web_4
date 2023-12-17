<template>
  <div class="graph">
    <div class="svg-wrapper">
      <svg height="300" width="300" xmlns="http://www.w3.org/2000/svg" id="graph" @click="validateFromGraph">
        <!-- Стерлки и оси -->
        <line stroke="black" x1="0" x2="300" y1="150" y2="150"></line>
        <line stroke="black" x1="150" x2="150" y1="0" y2="300"></line>
        <polygon fill="black" points="150,0 144,15 156,15" stroke="black"></polygon>
        <polygon fill="black" points="300,150 285,156 285,144" stroke="black"></polygon>

        <!-- Деления -->
        <line stroke="black" x1="200" x2="200" y1="155" y2="145"></line>
        <line stroke="black" x1="250" x2="250" y1="155" y2="145"></line>

        <line stroke="black" x1="50" x2="50" y1="155" y2="145"></line>
        <line stroke="black" x1="100" x2="100" y1="155" y2="145"></line>

        <line stroke="black" x1="145" x2="155" y1="100" y2="100"></line>
        <line stroke="black" x1="145" x2="155" y1="50" y2="50"></line>

        <line stroke="black" x1="145" x2="155" y1="200" y2="200"></line>
        <line stroke="black" x1="145" x2="155" y1="250" y2="250"></line>

        <!-- Подписи к осям -->
        <text fill="black" x="285" y="140">X</text>
        <text fill="black" x="160" y="15">Y</text>

        <!-- Первая фигура (1 четверть) -->
        <path id="circle"
              fill="blue"
              fill-opacity="0.2"
              stroke="blue"
              d="M 200 150 A 50 50, 90, 0, 0, 150 100 L 150 150 Z"></path>

        <!-- Вторая фигура (2 четверть) -->
        <polygon id="rectangle"
                 fill="blue"
                 fill-opacity="0.2"
                 stroke="blue"
                 points="100,50 100,150 150,150 150,50"></polygon>

        <!-- Третья фигура (4 четверть) -->
        <polygon id="triangle"
                 fill="blue"
                 fill-opacity="0.2"
                 stroke="blue"
                 points="150,150 250,150 150,200"></polygon>
        <!-- Точки на графике -->
      </svg>
    </div>
  </div>
</template>

<script>
import {mapGetters} from "vuex";

export default {
  computed: {
    ...mapGetters('dotModule', [
      'getDots',
      'getDot'
    ]),
    dots() {
      return this.getDots;
    },
    dot() {
      return this.getDot;
    }
  },
  methods: {
    // loadDots(){
    //   this.$axios.get("http://localhost:8890/api/point", {
    //     headers: {Authorization: "Bearer " + localStorage.getItem("jwt")}
    //   }).then(response => {
    //     this.dots = response.data;
    //     this.drawDots();
    //   }).catch(() => {
    //     this.AxiosErrorHandler("Точки не удалось загрузить");
    //   });
    // },
    drawDots(){
      let r = this.$store.getters.dot().current_r;
      let svg = document.getElementById("graph")
      let oldDots = document.querySelectorAll("circle");
      oldDots.forEach(oldDot => oldDot.parentNode.removeChild(oldDot));

      if(this.dots.length !== 0){
        this.dots.forEach(dot => {
          let newDot = document.createElementNS("http://www.w3.org/2000/svg", "circle");
          newDot.setAttribute("id", "target-dot");
          newDot.setAttribute("r", "3.5");
          if (r >= 0) {
            newDot.setAttribute("cx", `${dot.x / 5 * 100 + 150}`);
            newDot.setAttribute("cy", `${150 - dot.y / 5 * 100}`);
          } else {
            newDot.setAttribute("cx", `${(-1.8 * dot.x) / 5 * 100 + 150}`);
            newDot.setAttribute("cy", `${150 - (-1.8 * dot.y) / 5 * 100}`);
          }
          if (dot.r == r) {
            newDot.setAttribute("fill", dot.result === true ? "green" : "red");
            newDot.setAttribute("r", "4.5");
          } else {
            newDot.setAttribute("fill", "black");
            newDot.setAttribute("opacity", `${((r - 0.5 < dot.r) && (r + 0.5 > dot.r)) ? "0.5" : "0.1"}`);
          }
          svg.appendChild(newDot);
        })
      }
    },
  }
}
</script>

<style scoped>
  .svg-wrapper{
    margin-top: 7%;
    background-color: white;
    border: 2px solid #ff5258;
    box-shadow: 0 0 5px 0 #ff5258;
    padding: 15px;
    margin-bottom: 10px;
    width: 40%
  }
</style>