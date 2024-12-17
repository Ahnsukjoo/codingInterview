class Solution {
    public int solution(int n, int a, int b) {
        int round = 0;
        int player1 = Math.min(a, b);
        int player2 = Math.max(a, b);
        
        while (player1 != player2) {
            player1 = (player1 + 1) / 2;
            player2 = (player2 + 1) / 2;
            round++;
        }
        
        return round;
    }
}
