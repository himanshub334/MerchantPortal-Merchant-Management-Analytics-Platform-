# ADR-001: Select Angular 15 for merchant onboarding

- Status: Accepted for this demo
- Date: 2025

## Context
The merchant domain is form-heavy: onboarding, validation, review states, and consistent enterprise UI patterns. Analytics also need to be displayed clearly.

## Alternatives considered

| Option | Strengths | Trade-offs |
|---|---|---|
| Angular 15 | Integrated TypeScript framework, reactive forms, dependency injection, Angular Material | More framework conventions and bundle overhead |
| React | Flexible ecosystem and broad data visualization choices | More choices required for forms, routing, and application structure |
| Vue | Approachable and lightweight | Smaller set of standardized enterprise conventions in this team's assumed stack |

## Decision
Use Angular 15 with reactive forms and Angular Material for the onboarding workflow. Keep analytics visualization isolated so a chart library can be changed without changing domain logic.

## Consequences
- Consistent form validation and reusable UI components
- Framework conventions for team onboarding
- Requires Angular version and dependency maintenance
- This ADR documents a project decision; it is not evidence of an actual organizational evaluation.
