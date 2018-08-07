
package RASTGELEKISIURET;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


    public class RastgeleKisi {

        /* İsimleri ve soyisimleri TEST klasörünün altındaki bir txt belgesinden alıp
        rastgele değerler ile birleştirdiğimiz kişiler oluşturuluyor*/
        public static void kisi_olustur(File f) { 
       
        try
        {
            Scanner sc = new Scanner(f); // Dosyayı okuma işlemi için sc nesnesi oluşturuluyor
            List<Kisi> kisiler = new ArrayList<Kisi>(); // Kisi tipinde elemanlara sahip kisiler listesi olusturuluyor
            while (sc.hasNextLine()){ // Okunan dosyada bir sonraki satır olduğu sürece döngü kırılmıyor
                String satir = sc.nextLine(); // Sonraki satır satir değişkenine atanıyor
                String[] ozellik = satir.split(" "); // Her bir boşluğa kadar olan kısım ozellik dizisinin bir elemanına atanıyor 
                String ad = ozellik[0]; // ozellik dizisinin ilk elemanı ad değişkenine atanıyor
                String soyad = ozellik[1]; // ozellik dizisinin ilk elemanı soyad değişkenine atanıyor
                Kisi k = new Kisi(ad, soyad); 
                /* k adında Kisi sınıfından bir nesne türetiliyor ve oluşturulan ad ve soyad değişkeni 
                parametre olarak gönderiliyor*/
                kisiler.add(k); // kisiler listesine k nesnesi eleman olarak ekleniyor
        }
            
            FileWriter fw = new FileWriter("./Kisiler.txt"); // Dosya yazma işlemi için fw nesnesi oluşturuluyor
            for (Kisi k: kisiler) // kisiler listesindeki her bir nesne elemanı için
            {
                String newLine = System.getProperty("line.separator");// Satır atlama değişkeni
                //Kisiler.txt dosyasına bir kişinin tüm özellikleri bir satırda olacak şekilde satır satır yazım işlemi gerçekleştiriliyor
                fw.write( k.tc.tc_no + " " + k.isim + " " + k.soyisim + " " + k.yas + " " + k.tel.telno + " (" + k.tel.imei + ")" + newLine);
            }
            fw.close(); // fw nesnesi kapatılıyor
            sc.close(); // sc nesnesi kapatılıyor
        }
        catch(IOException e) 
        {e.printStackTrace();}
        }
    }
       
        
        

