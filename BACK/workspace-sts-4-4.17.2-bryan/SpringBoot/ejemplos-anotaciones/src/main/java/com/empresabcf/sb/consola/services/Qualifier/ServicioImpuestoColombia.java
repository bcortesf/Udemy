package com.empresabcf.sb.consola.services.Qualifier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.empresabcf.sb.consola.models.Qualifier.Gasto;
import com.empresabcf.sb.consola.repository.Qualifier.ITipoIva;

@Service
public class ServicioImpuestoColombia {
	@Autowired
	@Qualifier(value = "colombia")
	private ITipoIva tipoIva;

	public ITipoIva getTipoIva() {
		return tipoIva;
	}

	public void setTipoIva(ITipoIva tipoIva) {
		this.tipoIva = tipoIva;
	}
	
	//
	public double totalGastoConIva(List<Gasto> gastos) {
		return gastos.stream().mapToDouble(gasto -> tipoIva.Calcular(gasto.getImporte())).sum();
	}

}
