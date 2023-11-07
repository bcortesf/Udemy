/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.a2_LambdaStream;

import com.mycompany.Repository.Repository;
import com.mycompany.entitysClass.Persona;
import com.mycompany.entitysClass.lombok.Producto;
import com.mycompany.services.Service;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * https://github.com/mitocode21/java11-stream-demo
 * https://github.com/mitocode21/java11-stream-demo/blob/main/pom.xml

 * https://www.youtube.com/watch?v=U5oOdNG2XQY&t=916s       :crear proyecto maven, con arquetipo "QuickStart" - vsCode
 * https://www.youtube.com/watch?v=U5oOdNG2XQY&t=1070s      :configurar tipo de java openJDK, oracle, AdoptOpenJDK - vsCode
 * https://www.youtube.com/watch?v=U5oOdNG2XQY&t=1790s      :metodo referencia dice: si tengo en el parametroIzquierda, lo mismo que el parametroDerecha. Entonces simplificar
 * https://www.youtube.com/watch?v=U5oOdNG2XQY&t=3185s      :funcionalidad de map; trnasformacion de datos y obtener una lista del mismo tipo o de otro tipo de dato
 * https://www.youtube.com/watch?v=U5oOdNG2XQY&t=4672s      :paginador para con frontend y un springbot por ejemplo, usando limit y skip
 * https://www.youtube.com/watch?v=U5oOdNG2XQY&t=5310s      :agrupar por tipo de dato y mostrar cuantas veces se repite un dato - groupingBy..counting
 * https://www.youtube.com/watch?v=U5oOdNG2XQY&t=5963s      :reduce, recibe acumuladores
 * @author BryanCFz
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.a2_LambdaStream.Test".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        //
        Test tst = new Test();
        Repository repo = new Repository();
        List<Persona> personas = repo.getPersonas();
        List<Producto> productos = repo.getProductos();

        tst.Lambda_MethodReference(personas, productos);
        tst.Filter(personas, productos);
        tst.Map(personas, productos);
        tst.Sorted(personas, productos);
        tst.Match(personas, productos);
        tst.AnyMatch(personas, productos);
        tst.AllMatch(personas, productos);
        tst.NoneMatch(personas, productos);
        tst.Limit_Skip(personas, productos);
        tst.Collectors(personas, productos);
        tst.GroupBy(personas, productos);
        tst.Counting(personas, productos);
        tst.AgruparPorNombreProducto_sumarValores(personas, productos);
        tst.ObtenerSuma_yResumen(personas, productos);
        tst.Reduce(personas, productos);
    }

    public void Lambda_MethodReference(List<Persona> personas, List<Producto> productos) {
        System.out.println("\n->Lambda_MethodReference()");

        System.out.println("+ servicio +");
        //->filtramos registros, que llegan de FRONT-END
        List<Persona> listPeople = personas.stream()
            .filter((Persona p) ->
                    p.getFechaNacimiento().isAfter(LocalDate.parse("1990-02-21"))
                &&  p.getFechaNacimiento().isBefore(LocalDate.parse("2019-01-01")) )
            .toList();

        //->OPERACIONES BACK-END; PARA UNA DATA-BASE
        Service servicio = new Service();

        //->guardar personas en el servicio de almacenamiento de personas; BACKEND
//        listPeople.forEach((Persona p) -> servicio.registrarPersona(p) );     //consumer: es un metodo void
        listPeople.forEach(servicio::registrarPersona);                         //consumer: es un metodo void

        //->obtener registros del servicio BACKEND
        servicio.getPersons().forEach(System.out::println);
        ///////////////////////////////////////////////////

        System.out.println("+ lamda y metodoReferencia; simple +");
        personas.forEach((Persona p) -> {System.out.println(p);}); //consumer: es un metodo void
        productos.forEach(System.out::println);
    }

    public void Filter(List<Persona> personas, List<Producto> productos) {
        System.out.println("\n->1. Filter(param: Predicate)");

        System.out.println("+ productos con precio = 15.0 +");
        productos.stream()
                .filter((Producto p) -> p.getPrecio() == 15.0)
                .forEach(System.out::println);

        System.out.println("+ personas mayores a la fecha '2000-01-01' +");
        personas.stream()
                .filter((Persona p) -> p.getFechaNacimiento().isAfter(LocalDate.parse("2000-01-01")))
                .forEach(System.out::println);
        
        System.out.println("+ personas menores a 18 años +");
//        personas.stream()
//                .forEach((per) -> {
//                    System.out.println(per);
//                    System.out.println("añóös: " + (LocalDate.of(2023, Month.SEPTEMBER, 1).getYear() - per.getFechaNacimiento().getYear()) );
//                });

//        personas.stream()
//                .filter((Persona p) -> {
//                    int edadPersona = LocalDate.of(2023, Month.SEPTEMBER, 1).getYear() - p.getFechaNacimiento().getYear();
//                    return edadPersona < 18;
//                })
//                .forEach(System.out::println);

        List<Persona> personasMenoresEdad = personas.stream()
                .filter((Persona p) -> Test.getAge(p.getFechaNacimiento()) < 18 )
                .collect(Collectors.toList());
        Test.printList(personasMenoresEdad); //convertido a tipo Object, mirar javaJDK-7
    }
    private static int getAge(LocalDate birthDay) {
        return Period.between(birthDay, LocalDate.of(2023, Month.SEPTEMBER, 1)).getYears(); //por-fecha-seteada
        //return Period.between(birthDay, LocalDate.now()).getYears();                                                                    //por-añoActual
    }

    //->* Transformar una lista de un tipo<valorA> a otro tipo<valorB>
    public void Map(List<Persona> personas, List<Producto> productos) {
        System.out.println("\n2. ->Map(param: Function)");
        
        System.out.println("+ personas menores a 18 años +");
        //var = JDK-9
        var aaa = personas.stream()
                .filter((Persona p) -> Test.getAge(p.getFechaNacimiento()) < 18)
                .map((Persona p) -> Test.getAge(p.getFechaNacimiento()) )
                .collect(Collectors.toList());
        Test.printList(aaa);
        System.out.println( "tipo de dato de var :" + aaa.getClass().getSimpleName() ); //->:ArrayList
        System.out.println( "tipo de dato de var :" + aaa.getClass().getName() );       //->:java.util.ArrayList
        
        System.out.println("+ edad de todas las personas +");
        List<Integer> listaEdades = personas.stream()
                .map((Persona p) -> Test.getAge(p.getFechaNacimiento()) )
                .collect(Collectors.toList());
        Test.printList(listaEdades);
        
        System.out.println("+ Funcion para reutilizar en un MAP muchas veces +");
        Function<String, String> coderFunction =  (String paramEntrada_nombrePersona) -> "Coder-" + paramEntrada_nombrePersona;
        List<String> listaDesarrolladores = personas.stream()
                //.map((Persona p) -> p.getNombre()) //el map es de tipo Stream<PERSONA>, debemos transformarlo en un --> Stream<STRING>
                .map(Persona::getNombre)            //el map es de tipo Stream<PERSONA>, debemos transformarlo en un --> Stream<STRING>
                .map( coderFunction )        //teniendo el Stream<String> ya treansformado, ya podemos manipularlo como <STRING>
                .collect(Collectors.toList());
        Test.printList(listaDesarrolladores);
    }

    public void Sorted(List<Persona> personas, List<Producto> productos){
        System.out.println("\n3. ->Sorted(param: Comparator)");

        System.out.println("+ Personas ordenadas ASC, por nombre +");
        List<Persona> personasSortedByName = personas.stream()
                .sorted((Persona p1, Persona p2) -> p1.getNombre().compareTo(p2.getNombre()))
                .collect(Collectors.toList());
        Test.printList(personasSortedByName);
        
        System.out.println("+ Personas ordenadas DESC, por fechaNacimiento +");
        List<Persona> personasAscSortedByBirthDay = personas.stream()
                .sorted((Persona p1, Persona p2) -> p2.getFechaNacimiento().compareTo(p1.getFechaNacimiento()))
                .collect(Collectors.toList());
        Test.printList(personasAscSortedByBirthDay);

        
        System.out.println("+ Personas ordenadas ASC, por fechaNacimiento +");
        Comparator<Persona> byBirthDayDESC = (Persona p1, Persona p2) -> p1.getFechaNacimiento().compareTo(p2.getFechaNacimiento());   //creacion de un comparator
        List<Persona> personasDescSortedByBirthDay = personas.stream()
                .sorted(byBirthDayDESC)          //usando un comparator
                .collect(Collectors.toList());
        Test.printList(personasDescSortedByBirthDay);
    }

    public void Match(List<Persona> personas, List<Producto> productos) {
        System.out.println("\n4. ->MATCH:  [{AnyMatch~~AllMatch~~NoneMatch} x (param: Predicate)=funcBoleana]");
    }

    public void AnyMatch(List<Persona> personas, List<Producto> productos) {
        System.out.println("\n\t".concat("4.1 ->AnyMatch(param: Predicate)  -  :No evalua todo el stream, termina en la primer coincidencia"));
        Predicate<Persona> predicate = (Persona p) -> p.getNombre().startsWith("B");
        boolean existeNombrePorB = personas.stream()
                .anyMatch(predicate);
        System.out.println("\t" + "Existe algun nombre, que empieze por la letra 'B'?  :" + existeNombrePorB);
    }

    public void AllMatch(List<Persona> personas, List<Producto> productos) {
        System.out.println("\n\t".concat("4.2 ->AllMatch(param: Predicate)  -  :Evalua todo el stream, bajo la condición"));
        Predicate<Persona> predicate = (Persona p) -> p.getNombre().startsWith("B");
        boolean existeNombrePorB = personas.stream()
                .allMatch(predicate);
        System.out.println("\t" + "Todos los nombres, empiezan por la letra 'B'?  :" + existeNombrePorB);
    }

    public void NoneMatch(List<Persona> personas, List<Producto> productos) {
        System.out.println("\n\t".concat("4.3 ->NoneMatch(param: Predicate)  -  :Evalua todo el stream, bajo la concondición"));
        //Predicate<Persona> predicate = (Persona p) -> p.getNombre().startsWith("B"); //false
        Predicate<Persona> predicate = (Persona p) -> p.getNombre().startsWith("Z"); //true
        boolean existeNombrePorB = personas.stream()
                .noneMatch(predicate);
        System.out.println("\t" + "Ninguno de los nombres, empiezan por la letra 'B'?  :" + existeNombrePorB);
    }

    public void Limit_Skip(List<Persona> personas, List<Producto> productos) {
        System.out.println("\n5. ->Limit_Skip()");
        
        System.out.println("+ Primeras 2 Personas de la lista +");
        List<Persona> listaPrimerasTresPersonas = personas.stream()             //primeras 2 personas
                .limit(2)
                .collect(Collectors.toList());
        Test.printList(listaPrimerasTresPersonas);
        
        System.out.println("+ Saltar primeras 2 Personas y obtener el restante de la lista +");
        List<Persona> listaQuitarPrimerasTresPersonas = personas.stream()       //ultimas 3 personas
                .skip(2)
                .collect(Collectors.toList());
        Test.printList(listaQuitarPrimerasTresPersonas);
        
        // https://stackoverflow.com/questions/4540684/java-round-up-any-number
        System.out.println("+ Paginador de personas +");
        int totalPersonas = personas.size();  //5
        int pageNumber = 0; //paginaActual
        int pageSize = 2;   //cantidadPaginas
        int iteraciones    = (int)Math.ceil( totalPersonas/Double.valueOf(pageSize) );
        for (int i = 0; i < iteraciones; i++) {
            pageNumber = i;
            System.out.println("***Iteracion["+i+"]");
            personas.stream()
                    .skip(pageSize * pageNumber)
                    .limit(pageSize).forEach(System.out::println);
        }
    }

    public void Collectors(List<Persona> personas, List<Producto> productos) {
        System.out.println("\n6. ->COLLLECTORS:  [{GroupBy~~Counting~~xxx~~} x (param: Collectors)]");
    }

    public void GroupBy(List<Persona> personas, List<Producto> productos) {
        System.out.println("\n\t".concat("6.1 ->GroupBy(param: Collectors)"));
        System.out.println("\t + Agrupar Productos por precio; mayor a 15 +");
        Map<Double, List<Producto>> mapAgruparPrecioPorProductos = productos.stream()
                .filter((Producto p) -> p.getPrecio() > 20)
                .collect(Collectors.groupingBy(Producto::getPrecio));
        System.out.println("\t" + mapAgruparPrecioPorProductos);
    }

    public void Counting(List<Persona> personas, List<Producto> productos) {
        System.out.println("\n\t".concat("6.2 ->Counting(param: Collectors)"));
        System.out.println("\t + Agrupar Productos por nombre; mostrar cantidad de veces que esta el <Producto.Nombre> +");
        Map<String, Long> mapAgruparNombrePorCantidad = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getNombre,
                        Collectors.counting()
                ));
        System.out.println("\t" + mapAgruparNombrePorCantidad);
    }

    public void AgruparPorNombreProducto_sumarValores(List<Persona> personas, List<Producto> productos) {
        System.out.println("\n\t".concat("6.3 ->AgruparPorNombreProducto_sumarValores()"));
        System.out.println("\t + Agrupar Productos por nombre; mostrar sumatoria de <Producto.Precio> +");
        Map<String, Double> mapAgruparNombreMasSumatoriaPrecio = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getNombre,
                        Collectors.summingDouble(Producto::getPrecio)
                ));
        System.out.println("\t" + mapAgruparNombreMasSumatoriaPrecio);
    }

    public void ObtenerSuma_yResumen(List<Persona> personas, List<Producto> productos) {
        System.out.println("\n\t".concat("\n6.4 ->ObtenerSuma_yResumen()"));

        DoubleSummaryStatistics resumenEstadistico = productos.stream()
                .collect(Collectors.summarizingDouble(Producto::getPrecio));
        System.out.println("\t + resumen estadistico + :" + resumenEstadistico);
        System.out.println("\t + sumatoria de todos los productos, por <Producto.precio> + :" + resumenEstadistico.getSum());
        System.out.println("\t + promedio de todos los productos, por <Producto.precio> + :" + resumenEstadistico.getAverage());
    }

    public void Reduce(List<Persona> personas, List<Producto> productos) {
        System.out.println("\n7. ->Reduce()");
        Optional<Double> sumatoriaA = productos.stream()
                .map(Producto::getPrecio)
                .reduce((Double t, Double u) -> t+u); //agrupar criterios-acumuladores(sumas,maximos,minimos)
        System.out.println("\t + sumatoriaA + :" + sumatoriaA);
        
        // https://www.javatpoint.com/java-double-sum-method
        //      public static double sum(double a, double b){}
        
        Optional<Double> sumatoriaB = productos.stream()
                .map(Producto::getPrecio)
                .reduce(Double::sum); //agrupar criterios-acumuladores(sumas,maximos,minimos)
        System.out.println("\t + sumatoriaB + :" + sumatoriaB.get());
    }


    ////////////////////////////////////////////////////////////////////////////
    /**
     * (List<?> lista) = (List<? extends Object> lista)
     * @param lista     :convertida a tipo OBJECT
     */
    public static void printList(List<?> lista) {
        lista.forEach(System.out::println);
    }
}

    // public void () {
        
    // }
