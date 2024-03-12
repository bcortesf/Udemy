package com.company.springbootjparelationship.entitys;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
        ,fetch = FetchType.LAZY  //->default.LAZY: PEREZOSA, NO SE CARGA
    )
    private Set<AddressDirecciones> direcciones;



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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true ,fetch = FetchType.LAZY
        ,mappedBy = "client"
    )
    private Set<Invoice> invoices;
    /* org.hibernate.LazyInitializationException:
        failed to lazily initialize a collection of role: com.company.springbootjparelationship.entitys.Client.invoices: could not initialize proxy - no Session
     * SOLUCIONES:  SE ESCOGE LA *3*
     *   + 1. cambiar a -> fetch = FetchType.LAZY
     *   + 2. agregar en application.properties -> spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
     *   + 3. *=>CREAR CONSULTA-CUSTOM EN REPOSITORIO CLIENTE CON "join fetch" :*
     *          src\main\java\com\company\springbootjparelationship\repositorys\IClientRepository.java
     */


    /*----------------------------------------------------------------------------------------------------------------- */
    /**                  UNI-DIRRECCIONAL
    /**
     * Si es UNI-DIRECCIONAL:
     *   El dueñó de la relacion es Client, y tendria LLAVE-FORANEA<ClientDetails>
     *  -Por defecto es:  @JoinColumn("client_details")
     *  -Podemos cambiar el nombre:  @JoinColumn("fk_client_details_id")
     */
    @JoinColumn(name = "fk_client_details_id")
    // @OneToOne
    @OneToOne(fetch = FetchType.EAGER)
    private ClientDetails clientDetails;



    public Client() {
        this.addresses = new ArrayList<>();
        this.direcciones = new HashSet<>();
        this.cars = new ArrayList<>();
        this.invoices = new HashSet<>();
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
    public void setDirecciones(Set<AddressDirecciones> direcciones) {
        this.direcciones = direcciones;
    }
    public Set<AddressDirecciones> getDirecciones() {
        return direcciones;
    }
    public List<Car> getCars() {
        return cars;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }
    public Set<Invoice> getInvoices() {
        return invoices;
    }
    public ClientDetails getClientDetails() {
        return clientDetails;
    }
    public void setClientDetails(ClientDetails clientDetails) {
        this.clientDetails = clientDetails;
    }

    //-----------------------------------------------
    //          METODOS-OPTIMIZADOS

    public Client addInvoice(Invoice invoice) {
        //oneToMany": unCliente-muchasFacturas
        this.invoices.add(invoice);
        //ManyToOne": unaFactura-unCliente
		invoice.setClient(this);

        return this;
    }
    public void removeInvoice(Invoice invoice) {
        //->Al Cliente remover sus Facturas //
        this.getInvoices().remove(invoice);
        //->A la Factura Remover su Cliente //
        invoice.setClient(null);
    }
    //-----------------------------------------------


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
                ", invoices=" + invoices +  /*->DEJAR uno de los dos en:  toString().client ó toString().invoice;  PARA-EVITAR-LOOP-INFINITO*/
                ", clientDetails=" + clientDetails +
                "}";
    }
}
