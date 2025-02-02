import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        int card1 = 0;
        int card2 = 0;
        ArrayDeque<String> deque = new ArrayDeque<String>();
        for(int i = 0; i < goal.length; i++){
            if(card1 < cards1.length && cards1[card1].equals(goal[i]) ){
                deque.addLast(goal[i]);
                card1++;
                continue;
            }
            if(card2 < cards2.length && cards2[card2].equals(goal[i]) ){
                deque.addLast(goal[i]);
                card2++;
                continue;
            }
        }
        if(deque.size() == goal.length){
            return "Yes";
        }
        
        
        return answer;
    }
}