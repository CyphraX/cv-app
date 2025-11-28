<script lang="ts">
  import { fly } from "svelte/transition";
  import Icon from "./Icon.svelte";

  export let qualifications: string[];
  export let visible: boolean = false;
</script>

<section
  id="qualifications"
  class="glass-card"
  class:visible
  in:fly={{ y: 30, duration: 600, delay: 700 }}
>
  <div class="section-header">
    <div class="section-icon">
      <Icon name="star" size={24} />
    </div>
    <h2>Zusatzqualifikationen</h2>
  </div>
  <ul class="qualifications-list">
    {#each qualifications as qual, i}
      <li in:fly={{ x: -20, duration: 400, delay: 800 + i * 80 }}>
        <span class="qual-icon">✦</span>
        <span>{qual}</span>
      </li>
    {/each}
  </ul>
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

  .qualifications-list {
    list-style: none;
    margin: 0;
    padding: 0;
    display: grid;
    gap: 0.75rem;
  }

  .qualifications-list li {
    display: flex;
    align-items: center;
    gap: 0.75rem;
    padding: 0.75rem 1rem;
    background: rgba(255, 255, 255, 0.02);
    border: 1px solid rgba(255, 255, 255, 0.04);
    border-radius: 10px;
    transition: all 0.3s ease;
  }

  .qualifications-list li:hover {
    background: rgba(255, 255, 255, 0.04);
    border-color: rgba(0, 217, 255, 0.2);
    transform: translateX(8px);
  }

  .qual-icon {
    color: #00ff88;
    font-size: 0.9rem;
    flex-shrink: 0;
  }

  .qualifications-list li span:last-child {
    color: #a1a1aa;
    font-size: 0.95rem;
    line-height: 1.5;
  }

  @media (max-width: 768px) {
    .glass-card {
      padding: 1.5rem;
      border-radius: 16px;
    }

    .qualifications-list li {
      padding: 0.6rem 0.8rem;
    }
  }
</style>
