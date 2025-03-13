import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-person-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.css']
})
export class PersonFormComponent {
  @Output() closeForm = new EventEmitter<void>();
  @Output() personAdded = new EventEmitter<any>();

  person = {
    name: '',
    phoneNumber: '',
    address: '',
    city: '',
    state: '',
    zipCode: ''
  };

  onSubmit() {
    this.personAdded.emit(this.person);
    this.resetForm();
  }

  close() {
    this.closeForm.emit();
  }

  resetForm() {
    this.person = { name: '', phoneNumber: '', address: '', city: '', state: '', zipCode: '' };
  }
}
