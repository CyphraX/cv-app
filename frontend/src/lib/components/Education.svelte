<script lang="ts">
  import { fly, scale } from "svelte/transition";
  import Icon from "./Icon.svelte";
  import type { Education as EducationType } from "../types";

  export let education: EducationType[];
  export let visible: boolean = false;
</script>

<section
  id="education"
  class="glass-card"
  class:visible
  in:fly={{ y: 30, duration: 600, delay: 500 }}
>
  <div class="section-header">
    <div class="section-icon">
      <Icon name="graduation" size={24} />
    </div>
    <h2>Ausbildung</h2>
  </div>
  <div class="education-grid">
    {#each education as edu, i}
      <div
        class="education-card"
        in:fly={{ y: 20, duration: 400, delay: 600 + i * 100 }}
      >
        <div class="education-period">{edu.period}</div>
        <h3>{edu.degree}</h3>
        <p class="institution">{edu.institution}</p>
        {#if edu.field}
          <p class="field">{edu.field}</p>
        {/if}
        {#if edu.focus && edu.focus.length > 0}
          <div class="focus-tags">
            {#each edu.focus as focusItem}
              <span class="focus-tag">{focusItem}</span>
            {/each}
          </div>
        {/if}
        {#if edu.note}
          <p class="note">{edu.note}</p>
        {/if}
        {#if edu.thesis}
          <div
            class="thesis-box"
            in:scale={{ duration: 300, delay: 700 + i * 100 }}
          >
            <span class="thesis-label">Thesis</span>
            <p>{edu.thesis}</p>
          </div>
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

  .education-grid {
    display: grid;
    gap: 1.5rem;
  }

  .education-card {
    background: rgba(255, 255, 255, 0.02);
    border: 1px solid rgba(255, 255, 255, 0.04);
    border-radius: 16px;
    padding: 1.5rem;
    transition: all 0.3s ease;
  }

  .education-card:hover {
    background: rgba(255, 255, 255, 0.04);
    border-color: rgba(0, 217, 255, 0.2);
    transform: translateX(8px);
  }

  .education-period {
    font-size: 0.8rem;
    color: #00d9ff;
    font-weight: 600;
    text-transform: uppercase;
    letter-spacing: 0.05em;
    margin-bottom: 0.5rem;
  }

  .education-card h3 {
    font-size: 1.15rem;
    font-weight: 600;
    color: #fff;
    margin: 0 0 0.5rem;
  }

  .institution {
    font-size: 0.95rem;
    color: #a1a1aa;
    margin: 0 0 0.5rem;
  }

  .field {
    font-size: 0.9rem;
    color: #71717a;
    font-style: italic;
    margin: 0 0 0.75rem;
  }

  .focus-tags {
    display: flex;
    flex-wrap: wrap;
    gap: 0.5rem;
    margin-bottom: 0.75rem;
  }

  .focus-tag {
    font-size: 0.75rem;
    color: #00d9ff;
    background: rgba(0, 217, 255, 0.1);
    padding: 0.25rem 0.5rem;
    border-radius: 4px;
    border: 1px solid rgba(0, 217, 255, 0.2);
  }

  .note {
    font-size: 0.85rem;
    color: #71717a;
    margin: 0;
  }

  .thesis-box {
    background: linear-gradient(
      135deg,
      rgba(0, 255, 136, 0.05),
      rgba(0, 217, 255, 0.05)
    );
    border: 1px solid rgba(0, 255, 136, 0.15);
    border-radius: 12px;
    padding: 1rem;
    margin-top: 1rem;
  }

  .thesis-label {
    display: inline-block;
    font-size: 0.7rem;
    font-weight: 700;
    color: #00ff88;
    text-transform: uppercase;
    letter-spacing: 0.1em;
    background: rgba(0, 255, 136, 0.1);
    padding: 0.25rem 0.5rem;
    border-radius: 4px;
    margin-bottom: 0.5rem;
  }

  .thesis-box p {
    font-size: 0.9rem;
    color: #e4e4e7;
    line-height: 1.5;
    margin: 0;
  }

  @media (max-width: 768px) {
    .glass-card {
      padding: 1.5rem;
      border-radius: 16px;
    }

    .education-card {
      padding: 1.25rem;
    }
  }
</style>
