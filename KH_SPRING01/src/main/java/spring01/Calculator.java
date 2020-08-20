package spring01;

public class Calculator {
	
	
	public int process(int x, int y, String z) {
		if(z.equals("+")) {
			return x+y;
		}
		if(z.equals("-")) {
			return x-y;
		}
		if(z.equals("*")) {
			return x*y;
		}
		if(z.equals("/")) {
			return x/y;
		}
		return -1;
	}

}
