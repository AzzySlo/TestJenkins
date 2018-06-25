
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aljaz Debelak
 */
public class MainHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Please define number of nodes");
        int k = sc.nextInt();
        System.out.println("Please define maximum capacity");
        int capacity = sc.nextInt();
        //fill heap with randon numbers
        int[] items = new int[capacity];
        Random r = new Random();
        for (int i = 0; i < capacity; i++) {
            items[i] = r.nextInt();
        }
        //Select task
        int task;
        do{
        System.out.println("Please select:");
        System.out.println("For 'Insert then delete' type 1");
        System.out.println("For 'Insert and delete' type 2");
        System.out.println("For exit type 3");
        task = sc.nextInt();
            if (task == 3)
                System.exit(0);
        }
        while (!(task == 1 || task == 2));
        Double result;
        //Test insert then delete
         
        if (task == 1)
            result = testMinHeapInsertThenDelete(capacity,k,items);
        //Test insert and delete
        else 
            result = testMinHeapInsertAndDelete(capacity,k,items);
        
        System.out.println("Resulting time in miliseconds: "+result);
        
    }
   private static double testMinHeapInsertThenDelete(int insertsDeletes,int k,int[] items){
       
        long beginTime = System.nanoTime();
        MinHeap minHeap = new MinHeap(insertsDeletes,k,items);
        for (int i = 0; i < insertsDeletes; i++)
            minHeap.delMin();
        long endTime = System.nanoTime();
        //return time in miliseconds
        return (endTime-beginTime)/1000000.0;
   }
   private static double testMinHeapInsertAndDelete(int insertsDeletes,int k,int[] arr){
        Random r = new Random();
        long beginTime = System.nanoTime();
        MinHeap minHeap = new MinHeap(insertsDeletes,k,arr);
        //adding random nubmers while removing min
        for (int i = 0; i < insertsDeletes+insertsDeletes/3; i++){
            minHeap.delMin();
            minHeap.delMin();
            minHeap.add(r.nextInt());
            minHeap.delMin();
            minHeap.add(r.nextInt());
            minHeap.add(r.nextInt());
            minHeap.delMin();
            minHeap.delMin();
            minHeap.add(r.nextInt());
        }
        long endTime = System.nanoTime();
        //return time in miliseconds
        return (endTime-beginTime)/1000000.0;
   }
}
