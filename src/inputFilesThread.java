
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class inputFilesThread extends Thread {
	private String nameoffile;
	private ArrayList<String> words;

	public inputFilesThread(String str) {
		nameoffile = str;
	}

	public void openFile(String str) throws IOException {
		words = new ArrayList<String>();
		synchronized (this) {
			FileReader fileObj = new FileReader(str);

			BufferedReader readerObj = new BufferedReader(fileObj);
			String str1 = "";
			System.out.println("the content of file input is : ");
			while ((str1 = readerObj.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(str1, " ");
				while (st.hasMoreTokens()) {
					String x = st.nextToken();
					System.out.println("-> " + x);
					words.add(x);
				}
			}
		}
	}

	public void run() {
		try {
			this.openFile(nameoffile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getWords(){
		return words;
	}
}
