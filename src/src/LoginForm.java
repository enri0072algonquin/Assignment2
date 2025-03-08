import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm implements ActionListener {
private static JLabel userLabel;
private static JTextField userText;
private static JLabel passwordLabel;
private static JPasswordField passwordText;
private static JButton button; 
private static JLabel success; 
	
public static void main(String[] args) {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(300,250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		
		panel.setLayout(null);
		
		userLabel = new JLabel("User");
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);
		
		
		//text field 
		userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		
		passwordLabel= new JLabel("Password");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 162, 25);
		panel.add(passwordText);
		
		//login button
		button = new JButton("Login");
		button.setBounds(10, 80, 80, 25);
		panel.add(button);
		
		success = new JLabel("");
		success.setBounds(10, 110, 300, 25);
		button.addActionListener(new LoginForm());
		panel.add(success);
		
		
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String user = userText.getText();
		String password = passwordText.getText();
		System.out.println(user +"," +password);
		
	}
//test 3 made for hub  //

		
	}

