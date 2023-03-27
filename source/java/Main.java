import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> input = new ArrayList<>();
        input.add(new Person("John", "Valid", 32));
        input.add(new Person("John", "InValid", 17));
        input.add(new Person("OtherJohn", "Valid", 19));

        List<String> output = Person.validByAge(input);
        System.out.println(output);
    }
}