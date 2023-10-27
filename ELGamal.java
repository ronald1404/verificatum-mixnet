import java.math.*;
import java.util.*;
import java.security.*;
import java.io.*;

public class ELGamal {
    public static void main(String[] args) throws IOException {
        BigInteger p, b, c, secretKey;
        secretKey = new BigInteger("13");

        // public key

        p = BigInteger.probablePrime(64, new SecureRandom());
        b = new BigInteger("3");
        c = b.modPow(secretKey, p);

        System.out.println("\npublic key (p,b,c) = ("+p+","+b+","+c+")");

        // Encryption
        String message = "123456";
        BigInteger X = new BigInteger(message);
        BigInteger r = new BigInteger(64, new SecureRandom()); // secret key r
        BigInteger K = X.multiply(c.modPow(r, p)).mod(p); // X*(c^r) mod p
        BigInteger B = b.modPow(r, p);

        System.out.println("Plaintext = " + X);
        System.out.println("(K,B) = ("+K+","+B+")");

        // Decryption
        BigInteger crmodp = B.modPow(secretKey, p); // (((b^r)modp)^(secretkey)mod p)
        BigInteger d = crmodp.modInverse(p); // d^(⁻1) mod p
        BigInteger message_decodes = d.multiply(K).mod(p);

        System.out.println("(d,crmodp) = ("+d+","+crmodp+")");
        System.out.println("Alice decodes: " + message_decodes);

    }
}
// reference: https://lume.ufrgs.br/bitstream/handle/10183/208458/Poster_63698.pdf?sequence=2
