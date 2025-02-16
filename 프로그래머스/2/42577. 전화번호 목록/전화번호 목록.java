import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> phoneSet = new HashSet<>();
        
        // 모든 번호를 해시셋에 저장
        for (String number : phone_book) {
            phoneSet.add(number);
        }

        for (String number : phone_book) {
            String temp = "";
            for (int i = 0; i < number.length() - 1; i++) { 
                temp += number.charAt(i);
                if (phoneSet.contains(temp)) {
                    return false;
                }
            }
        }

        return true;
    }
}
