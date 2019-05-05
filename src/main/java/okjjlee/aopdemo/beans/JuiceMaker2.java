package okjjlee.aopdemo.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Bean的生命周期：
 * 关于Bean的生命周期的接口，一共有6个，分别是：
 * BeanNameAware、BeanFactoryAware、ApplicationContextAware、
 * BeanPostProcessor、InitializingBean、DisposableBean
 * 
 * 调用次序为：
 * 1、BeanNameAware.setBeanName()
 * 2、BeanFactoryAware.setBeanFactory()
 * 3、ApplicationContextAware.setApplicationContext()
 * 4、BeanPostProcessor.postProcessorBeforeInitialization()
 * 5、InitializingBean.afterPropertiesSet()
 * 6、自定义初始化方法
 * 7、BeanPostProcessor.postProcessorAfterInitialization()
 * 8、DisposableBean.destroy()
 * 9、自定义销毁方法
 */
public class JuiceMaker2 implements BeanNameAware,
				BeanFactoryAware, ApplicationContextAware,
				InitializingBean, DisposableBean{

	private String beverageShop;

	private Source source;

	public void makeJuice() {
		System.out.println(beverageShop + ":" + source.getFruit() + "," + source.getSize() + "," + source.getSugar());
	}

	public String getBeverageShop() {
		return beverageShop;
	}

	public void setBeverageShop(String beverageShop) {
		this.beverageShop = beverageShop;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("5、调用了" + this.getClass().getSimpleName() + "的afterPropertiesSet方法");
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("3调用了" + this.getClass().getSimpleName() + "的setApplicationContext方法");
	}

	public void setBeanName(String name) {
		System.out.println("1、[" + this.getClass().getSimpleName() + "]调用BeanNameAware接口的SetBeanName方法");
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("2、调用了" + this.getClass().getSimpleName() + "的setBeanFactory方法");
	}

	public void init() {
		System.out.println("6、[" + this.getClass().getSimpleName() + "] 执行自定义初始化方法");
	}
	
	public void myDestroy() {
		System.out.println("9、[" + this.getClass().getSimpleName() + "] 执行自定义销毁方法");
	}

	public void destroy() throws Exception {
		System.out.println("8[" + this.getClass().getSimpleName() + "] 执行销毁方法");
	}
}
