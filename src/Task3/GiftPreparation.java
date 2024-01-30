package Task3;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GiftPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Gift[] gifts = new Gift[n];

        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt(); // день, когда придут материалы
            int c = scanner.nextInt(); // время на приготовление подарка
            int s = scanner.nextInt(); // день отправки подарка

            gifts[i] = new Gift(d, c, s);
        }

        Arrays.sort(gifts, Comparator.comparingInt(g -> g.s));

        int currentDay = 0;

        for (Gift gift : gifts) {
            currentDay = Math.max(currentDay, gift.d);
            if (currentDay + gift.c > gift.s) {
                System.out.println("NO");
                return; // если хоть один подарок не успевает, прерываем программу
            }
            currentDay++;
        }

        System.out.println("YES");
    }

    static class Gift {
        int d, c, s;

        Gift(int d, int c, int s) {
            this.d = d;
            this.c = c;
            this.s = s;
        }
    }
}

