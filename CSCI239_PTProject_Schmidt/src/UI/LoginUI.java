package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoginUI extends JFrame implements ActionListener, WindowListener
	{
		private JPanel contentPane;
		private JMenuItem mnuFileNew;
		private JButton btnExit;
		private JPanel dataPanel;
		
		
		// Constructor
		public LoginUI()
		{
			super();
			
			
			setSize(1200, 800);
			
			
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension d = tk.getScreenSize();
			
			
			int x = (d.width - getWidth() ) /2;
			int y = (d.height - getHeight()) /2;
			
			setLocation(x,y);
			setContentPane( getContentPane() );
			setTitle("CSCI239 - Java Programming II");
			setResizable(true);
			setVisible(true);
			//setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		
		public JPanel getContentPane()
		{
			if( contentPane == null )
			{
				contentPane = new JPanel();
				//contentPane.setBackground(Color.CYAN);
				JPanel menuPanel = new JPanel();
				menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
				
				JLabel mnuBanner = new JLabel("Welcome to Brett's Workout App!");
				mnuBanner.setBackground(Color.CYAN);
				mnuBanner.setLayout(new FlowLayout(FlowLayout.CENTER));
				JLabel mnuUser = new JLabel("Username:");
				JLabel mnuPW = new JLabel("Password:");
				JLabel mnuBlank = new JLabel("                   ");
				JLabel mnuBlank2 = new JLabel("                   ");
				JLabel mnuBlank3 = new JLabel("                   ");
				JButton mnuLogin = new JButton("Login");
				
				JTextField userText = new JTextField(25);
				JTextField PWText = new JTextField(25);
				
				JMenuBar bannerBar = new JMenuBar();
				JMenuBar userBar = new JMenuBar();
				JMenuBar PWBar = new JMenuBar();
				JMenuBar loginBar = new JMenuBar();
				bannerBar.setLayout(new FlowLayout(FlowLayout.CENTER));
				userBar.setLayout(new FlowLayout(FlowLayout.CENTER));
				PWBar.setLayout(new FlowLayout(FlowLayout.CENTER));
				loginBar.setLayout(new FlowLayout(FlowLayout.CENTER));
				
				
				mnuLogin.setActionCommand("LOGIN");
				mnuLogin.addActionListener(this);
				
				bannerBar.add(mnuBanner);
				userBar.add(mnuUser);
				userBar.add(userText);
				PWBar.add(mnuPW);
				PWBar.add(PWText);
				loginBar.add(mnuLogin);
				
				menuPanel.add(bannerBar);
				//menuPanel.add(mnuBlank);
				menuPanel.add(userBar);
				menuPanel.add(PWBar);
				//menuPanel.add(mnuBlank3);
				menuPanel.add(loginBar);
				
				contentPane.add(menuPanel);
					
			}
			return contentPane;
			
		}
		
		
		
		public static void main(String[] args) 
		{
			LoginUI form = new LoginUI();
			
			

		}
		
		private void NewStudent()
		{
			
		}

		// Where UI talks to business logic
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JOptionPane.showMessageDialog(this, e.getActionCommand());
			
			switch( e.getActionCommand() )
			{
				
				case "NEW":
					NewStudent();
					break;
			
				case "EXIT":
					System.exit(0);
					break;
					
				case "LOGIN":
					CSCI239_UI form1 = new CSCI239_UI();
					this.setVisible(false);
					break;
				
				case "CREATEWORKOUT":
					CSCI239_WorkoutUI form2 = new CSCI239_WorkoutUI();
					break;
					
				case "ADDWORKOUT":
					dataPanel.add(new DataBar());
					SwingUtilities.updateComponentTreeUI(this);
					break;
					
				case "ABOUT":
					
					btnExit.setEnabled(!btnExit.isEnabled());
				
			
				default:
					JOptionPane.showMessageDialog(this, 
							String.format("Unknown Action Command %s", e.getActionCommand()));
			}
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		// e is the secret way to get the program to exit on X click.
		

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	}



