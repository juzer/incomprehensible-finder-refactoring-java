package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import algorithm.F;
import algorithm.FT;
import algorithm.Finder;
import algorithm.Person;

import static org.junit.Assert.*;

public class FinderTests {

	Person sue = new Person("Sue", new Date(50, 0, 1));
	Person greg = new Person("Greg", new Date(52, 5, 1));
	Person sarah = new Person("Sarah", new Date(82, 0, 1));
	Person mike = new Person("Mike", new Date(79, 0, 1));


	@Test
	public void Returns_Empty_Results_When_Given_Empty_List() {
		List<Person> list = new ArrayList<Person>();
		Finder finder = new Finder(list);

		Optional<F> result = finder.Find(FT.Closest);
		assertTrue(result.isEmpty());

	}

	@Test
	public void Returns_Empty_Results_When_Given_One_Person() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);

		Finder finder = new Finder(list);

		Optional<F> result = finder.Find(FT.Closest);
		assertTrue(result.isEmpty());
	}

	@Test
	public void Returns_Closest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(greg);
		Finder finder = new Finder(list);

		Optional<F> result = finder.Find(FT.Closest);

		assertFalse(result.isEmpty());
		assertEquals(sue, result.get().personOne());
		assertEquals(greg, result.get().personTwo());
	}

	@Test
	public void Returns_Furthest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		Optional<F> result = finder.Find(FT.Furthest);

		assertFalse(result.isEmpty());
		assertEquals(greg, result.get().personOne());
		assertEquals(mike, result.get().personTwo());
	}

	@Test
	public void Returns_Furthest_Two_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);
		Finder finder = new Finder(list);

		Optional<F> result = finder.Find(FT.Furthest);

		assertFalse(result.isEmpty());
		assertEquals(sue, result.get().personOne());
		assertEquals(sarah, result.get().personTwo());
	}

	@Test
	public void Returns_Closest_Two_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		Optional<F> result = finder.Find(FT.Closest);

		assertFalse(result.isEmpty());
		assertEquals(sue, result.get().personOne());
		assertEquals(greg, result.get().personTwo());
	}

}
