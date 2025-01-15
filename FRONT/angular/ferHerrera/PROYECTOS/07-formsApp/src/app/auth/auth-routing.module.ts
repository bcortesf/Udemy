import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterPageComponent } from './pages/register-page/register-page.component';

const routes: Routes = [
  /**CARGA-DIRECTA */
  // {path: '', component: RegisterPageComponent}

  /**CARGA-HEREDADA:'/auth',  DESDE:'app-routing.module' */
  {
    path: '',
    children: [
      {//->Crear-una-cuenta
        path: 'sign-up', component: RegisterPageComponent
      },
      {
        /**
         * Para:
         *    'http://localhost:4200/auth'  ,  'http://localhost:4200/auth/'
         *    'http://localhost:4200/auth/<CUALQUIER-COSA>'
         *
         * redirigir a:
         *    'http://localhost:4200/auth/sign-up'
         */
        path: '**',
        redirectTo: 'sign-up'
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule { }
