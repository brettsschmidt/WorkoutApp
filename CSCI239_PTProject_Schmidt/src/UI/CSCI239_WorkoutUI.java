package UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CSCI239_WorkoutUI extends JFrame implements ActionListener, WindowListener
{
	private JPanel contentPane;
	private JMenuItem mnuFileNew;
	private JButton btnExit;
	
	
	// Constructor
	public CSCI239_WorkoutUI()
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
			contentPane.setBackground(Color.CYAN);
			JPanel menuPanel = new JPanel();
			menuPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
			//menuPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			//menuPanel.setBackground(Color.gray);
			JPanel dataPanel = new JPanel();
			dataPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
			dataPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			//dataPanel.setBackground(Color.CYAN);
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
			buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			//buttonPanel.setBackground(Color.CYAN);
			JPanel functionPanel = new JPanel();
			functionPanel.setLayout(new BoxLayout(functionPanel, BoxLayout.Y_AXIS));
			
			contentPane.setLayout(new FlowLayout());
			
			JMenuBar mnuBar = new JMenuBar();
			mnuBar.setLayout(new FlowLayout(FlowLayout.LEADING));
			//mnuBar.setBackground(Color.CYAN);
			mnuBar.setBorder(BorderFactory.createLineBorder(Color.black));
			JMenu mnuFile = new JMenu("File", true);
			JMenu mnuHelp = new JMenu("Help", true);
			
			
			
			JMenuBar dataBar = new JMenuBar();
			dataBar.setLayout(new BoxLayout(dataBar, BoxLayout.Y_AXIS));
			JMenuBar nameBar = new JMenuBar();
			//nameBar.setLayout(new GridLayout(5,1));
			JMenuBar addBar = new JMenuBar();
			//addBar.setLayout(new BoxLayout(addBar, BoxLayout.Y_AXIS));
			JMenuBar cityBar = new JMenuBar();
			JMenuBar stateBar = new JMenuBar();
			JMenuBar zipBar = new JMenuBar();
			zipBar.setLayout(new FlowLayout(FlowLayout.LEADING));
			JLabel mnuName = new JLabel("Exercise Name:");
			JLabel mnuAdd = new JLabel("Video Link:");
			JLabel mnuCity = new JLabel("Description:");
			JLabel mnuState = new JLabel("Category: ");
			JLabel mnuZip = new JLabel("Picture: ");
			JTextField mnuStuff = new JTextField(25);
			JTextField mnuStuff2 = new JTextField(25);
			JTextField mnuStuff3 = new JTextField(25);
			JTextField mnuStuff4 = new JTextField(25);
			JButton mnuStuff5 = new JButton("Upload");
			JButton mnuStateU = new JButton("U");
			
			JMenuBar buttBar = new JMenuBar();
			JButton mnuSave = new JButton("Save");
			JButton mnuUpdate = new JButton("Update");
			JButton mnuClear = new JButton("Clear");
			//JButton mnuExit = new JButton("Exit");
			
			mnuFileNew = new JMenuItem("New");
			mnuFileNew.setActionCommand("NEW");
			mnuFileNew.addActionListener(this);
			mnuFile.add(mnuFileNew);
			
			mnuFile.add(new JSeparator());
			
			JMenuItem mnuFileExit = new JMenuItem("Exit");
			mnuFileExit.setActionCommand("EXIT");
			mnuFileExit.addActionListener(this);
			mnuFile.add(mnuFileExit);
			
			JMenuItem mnuHelpAbout = new JMenuItem("About");
			mnuHelpAbout.setActionCommand("ABOUT");
			mnuHelpAbout.addActionListener(this);
			mnuHelp.add(mnuHelpAbout);
			
			btnExit = new JButton("Exit");
			btnExit.setActionCommand("EXIT");
			btnExit.addActionListener(this);
			btnExit.setEnabled(false);
			
			mnuBar.add(mnuFile);
			mnuBar.add(mnuHelp);
			
			
			buttBar.add(mnuSave);
			buttBar.add(mnuUpdate);
			buttBar.add(mnuClear);
			buttBar.add(btnExit);
			
			//menuPanel.add(mnuBar);
			
			buttonPanel.add(buttBar);
			
			nameBar.add(mnuName);
			nameBar.add(mnuStuff);
			addBar.add(mnuAdd);
			addBar.add(mnuStuff2);
			cityBar.add(mnuCity);
			cityBar.add(mnuStuff3);
			stateBar.add(mnuState);
			stateBar.add(mnuStuff4);
			//stateBar.add(mnuStateU);
			zipBar.add(mnuZip);
			zipBar.add(mnuStuff5);
			
			//nameBar.add(mnuName);
			//addBar.add(mnuStuff);
			//nameBar.add(mnuAdd);
			//addBar.add(mnuStuff2);
			//nameBar.add(mnuCity);
			//addBar.add(mnuStuff3);
			//addBar.add(stateBar);
			//nameBar.add(mnuState);
			//stateBar.add(mnuStuff4);
			//stateBar.add(mnuStateU);
			//nameBar.add(mnuZip);
			//addBar.add(mnuStuff5);
			
			dataBar.add(nameBar);
			dataBar.add(addBar);
			dataBar.add(cityBar);
			dataBar.add(stateBar);
			dataBar.add(zipBar);
			dataPanel.add(dataBar);
			
			//contentPane.add(btnExit);
			//functionPanel.add(menuPanel);
			functionPanel.add(mnuBar);
			functionPanel.add(dataPanel);
			functionPanel.add(buttonPanel);
			
			contentPane.add(functionPanel);
			
		}
		return contentPane;
		
	}
	
	//public static void main(String[] args) 
	//{
		//CSCI239_WorkoutUI form2 = new CSCI239_WorkoutUI();
		
		

	//}
	
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
