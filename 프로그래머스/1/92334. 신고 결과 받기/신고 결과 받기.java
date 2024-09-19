import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> id = new HashMap<>();  // id와 배열 인덱스 매핑
        HashMap<String, HashSet<String>> idListCount = new HashMap<>();  // 신고당한 id와 신고한 id 목록 (중복 제거를 위해 HashSet 사용)
        
        // id_list 배열을 기반으로 초기화
        for (int i = 0; i < id_list.length; i++) {
            id.put(id_list[i], i);  // id의 인덱스 저장
            idListCount.put(id_list[i], new HashSet<>());  // 신고당한 유저 별로 신고한 사람 목록 저장
        }
        
        // report 배열을 처리하여 신고 카운트를 기록
        for (String rep : report) {
            String[] str = rep.split(" ");
            String reporter = str[0];  // 신고한 사람
            String reported = str[1];  // 신고당한 사람
            
            // 신고당한 사람에 대해 신고한 사람 목록에 추가 (중복 방지)
            idListCount.get(reported).add(reporter);
        }
        
        // 신고당한 유저에 대한 신고자 리스트를 기준으로 처리
        for (String reported : id_list) {
            HashSet<String> reporters = idListCount.get(reported);  // 신고한 사람 목록
            
            // 신고 횟수가 k 이상인 경우
            if (reporters.size() >= k) {
                // 신고한 사람들에게 알림을 줌 (answer 배열 업데이트)
                for (String reporter : reporters) {
                    answer[id.get(reporter)]++;  // 신고한 사람의 인덱스를 가져와서 1 증가
                }
            }
        }
        
        return answer;
    }
}