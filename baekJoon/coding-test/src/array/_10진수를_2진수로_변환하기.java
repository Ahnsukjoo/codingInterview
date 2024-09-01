package array;

import java.util.*;

public class _10진수를_2진수로_변환하기 {

    public static void main(String[] args) {
        String answer = solution(10);
        System.out.println(answer);
        String answer2 = solution(27);
        System.out.println(answer2);
        String answer3 = solution(12345);
        System.out.println(answer3);
        System.out.println("안녕");
    }

    public static String solution(int decimal) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        while (decimal > 0) {
            stack.push(decimal % 2);
            decimal = decimal / 2;
        }
        while (!stack.isEmpty()) {
            answer += stack.pop() + "";
        }
        return answer;
    }

}
