package main.java.com.wd;

public class InsertSort {
	public static void main(String[] args){
		int [] a=new int[]{6,78,9,4,63,48,2,56,74,36,45,1};
		insertSort(a);
		for (int value : a) {
			System.out.print(value + " ");
		}
	}
	private static void insertSort(int[] a){
		if(a==null || a.length<2){
			return;
		}
		int sortedIndex;
		int temp;
		for(int i=1;i<a.length;i++){
			sortedIndex=i-1;
			temp=a[i];
			for(;sortedIndex>=0;sortedIndex--){
				if(temp>=a[sortedIndex]){
					break;
				}
				a[sortedIndex+1]=a[sortedIndex];
			}
			a[sortedIndex+1]=temp;
		}
	}
}
