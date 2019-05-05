package okjjlee.aopdemo.beans.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorImpl implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("4、bean初始化：" + bean.getClass().getSimpleName());
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("7、bean初始化完成：" + bean.getClass().getSimpleName());
		return bean;
	}
}
