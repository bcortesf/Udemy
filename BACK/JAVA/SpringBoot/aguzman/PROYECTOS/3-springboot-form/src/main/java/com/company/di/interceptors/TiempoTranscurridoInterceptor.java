package com.company.di.interceptors;

import java.util.Random;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component(value = "TTiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {
	//private  Logger LOG = LoggerFactory.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		LOG.info("CLS.TiempoTranscurridoInterceptor: MTD.preHandle() - entrando...");
		long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);

		Random  random = new Random();
		Integer demora = random.nextInt(500);//Entre 0 y 500
		Thread.sleep(demora);
		
		return true;
		//return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		long tiempoFin = System.currentTimeMillis();
		long tiempoInicio = (Long)request.getAttribute("tiempoInicio");
		long tiempoTranscurrido = tiempoFin - tiempoInicio;

		if (modelAndView != null) {
			modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido);
		}

//		LOG.info("tiempoTranscurrido: " + tiempoTranscurrido + " milisegundos");
//		LOG.info("CLS.TiempoTranscurridoInterceptor: MTD.postHandle() - saliendo...");
		//HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
}
