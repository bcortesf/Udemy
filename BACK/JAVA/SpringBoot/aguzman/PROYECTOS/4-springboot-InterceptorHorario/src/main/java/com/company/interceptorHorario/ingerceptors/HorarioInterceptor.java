package com.company.interceptorHorario.ingerceptors;

import java.time.LocalTime;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component(value = "horarioInterceptor")
public class HorarioInterceptor implements HandlerInterceptor {
	//ALT + SHIFT + S  :  Override/Implement Methods...
	Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Value(value = "${config.horario.apertura}") private int horarioApertura;
	@Value(value = "${config.horario.cierre}") private int horarioCierre;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar calendar = Calendar.getInstance();
			int horaCa = calendar.get(Calendar.HOUR_OF_DAY);
			LOG.info("<Calendar>.Hora del dia: " + horaCa);
		LocalTime time = LocalTime.now();
			int horaTi = time.getHour();
			LOG.info("<LocalTime>.Hora del dia: " + horaTi);
		
		if (horaCa >= horarioApertura && horaCa < horarioCierre) {
			StringBuilder mensaje = new StringBuilder();
			mensaje.append("Bienvenido al horario de atención a clientes");
			mensaje.append(". Atendemos desde las ");
			mensaje.append(horarioApertura);
			mensaje.append("hrs de apertura. Hasta las ");
			mensaje.append(horarioCierre);
			mensaje.append("hrs de cierre. ");
			mensaje.append("Gracias por su visita");
			
			request.setAttribute("atencionHABILITADA", mensaje.toString());
			return true;
		}
		
		/*                                @GetMapping(path = {"/horarioCerrado"})*/
		response.sendRedirect(request.getContextPath().concat("/horarioCerrado"));
		return false;
		//return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		String mensaje = (String) request.getAttribute("atencionHABILITADA");
		if (modelAndView != null && handler instanceof HandlerMethod) {
			modelAndView.addObject("atencionON", mensaje);
			//HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		}
	}

}
