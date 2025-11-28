<script lang="ts">
</script>

<svelte:head>
  <title>Datenschutzerklärung - Philipp Saal</title>
  <meta name="robots" content="noindex, nofollow" />
</svelte:head>

<main>
  <a href="/" class="back-link">← Zurück zum CV</a>

  <h1>Datenschutzerklärung</h1>

  <section>
    <h2>1. Datenschutz auf einen Blick</h2>
    <h3>Allgemeine Hinweise</h3>
    <p>
      Die folgenden Hinweise geben einen einfachen Überblick darüber, was mit
      Ihren personenbezogenen Daten passiert, wenn Sie diese Website besuchen.
      Personenbezogene Daten sind alle Daten, mit denen Sie persönlich
      identifiziert werden können.
    </p>

    <h3>Datenerfassung auf dieser Website</h3>
    <p>
      <strong
        >Wer ist verantwortlich für die Datenerfassung auf dieser Website?</strong
      ><br />
      Die Datenverarbeitung auf dieser Website erfolgt durch den Websitebetreiber:
      Philipp Saal, An den Schäferpfühlen 113, 16321 Bernau bei Berlin, E-Mail: philipp.saal@proton.me
    </p>
    <p>
      <strong>Wie erfassen wir Ihre Daten?</strong><br />
      Diese Website erfasst keine personenbezogenen Daten aktiv. Es werden keine
      Cookies gesetzt, keine Analysetools verwendet und keine Formulare zur Dateneingabe
      bereitgestellt.
    </p>
  </section>

  <section>
    <h2>2. Hosting</h2>
    <p>
      Diese Website wird auf einem privaten Server (Raspberry Pi) gehostet. Bei
      jedem Zugriff auf diese Website werden automatisch Informationen in
      Server-Logfiles gespeichert:
    </p>
    <ul>
      <li>IP-Adresse des anfragenden Rechners</li>
      <li>Datum und Uhrzeit des Zugriffs</li>
      <li>Name und URL der abgerufenen Datei</li>
      <li>Übertragene Datenmenge</li>
      <li>Meldung über erfolgreichen Abruf</li>
      <li>Browsertyp und Browserversion</li>
      <li>Betriebssystem des Nutzers</li>
      <li>Referrer URL</li>
    </ul>
    <p>
      Diese Daten werden nur zur Sicherstellung eines störungsfreien Betriebs
      der Seite und zur Verbesserung des Angebots ausgewertet. Eine
      Zusammenführung dieser Daten mit anderen Datenquellen wird nicht
      vorgenommen. Die Rechtsgrundlage ist Art. 6 Abs. 1 lit. f DSGVO.
    </p>
  </section>

  <section>
    <h2>3. Allgemeine Hinweise und Pflichtinformationen</h2>
    <h3>Datenschutz</h3>
    <p>
      Der Betreiber dieser Seiten nimmt den Schutz Ihrer persönlichen Daten sehr
      ernst. Wir behandeln Ihre personenbezogenen Daten vertraulich und
      entsprechend den gesetzlichen Datenschutzvorschriften sowie dieser
      Datenschutzerklärung.
    </p>

    <h3>Hinweis zur verantwortlichen Stelle</h3>
    <p>
      Verantwortliche Stelle für die Datenverarbeitung auf dieser Website ist:<br
      /><br />
      Philipp Saal<br />
      An den Schäferpfühlen 113<br />
      16321 Bernau bei Berlin<br />
      E-Mail: philipp.saal@proton.me
    </p>
  </section>

  <section>
    <h2>4. Ihre Rechte</h2>
    <p>Sie haben jederzeit das Recht:</p>
    <ul>
      <li>
        Auskunft über Ihre bei uns gespeicherten personenbezogenen Daten zu
        erhalten (Art. 15 DSGVO)
      </li>
      <li>
        Berichtigung unrichtiger personenbezogener Daten zu verlangen (Art. 16
        DSGVO)
      </li>
      <li>
        Löschung Ihrer bei uns gespeicherten personenbezogenen Daten zu
        verlangen (Art. 17 DSGVO)
      </li>
      <li>
        Einschränkung der Verarbeitung Ihrer personenbezogenen Daten zu
        verlangen (Art. 18 DSGVO)
      </li>
      <li>Widerspruch gegen die Verarbeitung einzulegen (Art. 21 DSGVO)</li>
      <li>Datenübertragbarkeit zu verlangen (Art. 20 DSGVO)</li>
    </ul>
    <p>
      Wenn Sie glauben, dass die Verarbeitung Ihrer Daten gegen das
      Datenschutzrecht verstößt, können Sie sich bei der zuständigen
      Aufsichtsbehörde beschweren.
    </p>
  </section>

  <section>
    <h2>5. SSL- bzw. TLS-Verschlüsselung</h2>
    <p>
      Diese Seite nutzt aus Sicherheitsgründen und zum Schutz der Übertragung
      vertraulicher Inhalte eine SSL- bzw. TLS-Verschlüsselung. Eine
      verschlüsselte Verbindung erkennen Sie daran, dass die Adresszeile des
      Browsers von "http://" auf "https://" wechselt und an dem Schloss-Symbol
      in Ihrer Browserzeile.
    </p>
  </section>

  <section>
    <h2>6. Cloudflare</h2>
    <p>
      Diese Website nutzt den Dienst Cloudflare als DNS-Provider und für die
      SSL-Zertifikatsverwaltung. Cloudflare ist ein US-amerikanisches
      Unternehmen, das Content-Delivery-Network-Dienste, DDoS-Schutz und
      DNS-Dienste anbietet.
    </p>
    <p>
      Bei der Nutzung von Cloudflare können Daten in die USA übertragen werden.
      Cloudflare ist unter dem EU-US Data Privacy Framework zertifiziert.
    </p>
    <p>
      Weitere Informationen zum Datenschutz bei Cloudflare finden Sie unter:
      <a href="https://www.cloudflare.com/privacypolicy/" target="_blank"
        >https://www.cloudflare.com/privacypolicy/</a
      >
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
    font-size: 1.3rem;
    margin-top: 0;
    margin-bottom: 1rem;
  }

  h3 {
    color: #00ff88;
    font-size: 1rem;
    margin-top: 1.5rem;
    margin-bottom: 0.5rem;
  }

  h3:first-of-type {
    margin-top: 0;
  }

  p {
    margin: 0 0 1rem 0;
    color: #ccc;
  }

  ul {
    color: #ccc;
    padding-left: 1.5rem;
    margin: 0.5rem 0 1rem 0;
  }

  li {
    margin-bottom: 0.3rem;
  }

  a {
    color: #00d9ff;
  }

  a:hover {
    color: #00ff88;
  }

  strong {
    color: #fff;
  }
</style>
