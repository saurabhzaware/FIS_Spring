
public class ConsumerImpl implements Consumer<Person> {

	@Override
	public void accept(Person t) {
		// TODO Auto-generated method stub
		t.printPerson();
	}

}
