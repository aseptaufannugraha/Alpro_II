package DataTerstruktur;

import java.util.Scanner;

import Nasabah2.Nasabah;

public class TabMhs {
	int N=3;
	Mahasiswa []A=new Mahasiswa[N];

	void InitArray() {
		Mahasiswa R=new Mahasiswa();
		
		System.out.println("Inisialisasi array");
		for (int i=0; i<N; i++) {
			R.NIM="0";
			R.Nama="$";
			R.IPK=4;
			A[i]=R;
		}
	}

	void InputArray() {	
		Mahasiswa R=new Mahasiswa();
		System.out.println("Menginput element-element array");
		Scanner sc = new Scanner(System.in);	// Supaya bisa di imput
		for (int i=0; i<N; i++) {
			R=new Mahasiswa();	// Record harus disimpam dimemory
//			System.out.print("NIM ke-"+i+":");R.NIM=sc.next();
//			System.out.print("Nama ke-"+i+":");R.Nama=sc.next();
//			System.out.print("Data ke-"+i+":");R.IPK=sc.nextFloat();
			R.BacaMahasiswa();
			A[i]=R;
		}
	}
	
	void TampilArray() {
		System.out.println("Menampilkan isi/element array");
		for (int i=0; i<N; i++) {
			if(A[i].IPK < 2) {
//				System.out.println("Data ke "+i+" adalah "+A[i].NIM+","+A[i].Nama+","+A[i].IPK);
				System.out.println("Data untuk ke- "+i);
				System.out.println("NIM (string): "+A[i].NIM);
				System.out.println("Nama (string): "+A[i].Nama);
				System.out.println("IPK (real): "+A[i].IPK);
			}
			A[i].TulisMahasiswa();
		}
	}
	
	int CariElement(String x) {
		int index=-1;
		for (int i = 0; i < N; i++)
			if(A[i].NIM.equals(x)==true) {
				index= i;
	    }
		return index;
	}
	
	void RataIPK() {
		double total=0;
		for(int i=0; i<N; i++) {
			total= total +A[i].IPK;
		}
		double rata=(double)total/N;
		System.out.print("Rata-rata IPK Mahasiswa: "+ rata);	
	}
	
// Tipe record TabMahasiswa
	Mahasiswa GetElemen(int i) {
		return A[i];
	}
	
	void SetElemen(int i) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Data index ke-"+i+":");A[i].BacaMahasiswa();
	}
	
	void SetIpk(int i) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Data index ke-"+i+":");A[i].BacaIpk();
	}
	
// Perintah menampilkan Ipk kurang dari X
	void TampilIPK() {
		System.out.println("Menampilkan IPK kurang dari 2");
		for (int i=0; i<N; i++) {
			if (A[i].IPK < 2) {
//				System.out.println("Data ke "+i+" adalah "+A[i].NIM+","+A[i].Nama+","+A[i].IPK);
				System.out.print("Untuk data ke "+i+" :");
				System.out.print("NIM (string): "+A[i].NIM);
				System.out.print("Nama (string): "+A[i].Nama);
				System.out.print("IPK (real): "+A[i].IPK);
			}
		}
	}
	
//	Main program
	public static void main(String[] args) {
		TabMhs Mhs=new TabMhs();
		Scanner sc= new Scanner(System.in);
		
		Mhs.InitArray();
		Mhs.TampilArray();
		Mhs.InputArray();
		Mhs.TampilIPK();	
		
// Looping
		for(int l=0; l ==0;) {
			Mhs.TampilArray();
			System.out.println("");
			
// Menentukan Perintah
			System.out.print("Command (1=mencari, 2=mengubah IPK, 3=rata-rata, 4=menampilkan IPK < 2) :");
			int z=sc.nextInt();
			
			if(z==1) {
				System.out.print("Mencari Mahasiswa dengan NIM: ");
				String x= sc.next();
				int k =0;
				k = Mhs.CariElement(x);
				if(k!=-1) {
					System.out.println("Nilai "+x+" ketemu di index ke: "+k);
					Mahasiswa R= new Mahasiswa();
					R=Mhs.GetElemen(k); R.TulisMahasiswa();
				}else {
					System.out.print("Nilai "+x+" tidak ada didalam larik");
				}
				
				Mhs.TampilArray();
				System.out.print("Cari NIM bernilai: ");
				String i=sc.next();
			}
			
			if(z==2) {
				System.out.print("Mengubah IPK dengan NIM: ");
				String x= sc.next();
				int k = 0;
				k = Mhs.CariElement(x);
				
// Mengubah IPK
				Mahasiswa R= new Mahasiswa();
				R=Mhs.GetElemen(k); R.TulisMahasiswa();
				Mhs.SetIpk(k); Mhs.TampilArray();
			}
			
//Menghitung rata-rata
			if(z==3) {
				Mhs.RataIPK();
			}
			
			if(z==4) {
				Mhs.TampilIPK();
			}
			
		}
	}
}
