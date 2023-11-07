/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.b13_RxJava;

import com.mycompany.Repository.Repository;
import com.mycompany.entitysRecords.Nota;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import static io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe.subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=dD0vE3GGzDM&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&index=16
 * https://www.youtube.com/watch?v=bM9wZvlpRwE
 * https://www.youtube.com/watch?v=6_WmFwFcEcc
 * la programación reactiva cada vez gana más terreno en Backend y front end, alternativas como project reactor, webflux, rxjava, rxjs, etc.
 * System.out.println("->");
 * @author BryanCFz
 */
public class Test {
    
    private List<Nota> notasA;
    private List<Nota> notasB;

    public Test() {
        notasA = new ArrayList<>();
        notasB = new ArrayList<>();
        llenarListas();
    }
    
    public void llenarListas() {
        System.out.println("->llenarListas()");
        for (int i = 0; i < 10; i++) {
            notasA.add(new Nota("asignaturaA-"+i, i));
            notasB.add(new Nota("asignaturaB-"+i, i));
        }
    }
    
    /**
     * <Observador>     :Elemento  PADRE<OBSERVADOR> ; tendra una logica y puede cambiar
     * <Observadores>   :Elementos HIJOS<OBSERVABLES>; que "Observaran" a un --> PADRE<OBSERVADOR>
     * ..............
     * Definimos los objetos Observables:  es decir los Observadores
     * 
     * @param lista 
     */
    public void buscar() {
        System.out.println("->buscar()");
        Observable<List<Nota>> obsA = Observable.just(notasA);
        Observable<List<Nota>> obsB = Observable.just(notasB);
        //Observable<List<Nota>> obsB = Observable.fromArray(notasB);
        
        //unir dos obervables , en un solo Observable
        Observable.merge(obsA, obsB).subscribe( 
                //->onNext
                (List<Nota> n) -> {
                    System.out.println("\nNOTAS-IGUALES-A-1.0");
                    for (Nota nota : n) {
                        if (nota.valor() == 1.0) {
                            System.out.println("La asignatura[" + nota.asignatura() + "] con calificacion: " + nota.valor());
                        }
                    }
                }
        );
        /////////////////////////////////////////////////////
        // https://www.baeldung.com/rx-java#subjects
        System.out.println("NOTAS iguales a 2");
        Observable.merge(obsA, obsB)
//                .filter( (List<Nota> n) -> {
//                    //return true;
//                    for (Nota nota : n) {
//                        if (nota.valor() == 3.0) {
//                            return true;
//                        }
//                    }
//                    return false;
//                })
                .subscribe( (List<Nota> n) -> {
                    //System.out.println(n) 
                    for (Nota nota : n) {
                        if (nota.valor() == 5.0) {
                            System.out.println("La asignatura[" + nota.asignatura() + "] con calificacion: " + nota.valor());
                        }
                    }
                });
    }
    

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.b13_RxJava".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        // PRINCIPIO DE LA  :PROGRAMACION REACTIVA
        Test tst        = new Test();
        Repository repo = new Repository();
        List<Nota> lista = repo.getNotas();
        
        /**
         * http://migranitodejava.blogspot.com/search/label/Observer
         * https://www.youtube.com/watch?v=dD0vE3GGzDM&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS&t=178s
         * https://github.com/ReactiveX/RxJava
         * 
         * https://www.google.com/search?q=java+observable+subscribe&oq=java+observer.su&gs_lcrp=EgZjaHJvbWUqCAgBEAAYFhgeMgYIABBFGDkyCAgBEAAYFhgeMggIAhAAGBYYHtIBCTEwMjE5ajBqN6gCALACAA&sourceid=chrome&ie=UTF-8&bshm=rimc/1
         * https://www.baeldung.com/rx-java
         * https://programacionymas.com/blog/introduccion-rx-java-tutorial-android
         * 
         * https://chat.openai.com/c/a8bc7acd-6be1-45ef-acd5-108e8b17ac62
         */
        Observable<List<Nota>> obs = Observable.fromArray(lista);
        
        //obs.subscribe(    onNext, onError, onComplete, onSubscribe    );
        obs.subscribe(
                //->onNext
                (List<Nota> valueList) -> {  
                    System.out.println("onNext: " + valueList);
                },
                //->onError
                ((Throwable t) -> { 
                    System.err.println("onError: " + t);
                }),
                //->onComplete
                ( () -> { 
                    System.out.println("onComplete: ".concat("termina todo OK!"));
                })
        );

       //////////////////////////////////////////////////////////////
       tst.buscar();
    }
}
