package algorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Finder {
	private final List<Person> persons;

	public Finder(List<Person> p) {
		persons = p;
	}

	public Optional<F> Find(FT ft) {
		List<F> tr = new ArrayList<F>();

		for (int i = 0; i < persons.size() - 1; i++) {
			for (int j = i + 1; j < persons.size(); j++) {
				Person personOne;
				Person personTwo;
				if (persons.get(i).birthDate().getTime() < persons.get(j).birthDate().getTime()) {
					personOne = persons.get(i);
					personTwo = persons.get(j);
				} else {
					personOne = persons.get(j);
					personTwo = persons.get(i);
				}
				tr.add(new F(personOne, personTwo, personTwo.birthDate().getTime() - personOne.birthDate().getTime()));
			}
		}

		if (tr.size() < 1) {
			return Optional.empty();
		}

		F answer = tr.get(0);
		switch (ft) {
			case Closest:
				return tr.stream().filter(result -> result.difference() < answer.difference()).findFirst();
			case Furthest:
				if (result.difference() > answer.difference()) {
					answer = result;
				}
				break;
		}

		for (F result : tr) {
			switch (ft) {
				case Closest:
					if (result.difference() < answer.difference()) {
						answer = result;
					}
					break;

				case Furthest:
					if (result.difference() > answer.difference()) {
						answer = result;
					}
					break;
			}
		}

		return Optional.of(answer);
	}
}
