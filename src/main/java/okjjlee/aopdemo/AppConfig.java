package okjjlee.aopdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import okjjlee.aopdemo.beans.JuiceMaker2;

/**
 * spring-core介绍：
 * spring-core模块主要的功能是实现了控制反转IoC与AOP，Bean配置以及加载。
 * Core模块中有Beans、BeanFactory、BeanDefinitions、ApplicationContext等几个重要的概念
 * 
 * spring-beans介绍：
 * spring-beans模块中，定义了BeanFactory接口，BeanFactory是Spring IoC容器所定义的最底层接口。
 * Spring-IoC容器的设计主要是基于BeanFactory与ApplicationContext两个接口，
 * 其中ApplicationContext是BeanFactory子接口之一。
 * spring-beans主要解决三件事：bean的定义，bean的创建，bean的解析。
 * 
 * spring-context介绍：
 * ApplicationContext和WebApplicationContext在spring-context中定义，引入spring-context后，
 * 会自动引入spring-core和spring-beans。
 * 
 */


public class AppConfig
{
    public static void main( String[] args )
    {
    	FileSystemXmlApplicationContext act = new FileSystemXmlApplicationContext("//media/cocolee/MyFiles/code/oxygen_jsp/aopdemo/src/main/java/okjjlee/aopdemo/spring-cfg.xml");
    	JuiceMaker2 jui2 = (JuiceMaker2)act.getBean("juiceMaker2");
    	jui2.makeJuice();
    	act.close();
    }
}
