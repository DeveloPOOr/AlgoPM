package AntiQuick;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AntiQuick {
    public static void main(String[] args) throws IOException {

        //чтение файла и создание массива длины n
        Scanner sc = new Scanner(new File("src/AntiQuick/input.txt"));
        int n = sc.nextInt();
        int[] mas = IntStream.range(1, n+1).toArray();

        //сам алгоритм
        for(int i = 0; i < n; i ++) {
            int b = mas[i];
            mas[i] = mas[i/2];
            mas[i/2] = b;
        }

        //запись
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/AntiQuick/output.txt")));) {
            writer.write(Arrays.toString(mas));
        }
    }
}
