package com.develop_bcf.jpa.EntityDomain.Recursive;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERSONA_R")
public class PadreRecursivo {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    public String nombre;
    
    //obtiene todos los padres antepasados 
    @ManyToOne
    private PadreRecursivo padre;
    
    //obtiene todos los hijos del presente al futuro
    @OneToMany(mappedBy="padre")
    private List<PadreRecursivo> hijo;
    
    public PadreRecursivo() {
	}
    
    public PadreRecursivo(String nombre) {
		this.nombre = nombre;
	}

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public PadreRecursivo getPadre() {
		return padre;
	}

	public void setPadre(PadreRecursivo padre) {
		this.padre = padre;
	}


	//..
	public List<PadreRecursivo> getHijo() {
		return hijo;
	}

	public void setHijo(List<PadreRecursivo> hijo) {
		this.hijo = hijo;
	}

    
}
