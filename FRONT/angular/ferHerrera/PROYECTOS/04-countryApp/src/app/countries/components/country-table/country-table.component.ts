import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Capital } from '../../interfaces/capital.interface';
import { Country } from '../../interfaces/country.interface';
import { Region } from '../../interfaces/region.interface';

@Component({
  selector: 'countries-country-table',
  templateUrl: './country-table.component.html',
  styleUrl: './country-table.component.css'
})
export class CountryTableComponent implements OnChanges {

  @Input() capitals: Capital[];   //PADRE<by-capital.page.component>
  @Input() countries: Country[];  //PADRE<by-country.page.component>
  @Input() regions: Region[];     //PADRE<by-region.page.component>

  @Input()
  typeTable: string = 'NINGUNA_TABLA';

  constructor() {
    this.capitals = [];
    this.countries = [];
    this.regions = [];
  }

  ngOnChanges(changes: SimpleChanges): void {
    // console.log({changes});
  }


}
