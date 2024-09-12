import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> hash = new HashMap<>();
        int count = 0;
        for(int i = 0; i < record.length;i++){
            //System.out.println(record[i]);
            String[] str = record[i].split(" ");
            if(str[0].equals("Enter")){
                hash.put(str[1],str[2]);
                count++;
                //answer[i] = hash.get(str[1]) + "님이 들어왔습니다.";
            }
            if(str[0].equals("Leave")){
                count++;
            }
            if(str[0].equals("Change")){
                hash.put(str[1],str[2]);
            }
            //System.out.println(str[0]+ " "+str[1]);
        }
        String[] answer = new String[count];
        count = 0;
        for(int i = 0; i < record.length;i++){
            String[] str = record[i].split(" ");
            if(str[0].equals("Enter")){
                answer[count] = hash.get(str[1]) + "님이 들어왔습니다.";
                count++;
            }
            if(str[0].equals("Leave")){
                answer[count] = hash.get(str[1]) + "님이 나갔습니다.";
                count++;
            }
            //System.out.println(str[0]+ " "+str[1]);
        }

        return answer;
    }
}