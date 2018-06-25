package aps2.binpacking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Bin packing algorithm to compute the minimum number of bins to store all the
 * given items.
 */

public class BinPacking {
	int[] items; // sizes of items to store
	int m; // size of each bin

	public BinPacking(int[] items, int m) {
		this.items = items;
		this.m = m;
	}

	/**
	 * Computes the strictly minimal number of bins for the given items.
	 * 
	 * @return Array of size n which stores the index of bin, where each item is stored in.
	 */
	public int[] binPackingExact() {
            int length = items.length;
            int[] a = new int[length];
            int[] b = new int[length];
            int c = 0;
            // 7 2 7 2 8 8 3 3
            // 0 1 2 3 4 5 6 7
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if(a[j] == 0){
                        a[j] = items[i];
                        b[i] = j;
                        break;
                    }
                    else if (a[j] + items[i] == m){
                        a[j] += items[i];
                        b[i] = j;
                        break;
                    }
                }
            }
            
            return b;
	}
	
	/**
	 * Uses heuristics (e.g. first-fit, best-fit, ordered first-fit etc.) to
	 * compute the minimal number of bins for the given items. The smaller the
	 * number, the more tests you will pass.
	 * 
	 * @return Array of size n which stores the index of bin, where each item is stored in.
	 */
	public int[] binPackingApproximate() {
            int length = items.length;
            int[] a = items.clone();
            int[] b = items;
            int[] c = new int[length];
            Arrays.sort(a);
            for (int i = 0; i < length; i++) {
                b[i] = a[length-i-1];
            }
            
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if(c[j] == 0){
                        c[j] = b[i];
                        a[i] = j;
                        break;
                    }
                    else if (c[j] + b[i] <= m){
                        c[j] += b[i];
                        a[i] = j;
                        break;
                    }
                }
            }
            
            return a;
	}

}
