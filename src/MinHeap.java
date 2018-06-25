/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AzzySloPc
 */
public class MinHeap {
    private int k;
    private int[] minHeap;
    private int lastElement;
    public MinHeap(int capacity ,int k){
        this.k = k;
        this.lastElement = 0;
        this.minHeap = new int[capacity];
    }
    public MinHeap(int capacity ,int k, int[] items){
        this.k = k;
        this.lastElement = 0;
        this.minHeap = new int[capacity];
        for (int item : items) {
            add(item);
        }
    }
    public void add(int a){
        minHeap[lastElement] = a;
        lastElement++;
        siftUp();
    }
    public void siftUp(){
        int parent = (lastElement-1)/k;
        int child = lastElement-1;
        while (child > 0 && minHeap[parent] > minHeap[child]) {
            int temp = minHeap[child];
            minHeap[child] = minHeap[parent];
            minHeap[parent] = temp;
            child = parent;
            parent = parent/k;
        }
    }
    public void printOut(){
        for (int i = 0; i < minHeap.length && i<lastElement; i++) {
            System.out.print(minHeap[i]+" ");
        }
        System.out.println();
    }
    public void delMin(){
        if (lastElement == 0)
            return;
        minHeap[0] = minHeap[lastElement-1];
        lastElement--;
        minHeap[lastElement] = 0;
        siftDown(0);
    }
    public void siftDown(int k) {
        int smallest = k;
        int leftChildIdx = 2 * k;
        int rightChildIdx = 2 * k+1;
        for (int i = 0; i < k; i++) {
            if (k*k+i+1 < lastElement-1 && minHeap[smallest] > minHeap[k*k+i+1])
                smallest = k*k+i+1;
        }
        if (smallest != k){
            int temp = minHeap[k];
            minHeap[k] = minHeap[smallest];
            minHeap[smallest] = temp;
            siftDown(smallest);
        }
        
    }
    
}
