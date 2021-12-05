import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/avatar/src/vaadin-avatar.js';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';

@customElement('home-view')
export class HomeView extends LitElement {
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
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,600;1,700;1,800;1,900&amp;display=swap" rel="stylesheet">
<vaadin-vertical-layout theme="spacing" style="margin-left: 1.2rem; margin-top: 2rem;">
 <h1 style="margin-top: 0rem; margin-bottom: 0rem; font-family: 'Montserrat', sans-serif; font-weight: 700; " id="h1">Heading 1</h1>
 <vaadin-horizontal-layout theme="spacing" style="width: 95%;">
  <vaadin-text-field style="margin-top: 0rem; width: 98.5%; border-radius: 25px; font-family: 'Montserrat', sans-serif; font-weight: 700;" placeholder="Durchsuchen" id="search-input">
   <vaadin-icon icon="lumo:search" slot="suffix" id="search-icon"></vaadin-icon>
  </vaadin-text-field>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
<vaadin-vertical-layout theme="spacing">
 <vaadin-horizontal-layout theme="spacing" style="width: 90%; margin-top: 1.5rem; margin-left: 1.2rem;">
  <vaadin-vertical-layout theme="spacing">
   <vaadin-vertical-layout theme="spacing" class="box_big" style="background-image: url('/images/categories/cactus.jpg');" id="c1">
    <h5 class="categoryBox titleB">Allgemeines Wissen</h5>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" class="box" style="background-image: url('/images/categories/day.jpg');" id="vaadinVerticalLayout">
    <h5 class="categoryBox titleB">Gezielte Bewegung</h5>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" class="box_big" style="background-image: url('/images/categories/woman.jpg');" id="vaadinVerticalLayout1">
    <h5 class="categoryBox titleB">Freizeit & Aktivität</h5>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" class="box" style="background-image: url('/images/categories/landscape.jpg');" id="vaadinVerticalLayout2">
    <h5 class="categoryBox titleB">Lifestyle</h5>
   </vaadin-vertical-layout>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing">
   <vaadin-vertical-layout theme="spacing" class="box" style="background-image: url('/images/categories/man.jpg');" id="vaadinVerticalLayout3">
    <h5 class="categoryBox titleB">Physische Gesundheit</h5>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" class="box_big" style="background-image: url('/images/categories/ship.jpg');" id="vaadinVerticalLayout4">
    <h5 class="categoryBox titleB">Seelische und Mentale Gesundheit</h5>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" class="box" style="background-image: url('/images/categories/sununder.png');" id="vaadinVerticalLayout5">
    <h5 class="categoryBox titleB">Podcasts</h5>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" class="box" style="background-image: url('/images/categories/sun.jpg');" id="vaadinVerticalLayout6">
    <h5 class="categoryBox titleB">Ernährung</h5>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" class="box" style="background-image: url('/images/categories/sunset.jpg');" id="vaadinVerticalLayout7">
    <h5 class="categoryBox titleB">Yoga</h5>
   </vaadin-vertical-layout>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
