<script lang="ts">
  import { fly } from "svelte/transition";
  import Icon from "./Icon.svelte";
  import type { SkillCategories } from "../types";

  export let skills: SkillCategories;
  export let visible: boolean = false;

  const categoryLabels: Record<string, string> = {
    coreExpertise: "Kernkompetenz",
    solidKnowledge: "Solides Wissen",
    exploration: "Exploration",
  };
</script>

<section
  id="skills"
  class="glass-card"
  class:visible
  in:fly={{ y: 30, duration: 600, delay: 300 }}
>
  <div class="section-header">
    <div class="section-icon">
      <Icon name="code" size={24} />
    </div>
    <h2>Skills</h2>
  </div>
  <div class="skills-grid">
    {#each Object.entries(skills) as [category, skillList], i}
      <div
        class="skill-category"
        in:fly={{ y: 20, duration: 400, delay: 400 + i * 100 }}
      >
        <h3>{categoryLabels[category] || category}</h3>
        <div class="skill-tags">
          {#each skillList as skill, j}
            <span
              class="skill-tag"
              style="animation-delay: {500 + i * 100 + j * 50}ms"
            >
              {skill}
            </span>
          {/each}
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

  .skills-grid {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
    gap: 1.5rem;
  }

  .skill-category {
    background: rgba(255, 255, 255, 0.02);
    border: 1px solid rgba(255, 255, 255, 0.04);
    border-radius: 16px;
    padding: 1.25rem;
    transition: all 0.3s ease;
  }

  .skill-category:hover {
    background: rgba(255, 255, 255, 0.04);
    border-color: rgba(0, 217, 255, 0.2);
  }

  .skill-category h3 {
    font-size: 0.85rem;
    font-weight: 600;
    color: #00d9ff;
    text-transform: uppercase;
    letter-spacing: 0.1em;
    margin: 0 0 1rem 0;
  }

  .skill-tags {
    display: flex;
    flex-wrap: wrap;
    gap: 0.5rem;
  }

  .skill-tag {
    background: linear-gradient(
      135deg,
      rgba(0, 217, 255, 0.1),
      rgba(0, 255, 136, 0.1)
    );
    border: 1px solid rgba(0, 217, 255, 0.2);
    color: #fff;
    padding: 0.4rem 0.8rem;
    border-radius: 8px;
    font-size: 0.85rem;
    transition: all 0.3s ease;
    cursor: default;
    opacity: 0;
    animation: fadeInUp 0.4s forwards;
  }

  @keyframes fadeInUp {
    from {
      opacity: 0;
      transform: translateY(10px);
    }
    to {
      opacity: 1;
      transform: translateY(0);
    }
  }

  .skill-tag:hover {
    background: linear-gradient(
      135deg,
      rgba(0, 217, 255, 0.2),
      rgba(0, 255, 136, 0.2)
    );
    border-color: rgba(0, 217, 255, 0.4);
    transform: translateY(-2px);
    box-shadow: 0 4px 15px rgba(0, 217, 255, 0.2);
  }

  @media (max-width: 768px) {
    .glass-card {
      padding: 1.5rem;
      border-radius: 16px;
    }

    .skills-grid {
      grid-template-columns: 1fr;
    }
  }
</style>
