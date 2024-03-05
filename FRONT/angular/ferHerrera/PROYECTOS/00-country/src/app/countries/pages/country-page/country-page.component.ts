import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'country-country-page',
  templateUrl: './country-page.component.html',
  styleUrl: './country-page.component.css'
})
export class CountriesPageComponent implements OnInit {

  public paramId: number | undefined;

  constructor(private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.params.subscribe((params:Params) => {
      console.log(params);
      this.paramId = params['id'] as number;
    })
  }

}
