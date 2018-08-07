
package RASTGELEKISIURET;

import java.util.Random;

/**
 *
 * @author gokha
 */
public class Telefon {
    
    protected String imei = IMEINo.generateValidImeiNumber(); //Imei numarası oluşturuluyor
    protected String telno = telno_random(); //Telefon numarası atanıyor

    private static String telno_random() // Rastgele telefon numarası oluşturuluyor
    {
        Random generator = new Random(); // Random sınıfından nesne türetiliyor
        int operator_kodu; // Telefon numarasının 0'dan sonraki 3 hanesi
        int area1; // 0 ve operator kodu haricindeki 3 hanesi
        int area2; // 0 ve operator kodu haricindeki 4 hanesi
        operator_kodu = generator.nextInt(559-530+1) + 529; 
        // Türkiye'de bulunan yerel cep telefonu operatör numaraları aralığında rastgele bir değer atanıyor
        area1 = generator.nextInt(999-100+1) + 100; // 0 ve operator kodu haricindeki 3 hanesi rastgele atanıyor
        area2 = generator.nextInt(9999-1000+1) + 1000; // 0 ve operator kodu haricindeki 4 hanesi rastgele atanıyor
        String telno = "0" + operator_kodu + area1 + area2; // Telefon numarası string tipinde oluşturuluyor
        return telno; // Rastgele oluşturulan telefon numarası döndürülüyor
    }
                
}
