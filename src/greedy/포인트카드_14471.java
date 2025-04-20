package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/*
문제
JOI 상점가에서는 포인트 카드 서비스를 실시하고 있다. 각 포인트 카드에는 도장을 찍을 수 있는 칸이 총 2N개 있어, 상품을 구매하면 뽑기를 해서 결과에 따라 '당첨' 또는 '꽝' 도장이 찍힌다. 한 칸에 두 번 이상 도장을 찍을 수는 없다. 2N개 중 N개 이상의 칸에 당첨 도장이 찍힌 포인트 카드는 경품과 교환할 수 있다. 또, 한 칸에 찍힌 도장을 1엔을 내고 다른 도장으로 바꿀 수 있다.

JOI 군은 2N개 칸을 다 채운 포인트 카드를 M장 가지고 있다. i번째 포인트 카드에는 Ai개의 당첨 도장과, Bi개의 꽝 도장이 찍혀 있다.

JOI 군은 M-1개 이상의 경품을 가지려고 한다. 이에 필요한 비용의 최솟값을 구하라.

입력
입력은 M+1줄로 이루어진다.

첫 줄에는 2개의 정수 N, M(1 ≤ N ≤ 1000, 1 ≤ M ≤ 1000)이 공백을 사이에 두고 주어진다. 이는 포인트 카드에 2N개의 칸이 있고, JOI 군이 M장의 포인트 카드를 가지고 있음을 나타낸다.

다음 M개 줄 중 i번째(1 ≤ i ≤ M) 줄에는 각각 2개의 정수 Ai, Bi (0 ≤ Ai ≤ 2N, 0 ≤ Bi ≤ 2N, Ai + Bi = 2N)가 주어지며, 포인트 카드 i에 Ai개의 당첨 도장과 Bi개의 꽝 도장이 찍혀 있음을 나타낸다.

출력
JOI 군이 M-1개 이상의 경품을 얻기 위해 필요한 비용의 최솟값을 엔 단위로 한 줄로 출력하라.
 */
public class 포인트카드_14471 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int kan = 2 * N;

        List<Integer> fail =  new ArrayList<>();
        int reward = 0;

        for(int i=0; i<M; i++){

            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a >= N) {
                reward++; // 이 카드는 교환 없이 바로 경품
            } else {
                int cost = N - a; // 교환해야 할 도장 수 = 비용
                fail.add(cost);
            }
        }

        int needed = (M - 1) - reward;
        if (needed <= 0) {
            System.out.println(0);
            return;
        }

        Collections.sort(fail);
        int result = 0;
        for (int i = 0; i < needed; i++) {
            result += fail.get(i);
        }

        System.out.println(result);

    }
}