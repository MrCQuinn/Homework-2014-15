import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Client extends JFrame {	
	private static final int PORT = 1235;

	private JTextArea _textArea;
	private JTextField _textField;
	private JButton _sendList = new JButton("Send List");
	private ObjectInputStream _inputStream;
	private ObjectOutputStream _outputStream;
	private ArrayList<String> nlist = new ArrayList<String>();
	private boolean _running = true;
	
	public Client() {
		super("Prime number list chat window");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		_textArea = new JTextArea(15, 30);
		_textArea.setEditable(false);
		_textArea.append("Enter a number\n");
		add(new JScrollPane(_textArea), BorderLayout.CENTER);
	
		_textField = new JTextField(30);
		_textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				String message = _textField.getText();
				try{
			        int n = Integer.parseInt(message);
			        nlist.add(message);
					_textArea.append(message);
					_textArea.append("\nEnter a number\n");
			        
			     }
			     catch(NumberFormatException e){
			        _textArea.append("THATS NOT A NUMBER\n");
			     }

				_textField.setText("");				
			}
		});
		add(_textField, BorderLayout.SOUTH);
		
		
		_sendList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				sendMessage(nlist);
				_textArea.append("Client sent: "+nlist+"\n");
			}
		});
		add(_sendList, BorderLayout.EAST);
		
		pack();
		setVisible(true);
				
		Socket socket = null;
		try {

			InetAddress localHost = InetAddress.getLocalHost();
			socket = new Socket(localHost, PORT);

			_outputStream = new ObjectOutputStream(socket.getOutputStream());
			_outputStream.flush();
			
			_inputStream = new ObjectInputStream(socket.getInputStream());
			
			try {
				while (_running) {
					ArrayList<String> message = null;
					try {
						message =  (ArrayList<String>) _inputStream.readObject();
					} catch (ClassNotFoundException e) {
						System.out.println("Error occurred here.");
					}
					
					System.out.println("Received message: " + message);

					displayMessage(message);
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (_inputStream != null) {
					_inputStream.close();
				}
				if (_outputStream != null) {
					_outputStream.close();
				}
				if (socket != null) {
					socket.close();
				}
				
				System.out.println("Shutdown successful!");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}	
	}
	
	private void sendMessage(ArrayList<String> message) {
		try {
			System.out.println("Sent message: " + message);
			_outputStream.writeObject(message);
			_outputStream.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void displayMessage(final ArrayList<String> message) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				_textArea.append("Client recieved: " + message.toString() + "\n");
			}
		});
	}
	
	public static void main(String[] args) {
		Client client = new Client();
	}	
}