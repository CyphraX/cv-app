<script lang="ts">
  import { fade } from "svelte/transition";
</script>

<div class="loading" in:fade>
  <div class="loader">
    <div class="loader-ring"></div>
    <div class="loader-ring"></div>
    <div class="loader-ring"></div>
    <span class="loader-text">Loading</span>
  </div>
</div>

<style>
  .loading {
    display: flex;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
  }

  .loader {
    position: relative;
    width: 120px;
    height: 120px;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .loader-ring {
    position: absolute;
    border: 2px solid transparent;
    border-radius: 50%;
    animation: loader-spin 1.5s linear infinite;
  }

  .loader-ring:nth-child(1) {
    width: 100%;
    height: 100%;
    border-top-color: #00d9ff;
  }

  .loader-ring:nth-child(2) {
    width: 75%;
    height: 75%;
    border-right-color: #00ff88;
    animation-duration: 2s;
    animation-direction: reverse;
  }

  .loader-ring:nth-child(3) {
    width: 50%;
    height: 50%;
    border-bottom-color: #ff00aa;
    animation-duration: 2.5s;
  }

  .loader-text {
    font-size: 0.8rem;
    color: #888;
    text-transform: uppercase;
    letter-spacing: 2px;
  }

  @keyframes loader-spin {
    to {
      transform: rotate(360deg);
    }
  }
</style>
