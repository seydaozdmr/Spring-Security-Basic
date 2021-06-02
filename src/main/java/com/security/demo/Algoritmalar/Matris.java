package com.security.demo.Algoritmalar;

public class Matris {

    public static void main(String[] args) {
        int[][] arr={{1,2,3},{4,5,6},{9,8,9}};

        System.out.println(matrisFark(arr));
    }

    public static int matrisFark(int [][] arr){
        int a=0;
        int b=0;
        int j=arr[0].length-1;
        for(int i=0;i<arr[0].length;i++){
            a+=arr[i][i];
            b+=arr[j][i];
            j-=1;
        }
        return Math.abs(a-b);
    }

}
