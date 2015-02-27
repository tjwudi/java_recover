package com.wudi;

public class Test4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new CircleSorted().isCircleSorted(new int[] { 1, 2, 3, 0 }));
	}

}


class CircleSorted {


    public boolean isCircleSorted(int[] a) {
          int lenA = a.length;
          int[] extendedA = new int[lenA + 1];
          for (int i = 0; i < lenA; i ++) extendedA[i] = a[i];
          extendedA[lenA] = extendedA[0];
          int greater = 0;
          for (int i = 0; i < lenA; i ++) 
            if (extendedA[i] > extendedA[i+1]) greater++;
          return greater <= 1;
    }
}