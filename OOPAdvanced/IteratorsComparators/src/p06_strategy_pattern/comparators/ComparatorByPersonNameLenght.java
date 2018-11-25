package p06_strategy_pattern.comparators;

import p06_strategy_pattern.Person;

import java.util.Comparator;

public class ComparatorByPersonNameLenght implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        int comparatorByNameLenght = person1.getName().length() - person2.getName().length();
        if (comparatorByNameLenght != 0) {
            return comparatorByNameLenght;
        }
        return String.valueOf(person1.getName().charAt(0)).compareToIgnoreCase(String.valueOf(person2.getName().charAt(0)));
    }
}
