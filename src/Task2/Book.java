package Task2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Book {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int countBook = sc.nextInt();
            int[] bookHeights = new int[countBook];

            for (int i = 0; i < bookHeights.length; i++) {
                bookHeights[i] = sc.nextInt();
            }

            var stacks = countBookStacks(bookHeights);

            Arrays.sort(stacks);
            stacks = Arrays.stream(stacks).filter(stack -> stack > 0).toArray();

            System.out.println(stacks.length);

            for (int stack : stacks) {
                System.out.print(stack + " ");
            }
        }
    }

    private static int[] countBookStacks(int[] bookHeights) {
        var stacks = new int[bookHeights.length];

        for (int bookHeight : bookHeights) {
            int height = bookHeight;
            int number = stacks[--height];
            stacks[height] = ++number;
        }

        return stacks;
    }
}
