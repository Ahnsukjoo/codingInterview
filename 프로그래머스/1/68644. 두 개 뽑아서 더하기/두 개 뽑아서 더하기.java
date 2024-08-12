import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        // 1.두개씩 뽑을수 있는 경우의수 모두 리스트에 추가한다
       //List<String> lst = Arrays.asList(strs)
        List<Integer> num = new ArrayList<>();
        for(int i = 0; i < numbers.length-1; i++){
            for(int j = i+1 ; j < numbers.length; j++){
                num.add(numbers[i]+numbers[j]);
            }
        }
        //System.out.println(num);
        // 2.중복을 제거한다
        List<Integer>newnum = num.stream().distinct().collect(Collectors.toList());
        
        // 3.정렬한다s Solutio
        return newnum.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}