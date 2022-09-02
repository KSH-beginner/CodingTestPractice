import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

    }
}
