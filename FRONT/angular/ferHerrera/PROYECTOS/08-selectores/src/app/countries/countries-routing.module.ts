import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SelectorPageComponent } from './pages/selector-page/selector-page.component';

//-> 1.Define las rutas
const routes: Routes = [
  // { path: 'selector' , component: SelectorPageComponent}

  //-> 5.<CARGA-HEREDADA> DESDE:'app-routing.module' - mediante LAZY-LOADING
  {
    path: '',  //->/selector
    children: [
      {
        path: 'multiple', component: SelectorPageComponent
      },
      {
        path: '**',
        redirectTo: 'multiple'
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CountriesRoutingModule { }
