import { LitElement, html, css, customElement } from 'lit-element';

@customElement('events-view')
export class EventsView extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
      <vaadin-vertical-layout style="width: 95%; height: 100%; margin: var(--lumo-space-l);">
        <h1>Liveangebote</h1>
        <vaadin-vertical-layout theme="spacing" class="box_cat">
          <h2>Yoga Nidra</h2>
          <p>bietet sich als Stressentlastungs-Übung an und wird auch in der Behandlung von Patienten mit Burn-out integriert werden.</p>
        </vaadin-vertical-layout>
        <vaadin-vertical-layout theme="spacing" class="box_cat">
          <h2>Guten Morgen, Körper!</h2>
          <p>Motiviert, kraftvoll und gesund in den Tag starten, zusammen mit Ina und einer Ladung Energie.</p>
        </vaadin-vertical-layout>
      </vaadin-vertical-layout>
    `;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
