/*
 * Main
 */

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class Main{
    public static void main(String[] args){
    
        BigInteger p, r, x, y, a, b;

        p = new BigInteger("1009"); 
        r = new BigInteger("11");
        x = new BigInteger("13"); // private key B
        y = new BigInteger("69"); // private key A

        
        b = r.modPow(x, p); // b = (r^x) mod p
        System.out.println(b);

        //public key B
        BigInteger B[] = new BigInteger[3];
        B[0] = p;
        B[1] = r;
        B[2] = b;
        
        a = r.modPow(y, p); // a = (r^y) mod p
        System.out.println(a);

        // public key A
        BigInteger A[] = new BigInteger[3];
        A[0] = p;
        A[1] = r;
        A[2] = a;

        

        // for Alice send message K to Bob
        int  message_K = 281813;

    }
}
