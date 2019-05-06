package okjjlee.aopdemo;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import okjjlee.aopdemo.beans.Student;

/**
 * bean的作用域：
 * 单例（singleton）：默认选项，在整个应用中，Spring只为其生成一个Bean。
 * 
 * 原型（prototype）：当每次注入，或者通过Spring IoC容器获取Bean时，Spring都会
 * 为它创建一个新的实例。
 * 
 * 会话（session）：在web应用中，每个session都创建一个实例。
 * 
 * 请求（request）：在web应用中，每个request都创建一个实例。
 */
public class ScopeOfDeanDemo {

	public static void main(String[] args) {
		FileSystemXmlApplicationContext act = new FileSystemXmlApplicationContext("//media/cocolee/MyFiles/code/oxygen_jsp/aopdemo/src/main/java/okjjlee/aopdemo/spring-cfg.xml");
	
		//在xml中，将作用设置为prototype
		Student student = act.getBean(Student.class);
		Student student1 = act.getBean(Student.class);
		assert student == student1 : "错误";
	}
}
