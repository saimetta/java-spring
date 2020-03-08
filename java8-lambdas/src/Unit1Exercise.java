import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Unit1Exercise {
	

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
					new Person("Santiago","Aime",33),
					new Person("Vero","Sch",32),
					new Person("Magdalena","Boudelaire",5),
					new Person("Jerome","Sallinger",57),
					new Person("Raymond","Carver",52),
					new Person("Lewis","Carroll",69)
				);
		
		//Step 1 sort list by last name
		
		people.sort((p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		
		//step 2 create a method that prints all the elements in the list
		performConditionally(people,p -> true, p -> System.out.println(p));
		
		//step 3 create a method that prints persons with last name starting with C
		
		Predicate<Person> lastNameStartingWithCFilter = p -> p.getLastName().startsWith("C");
		
		performConditionally(people, lastNameStartingWithCFilter,p -> System.out.println(p));
	}
	
//It was replaced by a generic funcion interface from java.util.function
//	@FunctionalInterface
//	interface Filter<T> {
//		boolean test(T element);
//	}

	private static void performConditionally(List<Person> people, Predicate<Person> predicate,Consumer<Person> consumer) {
		people.forEach((p) -> {
			if(predicate.test(p)) {
				consumer.accept(p);;
			}
		});
	}
}
