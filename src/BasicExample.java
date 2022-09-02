import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BasicExample {

    /* #1018 시간 입력받아 그대로 출력하기 (문자 구분하여 출력)
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String time = kb.next();
        StringTokenizer stringTokenizer = new StringTokenizer(time, ":");
        int[] arr = new int[stringTokenizer.countTokens()];
        for(int i = 0; stringTokenizer.hasMoreTokens(); i++) {
            // 문자열 stringTokenizer.nextToken()을 Int형으로 변환
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        System.out.println(arr[0] + ":" + arr[1]);
    }
     */

    /* #1019 연월일 입력 받아 그대로 출력 (한 자리수 -> 0을 붙여 출력)
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String date = kb.next();
        StringTokenizer st = new StringTokenizer(date, ".");
        int[] arr = new int[st.countTokens()];
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.printf("%04d.%02d.%02d", arr[0], arr[1], arr[2]);
    }
     */

    /* #1020 주민번호 입력받아 형태바꿔 출력 (980111-1234567 -> 9801111234567)

    // StringTokenizer, Integer.parseInt, Integer.toString 사용
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String id = kb.next();
        StringTokenizer st = new StringTokenizer(id, "-");
        int[] new_id = new int[st.countTokens()];
        for (int i = 0; st.hasMoreTokens(); i++) {
            new_id[i] = Integer.parseInt(st.nextToken());
        }
        System.out.print(Integer.toString(new_id[0]) + Integer.toString(new_id[1]));
    }

    // split 사용
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String id = kb.next();
        String[] array_id = id.split("-");

        String str1 = array_id[0].toString();
        String str2 = array_id[1].toString();

        System.out.println(str1 + str2);
    }
     */

    /* #1023 실수 1개 입력받아 정수 부분, 실수 부분 나누기 -> split("\\.")
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        double num = kb.nextDouble();
        String str_num = String.valueOf(num);
        System.out.println(str_num);
        String[] split_num = str_num.split("\\.");
        for (int i = 0; i < split_num.length; i++) {
            System.out.println(split_num[i]);
        }
    }
     */

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str_num = kb.nextLine();
        String[] num = str_num.split(" ");

        Long num1 = Long.valueOf(num[0]);
        Long num2 = Long.valueOf(num[1]);

        System.out.println(num1 + num2);
    }
}
