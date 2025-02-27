import java.util.Objects;

/**
 * feel free to use this template as a starting point.
 */

public class Student extends Person {
    private int id;

    public Student(String theName, int id) {
        super(theName);
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "StudentSolution{" + "name='" + this.getName() + '\'' + ", id=" + this.getId() + '}';
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true; // Check for reference equality
        if (other == null || getClass() != other.getClass()) return false; // Not equal if not the same class or null

        Student other_student = (Student) other; // Typecast before comparing

        return getId() == other_student.getId() && Objects.equals(this.getName(), other_student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    public static void main(String[] args) {
        int value = 10;
        Person e1 = new Student("Alice", 1);
        Person e2 = new Student("Bob", 2);
        Person e3 = new Student("Carol", 3);
        Person e5 = new Person("Alice");
        Person arrayOfPeople[] = {e1, e2, e3};

        Person e4 = new Student("Alice", 1); // same as e1?

        System.out.println(e1 == arrayOfPeople[0]); // what is printed here?
        System.out.println(e1 == e4); // what is printed here?

        System.out.println(e1.equals(e4)); // and here?
        System.out.println(e1.equals(e5)); // and here?
    }
}
