package graph;

import java.util.*;

class Edge2 implements Comparable<Edge2> {
    int to;
    int weight;

    public Edge2(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge2 o) {
        return Integer.compare(this.weight, o.weight);
    }
}

public class 최소비용구하기_1916 {
    static List<Edge2>[] adjList;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 도시 수
        int M = sc.nextInt();  // 버스 수

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            adjList[from].add(new Edge2(to, weight));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dijkstra(start);

        System.out.println(dist[end]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge2> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Edge2(start, 0));

        while (!pq.isEmpty()) {
            Edge2 curr = pq.poll();
            int now = curr.to;
            int cost = curr.weight;

            if (cost > dist[now]) continue;

            for (Edge2 next : adjList[now]) {
                if (dist[next.to] > dist[now] + next.weight) {
                    dist[next.to] = dist[now] + next.weight;
                    pq.add(new Edge2(next.to, dist[next.to]));
                }
            }
        }
    }
}
