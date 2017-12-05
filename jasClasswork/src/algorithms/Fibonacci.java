package algorithms;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fibNum(3));
	}
	
	//Should take the first n numbers and add them
	public static int fibNum(int n) {
		if(n <= 1) {
			return 1;
		}
		return fibNum(n-1) + fibNum(n-2);
	}

}
