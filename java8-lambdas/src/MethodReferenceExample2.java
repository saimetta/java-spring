import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {
	
	//TODO: seguir x aca: https://javabrains.io/courses/java_lambdabasics/lessons/The-foreach-iteration/
	
	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
					new Person("Santiago","Aime",33),
					new Person("Vero","Sch",32),
					new Person("Magdalena","Boudelaire",5),
					new Person("Jerome","Sallinger",57),
					new Person("Raymond","Carver",52),
					new Person("Lewis","Carroll",69)
				);
		
		
		performConditionally(people,p -> true, System.out::println);
		
		
	}
	


	private static void performConditionally(List<Person> people, Predicate<Person> predicate,Consumer<Person> consumer) {
		people.forEach((p) -> {
			if(predicate.test(p)) {
				consumer.accept(p);;
			}
		});
	}
}
