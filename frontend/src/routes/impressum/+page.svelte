<script lang="ts">
</script>

<svelte:head>
  <title>Impressum - Philipp Saal</title>
  <meta name="robots" content="noindex, nofollow" />
</svelte:head>

<main>
  <a href="/" class="back-link">← Zurück zum CV</a>

  <h1>Impressum</h1>

  <section>
    <h2>Angaben gemäß § 5 TMG</h2>
    <p>
      Philipp Saal<br />
      An den Schäferpfühlen 113<br />
      16321 Bernau bei Berlin
    </p>
  </section>

  <section>
    <h2>Kontakt</h2>
    <p>
      Telefon: +49 176 20690117<br />
      E-Mail: philipp.saal@proton.me
    </p>
  </section>

  <section>
    <h2>Verantwortlich für den Inhalt nach § 55 Abs. 2 RStV</h2>
    <p>
      Philipp Saal<br />
      An den Schäferpfühlen 113<br />
      16321 Bernau bei Berlin
    </p>
  </section>

  <section>
    <h2>Haftung für Inhalte</h2>
    <p>
      Als Diensteanbieter bin ich gemäß § 7 Abs.1 TMG für eigene Inhalte auf
      diesen Seiten nach den allgemeinen Gesetzen verantwortlich. Nach §§ 8 bis
      10 TMG bin ich als Diensteanbieter jedoch nicht verpflichtet, übermittelte
      oder gespeicherte fremde Informationen zu überwachen oder nach Umständen
      zu forschen, die auf eine rechtswidrige Tätigkeit hinweisen.
    </p>
    <p>
      Verpflichtungen zur Entfernung oder Sperrung der Nutzung von Informationen
      nach den allgemeinen Gesetzen bleiben hiervon unberührt. Eine
      diesbezügliche Haftung ist jedoch erst ab dem Zeitpunkt der Kenntnis einer
      konkreten Rechtsverletzung möglich. Bei Bekanntwerden von entsprechenden
      Rechtsverletzungen werde ich diese Inhalte umgehend entfernen.
    </p>
  </section>

  <section>
    <h2>Haftung für Links</h2>
    <p>
      Diese Website enthält Links zu externen Websites Dritter, auf deren
      Inhalte ich keinen Einfluss habe. Deshalb kann ich für diese fremden
      Inhalte auch keine Gewähr übernehmen. Für die Inhalte der verlinkten
      Seiten ist stets der jeweilige Anbieter oder Betreiber der Seiten
      verantwortlich.
    </p>
  </section>

  <section>
    <h2>Urheberrecht</h2>
    <p>
      Die durch den Seitenbetreiber erstellten Inhalte und Werke auf diesen
      Seiten unterliegen dem deutschen Urheberrecht. Die Vervielfältigung,
      Bearbeitung, Verbreitung und jede Art der Verwertung außerhalb der Grenzen
      des Urheberrechtes bedürfen der schriftlichen Zustimmung des jeweiligen
      Autors bzw. Erstellers.
    </p>
  </section>
</main>

<style>
  :global(body) {
    font-family:
      "Inter",
      -apple-system,
      BlinkMacSystemFont,
      "Segoe UI",
      Roboto,
      sans-serif;
    background: linear-gradient(135deg, #0f0f1a 0%, #1a1a2e 50%, #16213e 100%);
    color: #e4e4e4;
    margin: 0;
    min-height: 100vh;
    line-height: 1.6;
  }

  main {
    max-width: 800px;
    margin: 0 auto;
    padding: 2rem;
  }

  .back-link {
    color: #00d9ff;
    text-decoration: none;
    display: inline-block;
    margin-bottom: 2rem;
  }

  .back-link:hover {
    color: #00ff88;
  }

  h1 {
    font-size: 2.5rem;
    margin-bottom: 2rem;
    background: linear-gradient(90deg, #00d9ff, #00ff88);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    background-clip: text;
  }

  section {
    background: rgba(255, 255, 255, 0.03);
    border: 1px solid rgba(255, 255, 255, 0.05);
    border-radius: 12px;
    padding: 1.5rem;
    margin-bottom: 1.5rem;
  }

  h2 {
    color: #00d9ff;
    font-size: 1.2rem;
    margin-top: 0;
    margin-bottom: 1rem;
  }

  p {
    margin: 0 0 1rem 0;
    color: #ccc;
  }

  p:last-child {
    margin-bottom: 0;
  }
</style>
