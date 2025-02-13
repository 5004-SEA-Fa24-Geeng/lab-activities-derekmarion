
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

// yes we used all the above in the solution. You
// may not use them all, that is fine.


/**
 * a few java syntax items to help you out. Depending on how you do it, you may not need them
 * <p>
 * /
 * <p>
 * /* String[] parts = line.split("\\s+"); // split by whitespace String student = parts[0]; String
 * course = parts[1];
 */

/**
 * Set.of() creates an immutable set!, So if you want it mutable.
 * <p>
 * You will need to use a HashSet
 * <p>
 * Set<String> courses = new HashSet<>();
 * <p>
 * courses.add(course);
 * <p>
 * students.put(student, courses);
 */

/*
 * Using a stream to take a list and make it a string of "value value value"
 *
 *
 * students.get(student).stream().collect(Collectors.joining(" ")) - This one may be easier to do as
 * a separate loop, but feel free to play with this one.
 *
 */

public class StudentLoader {

    // todo: write a program that reads
    // the courses.txt file, and links
    // all classes with the String (name) of the student
    // outputs then will be "person has completed class1 class2 etc"
    // for each student

    // Read courses.txt
    public static Stream<String> getLines(String filename) {
        try {
            List<String> lines = Files.readAllLines(Path.of(filename));
            System.out.println(lines);
            return lines.stream();
        } catch (
                IOException e) {
            System.out.println("Error reading courses.txt");
            e.printStackTrace();
            return Stream.empty();
        }
    }

    public static void main(String[] args) {
        Map<String, Set<String>> courses = new HashMap<>();

        // Iterate over lines, add to courses
        getLines("courses.txt").forEach(line -> {
            String[] split = line.split("\\s+");

            String student = split[0];
            String course = split[1];
            if (!courses.containsKey(student)) {
                Set<String> courses_set = new HashSet<>();
               courses_set.add(course);
                courses.put(student, courses_set);
            } else {
                courses.get(student).add(course);
            }
        });

        // Print out hashmap
        for (String student : courses.keySet()) {
            System.out.println(student + " has completed courses: " + courses.get(student));
        }
    }
}




