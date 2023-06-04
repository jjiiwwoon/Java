import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Client4 extends JFrame {
	private JTextField wordTf= new JTextField(7);
	private JLabel resLabel = new JLabel("word");
	private Socket socket = null;
	private BufferedReader in = null;
	private BufferedWriter out = null;
	
	public Client4() {
		super("스펠 체크 클라이언트");
		setSize(300,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("단어 입력 "));
		c.add(wordTf);
		c.add(resLabel);
		
		setVisible(true);
		
		setupConnection();
		
		wordTf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();
				try {
					String word = tf.getText().trim();
					if(word==null)
						return;
					
					out.write(word+"\n");
					out.flush();
					
					String YesNo = in.readLine();
					resLabel.setText(word+"는 "+YesNo);
				}catch (IOException el) {
					System.out.println("클라이언트 : 서버로부터 연결 종료");
					return;
				}
			}
		});
	}
	
	public void setupConnection() {
		try {
			socket = new Socket("localhost",222);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Client4();
	}
}
