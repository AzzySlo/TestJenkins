package aps2.binpacking;

import aps2.binpacking.BinPacking;
import java.util.HashSet;

public class PublicTests {
        private static BinPacking bp;
        public static void main(String[] args) {
            int[] a = new int[20];
            int[] b = new int[20];
            //System.out.println(checkBinsAndItemsValidity(a,b,5));
            testBinPackingExactTiny();
            testBinPackingApproximateTiny();
        }

	public static boolean checkBinsAndItemsValidity(int[] items, int[] itemBins, int m) {
		if (items.length != itemBins.length) {
			// each item should be assigned into exactly one bin
			return false;
		}
		
		int[] binCapacity = new int[items.length];		
		for (int i=0; i<items.length; i++) {
			binCapacity[itemBins[i]] += items[i];
		}
                
		for (int curBinCapacity: binCapacity) {
			if (curBinCapacity > m) {
				// bin capacity overflow
				return false;
			}
		}
		
		return true;
	}
	
	public static void testBinPackingExactTiny() {
		int[] items = {7,2,7,2,8,8,3,3};
		int m=10;
		bp = new BinPacking(items, m);
		
		int[] res = bp.binPackingExact();
		System.out.println((checkBinsAndItemsValidity(items, res, m))+"  --- must be true");
		HashSet<Integer> uniqueBins = new HashSet();
                
		for (int bin: res) {
			uniqueBins.add(bin);
		}
		          System.out.println((4+"   "+uniqueBins.size())); // the optimal number bins is 4, for example {7,3},{7,3},{8,2},{8,2}
	}
	
	public static  void testBinPackingApproximateTiny() {
		int[] items = {7,2,7,2,8,8,3,3};
		int m=10;
		bp = new BinPacking(items, m);
		
		int[] res = bp.binPackingApproximate();
		          System.out.println((checkBinsAndItemsValidity(items, res, m)) + " wgy");
		HashSet<Integer> uniqueBins = new HashSet();
                
		for (int bin: res) {
			uniqueBins.add(bin);
		}
		          System.out.println(uniqueBins.size() <= 4*1.23); // you should pack into at most 4.92=4 bins using the heuristics
	}
}
