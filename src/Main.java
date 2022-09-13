import java.util.*;

/* 1-1. 문자 찾기
public class Main {
    public int solution(String str, char t) {
        int answer = 0;

        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == t) answer++;
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.println(T.solution(str, c));
    }
}
*/

/* 1-2. 대소문자 변환
public class Main {
    // 내 풀이
    public char[] Solution(String str) {
        char[] new_str = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if(Character.isUpperCase(str.charAt(i))) {
                new_str[i] = Character.toLowerCase(str.charAt(i));
            } else if (Character.isLowerCase(str.charAt(i))){
                new_str[i] = Character.toUpperCase(str.charAt(i));
            }
        }
        return new_str;
    }

    // 강의 풀이 (toCharArray)
    public String solution(String str) {
        String answer = "";
        for(char x : str.toCharArray()) {
            if (Character.isLowerCase(x)) answer += Character.toUpperCase(x);
            else answer += Character.toLowerCase(x);
        }

        return answer;
    }

    // 강의 풀이 (아스키 코드 조건)
    public String solution(String str) {
        String answer = "";
        for(char x : str.toCharArray()) {
            if(x>=97 && x<=122) answer += (char)(x-32); // 소문자일 때 대문자로
            else answer += (char)(x+32); // 대문자일 때 소문자로
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.Solution(str));
    }
}
 */

/* 1-3. 문장 속 단어 (indexOf() / substring())
public class Main {

    // split 사용 풀이
    public String Solution(String sentence) {
        String answer = "";
        int m = Integer.MIN_VALUE; // 가장 작은 수로 초기화
        String[] split_sentence = sentence.split(" ");
        for (String x : split_sentence) {
            int max_len = x.length();
            if (max_len > m) {
                m = max_len;
                answer = x;
            }
        }
        return answer;
    }

    // indexOf, substring 사용
    // indexOf("a") : 문자열에서 a를 찾아서 인덱스 반환 (a가 없다면 -1 반환)
    // substring(2) : 문자열에서 인덱스 2부터 끝까지 슬라이싱
    // substring(2, 10) : 문자열에서 인덱스 2부터 9(10 전)까지 슬라이싱
    public String Solution(String sentence) {
        String answer = "";
        int m = Integer.MIN_VALUE;
        int pos;
        while((pos=sentence.indexOf(" ")) != -1) {
            String tmp = sentence.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            sentence = sentence.substring(pos+1);
        }
        // while 문을 빠져나왔을 때 -> substring 결과가 -1이다 -> substring으로 슬라이싱한 문자에 공백이 없다 -> 마지막 단어이다.
        // 마지막 단어가 제일 긴 테스트 케이스도 체크 (while문을 빠져나왔을 때 sentence에는 마지막 단어가 들어가있다.)
        if(sentence.length() > m) answer = sentence;
        return answer;
    }

   public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String sentence = kb.nextLine();
        System.out.println(T.Solution(sentence));
    }
}
*/

/* 1-4. 단어 뒤집기 (StringBuilder 이용 or 직접 뒤집기)
public class Main {

    // StringBuilder.reverse() 사용
    String Solution(String word) {
        String answer = "";
        answer = new StringBuilder(word).reverse().toString();
        return answer;
    }

    // toCharArray()로 직접 뒤집기
    String Solution(String word) {
        String answer = "";
        char[] word_char = word.toCharArray();
        int lt = 0;
        int rt = word.length() -1;
        while (lt < rt) {
            char tmp = word_char[lt];
            word_char[lt] = word_char[rt];
            word_char[rt] = tmp;
            lt++;
            rt--;
        }

        answer = String.valueOf(word_char);

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        String[] word_arr = new String[num];
        for (int i = 0; i < num; i++) {
            word_arr[i] = kb.next();
        }
        for (String x : word_arr) {
            System.out.println(T.Solution(x));
        }

    }
}
 */

/* 1-5. 특정 문자 뒤집기 (isAlphabetic)
public class Main {

    public String Solution(String str) {
        String answer = "";
        int lt = 0;
        int rt = str.length()-1;
        char[] char_arr = str.toCharArray();
        while(lt < rt) {
            if(Character.isAlphabetic(char_arr[lt]) == false) lt++;
            else if(Character.isAlphabetic(char_arr[rt]) == false) rt--;
            else {
                char tmp = char_arr[lt];
                char_arr[lt] = char_arr[rt];
                char_arr[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(char_arr);
        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.Solution(str));
    }
}
 */

/* 1-6. 중복문자제거 (indexOf 사용)
public class Main {

    public String Solution(String str) {
        String answer = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.Solution(str));
    }
}
 */

/* 1-7. 회문문자열 (StringBuilder.reverse / equalsIgnoreCase() 사용)
public class Main {

    // StringBuilder로 문자 뒤집고 equalsIgnoreCase로 대소문자 구분없이 문자열 비교
    public String Solution(String str) {
        String answer = "";
        String reverse_str = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(reverse_str)) answer = "YES";
        else answer = "NO";
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.Solution(str));
    }
}
 */

/* 1-8. 팰린드롬(replaceAll 정규식 이용)
public class Main {
    public String Solution(String str) {
        String answer = "";
        str=str.toUpperCase().replaceAll("[^A-Z]", "");
        String new_str = new StringBuilder(str).reverse().toString();
        if(str.equals(new_str)) answer = "YES";
        else answer = "NO";
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.Solution(str));
    }
}
 */

/* 1-9. 숫자만 추출
public class Main {

    public int Solution(String str) {
        String answer = str.replaceAll("[^0-9]", "");
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.Solution(str));
    }
}
 */

/* 1-10. 가장 짧은 문자 거리
public class Main {

    public int[] Solution(String s, char t) {
        int cnt = 1000;
        int[] distance = new int[s.length()];
        // 왼쪽 -> 오른쪽으로 반복하면서 같은 문자 찾기
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != t) {
                cnt += 1;
                distance[i] = cnt;
            }
            else if(s.charAt(i) == t) {
                cnt = 0;
                distance[i] = 0;
            }
        }
        // 오른쪽 -> 왼쪽으로 반복하면서 같은 문자 찾기 (이때, 왼쪽 -> 오른쪽 반복하면서 찾은 값보다 작으면 갱신)
        cnt = 1000;
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) != t) {
                cnt += 1;
                distance[i] = Math.min(distance[i], cnt);
            }
            else if(s.charAt(i) == t) {
                cnt = 0;
                distance[i] = 0;
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        char t = kb.next().charAt(0);
        for(int x : T.Solution(s, t)) {
            System.out.print(x + " ");
        }
    }
}
 */

/* 1-11. 문자열 압축
public class Main {

    public String Solution(String str) {
        String answer = "";
        int cnt = 1;
        String new_word = "";
        for(int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt += 1;
                if(i+1 == str.length()-1) new_word += str.charAt(i) + String.valueOf(cnt);
            }
            else if (str.charAt(i) != str.charAt(i + 1)) {
                if (cnt != 1) new_word += str.charAt(i) + String.valueOf(cnt);
                else new_word += str.charAt(i);
                if(i+1 == str.length()-1) new_word += str.charAt(i+1);
                cnt = 1;

            }
        }
        answer = new_word;

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.Solution(str));
    }
}
 */

/* 1-12. 암호 (substring, replace, parseInt(string, 2) 사용)
public class Main {

    public String Solution(int num, String str) {

        String answer = "";
        for(int i = 0; i < num; i++) {
            String str_tmp = str.substring(i*7, i*7+7).replace("#","1").replace("*","0");
            int trans_num = Integer.parseInt(str_tmp, 2);
            char trans_char = (char) trans_num;
            answer += trans_char;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        String str = kb.next();
        System.out.println(T.Solution(num, str));
    }
}
 */

/* 2-1. 큰 수 출력하기
public class Main {

    public ArrayList<Integer> Solution(int n, int[] num) {
        ArrayList<Integer> new_num = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(i == 0) new_num.add(num[i]);
            else {
                if(num[i] > num[i-1]) new_num.add(num[i]);
            }
        }
        return new_num;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i++) {
            num[i] = kb.nextInt();
        }
        for(Integer x : T.Solution(n, num)) {
            System.out.print(x + " ");
        }
    }
}
 */

/* 2-2. 보이는 학생
public class Main {

    public int Solution(int n, int[] height) {
        int tmp = height[0];
        int cnt = 1;
        for(int i = 0; i < n-1; i++) {
            if(height[i] < height[i+1]) {
                if(tmp < height[i+1]) {
                    tmp = height[i+1];
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] height = new int[n];
        for(int i = 0; i < n; i++) {
            height[i] = kb.nextInt();
        }
        System.out.println(T.Solution(n, height));
    }
}
 */

/* 2-3. 가위바위보
public class Main {

    // 1 : 가위, 2: 바위, 3: 보

    public String Solution(int n, int[] A_num, int[] B_num) {
        String answer = "";
        for(int i = 0; i < n; i++) {
                if(A_num[i] == 1) {
                    if(B_num[i] == 1) answer += "D";
                    else if(B_num[i] == 2) answer += "B";
                    else answer += "A";
                }
                if(A_num[i] == 2) {
                    if(B_num[i] == 1) answer += "A";
                    else if(B_num[i] == 2) answer += "D";
                    else answer += "B";
                }
                if(A_num[i] == 3) {
                    if(B_num[i] == 1) answer += "B";
                    else if(B_num[i] == 2) answer += "A";
                    else answer += "D";
            }

        }
        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int A_num[] = new int[n];
        int B_num[] = new int[n];
        for(int i = 0; i < n; i++) {
            A_num[i] = kb.nextInt();
        }
        for(int i = 0; i < n; i++) {
            B_num[i] = kb.nextInt();
        }
        for(char x : T.Solution(n, A_num, B_num).toCharArray()) {
            System.out.println(x);
        }
    }
}
 */

/* 2-4. 피보나치 수열
public class Main {

    public int[] Solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for(int i = 1; i < n-1; i++) {
            answer[i+1] = answer[i] + answer[i-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        for(int x : T.Solution(n)) {
            System.out.print(x + " ");
        }
    }
}
 */

/* 2-5. 소수 (에라토스테네스 체)
public class Main {

    public int Solution(int n) {
        int cnt = 0;
        int[] num = new int[n+1];
        for(int i = 2; i <=n; i++) {
            if(num[i] == 0) {
                for (int j = i+i; j <=n; j = j + i) {
                    num[j] = 1;
                }
            }
        }

        for(int i = 0; i < n+1; i++) {
            if(num[i] == 0) cnt += 1;
        }

        return cnt-2;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.Solution(n));
    }
}
 */

/* 2-6. 뒤집은 소수
public class Main {

    public ArrayList<Integer> Solution(int n, int[] num) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int tmp = num[i];
            int result = 0;
            while(tmp > 0) {
                int t = tmp % 10;
                result = result * 10 + t;
                tmp = tmp / 10;
            }
            if(isPrime(result))  arr.add(result);
        }
        return arr;
    }

    public static void main(String args[]) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i++) {
            num[i] = kb.nextInt();
        }
        for(int x : T.Solution(n, num)) {
            System.out.print(x + " ");
        }


    }

    public boolean isPrime(int n) {
        if(n == 1) return false;
        for(int i = 2; i < n; i++) {
                if(n % i == 0) return false;
        }
        return true;
    }
}
 */

/* 2-7. 점수 계산
public class Main {

    public int Solution(int n, int[] num) {
        int[] score = new int[n];
        int cnt = 1;
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(num[i] == 1) {
                score[i] += cnt;
                cnt++;
            } else if(num[i] == 0) {
                cnt = 1;
                score[i] = 0;
            }
        }
        for(int x : score) {
            answer += x;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i++) {
            num[i] = kb.nextInt();
        }
        System.out.println(T.Solution(n, num));
    }
}
 */

/* 2-8. 등수 구하기
public class Main {

    public int[] Solution(int n, int[] num) {
        int[] cnt = new int[n];
        for(int i = 0; i < n; i++) {
            cnt[i] = 1;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(num[i] < num[j]) cnt[i] += 1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i++) {
            num[i] = kb.nextInt();
        }
        for(int x : T.Solution(n, num)) {
            System.out.print(x + " ");
        }
    }
}
 */

/* 2-9. 격자판 최대합
public class Main {

    public Integer Solution(int n, int[][] num) {
        List<Integer> max_num = new ArrayList<>(n*2 + 2);
        int cnt = 0;


        // 행 합
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                cnt += num[i][j];
            }
            max_num.add(cnt);
            cnt = 0;
        }


        // 열 합
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                cnt += num[j][i];
            }
            max_num.add(cnt);
            cnt = 0;
        }

        // 대각선1 합
        for(int i = 0; i < n; i++) {
            cnt += num[i][i];
        }
        max_num.add(cnt);
        cnt = 0;

        // 대각선2 합합
        for(int i = 0;i < n; i++) {
            cnt += num[i][n-i-1];
        }
        max_num.add(cnt);
        cnt = 0;

        Integer max = Collections.max(max_num);
        return max;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] num = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                num[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.Solution(n, num));
    }
}
 */

/* 2-10 봉우리
public class Main {

    public int Solution(int n, int[][] num) {
        int cnt = 0;
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                if(num[i][j] > num[i-1][j] && num[i][j] > num[i][j-1] && num[i][j] > num[i+1][j] && num[i][j] > num[i][j+1]) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] num = new int[n+2][n+2];
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                num[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.Solution(n, num));
    }
}
 */

/* 2-11 임시반장 정하기
public class Main {

    public int Solution(int n, int[][] num) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 1; i < n+1; i++) {
            int cnt = 0;
            for(int j = 1; j < n+1; j++) {
                for(int k = 1; k < 6; k++) {
                    if(num[i][k] == num[j][k]) {
                        cnt += 1;
                        break;
                    }
                }
            }
            if(max < cnt) {
                max = cnt;
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] num = new int[n+1][6];
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < 6; j++) {
                num[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.Solution(n, num));
    }
}
 */

/* 2-12. 멘토링
public class Main {

    public int Solution(int n, int m, int[][] num) {
        int answer = 0;
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                int cnt = 0;
                for(int k = 0; k < m; k++) {
                    int pi = 0, pj = 0;
                    for(int s = 0; s < n; s++) {
                        if(num[k][s] == i) pi = s;
                        if(num[k][s] == j) pj = s;
                    }
                    if(pi > pj) cnt++;
                }
                if(cnt == m) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] num = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                num[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.Solution(n, m, num));
    }
}
 */

/* 3-1. 두 배열 합치기 (내 풀이 -> two pointer 알고리즘 X)
public class Main {

    public List<Integer> Solution(int[] num1, int[] num2) {
        List<Integer> answer = new ArrayList<>(num1.length + num2.length);
        for(int num : num1) answer.add(num);
        for(int num : num2) answer.add(num);

        Collections.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] num1 = new int[n];
        for(int i = 0; i < n; i++) {
            num1[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        int[] num2 = new int[m];
        for(int i = 0; i < m; i++) {
            num2[i] = kb.nextInt();
        }

        for(Integer num : T.Solution(num1, num2)) {
            System.out.print(num + " ");
        }
    }
}
 */

/* 3-1. 두 배열 합치기 (two pointer 알고리즘 O, 강사님 풀이)
배열 2개가 있을 때, 두 배열을 하나의 배열로 합쳐서 거기서 정렬하는 것이 아니라,
2개의 배열에 각각 포인터 p1, p2를 둬서 둘이 비교하면서 정답 배열에 하나씩 추가하기
public class Main {

    public List<Integer> Solution(int[] num1, int[] num2) {
        List<Integer> answer = new ArrayList<>(num1.length + num2.length);
        int p1 = 0, p2 = 0;

        while(p1 < num1.length && p2 < num2.length) {
                if (num1[p1] < num2[p2]) {
                    answer.add(num1[p1]);
                    p1++;
                } else {
                    answer.add(num2[p2]);
                    p2++;
                }
            }
        while(p1 < num1.length) {
            answer.add(num1[p1]);
            p1++;
        }
        while(p2 < num2.length) {
            answer.add(num2[p2]);
            p2++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] num1 = new int[n];
        for (int i = 0; i < n; i++) {
            num1[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        int[] num2 = new int[m];
        for (int i = 0; i < m; i++) {
            num2[i] = kb.nextInt();
        }

        for(Integer num : T.Solution(num1, num2)) {
            System.out.print(num + " ");
        }
    }
}
 */

/* 3-2. 공통원소 구하기 (내 풀이 -> 시간초과 발생.. two pointer 알고리즘으로 했는데 왜?
-> two pointer 알고리즘을 사용하려면 비교할 배열이 정렬되어 있어야 한다...
public class Main {

    public List<Integer> Solution(int n, int m, int[] num1, int[] num2) {
        List<Integer> answer = new ArrayList<>(n+m);

        int p1 = 0, p2 = 0;
        while(p1 < n) {
            if(num1[p1] == num2[p2]) {
                answer.add(num1[p1]);
                p2 = 0;
                p1++;
            } else {
                if(p2 < m-1) {
                    p2++;
                } else {
                    p1++;
                    p2 = 0;
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] num1 = new int[n];
        for(int i = 0; i < n; i++) {
            num1[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        int[] num2 = new int[m];
        for(int i = 0; i < m; i++) {
            num2[i] = kb.nextInt();
        }
        for(Integer num : T.Solution(n, m, num1, num2)) {
            System.out.print(num + " ");
        }
    }
}
 */

/* 3-2. 공통원소 구하기 (강사님 풀이)
two pointer 알고리즘을 사용하려면 기존 배열 정렬
오름차순 배열 비교이므로 포인터 비교해서 작은 쪽 포인터 +1 (공통원소 구하는 것이므로 오름차순된 배열끼리에서 만약 작다면 공통원소가 나올 수 없으므로 포인터 +1)
p1이 p2보다 작다면, 더 이상 num2 배열에서는 num1의 p1보다 작은 수가 없으므로 공통원소가 나올 수 없음 -> p1 +1
public class Main {

    public List<Integer> Solution(int n, int m, int[] num1, int[] num2) {
        List<Integer> answer = new ArrayList<>(n+m);

        int p1 = 0, p2 = 0;
        while(p1 < n && p2 < m) {
            if(num1[p1] == num2[p2]) {
                answer.add(num1[p1]);
                p1++;
                p2++;
            } else {
                if(num1[p1] < num2[p2]) {
                    p1++;
                } else {
                    p2++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] num1 = new int[n];
        for(int i = 0; i < n; i++) {
            num1[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        int[] num2 = new int[m];
        for(int i = 0; i < m; i++) {
            num2[i] = kb.nextInt();
        }
        Arrays.sort(num1);
        Arrays.sort(num2);

        for(Integer num : T.Solution(n, m, num1, num2)) {
            System.out.print(num + " ");
        }
    }
}
 */

/* 3-3. 최대 매출 구하기 (슬라이딩 윈도우)
   슬라이딩 윈도우 : 비교할 길이의 창을 만들고, 그 창을 옆으로 쭉 밀면서 비교
public class Main {

    public int Solution(int n, int k, int[] money) {
        int answer = 0;
        int sum = 0;
        for(int i = 0; i < k; i++) { // 비교할 window 생성
            sum += money[i];
        }
        answer = sum;
        for(int i = k; i < n-k-1; i++) { // 1칸씩 window 밀기
            sum = sum + money[i] - money[i-k];
            if(sum > answer) answer = sum;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] money = new int[n];
        for(int i = 0; i < n; i++) {
            money[i] = kb.nextInt();
        }
        System.out.println(T.Solution(n, k, money));
    }
}
 */

/* 3-4. 연속 부분수열 : lt, rt를 생각하고, rt 기준으로 for문이 도는 것, sum >= m일때 while문을 돌면서 lt를 늘려주는 것이 핵심!
public class Main {

    public int Solution(int n, int m, int[] num) {
        int lt = 0;
        int answer = 0;
        int sum = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += num[rt];
            if (sum == m) answer++;
            while (sum >= m) {
                sum -= num[lt];
                lt++;
                if (sum == m) answer++;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i++) {
            num[i] = kb.nextInt();
        }
        System.out.println(T.Solution(n, m, num));
    }
 */

/* 3-5. 연속된 자연수의 합
public class Main {

    public int Solution(int num) {
        int answer = 0;
        int lt =1;
        int sum = 0;
        int[] arr = new int[num/2 +2];
        for(int i = 1; i <= num/2 +1; i++) {
            arr[i] = i;
        }

        for(int rt = 1; rt <= num/2 +1; rt++) {
            sum += arr[rt];
            if(sum == num) answer++;
            while(sum >= num) {
                sum -= arr[lt];
                lt++;
                if(sum == num) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        System.out.println(T.Solution(num));
    }
}
 */

/* 3-6. 최대 길이 연속부분수열
public class Main {

    public int Solution(int[] arr, int len, int change_num) {
        int answer = 0;
        int lt = 0;
        int cnt = 0;
        for(int rt = 0; rt < len; rt++) {
            int sol_len = rt - lt + 1;
            if(arr[rt] == 0) {
                cnt += 1;
            }
            if(cnt <= change_num) {
                if (sol_len > answer) {
                    answer = sol_len;
                }
            } else {
                while(cnt > change_num) {
                    if(arr[lt] == 0) {
                        cnt -= 1;
                    }
                    lt += 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int len = kb.nextInt();
        int change_num = kb.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.Solution(arr, len, change_num));
    }
}
 */

/* 4-1. 학급회장
public class Main {

    public char Solution(int num, String voteResult) {
        char answer = ' ';
        char[] charArray = voteResult.toCharArray();

        Map<Character, Integer> voteCount = new HashMap<>();

        for(char x : charArray) {
            voteCount.put(x, voteCount.getOrDefault(x, 0) + 1);
        }
        int max = 0;
        for(char key : voteCount.keySet()) {
            if(max < voteCount.get(key)) {
                max = voteCount.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        String voteResult = kb.next();
        System.out.println(T.Solution(num, voteResult));
    }
}
 */

/* 4-2. 아나그램(해쉬)
public class Main {

    public String Solution(String str1, String str2) {
        String answer = " ";
        int len1 = str1.length();
        int len2 = str2.length();
        Map<Character, Integer> str1_map = new HashMap<>();
        Map<Character, Integer> str2_map = new HashMap<>();

        char[] str1_chars = str1.toCharArray();
        char[] str2_chars = str2.toCharArray();

        if(len1 != len2) answer = "NO";
        else {
            for(int i = 0; i < len1; i++) {
                str1_map.put(str1_chars[i], str1_map.getOrDefault(str1_chars[i], 0) + 1);
                str2_map.put(str2_chars[i], str2_map.getOrDefault(str2_chars[i], 0) + 1);
            }
            if(str1_map.equals(str2_map)) answer = "YES";
            else answer = "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str1 = kb.next();
        String str2 = kb.next();
        System.out.println(T.Solution(str1, str2));
    }
}
 */

/* 4-3 매출액의 종류(해쉬맵, 슬라이딩 윈도우)
public class Main {

    public List<Integer> Solution(int day, int num, int[] arr) {

        int lt = 0;
        int rt = lt + num -1;
        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> category_count = new ArrayList<>();
            for(int i = lt; i <= rt; i++) { // 슬라이딩 할 윈도우 반복문 돌면서 생성
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            category_count.add(map.size());
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
            rt++;

            for(int i = rt; i < day; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                category_count.add(map.size());
                map.put(arr[lt], map.get(arr[lt]) - 1);
                if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
                lt++;
            }
        return category_count;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int day = kb.nextInt();
        int num = kb.nextInt();
        int[] arr = new int[day];
        for(int i = 0; i < day; i++) {
            arr[i] = kb.nextInt();
        }
        for(Integer x : T.Solution(day, num, arr)) {
            System.out.print(x + " ");
        }
    }
}
 */

/* 4.5 모든 아나그램 찾기 (Hash, Sliding Window)
public class Main {

    public int Solution(String str1, String str2) {
        int lt = 0;
        int size = str2.length();
        int rt = size -1;
        int cnt = 0;


        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i <= rt; i++) {
            map1.put(chars1[i], map1.getOrDefault(chars1[i], 0) + 1);
        }

        for(char x : chars2) {
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }
        if(map1.equals(map2)) cnt += 1;
        map1.put(chars1[lt], map1.get(chars1[lt]) -1);
        if(map1.get(chars1[lt]) == 0) map1.remove(chars1[lt]);

        for(int i = rt+1; i < str1.length(); i++) {
            lt++;
            map1.put(chars1[i], map1.getOrDefault(chars1[i], 0) + 1);
            if(map1.equals(map2)) cnt += 1;
            map1.put(chars1[lt], map1.get(chars1[lt]) -1);
            if(map1.get(chars1[lt]) == 0) map1.remove(chars1[lt]);
        }

        return cnt;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str1 = kb.next();
        String str2 = kb.next();
        System.out.println(T.Solution(str1, str2));

    }

}
 */

/* 4-6. K번째 큰 수 (TreeSet)
public class Main {

    public int Solution(int num, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0; i < num; i++) {
            for(int j = i+1; j < num; j++) {
                for(int l = j+1; l < num; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for(int x : Tset) {
            cnt++;
            if(cnt == k) {
                answer = x;
                return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[num];
        for(int i = 0; i < num; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.Solution(num, k, arr));
    }
}
 */

/* 5-1. 올바른 괄호
public class Main {

    public String Solution(String str) {

        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char x : chars) {
            if(x == '(') stack.push('(');
            else {
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if(stack.isEmpty()) return "YES";
        else return "NO";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.Solution(str));
    }
}
 */

/* 5-2. 괄호 문자 제거
public class Main {

    public String Solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for(char x : chars) {
            if(x == ')') {
                while(stack.pop() != '(');
            } else {
                stack.push(x);
            }
        }
        for(int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.Solution(str));
    }
}
 */

/* 5-3. 크레인 인형뽑기 (카카오)
public class Main {

    public int Solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int x : moves) {
            for(int i = 0; i < n; i++) {
                if(board[i][x-1] != 0) {
                    if(!stack.isEmpty() && stack.peek() == board[i][x-1]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[i][x-1]);
                    }
                    board[i][x-1] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        int m = kb.nextInt();
        int[] moves = new int[m];
        for(int i = 0; i < m; i++) {
            moves[i] = kb.nextInt();
        }
        System.out.println(T.Solution(n, board, m, moves));
    }
}
 */

/* 5-4. 후위 연산식
public class Main {

    public int Solution(String str) {
        int answer = 0;
        int num1 = 0;
        int num2 = 0;
        Stack<Integer> stack = new Stack<>();

        for(char x : str.toCharArray()) {
            if(x == '+') {
                num2 = stack.pop();
                num1 = stack.pop();
                int plus_num = num1 + num2;
                stack.push(plus_num);
            } else if(x == '-') {
                num2 = stack.pop();
                num1 = stack.pop();
                int minus_num = num1 - num2;
                stack.push(minus_num);
            } else if(x == '*') {
                num2 = stack.pop();
                num1 = stack.pop();
                int multiply_num = num1 * num2;
                stack.push(multiply_num);
            } else if(x == '/') {
                num2 = stack.pop();
                num1 = stack.pop();
                int division_num = num1 / num2;
                stack.push(division_num);
            } else {
                stack.push(Character.getNumericValue(x));
            }
        }
        answer = stack.peek();
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.Solution(str));
    }
}
 */

/* 5-5. 쇠막대기
public class Main {

    public int Solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        char[] chars = str.toCharArray();

        for(int i = 0; i < str.length(); i++) {
            if (chars[i] == '(') stack.push(chars[i]);
            if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer += 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.Solution(str));
    }
}
 */

/* 5-6. 공주 구하기
public class Main {

    public int Solution(int n, int k) {
        int answer = 0;
        int cnt = 0;

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while(queue.size() != 1) {
            cnt++;
            if(cnt == k) {
                queue.poll();
                cnt = 0;
            } else {
                queue.offer(queue.poll());
            }
        }
        answer = queue.peek();

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        System.out.println(T.Solution(n, k));
    }
}
 */

/* 5-7. 교육과정 설계
public class Main {

    public String Solution(String required, String classPlan) {
        String answer = "NO";

        Queue<Character> queue = new LinkedList<>();
        for(char x : required.toCharArray()) {
            queue.offer(x);
        }

        for(char x : classPlan.toCharArray()) {
            if(queue.contains(x)) {
                if(queue.peek() != x) return answer;
                if(queue.peek() == x) {
                    queue.poll();
                }
            }
        }
        if(!queue.isEmpty()) return answer;
        else answer = "YES";


        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String required = kb.next();
        String classPlan = kb.next();
        System.out.println(T.Solution(required, classPlan));
    }
}
 */

/* 5-8. 응급실
class Person {
    int id;
    int priority;
    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

class Main {

    public int Solution(int n, int m, int[] patient) {
        int answer = 0;
        boolean isMax = true;

        Queue<Person> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            queue.offer(new Person(i, patient[i]));
        }

        while(!queue.isEmpty()) {
            isMax = true;
            Person tmp = queue.poll();
            for(Person x : queue) {
                if(x.priority > tmp.priority) {
                    queue.offer(tmp);
                    isMax = false;
                    break;
                }
            }
            if(isMax) {
                answer++;
                if(tmp.id == m) return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] patient = new int[n];
        for(int i = 0; i < n; i++) {
            patient[i] = kb.nextInt();
        }
        System.out.println(T.Solution(n, m, patient));
    }
}
 */

/*  6-1. 선택 정렬
public class Main {

    public int[] Solution(int n, int[] arr) {
        int indexMin = 0;
        int temp = 0;

        for(int i = 0; i < arr.length-1; i++) {
            indexMin = i;

            for(int j = i+1; j < arr.length; j++) {
                if(arr[indexMin] > arr[j]) {
                    indexMin = j;
                }
            }

            temp = arr[indexMin];
            arr[indexMin] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for(int x : T.Solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
 */

/* 6-2. 버블 정렬
public class Main {

    public int[] Solution(int n, int[] arr) {
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < n-i; j++) {
                if(arr[j-1] > arr[j]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for(int x : T.Solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
 */

/* 6-3. 삽입 정렬
public class Main {

    public int[] Solution(int n, int[] arr) {

        int tmp = 0;

        for(int i = 1; i < n; i++) {
            tmp = arr[i];
            int j;
            for(j = i-1; j >= 0; j--) {
                if(arr[j] > tmp) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }

            }
            arr[j+1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for(int x : T.Solution(n, arr)) {
            System.out.print(x + " ");
        }
    }

}
 */

/* 6-4.1 LRU : ArrayList 사용 방법
public class Main {

    public List<Integer> Solution(int s, int n, int[] arr) {

        List<Integer> list = new ArrayList<>();

        for(int j = 0; j < s; j++) {
            list.add(0);
        }

        for(int i = 0; i < n; i++) {
            if(!list.contains(arr[i])) {
                list.add(0, arr[i]);
                 list.remove(s);
            } else {
                int index = list.indexOf(arr[i]);
                list.remove(index);
                list.add(0, arr[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for(Integer x : T.Solution(s, n, arr)) {
            System.out.print(x + " ");
        }
    }
}
 */

/* 6.4.2 LRU : 삽입 정렬 사용 방법
public class Main {

    public int[] Solution(int s, int n, int[] arr) {
        int[] cache = new int[s];

        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < s; i++) {
                if (x == cache[i]) pos = i;
            }
            if (pos == -1) {
                for (int i = s - 1; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
                cache[0] = x;
            } else {
                for (int i = pos; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
                cache[0] = x;
            }
        }
        return cache;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (Integer x : T.Solution(s, n, arr)) {
            System.out.print(x + " ");
        }
    }
}
 */

/* 6-5. 중복 확인
public class Main {

    public String Solution(int n, int[] arr) {
        String answer = "U";

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(list.contains(arr[i])) {
                answer = "D";
                break;
            }
            list.add(arr[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.Solution(n, arr));
    }
}
 */

/* 6-6. 장난꾸러기
public class Main {

    public List<Integer> Solution(int n, int[] arr) {

        List<Integer> list = new ArrayList<>();

        int[] tmp = arr.clone();
        // tmp : 오름차순 정렬
        Arrays.sort(tmp);

        for(int i = 0; i < n; i++) {
            if(arr[i] != tmp[i]) list.add(i);
        }
        return list;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for(Integer x : T.Solution(n, arr)) {
            System.out.print(x+1 + " ");
        }
    }
}
 */

/* 6-7. 좌표 정렬
public class Main {

    static class Point implements Comparable<Point> {
        public int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        // 기준값(this)에서 비교값(매개변수 값, o)를 빼면 오름차순
        // 반대는 내림차순
        // 정렬 오름차순인지, 내림차순인지 정하는 메소드
        public int compareTo(Point o) {
            if(this.x == o.x) return this.y - o.y;
            else return this.x - o.x;
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            Point point = new Point(x, y);
            arr.add(point);
        }
        Collections.sort(arr);
        for(Point o : arr) {
            System.out.println(o.x + " " + o.y);
        }
    }
}
 */

/* 6-8. 이분검색
public class Main {

    public int Solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 0;
        int rt = n-1;
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(arr[mid] > m) rt = mid - 1;
            if(arr[mid] < m) lt = mid + 1;
            if(arr[mid] == m) {
                answer = mid + 1;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.Solution(n, m, arr));
    }
}
 */

/* 6-9. 뮤직비디오 (결정 알고리즘 - 이분 검색 활용)
public class Main {

    public int Solution(int n, int m, int[] arr) {
        int answer = 0;

        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(isAvailableNum(n, m, arr, mid)) {
                rt = mid - 1;
                answer = mid;
            }
            else lt = mid + 1;

        }
        return answer;
    }

    public boolean isAvailableNum(int n, int m, int[] arr, int checkNum) {
        int temp = 0;
        int cnt = 1;
        for(int x : arr) {
            if(temp + x > checkNum) {
                cnt++;
                temp = x;
            } else {
                temp += x;
            }
            if(cnt > m) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.Solution(n, m, arr));
    }
}
 */

/* 6-10. 마구간 정하기(강의 들어도 모르겠음... 로직 이해 불가 그냥 넘어가기)
public class Main {

    public int Solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        // 검색하고자 하는 값 : 가까운 두 말의 최대 거리
        int lt = 1;
        int rt = arr[n-1];
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(maxCount(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            }
            else rt = mid - 1;
        }
        return answer;
    }

    public int maxCount(int[] arr, int mid) {
        int cnt = 1;
        int temp = arr[0];
        for(int x : arr) {
            if(x - temp >= mid) {
                temp = x;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int c = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.Solution(n, c, arr));
    }
}
 */

/* 7-1. 재귀함수(스택프레임)
public class Main {

    public void DFS(int n) {

        if(n == 0) return;
        else {
            DFS(n-1);
            System.out.print(n + " ");
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        T.DFS(n);
    }
}
 */

/* 7-2. 이진수 출력 (재귀)
public class Main {

    public void DFS(int n) {
        int rest = n % 2;
        int quotient = n / 2;
        if(n == 0) {
            return;
        } else {
            DFS(quotient);
            System.out.print(rest + "");
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        T.DFS(n);
    }
}
 */

/* 7-3. 팩토리얼
public class Main {

    public int DFS(int n) {
        if(n == 1) return 1;
        else {
            return n * DFS(n-1);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.DFS(n));
    }
}
 */

public class Main {

    static int[] fibo;

    public int DFS(int n) {
        if(fibo[n] != 0) return fibo[n];
        if(n == 1) return fibo[n] = 1;
        else if(n == 2) return fibo[n] = 1;
        else {
            return fibo[n] = DFS(n-2) + DFS(n-1);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        fibo = new int[n+1]; // 10번 인덱스 사용하기 위해
        T.DFS(n);
        for(int i = 1; i <= n; i++) System.out.print(fibo[i] + " ");
    }
}