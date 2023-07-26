public class 삼각형_완성조건_2 {

    public int solution(int[] sides) {
        int answer = 0;
        int[] sides2 = sides;
        Arrays.sort(sides2);
        //가장 긴 변이 아닐경우
        answer = sides2[1] - (sides2[1] - sides2[0]);
        //가장 긴 변일 경우
        answer += sides2[0] + sides2[1] - sides2[1] - 1;
        return answer;
    }

}
