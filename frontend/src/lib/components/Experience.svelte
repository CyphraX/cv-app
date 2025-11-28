<script lang="ts">
  import { fly, slide, scale } from "svelte/transition";
  import Icon from "./Icon.svelte";
  import type { Experience as ExperienceType } from "../types";

  export let experience: ExperienceType[];
  export let visible: boolean = false;

  let expandedExperience: number | null = null;

  function toggleExperience(index: number) {
    expandedExperience = expandedExperience === index ? null : index;
  }
</script>

<section
  id="experience"
  class="glass-card"
  class:visible
  in:fly={{ y: 30, duration: 600, delay: 400 }}
>
  <div class="section-header">
    <div class="section-icon">
      <Icon name="briefcase" size={24} />
    </div>
    <h2>Berufserfahrung</h2>
  </div>
  <div class="timeline">
    {#each experience as exp, i}
      <div
        class="timeline-item"
        class:expanded={expandedExperience === i}
        in:fly={{ x: -30, duration: 500, delay: 500 + i * 150 }}
      >
        <div class="timeline-marker">
          <div class="marker-dot"></div>
          <div class="marker-line"></div>
        </div>
        <div
          class="timeline-content"
          on:click={() => toggleExperience(i)}
          on:keydown={(e) => e.key === "Enter" && toggleExperience(i)}
          role="button"
          tabindex="0"
        >
          <div class="timeline-header">
            <div class="timeline-meta">
              <span class="timeline-date">{exp.period}</span>
              <span class="timeline-company">{exp.company}</span>
              {#if exp.type}
                <span class="timeline-type">{exp.type}</span>
              {/if}
            </div>
            <div class="expand-icon" class:rotated={expandedExperience === i}>
              <Icon name="chevron-down" size={20} />
            </div>
          </div>
          <h3>{exp.role}</h3>

          {#if expandedExperience === i}
            <div class="exp-details" transition:slide={{ duration: 300 }}>
              {#if exp.description}
                <p class="exp-description">{exp.description}</p>
              {/if}
              {#if exp.highlights && exp.highlights.length > 0}
                <ul class="highlights">
                  {#each exp.highlights as highlight}
                    <li>{highlight}</li>
                  {/each}
                </ul>
              {/if}
              {#if exp.leadership && exp.leadership.length > 0}
                <div
                  class="leadership"
                  in:scale={{ duration: 300, delay: 100 }}
                >
                  <div class="leadership-header">
                    <Icon name="users" size={16} />
                    <span>Führung & Teams</span>
                  </div>
                  <ul>
                    {#each exp.leadership as item}
                      <li>{item}</li>
                    {/each}
                  </ul>
                </div>
              {/if}
            </div>
          {/if}
        </div>
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

  .timeline {
    position: relative;
    padding-left: 0;
  }

  .timeline-item {
    display: flex;
    gap: 1.5rem;
    margin-bottom: 1.5rem;
    position: relative;
  }

  .timeline-item:last-child {
    margin-bottom: 0;
  }

  .timeline-marker {
    display: flex;
    flex-direction: column;
    align-items: center;
    flex-shrink: 0;
    padding-top: 0.5rem;
  }

  .marker-dot {
    width: 14px;
    height: 14px;
    background: linear-gradient(135deg, #00d9ff, #00ff88);
    border-radius: 50%;
    box-shadow: 0 0 20px rgba(0, 217, 255, 0.5);
    z-index: 1;
    transition: all 0.3s ease;
  }

  .timeline-item:hover .marker-dot {
    transform: scale(1.3);
    box-shadow: 0 0 30px rgba(0, 217, 255, 0.7);
  }

  .timeline-item.expanded .marker-dot {
    transform: scale(1.4);
    background: linear-gradient(135deg, #00ff88, #00d9ff);
  }

  .marker-line {
    width: 2px;
    flex: 1;
    background: linear-gradient(
      to bottom,
      rgba(0, 217, 255, 0.3),
      rgba(0, 217, 255, 0.05)
    );
    margin-top: 0.5rem;
  }

  .timeline-item:last-child .marker-line {
    display: none;
  }

  .timeline-content {
    flex: 1;
    background: rgba(255, 255, 255, 0.02);
    border: 1px solid rgba(255, 255, 255, 0.04);
    border-radius: 16px;
    padding: 1.25rem;
    cursor: pointer;
    transition: all 0.3s ease;
  }

  .timeline-content:hover {
    background: rgba(255, 255, 255, 0.04);
    border-color: rgba(0, 217, 255, 0.2);
  }

  .timeline-item.expanded .timeline-content {
    border-color: rgba(0, 217, 255, 0.3);
    box-shadow: 0 4px 20px rgba(0, 217, 255, 0.1);
  }

  .timeline-header {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    margin-bottom: 0.5rem;
  }

  .timeline-meta {
    display: flex;
    flex-direction: column;
    gap: 0.25rem;
  }

  .timeline-date {
    font-size: 0.8rem;
    color: #00d9ff;
    font-weight: 600;
    text-transform: uppercase;
    letter-spacing: 0.05em;
  }

  .timeline-company {
    font-size: 0.85rem;
    color: #71717a;
  }

  .expand-icon {
    color: #71717a;
    transition:
      transform 0.3s ease,
      color 0.3s ease;
  }

  .expand-icon.rotated {
    transform: rotate(180deg);
    color: #00d9ff;
  }

  .timeline-content h3 {
    font-size: 1.1rem;
    font-weight: 600;
    color: #fff;
    margin: 0.5rem 0 0.25rem;
  }

  .timeline-type {
    font-size: 0.75rem;
    color: #00ff88;
    background: rgba(0, 255, 136, 0.1);
    padding: 0.15rem 0.5rem;
    border-radius: 4px;
    margin-top: 0.25rem;
  }

  .exp-details {
    margin-top: 1rem;
    padding-top: 1rem;
    border-top: 1px solid rgba(255, 255, 255, 0.06);
  }

  .exp-description {
    font-size: 0.9rem;
    color: #a1a1aa;
    line-height: 1.6;
    margin: 0 0 1rem;
  }

  .leadership {
    background: rgba(0, 217, 255, 0.05);
    border: 1px solid rgba(0, 217, 255, 0.1);
    border-radius: 12px;
    padding: 1rem;
  }

  .leadership-header {
    display: flex;
    align-items: center;
    gap: 0.5rem;
    color: #00d9ff;
    font-size: 0.85rem;
    font-weight: 600;
    margin-bottom: 0.75rem;
  }

  .leadership ul {
    margin: 0;
    padding-left: 1.25rem;
    list-style: none;
  }

  .leadership li {
    position: relative;
    font-size: 0.85rem;
    color: #a1a1aa;
    margin-bottom: 0.5rem;
    line-height: 1.5;
  }

  .leadership li::before {
    content: "→";
    position: absolute;
    left: -1.25rem;
    color: #00d9ff;
  }

  .leadership li:last-child {
    margin-bottom: 0;
  }

  @media (max-width: 768px) {
    .glass-card {
      padding: 1.5rem;
      border-radius: 16px;
    }

    .timeline-item {
      gap: 1rem;
    }

    .timeline-content {
      padding: 1rem;
    }
  }
</style>
