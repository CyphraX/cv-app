<script lang="ts">
  export let mouseX: number = 0;
  export let mouseY: number = 0;
  export let gridParallax: number = 0;
  export let bgParallax: number = 0;
  export let scrollProgress: number = 0;
</script>

<!-- Scroll Progress Bar -->
<div class="scroll-progress" style="transform: scaleX({scrollProgress})"></div>

<!-- Cursor Glow -->
<div class="cursor-glow" style="left: {mouseX}px; top: {mouseY}px;"></div>

<!-- Background Grid -->
<div class="bg-grid" style="transform: translateY({gridParallax}px)"></div>

<!-- Background Gradient -->
<div class="bg-gradient" style="transform: translateY({bgParallax}px)"></div>

<!-- Floating Particles -->
<div class="particles">
  {#each Array(20) as _, i}
    <div
      class="particle"
      style="
        left: {Math.random() * 100}%;
        top: {Math.random() * 100}%;
        animation-delay: {Math.random() * 5}s;
        animation-duration: {10 + Math.random() * 20}s;
      "
    ></div>
  {/each}
</div>

<style>
  .scroll-progress {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    height: 3px;
    background: linear-gradient(90deg, #00d9ff, #00ff88, #ff00aa);
    transform-origin: left;
    z-index: 1000;
    box-shadow: 0 0 10px rgba(0, 217, 255, 0.5);
  }

  .cursor-glow {
    position: fixed;
    width: 400px;
    height: 400px;
    background: radial-gradient(
      circle,
      rgba(0, 217, 255, 0.08) 0%,
      transparent 70%
    );
    border-radius: 50%;
    pointer-events: none;
    transform: translate(-50%, -50%);
    z-index: 0;
    transition: opacity 0.3s;
  }

  .bg-grid {
    position: fixed;
    inset: 0;
    background-image: linear-gradient(
        rgba(255, 255, 255, 0.02) 1px,
        transparent 1px
      ),
      linear-gradient(90deg, rgba(255, 255, 255, 0.02) 1px, transparent 1px);
    background-size: 50px 50px;
    z-index: -2;
  }

  .bg-gradient {
    position: fixed;
    inset: 0;
    background: radial-gradient(
        ellipse at 20% 0%,
        rgba(0, 217, 255, 0.1) 0%,
        transparent 50%
      ),
      radial-gradient(
        ellipse at 80% 100%,
        rgba(0, 255, 136, 0.08) 0%,
        transparent 50%
      );
    z-index: -1;
  }

  .particles {
    position: fixed;
    inset: 0;
    pointer-events: none;
    z-index: -1;
    overflow: hidden;
  }

  .particle {
    position: absolute;
    width: 4px;
    height: 4px;
    background: rgba(0, 217, 255, 0.3);
    border-radius: 50%;
    animation: float-particle linear infinite;
  }

  .particle:nth-child(even) {
    background: rgba(0, 255, 136, 0.3);
  }

  .particle:nth-child(3n) {
    background: rgba(255, 0, 170, 0.2);
    width: 6px;
    height: 6px;
  }

  @keyframes float-particle {
    0% {
      transform: translateY(100vh) rotate(0deg);
      opacity: 0;
    }
    10% {
      opacity: 1;
    }
    90% {
      opacity: 1;
    }
    100% {
      transform: translateY(-100vh) rotate(720deg);
      opacity: 0;
    }
  }

  @media (max-width: 768px) {
    .cursor-glow {
      display: none;
    }

    .particles {
      display: none;
    }
  }

  @media (prefers-reduced-motion: reduce) {
    .particle {
      animation: none !important;
    }
  }
</style>
