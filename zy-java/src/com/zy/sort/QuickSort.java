package com.zy.sort;

public class QuickSort {
	public static void main(String[] args) {
		int[] a = {9,4,10,5,2,7,3,5,4,2,1,0};
		quickSort(a, 0, a.length-1);
		int length = a.length;
		for(int i = 0; i < length; i++) {
			System.out.print(a[i] +" ");
		}
	}

	public static void quickSort(int[] a, int begin, int end) {
		if (end - begin < 1) {
			return;
		}
		int p1 = begin;
		int p2 = end;
		boolean dir = true;// ÏòÓÒ
		int x = a[p1];
		L1: while (p1 < p2) {
			if(dir) {
				for(int i = p2; i > p1; i--) {
					if(x >= a[i]) {
						a[p1++] = a[i];
						p2 = i;
						dir = !dir;
						continue L1;
					}
				}
				p2 = p1;
			} else {
				for(int i = p1; i < p2; i++) {
					if(x <= a[i]) {
						a[p2--] = a[i];
						p1 = i;
						dir = !dir;
						continue L1;
					}
				}
				p1 = p2;
			}
		}
		a[p1] = x;
		quickSort(a, begin, p1-1);
		quickSort(a,p1 + 1,end);
		
		
	}

}
