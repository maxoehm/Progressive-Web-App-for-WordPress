import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

@customElement('main-layout')
export class MainLayout extends LitElement {
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
      <vaadin-vertical-layout style="width: 100%; height: 100%;">
        <vaadin-vertical-layout
          class="content"
          style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto;"
        ></vaadin-vertical-layout>
        <vaadin-horizontal-layout
          class="footer"
          style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"
          id="vaadinHorizontalLayout"
        ></vaadin-horizontal-layout>
      </vaadin-vertical-layout>
    `;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
