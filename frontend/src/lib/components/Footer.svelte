<script lang="ts">
  import { fly } from "svelte/transition";
</script>

<footer class="footer" in:fly={{ y: 30, duration: 600, delay: 800 }}>
  <div class="footer-content">
    <div class="tech-stack">
      <span class="tech-label">Built with</span>
      <div class="tech-icons">
        <span class="tech-badge">SvelteKit</span>
        <span class="tech-badge">Kotlin</span>
        <span class="tech-badge">Spring Boot</span>
      </div>
    </div>
    <div class="footer-divider"></div>
    <div class="hosting-info">
      <span class="hosting-label">Hosted on</span>
      <span class="hosting-value">Kubernetes Cluster</span>
    </div>
    <div class="footer-divider"></div>
    <div class="legal-links">
      <a href="/impressum" class="legal-link">Impressum</a>
      <span class="separator">•</span>
      <a href="/datenschutz" class="legal-link">Datenschutz</a>
    </div>
    <p class="copyright">© {new Date().getFullYear()} Philipp Saal</p>
  </div>
</footer>

<style>
  .footer {
    margin-top: 3rem;
    padding: 2rem;
    background: rgba(255, 255, 255, 0.01);
    border-top: 1px solid rgba(255, 255, 255, 0.04);
    border-radius: 24px 24px 0 0;
  }

  .footer-content {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 1.25rem;
    text-align: center;
  }

  .tech-stack {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 0.5rem;
  }

  .tech-label,
  .hosting-label {
    font-size: 0.75rem;
    color: #71717a;
    text-transform: uppercase;
    letter-spacing: 0.1em;
  }

  .tech-icons {
    display: flex;
    gap: 0.5rem;
    flex-wrap: wrap;
    justify-content: center;
  }

  .tech-badge {
    background: linear-gradient(
      135deg,
      rgba(0, 217, 255, 0.1),
      rgba(0, 255, 136, 0.1)
    );
    border: 1px solid rgba(0, 217, 255, 0.2);
    color: #e4e4e7;
    padding: 0.35rem 0.75rem;
    border-radius: 6px;
    font-size: 0.8rem;
    font-weight: 500;
    transition: all 0.3s ease;
  }

  .tech-badge:hover {
    background: linear-gradient(
      135deg,
      rgba(0, 217, 255, 0.2),
      rgba(0, 255, 136, 0.2)
    );
    transform: translateY(-2px);
  }

  .footer-divider {
    width: 60px;
    height: 1px;
    background: linear-gradient(
      90deg,
      transparent,
      rgba(255, 255, 255, 0.1),
      transparent
    );
  }

  .hosting-info {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 0.25rem;
  }

  .hosting-value {
    font-size: 0.9rem;
    color: #a1a1aa;
  }

  .legal-links {
    display: flex;
    align-items: center;
    gap: 0.75rem;
  }

  .legal-link {
    color: #71717a;
    text-decoration: none;
    font-size: 0.85rem;
    transition: color 0.3s ease;
  }

  .legal-link:hover {
    color: #00d9ff;
  }

  .separator {
    color: #3f3f46;
    font-size: 0.8rem;
  }

  .copyright {
    font-size: 0.8rem;
    color: #52525b;
    margin: 0;
  }

  @media (max-width: 768px) {
    .footer {
      padding: 1.5rem;
      margin-top: 2rem;
    }
  }
</style>
