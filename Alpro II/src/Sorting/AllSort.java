package Sorting;

import java.util.Scanner;

public class AllSort {
	
	int N=5;
	int []A=new int[N];
	
	void InitArray() {
		System.out.println("Inisialisasi array");
		for (int i=0; i<N;i++) {
			A[i]=0;
		}
	}

	void InputArray() {
		System.out.println("Menginput element-element array");
		Scanner sc = new Scanner(System.in); // supaya bisa di inputkan
		for (int i=0; i<N;i++) {
			System.out.print("Data ke-"+i+":");A[i]=sc.nextInt();
		}
	}

	void TampilArray() {
		System.out.println("Menampilkan isi/element array");
		for (int i=0; i<N;i++) {
			System.out.println("Data ke "+i+" adalah "+A[i]);
		}
	}
	
	
	void BubbleSort(int kodeurut) {
		int temp;
		
		for (int tahap=1; tahap<=N-1; tahap++) {
			for (int i=0; i<=N-tahap-1;i++) {
				if (kodeurut==1) {
//					mengurut membesar
					if (A[i]>A[i+1]) {
						temp=A[i];
						A[i]=A[i+1];
						A[i+1]=temp;
					}
				}else {
//					mengurut mengecil
					if (A[i]<A[i+1]) {
						temp=A[i];
						A[i]=A[i+1];
						A[i+1]=temp;
					}
				}
			}
		}
	}

	
	void BubbleSortMembesar() {
		int temp;
		
		for (int tahap=1; tahap<=N-1; tahap++) {
			for (int i=0; i<=N-tahap-1;i++) {
				if (A[i]>A[i+1]) {
					temp=A[i];
					A[i]=A[i+1];
					A[i+1]=temp;
				}
			}
		}
	}
	
	void BubbleSortMengecil() {
		int temp;
		
		for (int tahap=1; tahap<=N-1; tahap++) {
			for (int i=0; i<=N-tahap-1;i++) {
				if (A[i]<A[i+1]) {
					temp=A[i];
					A[i]=A[i+1];
					A[i+1]=temp;
				}
			}
		}
	}
	
	
//	terurut membesar
	void BubbleSort2() {
		int tahap=1, temp;
		Boolean tukar;
		
		
		do {
			System.out.println("Tahap ke" +tahap);
			tukar=false;
			for (int i=0; i<=N-tahap-1;i++) {
				if (A[i]>A[i+1]) {
					tukar=true;
					temp=A[i];
					A[i]=A[i+1];
					A[i+1]=temp;
				}
			}
			tahap++;
		}while(tahap<=N-1 && tukar==true);

	}
	
	void InsertionSort() {
		int i,temp;
		
		for (int tahap=1; tahap<=N-1; tahap++) {
			temp=A[tahap];
			i=tahap;
			
			while (A[i-1]<temp && i>0) {
				A[i]=A[i-1];
				i--;
			}
			A[i]=temp;
		}
	}
	
	public static void main(String[] args) {
		AllSort A = new AllSort();
		Scanner sc = new Scanner(System.in);
		
		A.InitArray();
		A.InputArray();
		A.TampilArray();
		
//		int x;
//		do {
//			System.out.print("1(membesar)/2(mengecil)/0(stop):");x=sc.nextInt(); // tambahkan ini bila Scanner sc sudah di buat
//			A.BubbleSort(x);
//			A.TampilArray();
//		}while(x!=0);
		
		A.BubbleSort2();
		A.TampilArray();

	}
}