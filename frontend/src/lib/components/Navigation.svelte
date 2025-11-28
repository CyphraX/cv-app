<script lang="ts">
  import { fade } from "svelte/transition";

  export let sections: { id: string; label: string; icon: string }[] = [];
  export let activeSection: string = "header";
  export let visible: boolean = false;
  export let onNavigate: (id: string) => void = () => {};
</script>

<nav class="floating-nav" class:visible in:fade={{ duration: 300 }}>
  <div class="nav-pills">
    {#each sections as section}
      <button
        class="nav-pill"
        class:active={activeSection === section.id}
        on:click={() => onNavigate(section.id)}
        title={section.label}
      >
        <span class="nav-icon">{section.icon}</span>
        <span class="nav-label">{section.label}</span>
      </button>
    {/each}
  </div>
</nav>

<style>
  .floating-nav {
    position: fixed;
    left: 50%;
    bottom: 2rem;
    transform: translateX(-50%) translateY(100px);
    z-index: 100;
    opacity: 0;
    transition: all 0.4s cubic-bezier(0.4, 0, 0.2, 1);
    pointer-events: none;
  }

  .floating-nav.visible {
    transform: translateX(-50%) translateY(0);
    opacity: 1;
    pointer-events: auto;
  }

  .nav-pills {
    display: flex;
    gap: 0.5rem;
    padding: 0.5rem;
    background: rgba(10, 10, 15, 0.9);
    border: 1px solid rgba(255, 255, 255, 0.1);
    border-radius: 100px;
    backdrop-filter: blur(20px);
    box-shadow: 0 10px 40px rgba(0, 0, 0, 0.5);
  }

  .nav-pill {
    display: flex;
    align-items: center;
    gap: 0.5rem;
    padding: 0.6rem 1rem;
    background: transparent;
    border: none;
    border-radius: 100px;
    color: #71717a;
    font-family: inherit;
    font-size: 0.85rem;
    cursor: pointer;
    transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
    white-space: nowrap;
  }

  .nav-pill:hover {
    color: #e4e4e7;
    background: rgba(255, 255, 255, 0.05);
  }

  .nav-pill.active {
    background: linear-gradient(
      135deg,
      rgba(0, 217, 255, 0.2),
      rgba(0, 255, 136, 0.2)
    );
    color: #00ff88;
    box-shadow: 0 0 20px rgba(0, 217, 255, 0.2);
  }

  .nav-icon {
    font-size: 1rem;
  }

  .nav-label {
    display: none;
  }

  @media (min-width: 768px) {
    .nav-label {
      display: inline;
    }
  }

  @media (max-width: 768px) {
    .floating-nav {
      bottom: 1rem;
      left: 1rem;
      right: 1rem;
      transform: translateX(0) translateY(100px);
    }

    .floating-nav.visible {
      transform: translateX(0) translateY(0);
    }

    .nav-pills {
      width: 100%;
      justify-content: center;
      overflow-x: auto;
      -webkit-overflow-scrolling: touch;
    }

    .nav-pill {
      padding: 0.5rem 0.75rem;
    }
  }

  @media (max-width: 480px) {
    .nav-pill {
      padding: 0.4rem 0.6rem;
      font-size: 0.8rem;
    }

    .nav-icon {
      font-size: 0.9rem;
    }
  }
</style>
