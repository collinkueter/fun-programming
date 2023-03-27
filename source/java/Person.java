import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Person {
    private final String firstName;
    private final String lastName;
    private final Integer age;

    public Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirst() {
        return firstName;
    }

    public String getLast() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean valid() {
        return age > 18;
    }

    public static List<String> validByAge(List<Person> in) {
        List<Person> people = new ArrayList<>();
        for (Person p : in) {
            if (p.valid()) people.add(p);
        }
        people.sort(Comparator.comparingInt(a -> a.age));
        List<String> ret = new ArrayList<>();
        for (Person p : people) {
            ret.add(p.firstName);
        }
        return ret;
    }
}