/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AzzySloPc
 */
public class Kopica {
    private int stOtrok;
    private int[] kopica;
    private int lastElement = 0;
    public Kopica(){
        stOtrok = 2;
        int a=Integer.MAX_VALUE/3;
        kopica = new int[a];
    }
    public Kopica(int steviloElementov){
        stOtrok = 2;
        kopica = new int[steviloElementov];
    }
    public Kopica(int steviloElementov ,int stOtrok){
        this.stOtrok = stOtrok;
        kopica = new int[steviloElementov];
    }
    public Kopica(int steviloElementov ,int stOtrok,int[] arr){
        this.stOtrok = stOtrok;
        kopica = new int[steviloElementov];
        for (int i : arr) {
            dodaj(i);
        }
    }
    public void dodaj(int a){
//        if(kopica.length <= lastElement) {
//            int[] temp = new int[kopica.length*2];
//            System.arraycopy(kopica, 0, temp, 0, kopica.length);
//            kopica = temp;
//        }
        kopica[lastElement] = a;
        lastElement++;
        sort();
    }
    public void sort(){
        int stars = (lastElement-1)/stOtrok;
        int otrok = lastElement-1;
        while (otrok > 0 && kopica[stars] > kopica[otrok]) {
            int temp = kopica[otrok];
            kopica[otrok] = kopica[stars];
            kopica[stars] = temp;
            otrok = stars;
            stars = stars/stOtrok;
        }
    }
    public void IzpisVseh(){
        for (int i = 0; i < kopica.length && i<lastElement; i++) {
            System.out.print(kopica[i]+" ");
        }
        System.out.println();
    }
    public void delMin(){
        if (lastElement == 0)
            return;
        kopica[0] = kopica[lastElement-1];
        lastElement--;
        kopica[lastElement] = 0;
        potopi(0);
    }
    public void potopi(int k) {
        int smallest = k;
        int leftChildIdx = 2 * k;
        int rightChildIdx = 2 * k+1;
        for (int i = 0; i < stOtrok; i++) {
            if (stOtrok*k+i+1 < lastElement-1 && kopica[smallest] > kopica[stOtrok*k+i+1])
                smallest = stOtrok*k+i+1;
        }
        if (smallest != k){
            int temp = kopica[k];
            kopica[k] = kopica[smallest];
            kopica[smallest] = temp;
            potopi(smallest);
        }
        
    }
    
}
