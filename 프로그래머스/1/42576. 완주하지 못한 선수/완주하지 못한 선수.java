import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int a = 0;
        HashMap<String,Integer> hash = new HashMap<>();
        for(String name : participant){
            a = 0;
            if(hash.containsKey(name)){
                a = hash.get(name);
            }
            hash.put(name,1+a);
        }
        for(String name : completion){
            if(hash.containsKey(name)){
                a = hash.get(name)-1;
            }
            hash.put(name, a);
        }
        for(String name : participant){
            if(hash.get(name) == 1){
                return name;
            }
        }
        return answer;
    }
}