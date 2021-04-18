package MergeSort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeTest {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("src/MergeSort/input.txt"));
        int n = sc.nextInt();
        int[] mas = new int[n];
        for(int i = 0; i < n; i++) {
            mas[i] = sc.nextInt();
        }
        mergeSort(mas, n);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/MergeSort/output.txt")));) {
            for(int i = 0; i < n; i++) {
                writer.write(mas[i] + " ");
            }
        }

//        System.out.println(Arrays.toString(mas));
    }


    public static void mergeSort(int[] a, int n) throws IOException {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) throws IOException {
        int end = left+right;
        int A = l[0];
        int B = r[r.length-1];
        int begin = left;
        String ans = begin + " " + end + " " + A + " " + B + "\n";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/MergeSort/output.txt")));) {

            writer.write(ans);
            writer.write(228);
        }

//        System.out.println(left + " " + end + " "+ A + " " + B);
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}


