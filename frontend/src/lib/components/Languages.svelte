<script lang="ts">
  import { fly } from "svelte/transition";
  import Icon from "./Icon.svelte";
  import type { Language } from "../types";

  export let languages: Language[];
  export let visible: boolean = false;

  function getLevelPercent(level: string): number {
    const levelMap: Record<string, number> = {
      Muttersprache: 100,
      Verhandlungssicher: 95,
      Fließend: 85,
      "Sehr gut": 80,
      Gut: 70,
      Grundkenntnisse: 40,
    };
    return levelMap[level] || 50;
  }
</script>

<section
  id="languages"
  class="glass-card"
  class:visible
  in:fly={{ y: 30, duration: 600, delay: 600 }}
>
  <div class="section-header">
    <div class="section-icon">
      <Icon name="globe" size={24} />
    </div>
    <h2>Sprachen</h2>
  </div>
  <div class="languages-list">
    {#each languages as lang, i}
      <div
        class="language-item"
        in:fly={{ x: -20, duration: 400, delay: 700 + i * 100 }}
      >
        <div class="language-header">
          <span class="language-name">{lang.language}</span>
          <span class="language-level">{lang.level}</span>
        </div>
        <div class="language-bar">
          <div
            class="language-progress"
            class:animate={visible}
            style="--target-width: {getLevelPercent(
              lang.level
            )}%; animation-delay: {600 + i * 100}ms"
          ></div>
        </div>
        {#if lang.details}
          <p class="language-details">{lang.details}</p>
        {/if}
      </div>
    {/each}
  </div>
</section>

<style>
  .glass-card {
    background: rgba(255, 255, 255, 0.02);
    border: 1px solid rgba(255, 255, 255, 0.06);
    border-radius: 24px;
    padding: 2rem;
    margin-bottom: 1.5rem;
    backdrop-filter: blur(20px);
    transition: all 0.5s cubic-bezier(0.4, 0, 0.2, 1);
    position: relative;
    overflow: hidden;
    opacity: 0;
    transform: translateY(40px);
  }

  .glass-card.visible {
    opacity: 1;
    transform: translateY(0);
  }

  .glass-card::before {
    content: "";
    position: absolute;
    top: 0;
    left: -100%;
    right: 0;
    height: 1px;
    background: linear-gradient(
      90deg,
      transparent,
      rgba(0, 217, 255, 0.5),
      rgba(0, 255, 136, 0.5),
      transparent
    );
    animation: shimmer 3s ease-in-out infinite;
  }

  @keyframes shimmer {
    0% {
      left: -100%;
    }
    100% {
      left: 100%;
    }
  }

  .glass-card:hover {
    border-color: rgba(0, 217, 255, 0.3);
    box-shadow:
      0 8px 40px rgba(0, 0, 0, 0.3),
      0 0 60px rgba(0, 217, 255, 0.1),
      inset 0 0 60px rgba(0, 217, 255, 0.02);
    transform: translateY(-4px) scale(1.01);
  }

  .section-header {
    display: flex;
    align-items: center;
    gap: 1rem;
    margin-bottom: 1.5rem;
  }

  .section-icon {
    width: 48px;
    height: 48px;
    background: linear-gradient(
      135deg,
      rgba(0, 217, 255, 0.2),
      rgba(0, 255, 136, 0.2)
    );
    border-radius: 12px;
    display: flex;
    align-items: center;
    justify-content: center;
    color: #00d9ff;
  }

  h2 {
    font-size: 1.5rem;
    font-weight: 700;
    color: #fff;
    margin: 0;
  }

  .languages-list {
    display: grid;
    gap: 1.25rem;
  }

  .language-item {
    background: rgba(255, 255, 255, 0.02);
    border: 1px solid rgba(255, 255, 255, 0.04);
    border-radius: 12px;
    padding: 1.25rem;
    transition: all 0.3s ease;
  }

  .language-item:hover {
    background: rgba(255, 255, 255, 0.04);
    border-color: rgba(0, 217, 255, 0.2);
  }

  .language-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 0.75rem;
  }

  .language-name {
    font-size: 1rem;
    font-weight: 600;
    color: #fff;
  }

  .language-level {
    font-size: 0.8rem;
    color: #00d9ff;
    font-weight: 500;
  }

  .language-bar {
    height: 6px;
    background: rgba(255, 255, 255, 0.1);
    border-radius: 3px;
    overflow: hidden;
  }

  .language-progress {
    height: 100%;
    background: linear-gradient(90deg, #00d9ff, #00ff88);
    border-radius: 3px;
    width: 0;
    box-shadow: 0 0 10px rgba(0, 217, 255, 0.5);
  }

  .language-progress.animate {
    animation: growWidth 1s cubic-bezier(0.4, 0, 0.2, 1) forwards;
  }

  @keyframes growWidth {
    from {
      width: 0;
    }
    to {
      width: var(--target-width);
    }
  }

  .language-details {
    font-size: 0.85rem;
    color: #71717a;
    margin: 0.75rem 0 0;
    line-height: 1.5;
  }

  @media (max-width: 768px) {
    .glass-card {
      padding: 1.5rem;
      border-radius: 16px;
    }

    .language-item {
      padding: 1rem;
    }
  }
</style>
