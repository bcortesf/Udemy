import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BasicPageComponent } from './pages/basic-page/basic-page.component';
import { DynamicPageComponent } from './pages/dynamic-page/dynamic-page.component';
import { SwitchesPageComponent } from './pages/switches-page/switches-page.component';

const routes: Routes = [
  /**CARGA-DIRECTA */
  // {path: '', component: BasicPageComponent}

  /**CARGA-HEREDADA:'/reactive',  DESDE:'app-routing.module' */
  {
    path: '',
    children: [
      {path: 'basic', component: BasicPageComponent},
      {path: 'dinamyc', component: DynamicPageComponent},
      {path: 'switches', component: SwitchesPageComponent},
      {
        /**
         * Para:
         *    'http://localhost:4200'  ,  'http://localhost:4200/'
         *    'http://localhost:4200/<CUALQUIER-COSA>'
         *    'http://localhost:4200/reactive/<CUALQUIER-COSA>'
         *
         * redirigir a:
         *    'http://localhost:4200/reactive/basic'
         */
        path: '**',
        redirectTo: 'basic'
      }
    ],
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ReactiveFormsRoutingModule { }
