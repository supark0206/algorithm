package stack;

import java.util.Scanner;
import java.util.Stack;
/*

이번 계절학기에 심리학 개론을 수강 중인 평석이는 오늘 자정까지 보고서를 제출해야 한다. 보고서 작성이 너무 지루했던 평석이는 노트북에 엎드려서 꾸벅꾸벅 졸다가 제출 마감 1시간 전에 깨고 말았다. 안타깝게도 자는 동안 키보드가 잘못 눌려서 보고서의 모든 글자가 A와 B로 바뀌어 버렸다! 그래서 평석이는 보고서 작성을 때려치우고 보고서에서 '좋은 단어'나 세보기로 마음 먹었다.

평석이는 단어 위로 아치형 곡선을 그어 같은 글자끼리(A는 A끼리, B는 B끼리) 쌍을 짓기로 하였다. 만약 선끼리 교차하지 않으면서 각 글자를 정확히 한 개의 다른 위치에 있는 같은 글자와 짝 지을수 있다면, 그 단어는 '좋은 단어'이다. 평석이가 '좋은 단어' 개수를 세는 것을 도와주자.

입력
첫째 줄에 단어의 수 N이 주어진다. (1 ≤ N ≤ 100)

다음 N개 줄에는 A와 B로만 이루어진 단어가 한 줄에 하나씩 주어진다. 단어의 길이는 2와 100,000사이이며, 모든 단어 길이의 합은 1,000,000을 넘지 않는다.

출력
첫째 줄에 좋은 단어의 수를 출력한다.
 */

public class 좋은단어 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 단어의 개수
        int goodWordCount = 0;

        for (int i = 0; i < n; i++) {
            String word = sc.next();
            if (isGoodWord(word)) {
                goodWordCount++;
            }
        }

        System.out.println(goodWordCount);
        sc.close();
    }

    public static boolean isGoodWord(String word) {
        Stack<Character> stack = new Stack<>();

        for (char ch : word.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}