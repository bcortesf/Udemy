package com.empresabcf.sb.consola.repository.Qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value = "colombia")
public class TipoIvaColombia implements ITipoIva {

	@Override
	public double Calcular(double importe) {
		return importe * 1.19;
	}

}
