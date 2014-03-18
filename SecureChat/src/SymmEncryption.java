
public class SymmEncryption {
	public static void main(String[] args) {
		char[] test = padMessage("This is only a test", 2);
		
		test = encrypt(test, (short)4097);
		test = encrypt(test, (short)4097);
		
		padMessage("0123456789", 2);
		padMessage("0123456789", 3);
		padMessage("0123456789", 4);
		padMessage("0123456789", 5);
		padMessage("0123456789", 11);
	}

	public static char[] encrypt(char[] message, short k1){
		char[] c = new char[message.length];
		for(int i = 0; i < c.length; i++){
			c[i] = (char) (message[i] ^ MAC.toBytes(k1)[i % 2]);
		}
		
		System.out.println(c);
		
		return c;
	}
	
	public static char[] padMessage(String message, int keyLength){
		int mult = (message.length() - 1) / keyLength + 1;
		
		char[] charArray = new char[keyLength * mult];
		
		for(int i = 0; i < keyLength * mult; i++){
			if(i >= (keyLength * mult) - message.length())
				charArray[i] = message.charAt(i - (keyLength * mult) + message.length());
			else
				charArray[i] = 0;
		}

		
		return charArray;
	}
	

}
