export interface Experience {
  company: string;
  role: string;
  period: string;
  type: string;
  description: string | null;
  highlights: string[];
  leadership: string[] | null;
}

export interface Education {
  institution: string;
  degree: string;
  field: string;
  period: string;
  note: string | null;
  focus: string[] | null;
  thesis: string | null;
}

export interface Language {
  language: string;
  level: string;
  details: string | null;
}

export interface SkillCategories {
  coreExpertise: string[];
  solidKnowledge: string[];
  exploration: string[];
}

export interface CvData {
  name: string;
  title: string;
  subtitle: string | null;
  location: string;
  email: string;
  github: string;
  profile: string;
  skills: SkillCategories;
  experience: Experience[];
  education: Education[];
  languages: Language[];
  additionalQualifications: string[] | null;
}

export const fallbackCvData: CvData = {
  name: "Philipp Saal",
  title: "Java Backend Developer",
  subtitle: "Richtung Software Architecture",
  location: "Bernau bei Berlin",
  email: "philipp.saal@proton.me",
  github: "CyphraX",
  profile:
    "Java Backend Developer mit 4+ Jahren Erfahrung in der Entwicklung skalierbarer Plattform-Architekturen für Kommunalsoftware. Spezialisiert auf API-Design, Infrastruktur-Integration (Elasticsearch, Hazelcast) und technische Modernisierungsprojekte.",
  skills: {
    coreExpertise: [
      "Java (11-21)",
      "REST APIs",
      "Elasticsearch",
      "MSSQL / Oracle",
      "API- & Schnittstellendesign",
    ],
    solidKnowledge: [
      "OSGi",
      "Hazelcast",
      "Docker",
      "ADRs & arc42",
      "On-Premise Deployment",
    ],
    exploration: ["Spring Boot", "Quarkus", "Kotlin", "Rust", "Svelte"],
  },
  experience: [
    {
      company: "HSH-Berlin",
      role: "Java Backend Developer",
      period: "März 2022 - heute",
      type: "Kommunalsoftware",
      description:
        "Kernverantwortung: Plattform-Entwicklung für 20-40 Fachverfahren",
      highlights: ["Plattform-Entwicklung für 20-40 Fachverfahren"],
      leadership: ["Mentoring eines Werkstudenten über 9 Monate"],
    },
  ],
  education: [
    {
      institution: "HTW Berlin",
      degree: "Bachelor of Science",
      field: "Angewandte Informatik",
      period: "Abgeschlossen",
      note: null,
      focus: null,
      thesis: null,
    },
  ],
  languages: [
    { language: "Deutsch", level: "Muttersprache", details: null },
    {
      language: "Englisch",
      level: "Gut",
      details: "technische Dokumentation",
    },
  ],
  additionalQualifications: [
    "Eigeninitiative in der kontinuierlichen Weiterbildung zu Software-Architektur-Themen",
  ],
};
