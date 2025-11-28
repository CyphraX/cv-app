<script lang="ts">
  import { fly } from "svelte/transition";
  import { cubicOut } from "svelte/easing";
  import Icon from "./Icon.svelte";
  import type { CvData } from "../types";

  export let data: CvData;
  export let headerParallax: number = 0;
  export let scrollY: number = 0;

  function getInitials(name: string): string {
    return name
      .split(" ")
      .map((n) => n[0])
      .join("");
  }
</script>

<header
  id="header"
  in:fly={{ y: -50, duration: 800, easing: cubicOut }}
  style="transform: translateY({headerParallax * 0.3}px); opacity: {Math.max(
    0,
    1 - scrollY / 500
  )}"
>
  <div class="header-content">
    <div class="avatar-container">
      <div class="avatar">
        <span>{getInitials(data.name)}</span>
      </div>
      <div class="status-indicator"></div>
    </div>

    <h1 class="glitch" data-text={data.name}>{data.name}</h1>

    <div class="title-wrapper">
      <p class="title">{data.title}</p>
      {#if data.subtitle}
        <span class="subtitle-arrow">→</span>
        <p class="subtitle">{data.subtitle}</p>
      {/if}
    </div>

    <div class="contact-chips">
      <a href="mailto:{data.email}" class="chip">
        <Icon name="mail" size={16} />
        {data.email}
      </a>
      <a href="https://github.com/{data.github}" target="_blank" class="chip">
        <Icon name="github" size={16} />
        {data.github}
      </a>
      <span class="chip location">
        <Icon name="location" size={16} />
        {data.location}
      </span>
    </div>
  </div>

  <div class="scroll-indicator">
    <div class="mouse">
      <div class="wheel"></div>
    </div>
    <span>Scroll</span>
  </div>
</header>

<style>
  header {
    text-align: center;
    padding: 4rem 2rem 6rem;
    position: relative;
    margin-bottom: 2rem;
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    justify-content: center;
    will-change: transform, opacity;
  }

  .header-content {
    position: relative;
  }

  .avatar-container {
    position: relative;
    display: inline-block;
    margin-bottom: 1.5rem;
  }

  .avatar {
    width: 100px;
    height: 100px;
    border-radius: 50%;
    background: linear-gradient(135deg, #00d9ff 0%, #00ff88 100%);
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 2rem;
    font-weight: 700;
    color: #0a0a0f;
    box-shadow: 0 0 40px rgba(0, 217, 255, 0.3);
    animation: avatar-pulse 3s ease-in-out infinite;
  }

  @keyframes avatar-pulse {
    0%,
    100% {
      box-shadow: 0 0 40px rgba(0, 217, 255, 0.3);
    }
    50% {
      box-shadow: 0 0 60px rgba(0, 217, 255, 0.5);
    }
  }

  .status-indicator {
    position: absolute;
    bottom: 5px;
    right: 5px;
    width: 20px;
    height: 20px;
    background: #00ff88;
    border-radius: 50%;
    border: 3px solid #0a0a0f;
    animation: status-blink 2s ease-in-out infinite;
  }

  @keyframes status-blink {
    0%,
    100% {
      opacity: 1;
    }
    50% {
      opacity: 0.5;
    }
  }

  h1 {
    font-size: clamp(2.5rem, 8vw, 4rem);
    font-weight: 800;
    background: linear-gradient(135deg, #fff 0%, #00d9ff 50%, #00ff88 100%);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    background-clip: text;
    margin-bottom: 0.5rem;
    position: relative;
  }

  .glitch {
    animation: glitch-skew 4s infinite linear alternate-reverse;
  }

  @keyframes glitch-skew {
    0%,
    100% {
      transform: skew(0deg);
    }
    20% {
      transform: skew(-0.5deg);
    }
    40% {
      transform: skew(0.5deg);
    }
    60% {
      transform: skew(-0.3deg);
    }
    80% {
      transform: skew(0.3deg);
    }
  }

  .title-wrapper {
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 0.75rem;
    flex-wrap: wrap;
    margin-bottom: 2rem;
  }

  .title {
    font-size: 1.3rem;
    color: #a1a1aa;
    font-weight: 500;
  }

  .subtitle-arrow {
    color: #00d9ff;
    animation: arrow-bounce 1s ease-in-out infinite;
  }

  @keyframes arrow-bounce {
    0%,
    100% {
      transform: translateX(0);
    }
    50% {
      transform: translateX(5px);
    }
  }

  .subtitle {
    font-size: 1.2rem;
    color: #00ff88;
    font-weight: 500;
  }

  .contact-chips {
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
    gap: 0.75rem;
  }

  .chip {
    display: inline-flex;
    align-items: center;
    gap: 0.5rem;
    padding: 0.6rem 1rem;
    background: rgba(255, 255, 255, 0.05);
    border: 1px solid rgba(255, 255, 255, 0.1);
    border-radius: 100px;
    color: #a1a1aa;
    text-decoration: none;
    font-size: 0.9rem;
    transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
  }

  .chip:hover {
    background: rgba(0, 217, 255, 0.1);
    border-color: rgba(0, 217, 255, 0.3);
    color: #00d9ff;
    transform: translateY(-2px);
    box-shadow: 0 4px 20px rgba(0, 217, 255, 0.2);
  }

  .chip :global(svg) {
    opacity: 0.7;
  }

  .chip:hover :global(svg) {
    opacity: 1;
  }

  .scroll-indicator {
    position: absolute;
    bottom: 0;
    left: 50%;
    transform: translateX(-50%);
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 0.5rem;
    color: #52525b;
    font-size: 0.75rem;
    text-transform: uppercase;
    letter-spacing: 2px;
    animation: scroll-bounce 2s ease-in-out infinite;
  }

  @keyframes scroll-bounce {
    0%,
    100% {
      transform: translateX(-50%) translateY(0);
    }
    50% {
      transform: translateX(-50%) translateY(10px);
    }
  }

  .mouse {
    width: 24px;
    height: 38px;
    border: 2px solid #52525b;
    border-radius: 12px;
    position: relative;
  }

  .wheel {
    width: 4px;
    height: 8px;
    background: #00d9ff;
    border-radius: 2px;
    position: absolute;
    top: 6px;
    left: 50%;
    transform: translateX(-50%);
    animation: wheel-scroll 1.5s ease-in-out infinite;
  }

  @keyframes wheel-scroll {
    0%,
    100% {
      opacity: 1;
      top: 6px;
    }
    50% {
      opacity: 0.3;
      top: 16px;
    }
  }

  @media (max-width: 768px) {
    header {
      padding: 2rem 1rem 4rem;
      min-height: auto;
      padding-top: 15vh;
      padding-bottom: 10vh;
    }

    .avatar {
      width: 80px;
      height: 80px;
      font-size: 1.5rem;
    }
  }

  @media (max-width: 480px) {
    .title-wrapper {
      flex-direction: column;
      gap: 0.25rem;
    }

    .subtitle-arrow {
      display: none;
    }

    .contact-chips {
      flex-direction: column;
    }

    .chip {
      width: 100%;
      justify-content: center;
    }
  }

  @media (prefers-reduced-motion: reduce) {
    .avatar,
    .status-indicator,
    .glitch,
    .wheel,
    .scroll-indicator {
      animation: none !important;
    }
  }
</style>
