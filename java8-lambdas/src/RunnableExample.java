
public class RunnableExample {

	public static void main(String[] args) {
		//Annonymus inner class example
		Thread threadWithInnerClass = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Printed inside a thread");
				
			}
		});
		threadWithInnerClass.run();
		
		//This works b/c Runnable has only one method!
		Thread threadWithLambda = new Thread(() -> System.out.println("Printed inside lambda"));
		threadWithLambda.run();

	}

}
