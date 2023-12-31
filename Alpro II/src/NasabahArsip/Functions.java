package NasabahArsip;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Functions {
    Scanner sc = new Scanner(System.in);
    
    public String Login() {
		Nasabah R = new Nasabah();
		String Norek, Pin;
		Boolean Ketemu = false;

		System.out.println("========= Login ATM Kasih Bunda ========");     
		ObjectInputStream in = null;
		
		try {
			
// 1. buka file untuk dibaca	
			in = new ObjectInputStream(new FileInputStream
    		   ("/Users/jamjam/Desktop/FileJava/Nasabah/NasabahKasihBunda.dat"));
       Object curR = in.readObject();	
       try {	
    	   Scanner sc = new Scanner(System.in);
    	   
// 2. baca dan proses setiap record yang dibaca  
    	   System.out.print("Norek :  ");Norek = sc.next();
    	   System.out.print("PIN :  ");Pin = sc.next();
	
    	   while (Ketemu == false) {
        	   R = (Nasabah) curR; //inputstream -> objek customer
// cek apakah norek ada?
        	  if (R.getNorek().contentEquals(Norek)){
        		  Ketemu = true;
        	  }
// kalo ada masuk ke sini
        	  if (Ketemu == true) {
  	        		int coba = 1;
  	        	  do {
  	              	  if (R.getPin().contentEquals(Pin)) {
  	              		  return Norek;
  		        	  }else {
  		        		  System.out.println("Password yang anda masukan salah!");
  		        		  if(coba==1) {
  		        			  System.out.println("Percobaan hanya sampai 3x, kalo tidak rekening anda ditahan");		        			  
  		        		  }
  		        		  if(coba<=3) {
  		        			  System.out.println("Percobaan ke-"+coba);
  		        			  System.out.print("PIN :  "); Pin=sc.next();
  		        			  coba++;
  		        		  }
  		        	  }
  	        	  }while(coba<=3);
  	        	 System.out.println("=== Mohon Maaf Norek Anda Saya Tahan ===");
  	          }
        	  
        	  curR = in.readObject(); // baca terus kedata selanjutnya
         }    
          
      
       } catch (EOFException e) {}
             System.out.println("");	
             System.out.println("Nasabah tidak ditemukan");
       } catch (ClassNotFoundException e) {
             System.out.println("Class tidak ditemukan.");
       } catch (IOException e) {
             e.printStackTrace();
      }   
	return "";	
	
    }

// Cek Saldo
	public void CekSaldo(String norek){
	    Nasabah R = new Nasabah();
	    Boolean Ketemu = false;
	    System.out.println("====== Cek Saldo ======");     
	    ObjectInputStream in = null;
	    try {
// 1. buka file untuk dibaca	
	       in = new ObjectInputStream(new FileInputStream
	    		   ("/Users/jamjam/Desktop/FileJava/Nasabah/NasabahKasihBunda.dat"));
	       Object curR = in.readObject();					
	       try {	
// 2. baca dan proses setiap record yang dibaca                 
	    	   while (Ketemu == false) {
		        	   R = (Nasabah) curR; //inputstream -> objek customer
		        	  if (R.getNorek().contentEquals(norek)){
		        		  Ketemu = true;
		        	  }
		        	  
		        	  if(Ketemu == true) {
		        		  System.out.println("Saldo Anda : Rp."+ R.getSaldo());
		        	  }
		        	  
		        	  curR = in.readObject(); // baca lagi...
		         } 
	       } catch (EOFException e) {}
	             System.out.println("");				
	       } catch (ClassNotFoundException e) {
	             System.out.println("Class tidak ditemukan.");
	       } catch (IOException e) {
	             e.printStackTrace();
	      }           
	    }
	
// Stor Saldo
	public void StorSaldo(String norek){
	    Nasabah R = new Nasabah();
	    Boolean Ketemu=false;
	    float Saldo;
	    System.out.println("====== Stor Saldo ======");     
	    ObjectInputStream in = null; // read
	    ObjectOutputStream out = null; // write
// TRY DI DALAM TRY APABILA IN OUT NYA MASING MASING
	    try {
	       try {
// ISI FILE UTAMA DI BACKUP KE TEMP
// 1. buka file untuk dibaca	
		       in = new ObjectInputStream(new FileInputStream
		    		   ("/Users/jamjam/Desktop/FileJava/Nasabah/NasabahKasihBunda.dat"));
		    		   Object curR = in.readObject();
// 2. buka file untuk ditulis	
		    	out = new ObjectOutputStream(new FileOutputStream
		    		              ("/Users/jamjam/Desktop/FileJava/Nasabah/Temp.dat"+ ""));// nama direktori+file
// 2. baca dan proses setiap record yang dibaca    
	     	   while (true) {
	        	   R = (Nasabah) curR; //inputstream -> objek customer
	        	   R = new Nasabah(R.getNorek(),R.getPin(),R.getNama(),R.getSaldo());    
	               out.writeObject(R); 
	        	   curR = in.readObject(); // baca lagi...
	           }   
	       } catch (EOFException e) {}
	       
			try {
				// FILE TEMP DI UBAH LALU DI PINDAHKAN KEMBALI KE FILE UTAMA
// 1. buka file untuk dibaca	
			    in = new ObjectInputStream(new FileInputStream
			    		   ("/Users/jamjam/Desktop/FileJava/Nasabah/Temp.dat"));
			    		   Object curR = in.readObject();
// 2. buka file untuk ditulis	
			    out = new ObjectOutputStream(new FileOutputStream
			    		   ("/Users/jamjam/Desktop/FileJava/Nasabah/NasabahKasihBunda.dat"+ ""));// nama direktori+file
		       BufferedReader brInput= new BufferedReader
	                    (new InputStreamReader(System.in)); 
		       
		       System.out.print("1.Lanjut/0.Batal:  ");int x=sc.nextInt();
		       if(x!=0) { 
		    	   do {
			    	   System.out.print("Stor Saldo (min 10k) :  ");Saldo=sc.nextFloat();
        		   }while(Saldo<10000);
// 2. baca dan proses setiap record yang dibaca    
		     		   while (true) {
			        	   R = (Nasabah) curR; //inputstream -> objek customer
			        	   
			        	   if(!R.getNorek().contentEquals(norek)) {
			        		   R = new Nasabah(R.getNorek(),R.getPin(),R.getNama(),R.getSaldo()); 
			        	   }else {
			        		   Saldo = R.getSaldo()+Saldo;
			        		   R = new Nasabah(R.getNorek(),R.getPin(),R.getNama(),Saldo); 
			        		   
			        	   }
			               out.writeObject(R); 
			        	   curR = in.readObject(); // baca lagi...
		     		   }   
		       }else {
// 2. baca dan proses setiap record yang dibaca    
	     		   while (true) {
		        	   R = (Nasabah) curR; //inputstream -> objek customer
		        	   R = new Nasabah(R.getNorek(),R.getPin(),R.getNama(),R.getSaldo()); 
		               out.writeObject(R); 
		        	   curR = in.readObject(); // baca lagi...
	     		   }  
		       }
			} catch (EOFException e) {}
			 System.out.println("");	
	       } catch (ClassNotFoundException e) {
	             System.out.println("Class tidak ditemukan.");
	       } catch (IOException e) {
	             e.printStackTrace();
	      }  
	    }	
	
// Tarik Saldo
	public void TarikSaldo(String norek){
	    Nasabah R = new Nasabah();
	    Boolean Ketemu;
	    float Saldo;
	    System.out.println("====== Stor Saldo ======");     
	    ObjectInputStream in = null; // read
	    ObjectOutputStream out = null; // write
// TRY DI DALAM TRY APABILA IN OUT NYA MASING MASING
	    try {
	       try {
// CEK SALDO NYA CUKUP ATAU ENGGA
// 1. buka file untuk dibaca	
		       in = new ObjectInputStream(new FileInputStream
		    		   ("/Users/jamjam/Desktop/FileJava/Nasabah/NasabahKasihBunda.dat"));
// 2. buka file untuk ditulis	
		    	out = new ObjectOutputStream(new FileOutputStream
		    		              ("/Users/jamjam/Desktop/FileJava/Nasabah/Temp.dat"+ ""));// nama direktori+file
	    	   Object curR = in.readObject();
// 2. baca dan proses setiap record yang dibaca  
		    	 while (true) {
		    		 Ketemu = false;
		        	   R = (Nasabah) curR; //inputstream -> objek customer
		        	  if (R.getNorek().contentEquals(norek)){
		        		  Ketemu=true;
		        	  }
		        	  
		        	  if (Ketemu == true && R.getSaldo()<10000) {
		        			 System.out.println("Mohon maaf anda miskin!");
		        			 System.out.println("");
		        			 return;
		        	  }  
		        	  
		        	  curR = in.readObject(); // baca lagi...
		        } 
	       } catch (EOFException e) {}
	       System.out.print("1.Lanjut/0.Batal: ");int x=sc.nextInt();
	       if(x!=0) {
	       try {	
// KALO CUKUP ISI FILE UTAMA DI BACKUP KE TEMP
// 1. buka file untuk dibaca	
		       in = new ObjectInputStream(new FileInputStream
		    		   ("/Users/jamjam/Desktop/FileJava/Nasabah/NasabahKasihBunda.dat"));
// 2. buka file untuk ditulis	
		    	out = new ObjectOutputStream(new FileOutputStream
		    		              ("/Users/jamjam/Desktop/FileJava/Nasabah/Temp.dat"+ ""));// nama direktori+file
			    Object curR = in.readObject();
// 2. baca dan proses setiap record yang dibaca  
		     	   while (true) {
		        	   R = (Nasabah) curR; //inputstream -> objek customer
		        	   R = new Nasabah(R.getNorek(),R.getPin(),R.getNama(),R.getSaldo());    
		               out.writeObject(R); 
		        	   curR = in.readObject(); // baca lagi...
		           }   
		       } catch (EOFException e) {}
			try {
// FILE TEMP DI UBAH LALU DI PINDAHKAN KEMBALI KE FILE UTAMA					
// 1. buka file untuk dibaca	
			     in = new ObjectInputStream(new FileInputStream
			    		   ("/Users/jamjam/Desktop/FileJava/Nasabah/Temp.dat"));
			    		   Object curR = in.readObject();
// 2. buka file untuk ditulis	
			    out = new ObjectOutputStream(new FileOutputStream
			    		   ("/Users/jamjam/Desktop/FileJava/Nasabah/NasabahKasihBunda.dat"+ ""));// nama direktori+file
		       BufferedReader brInput = new BufferedReader
	                    (new InputStreamReader(System.in)); 
				 
// 2. baca dan proses setiap record yang dibaca    
		     		   while (true) {
			        	   R = (Nasabah) curR; //inputstream -> objek customer
			        	   if(!R.getNorek().contentEquals(norek)) {
			        		   R = new Nasabah(R.getNorek(),R.getPin(),R.getNama(),R.getSaldo()); 
			        	   }else {
			        		   do {
						    	   System.out.print("Tarik Saldo (min 10k) :  ");Saldo = sc.nextFloat();
						    	   if (Saldo>R.getSaldo()) {
						    		   System.out.println("Maaf saldo anda tidak mencukupi");
						    		   System.out.println("Sisa Saldo Anda : Rp."+ R.getSaldo());
						    		   System.out.println("----------");
						    		   System.out.print("1.Lanjut/0.Batal: ");x=sc.nextInt();
						    		   System.out.println("");
						    		   if(x==0) {
						    			   R = new Nasabah(R.getNorek(),R.getPin(),R.getNama(),R.getSaldo());
							    		   out.writeObject(R); 
							    		   return;
						    		   }
						    	   }
			        		   }while(Saldo<10000 || Saldo>R.getSaldo());
			        		   Saldo = R.getSaldo()-Saldo;
			        		   R = new Nasabah(R.getNorek(),R.getPin(),R.getNama(),Saldo);
			        		   System.out.println("Saldo berhasil ditarik");
			        		   System.out.println("Sisa Saldo Anda : Rp."+ R.getSaldo());
			        	   }
			               out.writeObject(R); 
			        	   curR = in.readObject(); // baca lagi...
		     		   }   
			}catch (EOFException e) {}   
	       }
	       // endif
	       
	  	 System.out.println("");
	       } catch (ClassNotFoundException e) {
	             System.out.println("Class tidak ditemukan.");
	       } catch (IOException e) {
	             e.printStackTrace();
	      }  
	    }
	
}
	

//end functions