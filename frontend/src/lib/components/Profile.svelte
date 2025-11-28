<script lang="ts">
  import { fly } from "svelte/transition";
  import Icon from "./Icon.svelte";

  export let profile: string;
  export let visible: boolean = false;
</script>

<section
  id="profile"
  class="glass-card"
  class:visible
  in:fly={{ y: 30, duration: 600, delay: 200 }}
>
  <div class="section-header">
    <div class="section-icon">
      <Icon name="user" size={24} />
    </div>
    <h2>Profil</h2>
  </div>
  <p class="profile-text">{profile}</p>
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

  .profile-text {
    font-size: 1.1rem;
    color: #a1a1aa;
    line-height: 1.8;
    margin: 0;
  }

  @media (max-width: 768px) {
    .glass-card {
      padding: 1.5rem;
      border-radius: 16px;
    }
  }
</style>
