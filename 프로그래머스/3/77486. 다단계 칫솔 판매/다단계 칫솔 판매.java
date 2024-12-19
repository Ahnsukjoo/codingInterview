import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Integer> indexMap = new HashMap<>();
        Map<String, String> referralMap = new HashMap<>();
        
        // 이름에 대한 인덱스 맵과 추천인 맵 생성
        for (int i = 0; i < enroll.length; i++) {
            indexMap.put(enroll[i], i);
            referralMap.put(enroll[i], referral[i]);
        }
        
        // 각 판매에 대해 이익 분배
        for (int i = 0; i < seller.length; i++) {
            String currentSeller = seller[i];
            int profit = amount[i] * 100;
            
            while (!currentSeller.equals("-") && profit > 0) {
                int index = indexMap.get(currentSeller);
                int distribute = profit / 10;
                int keep = profit - distribute;
                
                // 현재 판매원의 이익 추가
                answer[index] += keep;
                
                // 추천인으로 이동
                currentSeller = referralMap.get(currentSeller);
                profit = distribute;
                
                // 분배할 이익이 1원 미만이면 중단
                if (profit < 1) break;
            }
        }
        
        return answer;
    }
}
