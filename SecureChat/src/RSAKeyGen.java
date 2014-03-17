import java.io.*;
import java.math.*;
import java.util.Random;


public class RSAKeyGen {
	public static void main(String[] args) throws FileNotFoundException{
		File pubKeyFile = new File("pub_key.txt");
		File priKeyFile = new File("pri_key.txt");
		
		BigInteger p = BigInteger.probablePrime(12, new Random());
		BigInteger q = BigInteger.probablePrime(12, new Random());
		
//		BigInteger p = BigInteger.probablePrime(args[0], new Random());
//		BigInteger q = BigInteger.probablePrime(args[0], new Random());
		
		BigInteger n = p.multiply(q);
		BigInteger totN = n.subtract(p).subtract(q).subtract(BigInteger.ONE);
		
		p = null;
		q = null;
		
		BigInteger e;
		do{
			e = new BigInteger(totN.bitLength(), new Random());
		}while(!e.gcd(totN).equals(BigInteger.ONE) || e.max(totN).equals(e));
		
		BigInteger d = e.modInverse(totN);
		
		PrintWriter pub = new PrintWriter(pubKeyFile);
		PrintWriter pri = new PrintWriter(priKeyFile);
		
		pub.println("e = " + e);
		pub.println();
		pub.println("n = " + n);

		pri.println("d = " + d);
		pri.println();
		pri.println("n = " + n);
		
		pub.close();
		pri.close();
		
		System.out.println("p = " + p);
		System.out.println("q = " + q);
		System.out.println("n = " + n);
		System.out.println("totN = " + totN);
		System.out.println("e = " + e);
		System.out.println("d = " + d);
	}
}
