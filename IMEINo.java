
package RASTGELEKISIURET;

import java.util.Random;

/**
 *
 * @author gokha
 */
public class IMEINo {
    
    //Rastgele imei no oluşturulup döndürülüyor
    protected static String generateValidImeiNumber() {
    
        String imei;
        Random myRandom = new Random();
        StringBuilder imeiNumber = new StringBuilder(14);
        imeiNumber.append("864898034");
        for(int counter  = 0;counter < 5 ; counter++) {
                imeiNumber.append(1 + myRandom.nextInt(8));
        }
        int generatedCheckDigit = getCheckDigit(imeiNumber.toString());
        imei = imeiNumber.toString();
        imei += generatedCheckDigit;
        return imei;
}
    private static int getCheckDigit(String input) {
        
        int sum = 0;
        for(int counter = 13 ; counter >= 0; counter--) {
                String digitString = input.substring(counter, counter+1);
                int digit = Integer.valueOf(digitString);
                if (counter % 2 == 0) 
                {
                    sum += digit;
                }
                else 
                {
                    sum += sumUpDigits(digit);
                }
        }
        sum *= 9;
        return sum%10;
    }
    private static int sumUpDigits(int digit) {
        
		int sum = 0;
		digit *= 2;
		while(digit > 0) {
			
			sum+=digit % 10;
			digit /= 10;
		}
		return sum;
		
	}
    private static int sumDig(int n){
        int a = 0;
        while (n > 0)
        {
            a = a + n % 10;
            n = n / 10;
        }
        return a;
    }
    //Imei no'lar kontrol edilip true veya false değeri döndürülüyor
    public static boolean isValidIMEI(long n)
    {
        String s = Long.toString(n);
        int len = s.length();
        if (len != 15)
            return false;
        int sum = 0;
        for (int i = len; i >= 1; i--)
        {
            int d = (int)(n % 10);
            if (i % 2 == 0)
                d = 2 * d;
            sum += sumDig(d);
            n = n / 10;
        }
        return (sum % 10 == 0);
    }
}



