import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int imsi = 0;
        int a = 0;
        int[] time = new int[progresses.length];
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        Stack<Integer>stack = new Stack<Integer>();
        for(int i = 0; i < progresses.length;i++){
            int minTime = 100-progresses[i];
            if(minTime%speeds[i]==0){
                deque.addLast(minTime/speeds[i]);
            }
            else{
                deque.addLast(minTime/speeds[i]+1);
            }
        }
        
        while (!deque.isEmpty()) {
            int out = deque.pollFirst();
            if (imsi < out) {
                imsi = out; 
                stack.push(1);
            } else {
                a = stack.pop();  
                stack.push(a + 1);  
            }
        }
        int[] answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}