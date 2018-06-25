
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AzzySloPc
 */
public class MainKopica extends JPanel {
    private static List<Integer> zaGraf = new ArrayList<Integer>();
    private static int max = 0;
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("za koliko števil naj rezerviram prostor");
        int stev = sc.nextInt();
        Random r = new Random();
        int[] arr = new int[stev];
        for (int i = 0; i < stev; i++) {
            arr[i] = r.nextInt();
        }
        System.out.println("Koliko naj bo največja osnova kopice");
        int in = sc.nextInt();
        
        System.out.println("Izberite nalogo!");
        System.out.println("Vpišite 1 za nalogo 1. Insert then delete");
        System.out.println("Vpišite 2 za nalogo 2. Insert and delete");
        System.out.println("Vpišite 3 za izhod");
        Double a;
        int in1 = sc.nextInt();
        
        for (int i = 2; i < in; i++) {
            //Test insert then delete
            while (!(in1 == 1 || in1 == 2)){
                System.out.println((in1 != 1 || in1 != 2) +" " + in1);
                if (in1 == 3){}
                    System.exit(0);
                System.out.println("Izberite nalogo!");
                System.out.println("Vpišite 1 za nalogo 1. Insert then delete");
                System.out.println("Vpišite 2 za nalogo 2. Insert and delete");
                System.out.println("Vpišite 3 za izhod");
            }
            if (in1 == 1)
                a = testKopicaInsertThenDelete(stev,i,arr);
            //Test insert and delete
            else 
                a = testKopicaInsertAndDelete(stev,i,arr);
            if (a > max)
                max = a.intValue();
            if (a < min)
                min = a.intValue();
            System.out.println(a);
            zaGraf.add(Math.round(Math.round(a)));
        }
      JFrame frame = new JFrame("DrawGraph");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new MainKopica());
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
    }
    
   @Override
   public Dimension getPreferredSize() {
      return new Dimension(800, 700);
   }
   protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < zaGraf.size(); i++) {
            g2.fill3DRect(i*20, max+300-zaGraf.get(i), 10, 10, true);
        }    
        System.out.println("Če so rezultati preveč podobni probajte večjo številko in obratno");
      
   }
   private static double testKopicaInsertThenDelete(int insertsDeletes,int stopnja,int[] arr){
       
        long a = System.nanoTime();
        Kopica K2 = new Kopica(insertsDeletes,stopnja,arr);
        for (int i = 0; i < insertsDeletes; i++)
            K2.delMin();
        long b = System.nanoTime();
        return (b-a)/1000000.0;
   }
   private static double testKopicaInsertAndDelete(int insertsDeletes,int stopnja,int[] arr){
        Random r = new Random();
        long a = System.nanoTime();
        Kopica K2 = new Kopica(insertsDeletes,stopnja,arr);
        for (int i = 0; i < insertsDeletes+insertsDeletes/3; i++){
            K2.delMin();
            K2.delMin();
            K2.dodaj(r.nextInt());
            K2.delMin();
            K2.dodaj(r.nextInt());
            K2.dodaj(r.nextInt());
            K2.delMin();
            K2.delMin();
            K2.dodaj(r.nextInt());
        }
        long b = System.nanoTime();
        System.out.print(".");
        return (b-a)/1000000.0;
   }
}
