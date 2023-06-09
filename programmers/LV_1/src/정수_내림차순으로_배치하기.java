public class 정수_내림차순으로_배치하기 {

    public long solution(long n) {
        long answer = 0;
        List<Integer> digits = new ArrayList<>();

        while (n > 0) {
            digits.add((int) (n % 10));
            n /= 10;
        }

        digits.sort(Comparator.reverseOrder());

        for (int digit : digits) {
            answer = answer * 10 + digit;
        }

        return answer;
    }

    //풀었지만 런타임오류..
    public long solution(long n) {
        long answer = 0;
        String N = n + "";
        char arr[] = N.toCharArray();
        Arrays.sort(arr);
        System.out.println(N);
        StringBuilder sb = new StringBuilder(new String(arr, 0, arr.length));
        System.out.println(sb);
        N = sb.reverse().toString();
        System.out.println(N);
        //Arrays.sort(N, Collections.reverseOrder());
        return Integer.parseInt(N);
    }
    /*문제 설명
함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.

제한 조건
n은 1이상 8000000000 이하인 자연수입니다.
입출력 예
n	return
118372	873211*/
}
