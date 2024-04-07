package com.company.alkosto.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    private String password;

    private boolean enabled;

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

    /**
     *        ***es-una-variable-de-clase***
     * @Transient = NO ES UN CAMPO DE LA BASE-DATOS
     */
    @Transient
    private boolean isAdmin;


    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
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
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    /**GETTERS & SETTERS: porClase  @Transient */
    public boolean isAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}
