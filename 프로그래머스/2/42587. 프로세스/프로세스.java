import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        // 데크에 인덱스 집어넣기
        for(int i = 0; i < priorities.length; i++){
            queue.offer(i);
        }
        while(!queue.isEmpty()){
            int check = queue.poll();
            int max =  Arrays.stream(priorities)
                        .max()
                        .getAsInt();
            if(priorities[check] < max){
                queue.offer(check);
                continue;
            }
            else{
                priorities[check] = -1;
                answer++;
                if (check == location){
                    return answer;
                }
            }
        }
         
        return answer;
    }
}