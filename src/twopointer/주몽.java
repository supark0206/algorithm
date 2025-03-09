package twopointer;

import java.util.Arrays;
import java.util.Scanner;


public class 주몽 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];

        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        int count = 0;
        int i = 0;
        int j = n-1;

        while(i<j){
            if(nums[i] + nums[j] < m){
                i++;
            } else if ( nums[i] + nums[j] == m ) {
                count++;
                i++;
                j--;
            } else {
                j--;
            }

        }

        System.out.println(count);

    }
}