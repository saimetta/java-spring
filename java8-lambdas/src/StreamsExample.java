import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsExample {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Santiago","Aime",33),
				new Person("Vero","Sch",32),
				new Person("Magdalena","Boudelaire",5),
				new Person("Jerome","Sallinger",52),
				new Person("Raymond","Carver",52),
				new Person("Lewis","Carroll",69)
			);
		
		
		/**
		 * VERY IMPORTANT ABOUT STREAMS:
		 * don’t leave an instantiated streams unconsumed (Use a terminal method) as that will lead to memory leaks.
		 */
		
		
		//Creation
		//From collection, is supported by any collection
		Stream<Person> stream = people.stream();
		Stream<Person> streamOf = Stream.of(new Person("Santiago","Aime",33),new Person("Vero","Sch",32));
		//empty case
		Stream<Person> emptyStream = Stream.empty();
		//Builder
		Stream<Person> streamBuilder = 	Stream.<Person>builder().add(new Person("Santiago","Aime",33)).build();
		//Generated, it will generate an stream with 3 instance of Person santiago
		Stream<Person> generatedStream = Stream.generate( () -> new Person("Santiago","Aime",33)).limit(3);
		
		//Primitives streams, avoid the autoboxing to increase performance
		IntStream intStream = IntStream.range(1, 3); //excludes the end
		LongStream longStream = LongStream.rangeClosed(1, 3); //includes the end
		Random random = new Random();
		DoubleStream doubleStream = random.doubles(3);
		
		
		
		
		
		//Multi threading and parallel operations

				
		BiConsumer<Stream<Person>,Consumer<Person>> timer = (personStream,personAction)  -> {
			long startTime = System.currentTimeMillis();
			personStream.forEach(personAction);
			long endTime = System.currentTimeMillis();
			System.out.println((personStream.isParallel() ? "Parallel" : "Normal") +" stream took:" + (endTime - startTime) + " milliseconds");
		};
		
		//Normal
		timer.accept(people.stream(), p -> p.doSomethingThatTakes250Milis());
		//Parallel
		timer.accept(people.parallelStream(), p -> p.doSomethingThatTakes250Milis());
		
		//Convert parallel stream to sequential
		System.out.println("Is parallel? "+people.parallelStream().sequential().isParallel());
		
		
		
		//Filtering
		people.stream().filter(p -> p.getLastName().startsWith("C")).forEach(System.out::println);
		
		//Mapping
		Stream<String> firstNames = people.stream().map(p -> p.getFirstName());
		firstNames.forEach(System.out::println);
		
		//Flat mapping
		Stream<String> names =  people.stream().flatMap(p -> p.getNames().stream());
		names.forEach(n -> System.out.println("Flat mapping name: "+n));
		
		//Matching: terminal method that returns booleans
		System.out.println("any match with age = 5: "+people.stream().anyMatch(p -> p.getAge() == 5));
		System.out.println("all match with age >= 5: "+people.stream().allMatch(p -> p.getAge() >= 5));
		System.out.println("none match with age >= 5: "+people.stream().noneMatch(p -> p.getAge() >= 5));
		
		//Reducing
		
		System.out.println("Total age: "+people.stream().map(p -> p.getAge()).reduce(0, (total,age) -> total + age));
		
		//Collecting converts the stream to a collection
		
		System.out.println("To list: "+people.stream().map(p -> p.getFirstName()).collect(Collectors.toList()));
		
		System.out.println("Average age: "+people.stream().map( p -> p.getAge()).collect(Collectors.averagingInt(n -> n)));
		
		System.out.println("Average age: "+people.stream().collect(Collectors.averagingInt(p -> p.getAge())));
		
		System.out.println("Total age: "+people.stream().collect(Collectors.summingInt(p -> p.getAge())));
		
		//Collecting string
		System.out.println("Persons age: "+people.stream()
											.map(p -> p.getFirstName()+"("+p.getAge()+")")
											.collect(Collectors.joining(",","[","]"))
						   );
		//Collecting statistics
		IntSummaryStatistics statistics = people.stream()
				  .collect(Collectors.summarizingInt(Person::getAge));
		System.out.println("Age stats: "+statistics);
		
		
		//Grouping
		Map<Integer, List<Person>> ageMap = people.stream()
				  .collect(Collectors.groupingBy(Person::getAge));
		System.out.println("Grouped by age: "+ageMap);
		
		//Dividing, you can use Collectors.partitioningBy( predicate ) to divide elements, same procedure as Grouping
		
		

		
	

	}

}
