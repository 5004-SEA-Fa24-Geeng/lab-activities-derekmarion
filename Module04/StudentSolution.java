import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StudentSolution {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // this function is a quick way to build a
                                                                              // list
        List<Integer> evens2 = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evens2);
    }

    public static int sum(List<Integer> list) {
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        return result;
    }

    public static List<Integer> squareList(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : list) {
            result.add(number * number);
        }
        return result;
    }
}
