package algorithms;

public class NumberAlgorithms {

	public static void main(String[] args){
		int value = 18;
		System.out.println(value+"! is equal to "+factorial(value));
		System.out.println(value+ " has "+countPrimeFactors(value, 2)+" prime factors.");
	}

	public static int countPrimeFactors(int value, int testPrime) {
		if(testPrime == value) {
			return 1;
		}
		else if(value % testPrime == 0) {
			return countPrimeFactors(value / testPrime, testPrime) + 1;
		}
		else {
			return countPrimeFactors(value, testPrime + 1);
		}
	}

	public static int factorial(int value) {
		int num = 1;
		if(value > 0) {
			num = value * factorial(value - 1);
		}
		return num;
	}

}
