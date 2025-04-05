package search.binary;

import java.io.IOException;
import java.util.Scanner;

public class CD_4156 {

    public static void main(String[] args) throws IOException {
        Scanner sc  = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if (n == 0 && m == 0) break;

            int[] sang = new int[n];
            for (int i = 0; i < n; i++) {
                sang[i] = sc.nextInt();
            }

            int count = 0;
            for (int i = 0; i < m; i++) {
                int sun = sc.nextInt();
                if (binarySearch(sang, sun)) {
                    count++;
                }
            }

        }



    }
    public static boolean binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length- 1;

        while(left <= right){
            int mid = (left+right) / 2;
            if(arr[mid] == target ) return true;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;

    }


}
