package slidingwindow;

import java.util.Scanner;

public class BlobYum {

    public static int max;
    public static int sum;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();

        int[] apple = new int[K+N];
        max = 0;
        sum = 0;

        for(int i= 0; i<K; i++){
            apple[i] = sc.nextInt();
            if( i < N){
                apple[K+i] = apple[i];
            }
        }

        for(int i=0; i<N; i++){
            sum += apple[i];
        }

        max = sum;

        for(int i=N; i<K+N; i++){
            int j = i-N;
            add(apple[i]);
            remove(apple[j]);
            if(max < sum){
                max = sum;
            }
        }

        System.out.println(max);

    }

    public static void add(int arr){
        sum = sum + arr;
    }

    public static void remove(int arr){
        sum = sum - arr;
    }



}
