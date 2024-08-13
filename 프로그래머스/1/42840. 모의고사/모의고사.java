import java.util.Arrays;
import java.util.Collections;
import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int[] answerCount = new int[3];
        int[] one = {1,2,3,4,5}; //12345 무한반복
        int[] two = {2,1,2,3,2,4,2,5}; // 홀수index에는 1,3,4,5 반복, 짝수일때는 2반복
        int[] three = {3,3,1,1,2,2,4,4,5,5}; //3311224455 무한반복 
        //첫번째 사람
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == one[i%one.length]){
                answerCount[0]++;
            }
        }
        // 두번째 사람
        for(int i = 0; i < answers.length; i++){
            if(i%2==0){ //인덱스가 짝수일때
                if(answers[i]==2){
                    answerCount[1]++;
                }
            }
            else{ // 인덱스가 홀수일때
                if(answers[i]==two[i%two.length]){
                    answerCount[1]++;
                }
            }
        }
        // 세번째 사람
        for(int i = 0; i < answers.length; i++){
            if(answers[i]==three[i%three.length]){
                answerCount[2]++;
            }
        }
        int max = Arrays.stream(answerCount).max().getAsInt();
        //둘만 같을경우
        List<Integer> num = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(max == answerCount[i]){
                num.add(i+1);
            }
        }
        return num.stream().mapToInt(Integer::intValue).toArray();
        
        
        //return answerCount;
    }
}