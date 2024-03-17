import { Component } from '@angular/core';
import { MenuItem } from '../../interfaces/index.interface'

@Component({
  selector: 'shared-side-menu',
  templateUrl: './side-menu.component.html',
  styleUrl: './side-menu.component.css'
})
export class SideMenuComponent {
  public authMenu: MenuItem[] = [
    { title: 'Registro', route: './auth' }
  ]
  public reactiveMenu: MenuItem[] = [
    { title: 'Básicos', route: './reactive/basic' },
    { title: 'Dinámicos', route: './reactive/dinamyc' },
    { title: 'Switches', route: './reactive/switches' }
  ]
}
