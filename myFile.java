package pgp;

public class myFile extends PGPFile {

	public  PGPText readEntireFile(String FileName) {
		// TODO Auto-generated method stub
		PGPText file = new PGPText();
		
		String temp;
		
		if (openReadFile(FileName))
		{
			while ((temp = readNextLine()) != null)
			{
				file.addLine(temp);
			}
			closeReadFile();
		}
		return file;
	}
		
		public void writeEntireFile(PGPText text , String FName)
		{
			openWriteFile(FName);
			int i=0;
			for ( i = 0 ; i < text.getLineCount(); i++ )
			{
				writeLine(text.getLine(i));
			}
			closeWriteFile();

		}
		
		public static void main (String[] args)
		{
			System.out.println("working");
			myFile file= new myFile();
			PGPText text= new PGPText();
			text=file.readEntireFile("cw-2.txt");
			int count=0;
			for(count=0; count < 5;count++)  
					{
						text.setLine(count, "");
					}
			System.out.println("working 2");
			file.writeEntireFile(text, "out.txt");
		}
		

}
