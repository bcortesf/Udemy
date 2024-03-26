import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CountriesService } from '../../services/countries.service';
import { Region } from '../../interfaces/country.interfaces';

@Component({
  selector: 'app-selector-page',
  templateUrl: './selector-page.component.html',
  styleUrl: './selector-page.component.css'
})
export class SelectorPageComponent {

  public myForm: FormGroup = this.fb.nonNullable.group(
    {
      continent: ['', [Validators.required], []],
      country  : ['', [Validators.required], []],
      frontiers: ['', [Validators.required], []]
    }
  );

  constructor(
    private fb: FormBuilder,
    private countriesService: CountriesService
  ) {}


  get regions(): Region[] {
    return this.countriesService.regions;
  }


  onSave() {
    throw new Error('Method not implemented.');
    }
}
