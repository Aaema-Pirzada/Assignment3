
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class fileThreads extends Thread {

	static String s = null;
	static BinaryTree obj = new BinaryTree();

	public void openFile(String str) throws IOException {
		synchronized (this) {
			FileReader fileObj = new FileReader(str);

			BufferedReader readerObj = new BufferedReader(fileObj);
			String str1 = "";

			while ((str1 = readerObj.readLine()) != null) {

				obj.insert(str1);
			}
			
		}
	}

	public void run() {

		try {
			openFile(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("the number of files taken as argument are : " + args.length);
		System.out.println("\r\nnames of these files are :");
		for (int i = 0; i < args.length; i++) {
			System.out.println("file " + (i + 1) + " " + args[i]);
		}

		fileThreads t = new fileThreads();
		s = args[0];
		t.start();
		t.join();
		t.sleep(1000);
	boolean run=true;
		while(run) {
		System.out.print("***************  MENU  ***************\n" + "1. DISPLAY BST OF VOCAB\n" +"2.VECTOR BUILD OF INPUT FILES\n" +"3.MATCHING WORDS\n"+ "4.QUERY FROM USER\n"
		+ "5. EXIT\n\n");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Choice");
		// take input from the user
		int number = input.nextInt();
		switch(number) {
		case 1:
			System.out.println("\r\nBStree insertion on basis of length....");
			System.out.println("\r\n====INORDER TRAVERSAL====\r\n");
			obj.inorder();
           break;
		case 2:
		s = args[1];
		inputFilesThread t1 = new inputFilesThread(s);
		t1.start();
		t1.join();
		ArrayList<String> words1 = t1.getWords();
		
		s = args[2];
		inputFilesThread t2 = new inputFilesThread(s);
		t2.start();
		t2.join();
		ArrayList<String> words2 = t2.getWords();
		 break;
		case 3:	
			System.out.print("enter the number 0-4 for word searched");
			int num =input.nextInt();
			s = args[1];
			inputFilesThread t3 = new inputFilesThread(s);
			t3.start();
			t3.join();
			ArrayList<String> words3 = t3.getWords();
			
			System.out.println("Word searched "+words3.get(num));
		    System.out.println("input 1 file: " + obj.search(words3.get(num))+"\n");
		    
		    s = args[2];
			inputFilesThread t4 = new inputFilesThread(s);
			t4.start();
			t4.join();
			ArrayList<String> words4 = t4.getWords();
		
		System.out.println("Word searched "+words4.get(num));
		System.out.println("input 2 file: " + obj.search(words4.get(num))+"\n");
		break;
		case 4:
			System.out.print("Enter Query");   
			String str = input.next();
			s = args[1];
			inputFilesThread t5 = new inputFilesThread(s);
			t5.start();
			t5.join();
			ArrayList<String> words5 = t5.getWords();
			s = args[2];
			inputFilesThread t6 = new inputFilesThread(s);
			t6.start();
			t6.join();
			ArrayList<String> words6 = t6.getWords();
			StringTokenizer defaultTokenizer = new StringTokenizer(str);
			while (defaultTokenizer.hasMoreTokens())
			{
				String searched =defaultTokenizer.nextToken();
				System.out.print(searched +"\n"); 
				for(int i=0;i<6;i++) {
				if(searched.equalsIgnoreCase(words5.get(i)))
					{System.out.print("Word Found in file 1 " + args[1]+"\n");}}
				for(int i=0;i<9;i++) {
					if(searched.equalsIgnoreCase(words6.get(i)))
						{System.out.print("Word Found in file 2 " + args[2]+"\n");}}
			}

			break;
	
		case 5:
			run=false;
			break;
		default:
			
		}
	}
	}		
}
