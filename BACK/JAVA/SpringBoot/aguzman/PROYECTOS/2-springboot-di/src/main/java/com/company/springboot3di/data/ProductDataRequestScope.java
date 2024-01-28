package com.company.springboot3di.data;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.company.springboot3di.models.Product;

/*@SessionScope
 * Se mantiene mientras éste abierto cualquier pestaña del navegador. "Durablidad de varios request"
 * - Si se cierra el navegador, se destrutre toda la data
 * - EJEMPLO: un carrito de compras; sistema usuario con login.
 */
// @SessionScope

/*@RequestScope:
 * cambia componente-SINGLETON (Guardado en memoria), por:
 *      -> Un componente-INMUTABLE (por Usuario) por cada solicitud HTTP.request ~~ (Immutability-principle)
 */
@RequestScope
@Component
public class ProductDataRequestScope {
    private final List<Product> list;

    public ProductDataRequestScope() {
        this.list = Arrays.asList(
            new Product(1L, "productoA", 1.1),
            new Product(2L, "productoB", 2.2),
            new Product(3L, "productoC", 3.3)
        );
    }

    public List<Product> getList() {
        return list;
    }

}
