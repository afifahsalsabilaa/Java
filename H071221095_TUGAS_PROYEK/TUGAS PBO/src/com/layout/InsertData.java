package com.layout;

import java.util.Scanner;

import com.control.ControlDatabase;

public class InsertData {
    public static void showInsertData(){
        try {
            
            Scanner sc = new Scanner(System.in);
            System.out.println("====================================");
            System.out.println("SILAHKAN INPUT PRODUK");
            System.out.println("====================================");
            System.out.println("NAMA");
            String name = sc.nextLine();
            System.out.println("HARGA");
            long harga = sc.nextInt();
            System.out.println("STOK");
            int stok = sc.nextInt();
            System.out.println("====================================");
            if (ControlDatabase.insertDB(name, harga, stok)) {
                System.out.println("BERHASIL INSERT DATA");
                
            }else{
                System.out.println("GAGAL MENAMBAHKAN DATA");
            }
            System.out.println("------------------------------------");
            Menu.showMenu();
            sc.close();
        
        } catch (Exception e) {
            InsertData.showInsertData();
        }
    }
}
