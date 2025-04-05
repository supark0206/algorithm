package dfs;

import java.io.IOException;
import java.util.*;

/*
신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.

예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다. 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.


어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다. 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.

출력
1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
 */

public class 바이러스_2606 {
    static int count = 0;
    static boolean[] visited;
    static ArrayList<Integer>[] computers;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 컴퓨터 수 (노드 개수)
        int v = sc.nextInt();  // 간선(연결) 수

        // 방문 배열 초기화 (1번부터 n번 사용)
        visited = new boolean[n+1];
        // 인접 리스트 배열 초기화
        computers = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            computers[i] = new ArrayList<Integer>();
        }

        // 네트워크 연결 정보 입력받기
        for (int i = 0; i < v; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            // a와 b 컴퓨터가 서로 연결되어 있으므로 양쪽에 추가
            computers[a].add(b);
            computers[b].add(a);
        }

        // BFS 탐색: 1번 컴퓨터에서 시작
        DFS(1);
        // 1번 컴퓨터는 시작점이므로 감염된 컴퓨터 수에서 제외하여 출력
        System.out.println(count - 1);
    }


    private static void DFS(int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        count++;

        for (int i = 0; i < computers[node].size(); i++) {
            int next = computers[node].get(i);
            if (!visited[next]) {
                DFS(next);
            }
        }
    }
}
