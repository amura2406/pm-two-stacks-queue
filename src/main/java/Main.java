import collection.MyQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final Integer[] INPUT = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        List<Integer> results = new ArrayList<>();

        int i=0;
        for(; i<5; i++) queue.enqueue(INPUT[i]); // +5
        for(int j=0; j<3; j++) results.add(queue.dequeue()); // -3

        queue.enqueue(INPUT[i++]); // +1
        for(int j=0; j<3; j++) results.add(queue.dequeue()); // -3

        for(; i<10; i++) queue.enqueue(INPUT[i]); // +4
        for(int j=0; j<4; j++) results.add(queue.dequeue()); // -4

        for(; i<20; i++) queue.enqueue(INPUT[i]); // +10
        for(int j=0; j<6; j++) results.add(queue.dequeue()); // -6
        for(int j=0; j<4; j++) results.add(queue.dequeue()); // -4

        System.out.printf("INPUT : %s\n", Arrays.toString(INPUT));
        System.out.printf("RESULT: %s\n", results);

        if(!Arrays.equals(INPUT, results.toArray(new Integer[0]))){
            throw new AssertionError("Resulted list must match the order of inputted number");
        }

        System.out.println("Program finished !");
    }
}
