package Unit2;

/**
 * 	选择排序
 * 	参考：《算法》
 * @author Asia
 * @version 1.0
 */

import edu.princeton.cs.algs4.StdOut;

import java.io.IOException;

import edu.princeton.cs.algs4.StdIn;

public class SelectSort{

    private SelectSort(){}  

    public static void sort(int[] a){
        int n = a.length;
        for (int i = 0; i < n; ++i){
            int min = i;
            for (int j = i+1; j < n; ++j){
                if (a[j] < a[min])
                    min = j;
            }
            exch(a,i,min);      //交换
        }
    }

    public static void exch(int[] a, int i, int j){
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void show(int[] a){
        for (int i = 0; i < a.length; ++i){
            StdOut.println(a[i]);
        }
    }
    public static void main(String[] args) throws IOException{
        int[] a = new int[10];
        for (int i = 0; i < a.length; ++i)
            a[i] = System.in.read();
        sort(a);
        show(a);
    }
}