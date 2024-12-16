import java.util.*;

class Solution {
    private static HashMap<Integer, HashMap<String, Integer>> courseMap;

    public String[] solution(String[] orders, int[] course) {
        courseMap = new HashMap<>();
        for (int i : course) {
            courseMap.put(i, new HashMap<>());
        }
        
        for (String order : orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            for (int i : course) {
                combinations(0, orderArray, "", i);
            }
        }

        ArrayList<String> answer = new ArrayList<>();
        
        for (int courseSize : course) {
            HashMap<String, Integer> count = courseMap.get(courseSize);
            if (count.isEmpty()) continue;
            
            int max = Collections.max(count.values());
            if (max < 2) continue;
            
            for (Map.Entry<String, Integer> entry : count.entrySet()) {
                if (entry.getValue() == max) {
                    answer.add(entry.getKey());
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    public static void combinations(int idx, char[] order, String result, int targetLength) {
        if (result.length() == targetLength) {
            HashMap<String, Integer> map = courseMap.get(targetLength);
            map.put(result, map.getOrDefault(result, 0) + 1);
            return;
        }
        
        for (int i = idx; i < order.length; i++) {
            combinations(i + 1, order, result + order[i], targetLength);
        }
    }
}
