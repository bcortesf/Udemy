import { AfterViewInit, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import * as bootstrap from 'bootstrap';
import { Toast } from 'bootstrap';

@Component({
  selector: 'app-switches-page',
  templateUrl: './switches-page.component.html',
  styleUrl: './switches-page.component.css'
})
export class SwitchesPageComponent implements AfterViewInit {

  liveToastERROR?: HTMLElement|null;
  toastBootstrapERROR!: bootstrap.Toast;

  liveToastOK?: HTMLElement|null;
  toastBootstrapOK!: bootstrap.Toast;

  /**FORMULARIO-GENERAL */
  public myForm: FormGroup = this.fb.nonNullable.group({
    //       'M'
    gender: ['', [Validators.required],[]],
    wantNotificacion: [true, [Validators.required],[]],       //->required: debe-haber-un-valor-seleccionado(true ó false)
    termsAndConditions: [false, [Validators.requiredTrue],[]],//->required: debe ser marcado o chuleado siempre
  });


  constructor(private fb: FormBuilder) {
  }

  ngAfterViewInit(): void {
    /**INICIALIZACION-TOAST */
    this.liveToastERROR = document.getElementById('liveToast_error');
    this.liveToastOK = document.getElementById('liveToast_ok');
    if (this.liveToastERROR && this.liveToastOK) {
      this.toastBootstrapERROR = bootstrap.Toast.getOrCreateInstance(this.liveToastERROR);
      this.toastBootstrapOK = bootstrap.Toast.getOrCreateInstance(this.liveToastOK);
      // this.toastBootstrapERROR.show().;
      // this.toastBootstrapOK.show().;
    }

  }

  onSubmit(): void {
    console.log(this.myForm.value);
    if (this.myForm.invalid) {
      this.myForm.markAllAsTouched();
      //////////////////////////////////////////////////////////////////////////////
      // callLocalToast();
      this.toastBootstrapERROR.show();
      //////////////////////////////////////////////////////////////////////////////
      return;
    }
    this.toastBootstrapOK.show();
  }


  isValidField(field: string): boolean | null {
    return this.myForm.controls[field].errors
      && this.myForm.controls[field].touched;
  }



}


function callLocalToast() {
  // Obtener referencia al botón y al Toast
  const liveToast_error = document.getElementById('liveToast_error')
  if (liveToast_error) {
    const toastBootstrap = bootstrap.Toast.getOrCreateInstance(liveToast_error)
    toastBootstrap.show();
  }
}
/**
 * ACTIVAR EL TOAST DE BOOTSTRAP 5
 */
// const toastTrigger = document.getElementById('liveToastBtn')
// const toastLiveExample = document.getElementById('liveToast')

// if (toastTrigger) {
//   const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample)
//   toastTrigger.addEventListener('click', () => {
//     toastBootstrap.show()
//   })
// }



