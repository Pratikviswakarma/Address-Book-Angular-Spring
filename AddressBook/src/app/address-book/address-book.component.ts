import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PersonFormComponent } from '../person-form/person-form.component';

@Component({
  selector: 'app-address-book',
  standalone: true,
  imports: [CommonModule, PersonFormComponent],
  templateUrl: './address-book.component.html',
  styleUrls: ['./address-book.component.css']
})
export class AddressBookComponent {
  showForm = false;

  persons = [
    { name: 'Varaza Mishra', address: 'Marve Road, Next To Maniratna, Malad (west)', city: 'Mumbai', state: 'Maharashtra', zipCode: '400064', phoneNumber: '02228017752' },
    { name: 'Trishna Bhalla', address: '77, rd Flr., Desaichambers, Masjid Bunder (west)', city: 'Mumbai', state: 'Maharashtra', zipCode: '400003', phoneNumber: '02223420607' }
  ];

  addPerson(person: any) {
    this.persons.push(person);
    this.showForm = false;
  }

  deletePerson(person: any) {
    this.persons = this.persons.filter(p => p !== person);
  }

  editPerson(person: any) {
    console.log('Editing:', person);
  }
}
