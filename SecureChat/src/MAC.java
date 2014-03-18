import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MAC {
	public static void main(String [] args) throws Exception {

		
		//createMac("This is only a test of the emergency broadcast system.", (short)28659);
	}
	
	public static byte[] createMac(String message, short k2) throws NoSuchAlgorithmException{
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] messageBytes = message.getBytes();
		md.update(messageBytes);
		byte[] digest = md.digest();
		byte[] mac = new byte[16];
		
		for(int i = 0; i < 16; i++){
			mac[i] = (byte) (digest[i] ^ toBytes(k2)[i % 2]);
		}
		printBits(digest);
		System.out.println();
		printBits(toBytes(k2));
		System.out.println();
		printBits(mac);

		return mac;
	}
	
	public static byte[] toBytes(short val)
	{
		byte[] result = new byte[2];

		result[0] = (byte) ( val >> 8 );
		result[1] = (byte) ( val >> 0 );


		return result;
	}
	
	private static void printBits(byte[] in){
		for(int i = 0; i < in.length; i++){
			for(int j = 7; j >= 0; j--){
				System.out.print(((in[i] >> j) % 2 + 2) % 2);
			}
		}
	}
}
