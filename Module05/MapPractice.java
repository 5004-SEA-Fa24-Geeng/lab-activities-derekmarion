import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapPractice {

    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();

        map.put("Apple", 3.5);
        map.put("Banana", 2.0);
        map.put("Cherry", 4.0);

        // let's print the map

        System.out.println(map);

        // what happens if we add a duplicate key?
        map.put("Apple", 5.0);
        System.out.println(map);
        // Key is overwritten with new value


        // now try it with Person/Student. We will
        // use the person or student as a key and the
        // value will be a set of classes they are taking

        Map<Person, Set<String>> classes = new HashMap<>();

        // you will find Set.of() useful here
        // for example:
        // classes.put(p2, Set.of("CS5001", "CS5002"));
        Person person1 = new Person("John");
        Person person2 = new Person("Jane");
        classes.put(person1, Set.of("Apple", "Banana"));
        classes.put(person2, Set.of("Cherry", "Banana"));

    }

}
