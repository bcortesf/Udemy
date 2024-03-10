package com.company.springbootjparelationship.entitys;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "clients")
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;


    /*----------------------------------------------------------------------------------------------------------------- */
    /*----------------------------------------------------------------------------------------------------------------- */
    /* @ONE_TO_MANY  ~~  UNO_A_MUCHOS
     * cascade      : Cuando se (cree, actualice, elimine) EN-CASCADA un <Cliente>; realice la misma operacion en campo."direccion"
     * orphanRemoval: Si elimino un <Client> la <Address> queda sin asignar a un <Client>, osea queda huerfana
     *                  - La relación en la tabla quedaria en NULL, por ende se establece el atributo en "true".
     *                    OJO: by-default-false
    */

    /*UNICA DIRECCION -> @OneClient_To_ManyAddress
     * IMPORTANTE#1.1:   DESACOPLADO  ->  **CREAR TABLA**(INTERMEDIA-ENLACE) CON JPA <AUTOMATICO,MANUAL>
     *                   ENTRE <Client> y <Address>, JPA CREA:  <UNA-TABLA-INTERMEDIA && DOS-LLAVES-FORANEAS>
     *                   <TABLA."clients_addresses"  &&  LLAVE-FORANEA."(client_id,  addresses_id)">
    */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true
        ,fetch = FetchType.EAGER  //->EAGER: ANSIOSO, SE CARGA INMEDIATO
    )
    private List<Address> addresses;
    /*IMPORTANTE#1.2:   DESACOPLADO  ->  **CREAR TABLA**(INTERMEDIA-ENLACE) CUSTOMIZADA POR MI
     *                  CON JPA <AUTOMATICO,MANUAL>.
     *                      - UNA TABLA "clientes_a_direcciones"
     *                      - LLAVES-FORANEAS."(<PRINCIPAL>.id_cliente,  <INVERSA>.id_direcciones)">
     *                          -id_cliente    : llave-foranea-que-se-repite      <PRINCIPAL>
     *                          -id_direcciones: llave-foranea-irrepetible-unica  <INVERSA>
     *
     * *ELIMINACION CON ORPHAN-REMOVAL*
     * orphanRemoval = false <DEFAULT>
     *      -Elimina datos de la <TABLA-RELACIONES O TABLA-ENLACE>."clientes_a_direcciones"
     *      -No elimina nada de TABLA."AddressDirecciones" y quedarian huerfanas estas direcciones
     * orphanRemoval = true
     *      -Elimina datos de las <TABLAS-RELACIONES Y TABLA-PRIMARIA> "clientes_a_direcciones  y  AddressDirecciones"""
    */

    //@JoinColumn(name = "cliente_id") : SE-PUEDE-DEFINIR-AQUI; SI ES UNI-DIRECCIONAL
    //-> PORQUE: aquio seria el dueño de la relacion

    @JoinTable(name = "clientes_a_direcciones"
        , joinColumns = @JoinColumn(name = "id_cliente")               //FK.foreign-key
        , inverseJoinColumns    = @JoinColumn(name = "id_direcciones") //UK.unique-key
            , uniqueConstraints = @UniqueConstraint(columnNames = {"id_direcciones"})
    )
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true
        ,fetch = FetchType.EAGER  //->default.LAZY: PEREZOSA, NO SE CARGA
    )
    private List<AddressDirecciones> direcciones;



    /*UNICA DIRECCION -> @OneClient_To_ManyCars
     * IMPORTANTE#2:     ACOPLADO  ->  **CREAR CAMPO**(LLAVE-FORANEA) AUTOMATICO CON JPA
     *                   EN TABLA QUE ABSORBE "CAMPO" EN RELACION "**MUCHOS**"; USANDO "@JoinColumn"
    */
    @JoinColumn(name = "FK_client_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true
        ,fetch = FetchType.EAGER
    )
    List<Car> cars;
    /*----------------------------------------------------------------------------------------------------------------- */
    /*----------------------------------------------------------------------------------------------------------------- */

    /**                  BI-DIRRECCIONAL
     * ->Relacion: OneClient_To_ManyInvoices
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true ,fetch = FetchType.EAGER
        ,mappedBy = "client"
    )
    private List<Invoice> invoices;


    public Client() {
        this.addresses = new ArrayList<>();
        this.direcciones = new ArrayList<>();
        this.cars = new ArrayList<>();
        this.invoices = new ArrayList<>();
    }
    public Client(String name, String lastname) {          //create
        this();
        this.name = name;
        this.lastname = lastname;
    }
    public Client(Long id, String name, String lastname) { //update
        this(name, lastname);
        this.id = id;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    public List<Address> getAddresses() {
        return addresses;
    }
    public void setDirecciones(List<AddressDirecciones> direcciones) {
        this.direcciones = direcciones;
    }
    public List<AddressDirecciones> getDirecciones() {
        return direcciones;
    }
    public List<Car> getCars() {
        return cars;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
    public List<Invoice> getInvoices() {
        return invoices;
    }


    /** METODO TO-STRING();
     * no poner "this.invoices",  porque se arma un bucle infinito
     *
     * - DEJARLO SOLO DONDE LA RELACION SEA LA MAYOR O LA QUE ABSORBA
     * Desde: src\main\java\com\company\springbootjparelationship\entitys\Invoice.java
     * - Estara el atributo.Client
     *
     * - OJO: EN esta clase.Client, no se debe poner el atributo "invoices"
     */
    @Override
    public String toString() {
        return "{id=" + id +
                ", name=" + name +
                ", lastname=" + lastname +
                ", addresses=" + addresses +
                    ", direcciones=" + direcciones +
                    ", cars=" + cars +
                ", invoices=" + invoices +
                "}";
    }

}
