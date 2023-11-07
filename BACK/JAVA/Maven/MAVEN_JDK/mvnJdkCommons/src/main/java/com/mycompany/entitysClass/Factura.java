/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entitysClass;

import com.mycompany.entitys.Interface.IFactura;
import java.util.Objects;

/**
 *
 * @author BryanCFz
 */
public class Factura implements IFactura{
    private int id;
    private String concepto; //->nombre-producto
    private double importe;  //->costo

    public Factura(int id, String concepto, double importe) {
        this.id = id;
        this.concepto = concepto;
        this.importe = importe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", concepto=" + concepto + ", importe=" + importe + '}';
    }


    /////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
/*    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.concepto);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.importe) ^ (Double.doubleToLongBits(this.importe) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Factura other = (Factura) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.importe) != Double.doubleToLongBits(other.importe)) {
            return false;
        }
        return Objects.equals(this.concepto, other.concepto);
    }
*/
    /////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean FacturasMayoresA300() {
        return importe > 300;
    }
    
    
}
