package ua.advanced.lesson02;

import java.util.*;

class IterableStack<T> implements Iterable<T>{
    private T[] arr;
    private int top;

    public IterableStack(int n) {
        arr = (T[]) new Object [n];
        top = -1;
    }
    public IterableStack() {
        this(10);
    }
    public T pop(){
        T value = arr[top];
        arr[top] = null;
        top--;
        return value;
    }
    public void push (T value){
        arr[++top] = value;
    }
    public T peek(){
        return arr[top];
    }
    public int size(){
        return top+1;
    }
    public boolean isFull(){
        return top == arr.length-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int i = -1;
            @Override
            public boolean hasNext() {
                return i+1 < size();
            }

            @Override
            public T next() {
                return arr[++i];
            }
        };
    }
}

class MyList<E> extends AbstractList<E>{
    private E[] arr = (E[]) new Object[10];
    @Override
    public E get(int index) {
        return arr[index];
    }

    @Override
    public int size() {
        return arr.length;
    }
}
public class Program {
    public static void main(String[] args) {
        IterableStack<Integer> eStack = new IterableStack<>();
        eStack.push(1);
        eStack.push(2);
        eStack.push(3);
        eStack.push(4);
        eStack.push(5);
        eStack.pop();

        for(int value : eStack){
            System.out.println(value);
        }

        Iterator<Integer>iter = eStack.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        Deque<String> deque = new ArrayDeque<>();



    }
}
