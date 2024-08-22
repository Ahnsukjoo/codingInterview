import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder str = new StringBuilder(s);
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){
            // 괄호 회전하는 코드
            str.append(str.charAt(0));
            str.deleteCharAt(0);
            //System.out.println(str +" " +str.length());
            // 올바른 괄호 확인하는 코드
            for(int j = 0 ; j < s.length();j++){
                if(str.charAt(j)=='('||str.charAt(j)=='{'||str.charAt(j)=='['){
                    stack.push(str.charAt(j));
                }
                else if(stack.isEmpty()){
                    stack.push('n');
                    break;
                }
                else if(stack.peek() == '('&&str.charAt(j)==')'){
                    stack.pop();
                }
                else if(stack.peek() == '{'&&str.charAt(j)=='}'){
                    stack.pop();
                }
                else if(stack.peek() == '['&&str.charAt(j)==']'){
                    stack.pop();
                }
                else{
                    stack.push('n');
                    break;
                }
                //System.out.println(i+" j="+ j +stack);
            }
            if(stack.isEmpty()){
                answer++;
            }
            //System.out.println(i+" "+answer);
            stack.clear();
            
        }
        return answer;
    }
}