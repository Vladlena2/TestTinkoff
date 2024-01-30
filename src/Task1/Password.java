package Task1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println(findCode(text));
    }

    private static String findCode(String text) {
        String regex = "code\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        StringBuffer resultStringBuffer = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(resultStringBuffer, "???");
        }

        matcher.appendTail(resultStringBuffer);

        return resultStringBuffer.toString();
    }
}
