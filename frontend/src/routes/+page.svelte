<script lang="ts">
  import { onMount } from "svelte";

  interface Experience {
    company: string;
    role: string;
    period: string;
    type: string;
    highlights: string[];
  }

  interface Education {
    institution: string;
    degree: string;
    field: string;
    period: string;
    note: string | null;
  }

  interface Language {
    language: string;
    level: string;
  }

  interface SkillCategories {
    coreExpertise: string[];
    solidKnowledge: string[];
    exploration: string[];
  }

  interface CvData {
    name: string;
    title: string;
    location: string;
    email: string;
    phone: string;
    github: string;
    profile: string;
    skills: SkillCategories;
    experience: Experience[];
    education: Education[];
    languages: Language[];
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
      cvData = {
        name: "Philipp Saal",
        title: "Java Backend Developer",
        location: "Bernau bei Berlin",
        email: "philipp.saal@proton.me",
        phone: "+49 176 20690117",
        github: "CyphraX",
        profile: "Java Backend Developer mit 4+ Jahren Erfahrung in der Entwicklung skalierbarer Plattform-Architekturen f�r Kommunalsoftware.",
        skills: {
          coreExpertise: ["Java (11-21)", "REST API Design", "Elasticsearch", "MSSQL / Oracle", "Platform Architecture"],
          solidKnowledge: ["OSGi", "Hazelcast", "Docker", "ADRs & arc42", "On-Premise Deployment"],
          exploration: ["Spring Boot", "Kotlin", "Kubernetes", "Rust", "SvelteKit"]
        },
        experience: [{
          company: "HSH-Berlin",
          role: "Java Backend Developer",
          period: "M�rz 2022 - heute",
          type: "Kommunalsoftware",
          highlights: ["Plattform-Entwicklung f�r 20-40 Fachverfahren"]
        }],
        education: [{
          institution: "HTW Berlin",
          degree: "Bachelor of Science",
          field: "Angewandte Informatik",
          period: "Abgeschlossen",
          note: null
        }],
        languages: [
          { language: "Deutsch", level: "Muttersprache" },
          { language: "Englisch", level: "Gut" }
        ]
      };
    } finally {
      loading = false;
    }
  });
</script>

<svelte:head>
  <title>CV - Philipp Saal | Java Backend Developer</title>
  <meta name="description" content="Java Backend Developer mit 4+ Jahren Erfahrung in Plattform-Architekturen" />
  <meta name="robots" content="noindex, nofollow" />
</svelte:head>

<main>
  {#if loading}
    <div class="loading">
      <div class="spinner"></div>
      <p>Loading...</p>
    </div>
  {:else if cvData}
    <header>
      <h1>{cvData.name}</h1>
      <p class="title">{cvData.title}</p>
      <div class="contact-info">
        <span> {cvData.location}</span>
        <span> <a href="mailto:{cvData.email}">{cvData.email}</a></span>
        <span> <a href="https://github.com/{cvData.github}" target="_blank">github.com/{cvData.github}</a></span>
      </div>
    </header>

    <section class="profile">
      <h2>Profil</h2>
      <p>{cvData.profile}</p>
    </section>

    <section class="skills">
      <h2>Technische Kompetenzen</h2>
      
      <div class="skill-category">
        <h3> Core Expertise</h3>
        <div class="skill-tags">
          {#each cvData.skills.coreExpertise as skill}
            <span class="skill-tag core">{skill}</span>
          {/each}
        </div>
      </div>

      <div class="skill-category">
        <h3> Solid Knowledge</h3>
        <div class="skill-tags">
          {#each cvData.skills.solidKnowledge as skill}
            <span class="skill-tag solid">{skill}</span>
          {/each}
        </div>
      </div>

      <div class="skill-category">
        <h3> Exploration & Learning</h3>
        <div class="skill-tags">
          {#each cvData.skills.exploration as skill}
            <span class="skill-tag explore">{skill}</span>
          {/each}
        </div>
      </div>
    </section>

    <section class="experience">
      <h2>Berufserfahrung</h2>
      {#each cvData.experience as exp}
        <div class="experience-item">
          <div class="exp-header">
            <h3>{exp.role}</h3>
            <span class="period">{exp.period}</span>
          </div>
          <p class="company">{exp.company} <span class="type"> {exp.type}</span></p>
          <ul class="highlights">
            {#each exp.highlights as highlight}
              <li>{highlight}</li>
            {/each}
          </ul>
        </div>
      {/each}
    </section>

    <section class="education">
      <h2>Ausbildung</h2>
      {#each cvData.education as edu}
        <div class="education-item">
          <div class="edu-header">
            <h3>{edu.degree} - {edu.field}</h3>
            <span class="period">{edu.period}</span>
          </div>
          <p class="institution">{edu.institution}</p>
          {#if edu.note}
            <p class="note">{edu.note}</p>
          {/if}
        </div>
      {/each}
    </section>

    <section class="languages">
      <h2>Sprachen</h2>
      <div class="language-list">
        {#each cvData.languages as lang}
          <div class="language-item">
            <span class="lang-name">{lang.language}</span>
            <span class="lang-level">{lang.level}</span>
          </div>
        {/each}
      </div>
    </section>

    <footer>
      <p>Built with SvelteKit, Kotlin & Kubernetes • Hosted on Raspberry Pi</p>
      <div class="legal-links">
        <a href="/impressum">Impressum</a>
        <span>|</span>
        <a href="/datenschutz">Datenschutz</a>
      </div>
    </footer>
  {/if}

  {#if error}
    <p class="error-note"> API nicht erreichbar - Fallback-Daten werden angezeigt</p>
  {/if}
</main>

<style>
  :global(*) {
    box-sizing: border-box;
  }

  :global(body) {
    font-family: "Inter", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif;
    background: linear-gradient(135deg, #0f0f1a 0%, #1a1a2e 50%, #16213e 100%);
    color: #e4e4e4;
    margin: 0;
    min-height: 100vh;
    line-height: 1.6;
  }

  main {
    max-width: 900px;
    margin: 0 auto;
    padding: 2rem;
  }

  header {
    text-align: center;
    margin-bottom: 3rem;
    padding-bottom: 2rem;
    border-bottom: 1px solid rgba(0, 217, 255, 0.2);
  }

  h1 {
    font-size: 3rem;
    margin-bottom: 0.5rem;
    background: linear-gradient(90deg, #00d9ff, #00ff88);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    background-clip: text;
    font-weight: 700;
  }

  .title {
    font-size: 1.4rem;
    color: #888;
    margin-bottom: 1.5rem;
  }

  .contact-info {
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
    gap: 1.5rem;
    font-size: 0.95rem;
  }

  .contact-info a {
    color: #00d9ff;
    text-decoration: none;
    transition: color 0.2s;
  }

  .contact-info a:hover {
    color: #00ff88;
  }

  section {
    background: rgba(255, 255, 255, 0.03);
    border: 1px solid rgba(255, 255, 255, 0.05);
    border-radius: 16px;
    padding: 2rem;
    margin-bottom: 2rem;
    backdrop-filter: blur(10px);
  }

  h2 {
    color: #00d9ff;
    margin-top: 0;
    margin-bottom: 1.5rem;
    font-size: 1.5rem;
    border-bottom: 2px solid rgba(0, 217, 255, 0.3);
    padding-bottom: 0.5rem;
  }

  .profile p {
    font-size: 1.1rem;
    color: #ccc;
    margin: 0;
  }

  .skill-category {
    margin-bottom: 1.5rem;
  }

  .skill-category:last-child {
    margin-bottom: 0;
  }

  .skill-category h3 {
    color: #fff;
    font-size: 1rem;
    margin-bottom: 0.75rem;
  }

  .skill-tags {
    display: flex;
    flex-wrap: wrap;
    gap: 0.6rem;
  }

  .skill-tag {
    padding: 0.4rem 0.9rem;
    border-radius: 20px;
    font-size: 0.85rem;
    font-weight: 500;
    transition: transform 0.2s, box-shadow 0.2s;
  }

  .skill-tag:hover {
    transform: translateY(-2px);
    box-shadow: 0 4px 12px rgba(0, 217, 255, 0.3);
  }

  .skill-tag.core {
    background: linear-gradient(135deg, rgba(0, 217, 255, 0.25), rgba(0, 255, 136, 0.25));
    border: 1px solid rgba(0, 217, 255, 0.5);
    color: #00ff88;
  }

  .skill-tag.solid {
    background: rgba(255, 255, 255, 0.08);
    border: 1px solid rgba(255, 255, 255, 0.2);
    color: #e4e4e4;
  }

  .skill-tag.explore {
    background: rgba(136, 136, 136, 0.15);
    border: 1px solid rgba(136, 136, 136, 0.3);
    color: #aaa;
  }

  .experience-item, .education-item {
    border-left: 3px solid #00ff88;
    padding-left: 1.5rem;
    margin-bottom: 2rem;
  }

  .experience-item:last-child, .education-item:last-child {
    margin-bottom: 0;
  }

  .exp-header, .edu-header {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    flex-wrap: wrap;
    gap: 0.5rem;
  }

  .experience-item h3, .education-item h3 {
    margin: 0;
    color: #fff;
    font-size: 1.2rem;
  }

  .period {
    color: #00d9ff;
    font-size: 0.9rem;
    white-space: nowrap;
  }

  .company, .institution {
    color: #888;
    margin: 0.25rem 0 0.75rem 0;
    font-size: 1rem;
  }

  .type {
    color: #666;
  }

  .note {
    color: #666;
    font-size: 0.9rem;
    margin: 0.25rem 0 0 0;
    font-style: italic;
  }

  .highlights {
    margin: 0;
    padding-left: 1.2rem;
    color: #bbb;
  }

  .highlights li {
    margin-bottom: 0.4rem;
  }

  .highlights li:last-child {
    margin-bottom: 0;
  }

  .language-list {
    display: flex;
    gap: 2rem;
    flex-wrap: wrap;
  }

  .language-item {
    display: flex;
    flex-direction: column;
    gap: 0.25rem;
  }

  .lang-name {
    font-weight: 600;
    color: #fff;
  }

  .lang-level {
    color: #888;
    font-size: 0.9rem;
  }

  footer {
    text-align: center;
    padding: 2rem;
    color: #555;
    font-size: 0.85rem;
  }

  .loading {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    min-height: 50vh;
    color: #888;
  }

  .spinner {
    width: 40px;
    height: 40px;
    border: 3px solid rgba(0, 217, 255, 0.2);
    border-top-color: #00d9ff;
    border-radius: 50%;
    animation: spin 1s linear infinite;
  }

  @keyframes spin {
    to { transform: rotate(360deg); }
  }

  .error-note {
    text-align: center;
    color: #ff8800;
    font-size: 0.85rem;
    background: rgba(255, 136, 0, 0.1);
    padding: 0.75rem;
    border-radius: 8px;
    margin-top: 1rem;
  }

  @media (max-width: 600px) {
    h1 {
      font-size: 2rem;
    }

    .contact-info {
      flex-direction: column;
      gap: 0.75rem;
    }

    .exp-header, .edu-header {
      flex-direction: column;
    }

    section {
      padding: 1.5rem;
    }

    main {
      padding: 1rem;
    }
  }

  .legal-links {
    margin-top: 0.5rem;
    display: flex;
    justify-content: center;
    gap: 0.75rem;
    font-size: 0.8rem;
  }

  .legal-links a {
    color: #666;
    text-decoration: none;
  }

  .legal-links a:hover {
    color: #00d9ff;
  }

  .legal-links span {
    color: #444;
  }
</style>
