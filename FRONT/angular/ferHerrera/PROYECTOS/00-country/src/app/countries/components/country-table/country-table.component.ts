import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Capital } from '../../interfaces/capital';
import { Country } from '../../interfaces/country';
import { Region } from '../../interfaces/region';

@Component({
  selector: 'countries-country-table',
  templateUrl: './country-table.component.html',
  styleUrl: './country-table.component.css'
})
export class CountryTableComponent implements OnChanges {

  @Input() capitals: Capital[];
  @Input() countries: Country[];
  @Input() regions: Region[];

  typeTable: string = '';

  constructor() {
    this.capitals = [];
    this.countries = [];
    this.regions = [];
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.typeTable = this.capitals.length
      ? "capitals"
      : this.countries.length
        ? "countries"
        : this.regions.length
          ? "regions"
          : 'NINGUNA_TABLA';

    // console.log({
    //   TABLA: this.typeTable,
    //   capitals: this.capitals,
    //   countries: this.countries,
    //   regions: this.regions
    // });
  }


}
