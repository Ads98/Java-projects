
public class G51PGPOOCW1{
	
	
	public static void encrypt(StringBuffer message, String password)
	{
	int m = 0, p = 0;
	while (m<message.length())
	{
	message.setCharAt(m,(char)(32 +(126 + message.charAt(m) + password.charAt(p) - (m%95)) % 95));
	m++;
	p++;
	if (p==password.length())
	p = 0;
	}
	}
	
	
	public static void decrypt(StringBuffer message, String password)
	{
	int m = 0, p = 0;
	while (m<message.length())
	{
	message.setCharAt(m, (char)(32 + (95+message.charAt(m) - password.charAt(p) + m) % 95));
	m++;
	p++;
	if (p==password.length())
	p = 0;
	}
	}
	
	public static void encryptDecrypt(String word, String password)
	{
	System.out.println("Encrypt word: " + "'"+word +"'" + "'"+ " using password "+"'" + password +"'");
	StringBuffer copyOfWord=new StringBuffer(word);
	encrypt(copyOfWord, password);
	System.out.println("Encrypted word is " + copyOfWord);
	decrypt(copyOfWord, password);
	System.out.println("Decrypted word is " + copyOfWord + "\n");
	}


	public static void main(String[] args) {
		encryptDecrypt("Hello world", "password!");
		encryptDecrypt("Hello world", "pass");
		encryptDecrypt("Hello world", "word");
		encryptDecrypt("This is a longer message", "password!");
		encryptDecrypt("This is a longer message", "pass");
		encryptDecrypt("This is a longer message", "word");
		encryptDecrypt("aaaaaaaaaaaaaaaaaaaa", "password!");
		encryptDecrypt("abcdefghijklmnopqrstuvwxyz", "password!");
		encryptDecrypt("Hello my name is Adam", "password!");


	}

}
