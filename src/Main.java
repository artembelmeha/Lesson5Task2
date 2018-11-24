import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f1 = new File("file1.txt");
		File f2 = new File("file2.txt");
		File f3 = new File("file3.txt");
		
		FileOperation.commonWordsInOneFile(f1,f2,f3);
		
		
	}

}
