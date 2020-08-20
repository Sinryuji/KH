package spring01;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main4 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext3.xml");
		
		Calculator cal = ctx.getBean("calculator", Calculator.class);
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.nextLine();
		String z = sc.nextLine();
		
		System.out.println(cal.process(x, y, z));
		ctx.close();

	}

}
