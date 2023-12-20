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
        <path
            id="circle"
            fill="red"
            fill-opacity="0.2"
            stroke="red"
            :d="computeCircle"
        ></path>


        <!-- Вторая фигура (2 четверть) -->
        <polygon id="rectangle"
                 fill="red"
                 fill-opacity="0.2"
                 stroke="red"
                 :points="computeRectanglePoints"></polygon>

        <!-- Третья фигура (4 четверть) -->
        <polygon id="triangle"
                 fill="red"
                 fill-opacity="0.2"
                 stroke="red"
                 :points="computeTriangle"></polygon>

        <!-- Точки на графике -->
        <circle
            v-for="dot in dots"
            :key="dot.id"
            :r="dot.inside === true ? 4.5 : 3.5"
            :cx="computeCX(dot)"
            :cy="computeCY(dot)"
            :fill="computeFill(dot)"
            :opacity="computeOpacity(dot)"
        />
      </svg>
    </div>
  </div>
</template>

<script>
import {mapGetters, mapMutations} from "vuex";

export default {
  computed: {
    ...mapGetters('dotModule', ['getDots', 'getDot', 'getCurrentR']),
    currentX: {
      get() {
        return this.getCurrentX;
      },
      set(val) {
        this.$store.commit('dotModule/setCurrentX', val);
      }
    },
    currentY: {
      get() {
        return this.getCurrentY;
      },
      set(val) {
        this.$store.commit('dotModule/setCurrentY', val);
      }
    },
    currentR: {
      get() {
        return this.getCurrentR;
      },
      set(val) {
        this.$store.commit('dotModule/setCurrentR', val);
      }
    },
    computeCircle() {
      return `M ${150 + 50 * this.currentR} 150 A ${this.currentR * 50} ${this.currentR * 50}, 0, 0, 0, ${150} ${150 - 50 * this.currentR} L 150 150 Z`;
    },
    computeRectanglePoints() {
      return `${150 - 50 * this.currentR}, ${150 - 100 * this.currentR} ${150}, ${150 - 100 * this.currentR} ${150}, 150 ${150 - 50 * this.currentR}, 150`;
    },
    computeTriangle() {
      return `150,150 ${150+50*this.currentR},150 150,${150+50*this.currentR}`;
    },
    dots: {
      get() {
        return this.getDots;
      }
    },
    dot: {
      get() {
        return this.getDot;
      }
    }
  },
  methods: {
    ...mapMutations('dotModule', ['setCurrentX', 'setCurrentY', 'setCurrentR']),
    computeCX(dot) {
      console.log("omg");
      return dot.x/5*500+150;
    },
    computeCY(dot) {
      return 150 - dot.y / 5 * 500;
    },
    computeFill(dot) {
      return dot.r === this.currentR ? (dot.inside === true ? 'green' : 'red') : 'black';
    },
    computeOpacity(dot) {
      return (this.dot.r - 0.5 < dot.r) && (this.dot.r + 0.5 > dot.r) ? 0.5 : 0.1;
    },
    validateFromGraph(event) {
      let position = getMousePosition(document.getElementById("graph"), event);  // Pass the event parameter
      this.currentX = (Math.round((position.x - 150) / 100 * this.currentR * 2) / 2).toFixed(1);
      this.currentY = ((150 - position.y) / 100 * this.currentR).toFixed(2);
      if (!this.check()) {
        alert("invalid input");
      }

      function getMousePosition(element, event) {
        let rect = element.getBoundingClientRect();
        return {
          x: event.clientX - rect.left,
          y: event.clientY - rect.top
        };
      }
    },

    check() {
      if (!this.currentX || !this.currentY || !this.currentR) {
        alert("Please, set all fields");
        return false;
      }
      return true;
    }
  }
}
</script>

<style scoped>

  .svg-wrapper{
    background-color: white;
    border: 2px solid #ff5258;
    box-shadow: 0 0 5px 0 #ff5258;
    border-radius: 20%;
    padding: 15px;
    margin-bottom: 10px;
  }
</style>