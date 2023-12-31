package Sorting;

import java.util.Scanner;

public class MaxMinSort {
	int N = 5;
	int []A = new int[N];
	
	void InitArray() {
		System.out.println("Inisialisasi array");
		for (int i=0; i<N; i++) {
			A[i] = 0;
		}
	}
	
	void InputArray() {
		System.out.println("Menginput element-element array");
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<N; i++) {
			System.out.print("Data ke-"+i+":");A[i]=sc.nextInt(); // tambahkan ini bila Scanner sc sudah di buat
		}
	}
	
	void TampilArray() {
		System.out.println("Menampilkan isi/element array");
		for (int i=0; i<N; i++) {
			System.out.println("Data ke "+i+" adalah "+A[i]);
		}
	}
	
	void MaximumSort() {
		int temp, imax;
		
		for (int tahap=1; tahap <= N-1; tahap++) {
			imax = 0;
			for (int i=1; i <= N-tahap; i++) {
				if (A[i] > A[imax]) {
					imax = i;
				}
			}
			temp = A[imax];
			A[imax] = A[N-tahap];
			A[N-tahap] = temp;
		}
	}
	
	void MinimumSort() {
		int temp, imin;
		
		for (int tahap=1; tahap <= N-1; tahap++) {
			imin = 0;
			for (int i=1; i <= N-tahap; i++) {
				if (A[i] < A[imin]) {
					imin = i;
				}
			}
			temp = A[imin];
			A[imin] = A[N-tahap];
			A[N-tahap] = temp;
		}
	}	
	
	public static void main(String[] args) {
		MaxMinSort A = new MaxMinSort();
		Scanner sc = new Scanner(System.in);
		
		A.InitArray();
		A.InputArray();
		A.TampilArray();
		
//		int x;
//		do {
//			System.out.print("1(membesar)/2(mengecil)/0(stop): ");x = sc.nextInt();
//			A.BubbleSort(x);
//			A.TampilArray();
//		}while(x!=0);
		
		A.MinimumSort();
		A.TampilArray();

	}

}
