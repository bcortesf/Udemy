package com.company.beans10;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BryanBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("\nAntes de la Inicializacion:  BEAN<" + beanName + ">");
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Despues de la Inicializacion:  BEAN<" + beanName + ">\n");
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

}
