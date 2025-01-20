import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> HashSet = new HashSet<>();
        for (int i : nums) {
            HashSet.add(i);
        }
        int[] remakeArr = new int[HashSet.size()];
        if(nums.length/2 > HashSet.size()){
            return HashSet.size();
        }
        
        return nums.length/2;
    }
}