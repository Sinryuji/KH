package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import conf.JavaConfig;
import spring.Client;
import spring.Client2;

public class Main2 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		Client client = ctx.getBean("client", Client.class);
		Client2 client2 = ctx.getBean("client2",Client2.class);
		client.send();
		client2.send();
		ctx.close();

	}

}
