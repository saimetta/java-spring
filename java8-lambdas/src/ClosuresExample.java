
public class ClosuresExample {

	public static void main(String[] args) {
		int a = 10;
		int b = 2;
		
		
		//In both cases b is passed as value, and its assumed that it wont change, in J7 it was required
		//to use a final scope
		Process innerClassWay = new Process() {
			
			@Override
			public void process(int i) {
				System.out.println(i+b);
				
			}
		};
		
		Process lambdaWay = i -> System.out.println(i+b);
		
		doProcess(a, lambdaWay);
		
		doProcess(a, innerClassWay);

	}

	public static void doProcess(int i, Process p) {
		p.process(i);
	}

}


interface Process {
	public void process(int i);
}


