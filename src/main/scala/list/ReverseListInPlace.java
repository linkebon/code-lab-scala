package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseListInPlace {
    public static void main(String[] args) {
        final List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        for (int i = 0, j = list.size() - 1; i<j ; i++) {
            list.add(i, list.remove(j));
        }

        list.stream().forEach(System.out::println);
    }
}
