import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AleksTest {

	public static void main(String[] args) {
		List<Person> persons = getPeople();
		
		System.out.println("Filter > 56");
		List<Person> personesAgee = persons.stream()
			.filter(p -> p.getAge() > 56)
			.collect(Collectors.toList());
		personesAgee.forEach(System.out::println);		
		System.out.println("-----------------------------------");
		
		System.out.println("Filter FEMALE sorted by age");
		persons.stream()
			.filter(p -> p.getGender().equals(Gender.FEMALE))
			.sorted(Comparator.comparing(Person::getAge).reversed())
			.forEach(System.out::println);		
		System.out.println("-----------------------------------");
		
		boolean allMatch = persons.stream()
			.allMatch(p -> p.getAge() > 10);
		System.out.println("allMatch: "+allMatch);
		System.out.println("-----------------------------------");
		
		boolean noneMatch = persons.stream()
			.noneMatch(p -> p.getAge() < 5);
		System.out.println("noneMatch: "+noneMatch);
		System.out.println("-----------------------------------");
		
		boolean anyMatch = persons.stream()
			.anyMatch(p -> p.getGender().equals(Gender.FEMALE));
		System.out.println("anyMatch: "+anyMatch);
		System.out.println("-----------------------------------");
		
		persons.stream()
			.max(Comparator.comparing(Person::getAge))
			.map(Person::getAge)
			.ifPresent(System.out::println);
		System.out.println("-----------------------------------");
		
		persons.stream()
			.min(Comparator.comparing(Person::getAge))
			.map(Person::getAge)
			.ifPresent(System.out::println);
		System.out.println("-----------------------------------");
				
		Map<Gender, List<Person>> collect = persons.stream()
			.collect(Collectors.groupingBy(Person::getGender));
		
		collect.forEach((gender, people) -> {
			System.out.println(gender);
			people.forEach(System.out::println);
			System.out.println("");
		});
	}
	private static List<Person> getPeople() {
		List<Person> persons = new ArrayList<Person>();

		persons.add(new Person("Antonio", 20, Gender.MALE));
		persons.add(new Person("Alina Smith", 33, Gender.FEMALE));
		persons.add(new Person("Helen White", 57, Gender.FEMALE));
		persons.add(new Person("Alex Boz", 14, Gender.MALE));
		persons.add(new Person("Jamie Goa", 99, Gender.MALE));
		persons.add(new Person("Anna Cook", 7, Gender.FEMALE));
		persons.add(new Person("Zelda Brown", 120, Gender.FEMALE));
		return persons;
	}
}
