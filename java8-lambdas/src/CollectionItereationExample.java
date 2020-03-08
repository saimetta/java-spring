import java.util.Arrays;
import java.util.List;

public class CollectionItereationExample {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Santiago","Aime",33),
				new Person("Vero","Sch",32),
				new Person("Magdalena","Boudelaire",5),
				new Person("Jerome","Sallinger",57),
				new Person("Raymond","Carver",52),
				new Person("Lewis","Carroll",69)
			);
	
		people.forEach(System.out::println);
		people.forEach(p -> System.out.println(p));

	}

}
