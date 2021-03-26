package Que;

import java.io.*;
import java.util.Scanner;

public class TestQueue {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("src/Que/input.txt"));
        CustomQueue customQueue = new CustomQueue();
        int n = sc.nextInt();
        sc.nextLine();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/Que/output.txt")));) {

            for(int i = 0; i < n; i++) {
                String str = sc.nextLine();
                char operation = str.charAt(0);
                if(operation == '+') {
                    customQueue.push(Character.getNumericValue(str.charAt(2)));
                }
                if(operation == '-') {
                    customQueue.pop();
                }

                if(operation == '?') {
                    writer.write(String.valueOf(customQueue.getMin()));
                }
            }
        }



    }
}
