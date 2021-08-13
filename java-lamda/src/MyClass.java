import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MyClass {
	public static void main(String[] args) {
		List<Person> roster = new ArrayList<>();
		roster.add(new Person("Rajesh", 23, Sex.MALE, "Hello@gmail.com"));
		roster.add(new Person("Suresh", 22, Sex.MALE, "HelloSur@gmail.com"));
		roster.add(new Person("Rekha", 26, Sex.FEMALE, "HelloRe@gmail.com"));
		roster.add(new Person("Kumari", 18, Sex.FEMALE, "Kumari@gmail.com"));

		// Approach 1
		System.out.println("\nApproach 1");
		printPersonsOlderThan(roster, 19);
		// Approach 2
		System.out.println("\nApproach 2");
		printPersonsWithinAgeRange(roster, 20, 24);
		// Approach 3
		System.out.println("\nApproach 3");
		printPersons(roster, new CheckPersonEligibleForSelectiveService());
		// Approach 4
		System.out.println("\nApproach 4");
		printPersons(roster, new CheckPerson() {
			public boolean test(Person p) {
				return p.getGender() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
			}
		});

		// Approach 5
		System.out.println("\nApproach 5");
		printPersons(roster, (Person p) -> p.getGender() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);

		// Approach 6
		System.out.println("\nApproach 6");
		printPersonsWithPredicate(roster, p -> p.getGender() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);

		// Approach 7
		System.out.println("\nApproach 7");
		processPersons(roster, p -> p.getGender() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
				p -> p.printPerson());

		processPersonsWithFunction(roster, p -> p.getGender() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
				p -> p.getEmailAddress(), email -> System.out.println(email));

		// Approach 8
		System.out.println("\nApproach 8");
		processElements(roster, p -> p.getGender() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
				p -> p.getEmailAddress(), email -> System.out.println(email));

		// Approach 9
		System.out.println("\nApproach 9");
		roster.stream().filter(p -> p.getGender() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25)
				.map(p -> p.getEmailAddress()).forEach(email -> System.out.println(email));
	}

	public static void printPersonsOlderThan(List<Person> roster, int age) {
		for (Person p : roster) {
			if (p.getAge() >= age) {
				p.printPerson();
			}
		}
	}

	public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
		for (Person p : roster) {
			if (low <= p.getAge() && p.getAge() < high) {
				p.printPerson();
			}
		}
	}

	public static void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				block.accept(p);
			}
		}
	}

	public static void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester,
			Function<Person, String> mapper, Consumer<String> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				String data = mapper.apply(p);
				block.accept(data);
			}
		}
	}

	public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester, Function<X, Y> mapper,
			Consumer<Y> block) {
		for (X p : source) {
			if (tester.test(p)) {
				Y data = mapper.apply(p);
				block.accept(data);
			}
		}
	}
}
