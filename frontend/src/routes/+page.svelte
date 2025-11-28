<script lang="ts">
  import { onMount } from "svelte";

  interface Experience {
    company: string;
    role: string;
    period: string;
  }

  interface CvData {
    name: string;
    title: string;
    skills: string[];
    experience: Experience[];
  }

  let cvData: CvData | null = null;
  let loading = true;
  let error: string | null = null;

  onMount(async () => {
    try {
      const response = await fetch("/api/cv");
      if (!response.ok) throw new Error("Failed to fetch CV data");
      cvData = await response.json();
    } catch (e) {
      error = e instanceof Error ? e.message : "Unknown error";
      // Fallback data for demo
      cvData = {
        name: "Philipp Saal",
        title: "Software Developer",
        skills: [
          "Kotlin",
          "Spring Boot",
          "Kubernetes",
          "SvelteKit",
          "TypeScript",
        ],
        experience: [
          {
            company: "Tech Company",
            role: "Software Developer",
            period: "2023 - Present",
          },
        ],
      };
    } finally {
      loading = false;
    }
  });
</script>

<svelte:head>
  <title>CV - Philipp Saal</title>
  <meta name="description" content="Personal CV Website" />
</svelte:head>

<main>
  <header>
    <h1>{cvData?.name ?? "Loading..."}</h1>
    <p class="title">{cvData?.title ?? ""}</p>
  </header>

  {#if loading}
    <div class="loading">Loading...</div>
  {:else if cvData}
    <section class="skills">
      <h2>Skills</h2>
      <div class="skill-tags">
        {#each cvData.skills as skill}
          <span class="skill-tag">{skill}</span>
        {/each}
      </div>
    </section>

    <section class="experience">
      <h2>Experience</h2>
      {#each cvData.experience as exp}
        <div class="experience-item">
          <h3>{exp.role}</h3>
          <p class="company">{exp.company}</p>
          <p class="period">{exp.period}</p>
        </div>
      {/each}
    </section>
  {/if}

  {#if error}
    <p class="error-note">Note: Using demo data (API unavailable)</p>
  {/if}
</main>

<style>
  :global(body) {
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
      Ubuntu, sans-serif;
    background: linear-gradient(135deg, #1a1a2e 0%, #16213e 100%);
    color: #e4e4e4;
    margin: 0;
    min-height: 100vh;
  }

  main {
    max-width: 800px;
    margin: 0 auto;
    padding: 2rem;
  }

  header {
    text-align: center;
    margin-bottom: 3rem;
  }

  h1 {
    font-size: 3rem;
    margin-bottom: 0.5rem;
    background: linear-gradient(90deg, #00d9ff, #00ff88);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    background-clip: text;
  }

  .title {
    font-size: 1.5rem;
    color: #888;
  }

  section {
    background: rgba(255, 255, 255, 0.05);
    border-radius: 12px;
    padding: 2rem;
    margin-bottom: 2rem;
    backdrop-filter: blur(10px);
  }

  h2 {
    color: #00d9ff;
    margin-top: 0;
    border-bottom: 2px solid #00d9ff33;
    padding-bottom: 0.5rem;
  }

  .skill-tags {
    display: flex;
    flex-wrap: wrap;
    gap: 0.75rem;
  }

  .skill-tag {
    background: linear-gradient(135deg, #00d9ff33, #00ff8833);
    border: 1px solid #00d9ff55;
    padding: 0.5rem 1rem;
    border-radius: 20px;
    font-size: 0.9rem;
  }

  .experience-item {
    border-left: 3px solid #00ff88;
    padding-left: 1.5rem;
    margin-bottom: 1.5rem;
  }

  .experience-item h3 {
    margin: 0 0 0.25rem 0;
    color: #fff;
  }

  .company {
    color: #00d9ff;
    margin: 0 0 0.25rem 0;
  }

  .period {
    color: #888;
    font-size: 0.9rem;
    margin: 0;
  }

  .loading {
    text-align: center;
    padding: 3rem;
    color: #888;
  }

  .error-note {
    text-align: center;
    color: #ff8800;
    font-size: 0.85rem;
  }
</style>
