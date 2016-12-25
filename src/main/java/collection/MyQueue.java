package collection;

import collection.exception.EmptyQueueException;

import java.util.Stack;

/**
 * Created by amura on 12/25/16.
 */
public class MyQueue<T> {
    private Stack<T> stack1 = new Stack<T>();
    private Stack<T> stack2 = new Stack<T>();

    /**
     * Enqueue an item into the queue
     * Basically it will push an item into the first stack
     * Time complexity is O(1), and should be lightweight
     */
    public synchronized void enqueue(T item) {
        System.out.println("ENQUEUE: " + item);
        stack1.push(item);
    }

    /**
     * Dequeue an item from the queue
     * This method can sometimes costly because items transferring from first stack to second stack might occur.
     * If there's at least 1 item on second stack then the operation will just `pop` from second stack.
     * Time complexity minimum is O(1), maximum is O(n+1)
     *
     * It may throw `EmptyQueueException` when the underlying queue's storage is empty.
     */
    public synchronized T dequeue() {
        if(isEmpty())
            throw new EmptyQueueException();

        if(stack2.empty()){
            while(!stack1.empty())
                stack2.push(stack1.pop());
        }

        T item = stack2.pop();
        System.out.println("DEQUEUE: " + item);
        return item;
    }

    public synchronized boolean isEmpty(){
        return stack1.empty() && stack2.empty();
    }
}
