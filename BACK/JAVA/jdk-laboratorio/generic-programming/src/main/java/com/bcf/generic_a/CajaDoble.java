package com.bcf.generic_a;

// Clase genérica que puede contener dos tipos de datos diferentes

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CajaDoble<T, U> {
    private final T contenido1;
    private final U contenido2;
}
