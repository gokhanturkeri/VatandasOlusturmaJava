
package RASTGELEKISIURET;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author gokha
 */
public class Kisi {
        
        protected Telefon tel = new Telefon(); //Telefon sınıfından nesne oluşturuluyor
        protected KimlikNo tc = new KimlikNo(); //KimlikNo sınıfından nesne oluşturuluyor
        protected int yas = random_yas(); //Rastgele oluşturulan yaş değeri atanıyor
        protected String isim;
        protected String soyisim;
        
        Kisi() //Parametre almayan yapılandırıcı
        {
            
        }
        Kisi(String isim, String soyisim) //Parametre alan yapılandırıcı
        {
            this.isim = isim;
            this.soyisim = soyisim;
        }
        private int random_yas() //Rastgele yaş değeri oluşturulup döndürülüyor
        {
            int random_yas = ThreadLocalRandom.current().nextInt(0, 100 + 1); //Java 1.7'den sonra kullanılan random sayı oluşturma yolu
            return random_yas;
        }
}
