public class 접미사인지_확인하기 {


    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        int sufLeng = 0;
        int strLeng = 0;

        if (my_string.length() < is_suffix.length()) {
            return 0;
        } else if (my_string.equals(is_suffix)) {
            return 1;
        }

        if (is_suffix.length() == 1 || my_string.length() == 1) {
            sufLeng = 1;
            strLeng = 1;
        } else {
            sufLeng = is_suffix.length() - 1;
            strLeng = my_string.length() - 1;
        }

        int count = is_suffix.length() - 1;
        for (int i = sufLeng, j = strLeng; i >= 0; i--, j--) {
            if (count == 0) {
                return answer;
            }
            if (is_suffix.charAt(i) == my_string.charAt(j)) {
                answer = 1;
            } else {
                return answer = 0;
            }
        }
        return answer;
    }
    /*문제 설명
어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다. 예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다.
문자열 my_string과 is_suffix가 주어질 때, is_suffix가 my_string의 접미사라면 1을, 아니면 0을 return 하는 solution 함수를 작성해 주세요.

제한사항
1 ≤ my_string의 길이 ≤ 100
1 ≤ is_suffix의 길이 ≤ 100
my_string과 is_suffix는 영소문자로만 이루어져 있습니다.
입출력 예
my_string	is_suffix	result
"banana"	"ana"	1
"banana"	"nan"	0
"banana"	"wxyz"	0
"banana"	"abanana"	0
입출력 예 설명
입출력 예 #1

예제 1번에서 is_suffix가 my_string의 접미사이기 때문에 1을 return 합니다.
입출력 예 #2

예제 2번에서 is_suffix가 my_string의 접미사가 아니기 때문에 0을 return 합니다.
입출력 예 #3

예제 3번에서 is_suffix가 my_string의 접미사가 아니기 때문에 0을 return 합니다.
입출력 예 #4

예제 4번에서 is_suffix가 my_string의 접미사가 아니기 때문에 0을 return 합니다.*/

}
