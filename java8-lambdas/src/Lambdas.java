
public class Lambdas {

	public static void main(String[] args) {
		Greater greater = new Greater();
		
		greater.greet(new HelloworldGreetings());
		
		Greetings lambda = () -> System.out.println("Hello lambda");
		greater.greet(lambda);
		
		
		greater.greet(() -> System.out.println("Hello lambda 2"));
		
		

	}

}
