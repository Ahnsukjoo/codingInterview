import java.util.*;
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length]; // 가로 * 새로
        //int[][] answer = new int[3][3];
        for(int i = 0; i < arr2.length; i++){
            for(int j = 0 ; j < answer.length * answer[0].length ; j++){
              //  System.out.println(answer.length +"+"+ answer[0].length);
              //  System.out.println("i= "+ i+ "j= "+j);
                //System.out.println(" ["+ j/arr2[0].length+ "]"+"["+i+"] "+"["+ i+ "]"+"["+j%arr2[0].length+"] ");
                answer[j/answer[0].length][j%arr2[0].length] += arr1[j/arr2[0].length][i] * arr2[i][j%arr2[0].length];
            }
            //System.out.println();
        }
        //System.out.println(arr2[0].length);
        return answer;
    }
}