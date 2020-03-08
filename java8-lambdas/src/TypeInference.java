
public class TypeInference {

	public static void main(String[] args) {
		
		
		StringLengthLambda sll = s -> s.length();
		
		System.out.println(sll.getLength("The parameter type is inferred by the lambda type"));
		
		printLambda(s -> s.length());

	}
	
	private static void printLambda(StringLengthLambda l) {
		System.out.println(l.getLength("Using the interface to type the param"));
	}

	interface StringLengthLambda {
		int getLength(String s);
	}

}
