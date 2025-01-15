import { Injectable } from '@angular/core';
import { AbstractControl, AsyncValidator, ValidationErrors } from '@angular/forms';
import { Observable, delay, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmailValidatorService implements AsyncValidator {

  validate(control: AbstractControl): Observable<ValidationErrors | null> { //Emite(ValidationErrors)
    const email = control.value;
    //---------------------------------------------------------------
    /**temporal-test */

    /*console.log('email: ', email);
    return of({
      emailTaken: true
    }).pipe(
      delay(2000) //PAra ver el pending, en estados en HML-formulario
    );*/
    //---------------------------------------------------------------
    const httpCallObservable = new Observable<ValidationErrors | null>(
      (subscriber) => {
        console.log('email: ', email);
        const reponseEmailExistingBackend = 'bcortesf.developer@gmail.com';
        if (email === reponseEmailExistingBackend) {
          subscriber.next( //emite-el-valor-error
            { emailTaken: true }
          );
          subscriber.complete(); //==return
        }
        //->no existe correo, no esta tomado correo, no hay error
        subscriber.next(null);
        subscriber.complete(); //==return
      }
    ).pipe(
      delay(2000) //PAra ver el pending, en estados en HML-formulario
    );

    return httpCallObservable;
  }

}


/**
 *
  /-> //
  validate(control: AbstractControl<any, any>):
    Promise<ValidationErrors | null> |
    Observable<ValidationErrors | null> //Emite(ValidationErrors)
  {
  throw new Error('Method not implemented.');
  }

  //-->Determina cuando el validador cambia //
  registerOnValidatorChange?(fn: () => void): void {
    throw new Error('Method not implemented.');
  }
 *
 */
