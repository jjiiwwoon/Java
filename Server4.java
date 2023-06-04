import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.*;

public class Server4 extends JFrame {
	private WordCheck word = null;
	private JTextArea log = new JTextArea();
	
	public Server4() {
		super("영어스펠 체크서버");
		setSize(250,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(new JLabel("스펠체크 서버입니다"));
		c.add(new JScrollPane(log), BorderLayout.CENTER);
		setVisible(true);
		
		word = new WordCheck("C:\\\\Users\\\\leo01\\\\OneDrive\\\\문서\\\\자바프로그래밍\\\\word.txt");
		if(word.isFileRead()) {
			log.setText("word.txt읽기 완료\n");
			new ServerThread().start();
		}
	}
	
	class ServerThread extends Thread{
		public void run() {
			ServerSocket listener = null;
			Socket socket = null;
			try {
				listener = new ServerSocket(222);
				while(true) {
					socket = listener.accept();
					log.append("클라이언트 연결됨\n");
					new ServiceThread(socket).start();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (listener!= null)
					listener.close();
				if(socket != null)
					socket.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class WordCheck{
		Vector<String> wordVector = new Vector<String>();
		private boolean fileOn = false;
		
		public WordCheck(String fileName) {
			try {
				Scanner scanner = new Scanner(new FileReader(fileName));
				while(scanner.hasNext()) {
					String word = scanner.nextLine();
					wordVector.add(word);
				}
				scanner.close();
				fileOn=true;
			}catch (FileNotFoundException e) {
				System.out.println("file not found error");
				System.exit(0);
				fileOn=false;
			}
		}
		public boolean isFileRead() {
			return fileOn;
		}
		public String getWord(int index) {
			return wordVector.get(index);
		}
		public int wordsize() {
			int index = wordVector.size();
			return index;
		}
	}
	class ServiceThread extends Thread{
		private Socket socket = null;
		private BufferedReader in = null;
		private BufferedWriter out = null;
		WordCheck wordcheck = new WordCheck("C:\\Users\\leo01\\OneDrive\\문서\\자바프로그래밍\\word.txt");
		
		public ServiceThread(Socket socket) {
			this.socket = socket;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		public void run() {
			while(true) {
			    try {
			        String word = in.readLine();
			        Boolean check = false;
			        
			        for(int i = 0; i<wordcheck.wordsize();i++) {
			            if(word.equals(wordcheck.getWord(i))) {
			                out.write("Yes\n");
			                log.append(word+"=YES\n");
			                check = true;
			                break;
			            }
			        }
			        if(check == false) {
			            out.write("NO\n");
			            log.append(word+"=NO");
			        }
			        out.flush();
			    } catch(IOException e) {
			        log.append("연결 종료\n");
			        System.out.println("연결 종료");
			        try {
			            socket.close();
			        } catch(IOException e1) {
			            e1.printStackTrace();
			        }
			        return;
			    }
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server4();
	}
}
