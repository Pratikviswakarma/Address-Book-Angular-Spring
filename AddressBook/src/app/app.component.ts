import { Component } from '@angular/core';
import { AddressBookComponent } from './address-book/address-book.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [AddressBookComponent],
  template: '<app-address-book></app-address-book>',
  styleUrls: ['./app.component.css']
})
export class AppComponent {}
 