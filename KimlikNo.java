
package RASTGELEKISIURET;

import java.util.Random;
import java.util.Vector;

/**
 *
 * @author gokha
 */
public class KimlikNo {
    
        protected String tc_no = TCIDOlustur(); //Rastgele oluşturulan tc no atanıyor
        private static String TCIDOlustur() //Rastgele tc no oluşturulup döndürülüyor
  {
      Vector<Integer> numlist = new Vector<Integer>();
      Random randomGenerator = new Random();
      numlist.add(1 + randomGenerator.nextInt(9));
      int numara1 = 0;
      int numara2 = 0;
      for (int i=1;i<9;i++) 
      numlist.add(randomGenerator.nextInt(10));
    
      for (int i=0;i<9;i+=2){
       numara1 += numlist.elementAt(i);
      }

      for (int i=1;i<8;i+=2)
      numara2 += numlist.elementAt(i);
      int sonrakam = (numara1 * 7 - numara2) % 10;
      numlist.add(sonrakam);
      sonrakam=0;
      for(int i=0;i<10;i++) 
      sonrakam+= numlist.elementAt(i);
      sonrakam= sonrakam % 10;
    
      numlist.add(sonrakam);
      String tcNo = "";
      for(int i=0;i<11;i++) tcNo = tcNo + Integer.toString(numlist.elementAt(i));
      return tcNo;
  }
        public static boolean isValidTckn(Long tckn) {
            
            String tmp = tckn.toString();

                if (tmp.length() == 11) {
                    int totalOdd = 0;
                    int totalEven = 0;

                    for (int i = 0; i < 9; i++) {
                        int val = Integer.valueOf(tmp.substring(i, i + 1));
                        if (i % 2 == 0) {
                                totalOdd += val;
                        } else {
                                totalEven += val;
                        }
                    }
                    int total = totalOdd + totalEven + Integer.valueOf(tmp.substring(9, 10));
                    int lastDigit = total % 10;
                    if (tmp.substring(10).equals(String.valueOf(lastDigit))) {
                        int check = (totalOdd * 7 - totalEven) % 10;
                        if (tmp.substring(9, 10).equals(String.valueOf(check))) {
                                return true;
                        }
                    }
            }
    return false;
} //Tcno kontrol ediliyor
}