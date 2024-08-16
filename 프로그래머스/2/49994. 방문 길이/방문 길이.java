class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int y = 10;  // 시작 위치 y
        int x = 10;  // 시작 위치 x
        int[][] map = new int[21][21]; // 경로 방문 여부를 표시할 맵

        for (int i = 0; i < dirs.length(); i++) {
            int ny = y, nx = x;

            // 현재 방향에 따른 새 위치 계산
            if (dirs.charAt(i) == 'U') {
                ny -= 2;
            } else if (dirs.charAt(i) == 'D') {
                ny += 2;
            } else if (dirs.charAt(i) == 'R') {
                nx += 2;
            } else if (dirs.charAt(i) == 'L') {
                nx -= 2;
            }

            // 이동이 유효한지 확인
            if (nx >= 0 && nx <= 20 && ny >= 0 && ny <= 20) {
                // 만약 새 경로가 처음 방문되는 경우
                int midY = (y + ny) / 2;
                int midX = (x + nx) / 2;
                if (map[midY][midX] == 0) {
                    map[midY][midX] = 1; // 중간 경로를 표시
                    answer++;
                }

                // 새 위치로 이동
                y = ny;
                x = nx;
            }
        }

        return answer;
    }
}
