import java.math.BigInteger;


public class RSA {
	public static BigInteger encrypt(BigInteger e, BigInteger n, String s){
		BigInteger p = new BigInteger(s.getBytes());
		
		return p.modPow(e, n);
	}
}
