
package test;
import RASTGELEKISIURET.IMEINo;
import RASTGELEKISIURET.KimlikNo;
import RASTGELEKISIURET.RastgeleKisi;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TEST {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner giris = new Scanner(System.in); //Girilen değerin okunması için giris Scanner nesnesi oluşturuluyor
        int secenek = 0;
        do{
        System.out.println("1- Rastgele Kişi Üret");
        System.out.println("2- Üretilmiş Dosya Kontrol Et");
        System.out.println("3- Çıkış");
        secenek = giris.nextInt();
        switch(secenek)
        {
            case 1:
                File f = new File("./random_isimler.txt"); //File gösteriliyor
                RastgeleKisi.kisi_olustur(f); //RASTGELEKISIURET kütüphanesindeki RastgeleKisi sınıfından kisi_olustur fonksiyonu çalıştırılıyor.
                break;
                
            case 2:
                
                File f2 = new File("./Kisiler.txt"); //File gösteriliyor
                Scanner sc = new Scanner(f2); //Girilen değerin okunması için sc Scanner nesnesi oluşturuluyor
                int imei_kontrol_gecerli = 0;
                int imei_kontrol_gecersiz = 0;
                int tcno_kontrol_gecerli = 0;
                int tcno_kontrol_gecersiz = 0;
                while (sc.hasNextLine())
                    {
                    //Kisiler.txt dosyasındaki her satır için imei no ayıklanıyor...
                    String line = sc.nextLine(); //Her satırı oku ve line'a kaydet
                    String[] kelimeler = line.split("\\("); //Line'ı "(" işaretinin öncesi ve sonrası olarak böl details'e kaydet
                    String[] kelimeler2 = kelimeler[1].split ("\\)"); //kelimeler1[1]'de ki metni ")" işaretinin öncesi ve sonrası olarak böl ve kelimeler2'ye kaydet
                    //imei numaramız sorgulama fonksiyonuna gönderiliyor
                    String[] kelimeler3 = line.split(" ");
                    if (KimlikNo.isValidTckn(Long.parseLong(kelimeler3[0])) == true)
                    {
                        tcno_kontrol_gecerli ++;
                    }
                    else
                        tcno_kontrol_gecersiz ++;

                    if (IMEINo.isValidIMEI(Long.parseLong(kelimeler2[0])) == true)
                    {
                        imei_kontrol_gecerli ++;
                    }
                    else
                        imei_kontrol_gecersiz ++;
                    }
                    System.out.println("IMEI Kontrol");
                    System.out.println(imei_kontrol_gecerli + "    Geçerli");
                    System.out.println(imei_kontrol_gecersiz + "    Geçersiz");
                    System.out.println("T.C. Kimlik Kontrol");
                    System.out.println(tcno_kontrol_gecerli + "    Geçerli");
                    System.out.println(tcno_kontrol_gecersiz + "    Geçersiz");
                    break;
                case 3:
                    break;
                }      
            }while(secenek != 3);
        }
}
