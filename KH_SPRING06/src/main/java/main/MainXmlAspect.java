package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import calculator.Calculator;

public class MainXmlAspect {
	public static void main(String[] args) {
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("aopAspect.xml");
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("aopOrder.xml");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("aopOrderAspect.xml");
		Calculator implCal = ctx.getBean("implCal", Calculator.class);
		long fiveFact1 = implCal.factorial(5);
		System.out.println("implCal.factorial(5) = " + fiveFact1);
		System.out.println("====================================");
		Calculator recCal = ctx.getBean("recCal", Calculator.class);
		long fiveFact2 = recCal.factorial(5);
		System.out.println("recCal.factorial(5) = " + fiveFact2);
		
		ctx.close();
	}
}
