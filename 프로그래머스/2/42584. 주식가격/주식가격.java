import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int answer[] = new int [prices.length];
        for(int i = 0 ; i < answer.length; i++){
            for(int j = i+1; j < answer.length;j++){
                answer[i]++;
                if(prices[i] > prices[j]){
                    break;
                }
                
            }
        }
        
        return answer;
        
    }
    /*
    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < answer.length; i++){
            stack.push(prices[i]);
            for(int j = i+1 ; j < answer.length; j++){
                
                if(prices[i] > prices[j]){
                    stack.push(prices[j]);
                    break;
                }
                stack.push(prices[j]);
            }
            answer[i] = stack.size() - 1;
            stack.clear();
                
        }
        return answer;
    }*/
    
}