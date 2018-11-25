import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperation {

	public static void commonWordsInOneFile(File file1, File file2, File file3) {
		String s = new String();
		try (FileInputStream f1 = new FileInputStream(file1);
				FileInputStream f2 = new FileInputStream(file2);
				FileOutputStream fOutput=new FileOutputStream(file3)) {
			
			byte [] b1 = new byte[f1.available()];
			byte [] b2 = new byte[f2.available()];
						
			f1.read(b1);
			f2.read(b2);
			
			s=FileOperation.commonWords(b1, b2);	
			
			FileOperation.writeFile(file3, s);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		

		
		
	}
	public static void writeFile(File file3, String s) {

		try (FileOutputStream fOutput=new FileOutputStream(file3)) {
						
			byte buf[] = s.getBytes();
			fOutput.write(buf);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		

		
		
	}
	
	public static String commonWords(byte [] bFirst, byte [] bSecond) {
		String s1 ="", s2="";
		
		for (byte c : bFirst) 
			s1+=(char)c;	
	
		for (byte c : bSecond) 
			s2+=(char)c;	
		
		s1=s1.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
		s2=s2.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
		String [] s1Array = s1.split(" ");
		String [] s2Array = s2.split(" ");
		String sRez="";
		
		for(int i =0; i<s1Array.length; i++) {
			for (int j=0; j< s2Array.length; j++) {
				if (s1Array[i].equals(s2Array[j])) {
					sRez +=s2Array[j]+" ";
					s2Array[j]="";
					break;
				}
			}
		}
		return sRez;
	}
	
}
