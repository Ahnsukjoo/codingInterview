import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stageClear = new int[N];
        int[] failCount = new int[N];
        double[] fail = new double[N];  // 스테이지 5개범위에 맞는 실패율 배열
        double[] failSort = new double[N];
        int count = 0;
        // 정답 배열에 스테이지 도달한 사람 숫자 저장
        for(int i = 0 ; i < stages.length; i++){
            for(int j = 0 ; j < stages[i];j++){
                if(j<N){
                   stageClear[j]++; 
                }
                
                //System.out.println("i= " +i+ "j= "+j);
            }
        }
        for(int i = 0; i < stages.length; i++){
            if(stages[i] < N+1){
                failCount[stages[i]-1]++;
            }
        }
        //실패율 구하기
        for(int i = 0 ; i < N ; i++){
            if(stageClear[i]==0) {
                fail[i]=0;
                break;
            }
            fail[i] = (double)failCount[i]/ (double)stageClear[i];
            failSort[i] = fail[i];
        }
        Arrays.sort(failSort);
      
        for(int i = N-1; i >= 0 ; i--){
            for(int j = 0; j < N; j++){
                if(failSort[i]==fail[j]&&fail[j]!=-1){
                    //System.out.println("i= "+i+ "j= "+j);
                    answer[count] = j+1;
                    fail[j] = -1;
                    count++;
                    break;
                }
                if(count==N){
                    return answer;
                }
            }
        }
        return answer;
    }
}
