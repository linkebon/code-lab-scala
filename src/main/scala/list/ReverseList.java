package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {
    public static void main(String[] args) {
        final List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        final List<Integer> reversed = new ArrayList<>();

        for (int i = list1.size() - 1; i >= 0; i--) {
            reversed.add(list1.get(i));
        }

        reversed.forEach(System.out::println);
    }
}
