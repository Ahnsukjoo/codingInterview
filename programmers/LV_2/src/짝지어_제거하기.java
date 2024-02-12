import java.util.*;
public class 짝지어_제거하기 {

    public int solution(String s) {
        int answer = -1;
        String answer2 = "";
        int[] num = new int[s.length()];
        for (int k = 0; k < s.length(); k++) {
            num[k] = (int) s.charAt(k);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length; i++) {
            if (!stack.empty() && stack.peek() == num[i]) {
                stack.pop();
            } else {
                stack.push(num[i]);
            }
        }
        if (stack.empty()) {
            return 1;
        }

        return 0;
    }

}
