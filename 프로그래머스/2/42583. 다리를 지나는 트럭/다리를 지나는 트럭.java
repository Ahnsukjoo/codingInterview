import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0; 
        int bridge_weight = 0;
        Queue<Integer> bridge = new LinkedList<>(); 

        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int index = 0; 

        while (index < truck_weights.length) {
            time++; 
            bridge_weight -= bridge.poll(); 

            if (bridge_weight + truck_weights[index] <= weight) { 
                bridge.add(truck_weights[index]);
                bridge_weight += truck_weights[index];
                index++; 
            } else {
                bridge.add(0); 
            }
        }
        return time + bridge_length;
    }
}
