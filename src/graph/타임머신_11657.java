package graph;

import java.io.*;
import java.util.*;

public class 타임머신_11657 {

    static long[] dist;
    static final long MAX = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> edgeList = new ArrayList<>();
        dist = new long[N + 1];
        Arrays.fill(dist, MAX);
        dist[1] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(A, B, C));
        }

        for (int i = 1; i < N; i++) {
            for (Edge e : edgeList) {
                if (dist[e.from] != MAX && dist[e.to] > dist[e.from] + e.weight) {
                    dist[e.to] = dist[e.from] + e.weight;
                }
            }
        }

        // 음수 사이클 존재 체크
        for (Edge e : edgeList) {
            if (dist[e.from] != MAX && dist[e.to] > dist[e.from] + e.weight) {
                System.out.println("-1");
                return;
            }
        }

        // 결과 출력
        for (int i = 2; i <= N; i++) {
            if (dist[i] == MAX) sb.append("-1\n");
            else sb.append(dist[i]).append('\n');
        }

        System.out.print(sb);
    }
}

class Edge {
    int from, to, weight;

    Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
