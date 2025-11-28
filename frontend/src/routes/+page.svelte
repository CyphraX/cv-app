<script lang="ts">
  import { onMount } from "svelte";
  import { spring, tweened } from "svelte/motion";
  import { cubicOut } from "svelte/easing";
  import type { CvData } from "$lib/types";
  import { fallbackCvData } from "$lib/types";
  import {
    Loader,
    Navigation,
    Background,
    Header,
    Profile,
    Skills,
    Experience,
    Education,
    Languages,
    Qualifications,
    Footer,
  } from "$lib/components";

  let cvData: CvData | null = null;
  let loading = true;
  let mounted = false;
  let activeSection = "header";
  let scrollY = 0;
  let innerHeight = 0;
  let documentHeight = 0;
  let mouseX = 0;
  let mouseY = 0;

  // Parallax spring values
  const parallaxY = spring(0, { stiffness: 0.03, damping: 0.8 });

  // Scroll progress
  const scrollProgress = tweened(0, { duration: 150, easing: cubicOut });

  // Section visibility tracking
  let visibleSections: Set<string> = new Set();

  const sections = [
    { id: "header", label: "Start", icon: "👤" },
    { id: "profile", label: "Profil", icon: "📋" },
    { id: "skills", label: "Skills", icon: "⚡" },
    { id: "experience", label: "Erfahrung", icon: "💼" },
    { id: "education", label: "Bildung", icon: "🎓" },
    { id: "languages", label: "Sprachen", icon: "🌍" },
  ];

  let sectionElements: { [key: string]: HTMLElement } = {};

  function handleScroll() {
    const maxScroll = documentHeight - innerHeight;
    const progress = maxScroll > 0 ? scrollY / maxScroll : 0;
    scrollProgress.set(progress);
    parallaxY.set(scrollY);

    // Update active section based on scroll position
    for (const section of sections) {
      const el = sectionElements[section.id];
      if (el) {
        const rect = el.getBoundingClientRect();
        if (rect.top <= innerHeight / 3 && rect.bottom >= innerHeight / 3) {
          activeSection = section.id;
          break;
        }
      }
    }
  }

  function scrollToSection(sectionId: string) {
    const el = sectionElements[sectionId];
    if (el) {
      el.scrollIntoView({ behavior: "smooth", block: "start" });
    }
  }

  function handleMouseMove(e: MouseEvent) {
    mouseX = e.clientX;
    mouseY = e.clientY;
  }

  function observeSection(node: HTMLElement, sectionId: string) {
    sectionElements[sectionId] = node;

    const observer = new IntersectionObserver(
      (entries) => {
        entries.forEach((entry) => {
          if (entry.isIntersecting) {
            visibleSections.add(sectionId);
            visibleSections = visibleSections;
          }
        });
      },
      { threshold: 0.1 }
    );
    observer.observe(node);
    return {
      destroy() {
        observer.disconnect();
        delete sectionElements[sectionId];
      },
    };
  }

  async function fetchData() {
    try {
      const response = await fetch("/api/cv");
      if (!response.ok) throw new Error("Failed to fetch CV data");
      cvData = await response.json();
    } catch (e) {
      console.error("Using fallback data:", e);
      cvData = fallbackCvData;
    } finally {
      loading = false;
      setTimeout(() => (mounted = true), 100);
    }
  }

  onMount(() => {
    documentHeight = document.documentElement.scrollHeight;

    const resizeObserver = new ResizeObserver(() => {
      documentHeight = document.documentElement.scrollHeight;
    });
    resizeObserver.observe(document.body);

    fetchData();

    return () => {
      resizeObserver.disconnect();
    };
  });

  // Calculate parallax transforms
  $: headerParallax = -$parallaxY * 0.5;
</script>

<svelte:head>
  <title>CV - Philipp Saal | Java Backend Developer</title>
  <meta
    name="description"
    content="Java Backend Developer mit 4+ Jahren Erfahrung in Plattform-Architekturen"
  />
  <meta name="robots" content="noindex, nofollow" />
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link
    rel="preconnect"
    href="https://fonts.gstatic.com"
    crossorigin="anonymous"
  />
  <link
    href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&family=JetBrains+Mono:wght@400;500&display=swap"
    rel="stylesheet"
  />
</svelte:head>

<svelte:window
  bind:scrollY
  bind:innerHeight
  on:mousemove={handleMouseMove}
  on:scroll={handleScroll}
/>

<!-- Background Effects -->
<Background
  scrollProgress={$scrollProgress}
  {mouseX}
  {mouseY}
  gridParallax={-$parallaxY * 0.1}
  bgParallax={-$parallaxY * 0.2}
/>

{#if loading}
  <Loader />
{:else if cvData}
  <!-- Floating Navigation -->
  <Navigation
    {sections}
    {activeSection}
    visible={scrollY > 300 && mounted}
    onNavigate={scrollToSection}
  />

  <main class="container">
    <!-- Header Section -->
    <div use:observeSection={"header"}>
      <Header data={cvData} {headerParallax} {scrollY} />
    </div>

    <!-- Profile Section -->
    <div use:observeSection={"profile"}>
      <Profile
        profile={cvData.profile}
        visible={visibleSections.has("profile")}
      />
    </div>

    <!-- Skills Section -->
    <div use:observeSection={"skills"}>
      <Skills skills={cvData.skills} visible={visibleSections.has("skills")} />
    </div>

    <!-- Experience Section -->
    <div use:observeSection={"experience"}>
      <Experience
        experience={cvData.experience}
        visible={visibleSections.has("experience")}
      />
    </div>

    <!-- Education Section -->
    <div use:observeSection={"education"}>
      <Education
        education={cvData.education}
        visible={visibleSections.has("education")}
      />
    </div>

    <!-- Languages Section -->
    <div use:observeSection={"languages"}>
      <Languages
        languages={cvData.languages}
        visible={visibleSections.has("languages")}
      />
    </div>

    <!-- Qualifications Section -->
    {#if cvData.additionalQualifications && cvData.additionalQualifications.length > 0}
      <div use:observeSection={"qualifications"}>
        <Qualifications
          qualifications={cvData.additionalQualifications}
          visible={visibleSections.has("qualifications")}
        />
      </div>
    {/if}

    <!-- Footer -->
    <Footer />
  </main>
{/if}

<style>
  :global(*) {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }

  :global(html) {
    scroll-behavior: smooth;
  }

  :global(body) {
    font-family:
      "Inter",
      -apple-system,
      BlinkMacSystemFont,
      "Segoe UI",
      Roboto,
      sans-serif;
    background: #0a0a0f;
    color: #e4e4e7;
    min-height: 100vh;
    overflow-x: hidden;
    line-height: 1.6;
  }

  .container {
    max-width: 900px;
    margin: 0 auto;
    padding: 0 1.5rem 4rem;
    position: relative;
    z-index: 1;
  }

  /* Reduce motion for users who prefer it */
  @media (prefers-reduced-motion: reduce) {
    :global(html) {
      scroll-behavior: auto;
    }

    :global(*) {
      animation: none !important;
      transition: opacity 0.2s !important;
    }
  }
</style>
