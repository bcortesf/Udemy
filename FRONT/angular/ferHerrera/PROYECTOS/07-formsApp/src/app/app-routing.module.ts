import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'reactive', //-> lleva al componente que este definido con vacio-path:'', en el routing-modulo "ReactiveFormsModule"
    loadChildren: () => import('./reactive-forms/reactive-forms.module').then(m => m.ReactiveModule)
  },
  {
    path: 'auth',
    loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule)
  },
  {
    /**
     * ->Siempre me manda al reactive-routing.'routes',
     *   a menos que escriba 'auth', ingresa al auth-routing-routes.'routes'
     */
    path: '**',
    redirectTo: 'reactive'
  }
  // { path: '', redirectTo: '/home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
