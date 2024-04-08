package com.company.alkosto.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank
    @Size(min = 3, max = 12)
    private String username;

    @NotBlank
    // @JsonIgnore  //->IGNORAR: no la toma encuenta para serializar/deserializar JSON<-->objJava
    @JsonProperty(
        //-> INCLUIR al persistir, mediante un POST
        //->No se muestra en salida - IUserService{"findAll(), save(User)"}
        //->Cuando deserializa, lee JSON desde FRONTEND y lo transformamos en una clase
        access = JsonProperty.Access.WRITE_ONLY
    )
    private String password;

    /**
     * UNI-DIRECCIONAL :a partir del usuario se obtiene los roles
     * BI-DIRECCIONAL  :a partir de un rol se obtenga los usuarios
     * ----------------------------------------------------------
     * ***UNI-DIRECCIONAL***
     * USUARIO tiene -> roles
     *     - obtener roles del usuario para la AUTENTICACION
     *     - obtener roles del usuario para ver PERMISOS"escritura/lectura" tiene.
     *     - obtener roles del usuario para ver ACCESOS "reglas-AUTORIZACION"
     */
    @ManyToMany              //Many"User"->toMany"Rol"
    @JoinTable(
        name = "users_roles", //mapea-tabla-intermedia
        joinColumns = @JoinColumn(name = "user_id")
            ,inverseJoinColumns = @JoinColumn(name = "role_id"),
        uniqueConstraints = { @UniqueConstraint(columnNames = {"user_id","role_id"}) }
    )
    private List<Role> roles;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean enabled; //-> habilitar/deshabilitar: para iniciar sesion

    /**
     *        ***es-una-variable-de-clase***
     * @Transient = NO ES UN CAMPO DE LA BASE-DATOS
     */
    @Transient
    private boolean isAdmin;



    public User() {}
    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    @PrePersist
    public void prePersist() {
        this.enabled = true;
    }


    /**GETTERS & SETTERS: porBaseDatos */
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    /**GETTERS & SETTERS: porClase  @Transient */
    public boolean isAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}
