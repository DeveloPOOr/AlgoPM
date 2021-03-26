package Que;

import javafx.util.Pair;

import java.util.LinkedList;

public class CustomQueue {
    private LinkedList<Pair<Integer,Integer>> leftStack = new LinkedList<>();
    private LinkedList<Pair<Integer,Integer>> rightStack = new LinkedList<>();

    public int pop() {
        if(rightStack.isEmpty()) {
            while (!leftStack.isEmpty()) {
                int elem = leftStack.pollLast().getValue();
                int min = rightStack.isEmpty() ? elem : Math.min(elem, rightStack.peekLast().getKey());
                rightStack.add(new Pair<>(min, elem));
            }
        }
        return rightStack.pollLast().getValue();
    }

    public void push(int elem) {
        int current = leftStack.isEmpty() ? elem : Math.min(leftStack.peekLast().getKey(), elem);
        leftStack.add(new Pair<>(current, elem));
    }

    public int getMin() {
        int currentMin = 228;
        if(leftStack.isEmpty() || rightStack.isEmpty()) {
            currentMin = leftStack.isEmpty() ? rightStack.peekLast().getKey() : leftStack.peekLast().getKey();
        } else{
            currentMin = Math.min(rightStack.peekLast().getKey(), leftStack.peekLast().getKey());
        }
        return currentMin;
    }
}
