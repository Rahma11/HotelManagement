import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import sun.security.jgss.LoginConfigImpl;

public class Frame extends JFrame{
	
	private JButton login;
	private JTextField user;
	private JPasswordField pass;
	
	public Frame(){
		super("Simple Login System"); 
		setLayout(new FlowLayout());
		
		user = new JTextField(15);
		add(user);
		pass = new JPasswordField(15);
		add(pass);
		login = new JButton("Login");
		add(login);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,150);
		setVisible(true);
		setResizable(false); 
		login.addActionListener(new ButtonListener());
	}
	
	
	public class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			char [] input = pass.getPassword();
			char [] correctPass = {'K', 'l', 'e', 'o'};
			
			if(user.getText().trim().length() == 0 || pass.getPassword().toString().length() == 0)

                        {
				JOptionPane.showMessageDialog(null,"Please Fill out both of the TextBoxes");
				
			}
			else{
       if(user.getText().equals("Kleo") && (Arrays.equals(input, correctPass) ) ){

				JOptionPane.showMessageDialog(null,"Welcome");
			}
        else{
              JOptionPane.showMessageDialog(null,"Wrong Username | Password");

             }
            }
         }
      }
	
	
	
}