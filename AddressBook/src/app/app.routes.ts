import { Routes } from '@angular/router';
import { AddressBookComponent } from './address-book/address-book.component';
import { PersonFormComponent } from './person-form/person-form.component';

export const routes: Routes = [
  { path: '', component: AddressBookComponent },
  { path: 'add-person', component: PersonFormComponent }
];
