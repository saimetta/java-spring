
public class ThisReferenceExample {

	public void doProcess(int a, Process p) {
		p.process(a);
	}
	
	
	public void execute() {
		
		doProcess(10, i -> {
			System.out.println("Value of is I:"+i);
			System.out.println(this);
		});
	}
	
	public static void main(String[] args) {
		ThisReferenceExample example = new ThisReferenceExample();
		example.doProcess(10, new Process() {
			
			@Override
			public void process(int i) {
				System.out.println("Value of is I:"+i);
				System.out.println(this);
				
			}
			
			@Override
			public String toString() {
				return "This is the annonymous inner class";
			}
		});
		
		example.execute();
		
		
		
		example.doProcess(10, i -> {
			System.out.println("Value of is I:"+i);
			//It cant be done, lambdas use the same context of the class
			//Annonymous class has its own context
//			System.out.println(this);
		});
	}
	
	@Override
	public String toString() {
		return "This is ThisReferenceExample";
	}
}
