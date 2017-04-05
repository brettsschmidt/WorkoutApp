package UI;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

public class DataBar extends JMenuBar
{
	// TODO: Turn Name into a combo box that changed based off Category
	// Make mnuCat pull from Code Table in Database.
	
	public static String[] cat = {"Weight Lifting", "Cross Fit", "Yoga"};
	
	public DataBar()
	{
	super();
	
	String[] perMax = {"100%", "5%", "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%", "55%", "60%", "65%", "70%", "75%", "80%", "85%", "90%", "95%"};
	String[] rest = {"0 sec", "5 sec", "10 sec", "15 sec", "20 sec", "25 sec", "30 sec", "35 sec", "40 sec", "45 sec", "50 sec", "55 sec", "60 sec", "65 sec", "70 sec", "75 sec", "80 sec", "85 sec", "90 sec"};
	String[] sets = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
	
	this.setLayout(new FlowLayout(FlowLayout.LEADING));
	JMenuBar nameBar = new JMenuBar();
	JMenuBar catBar = new JMenuBar();
	JMenuBar setsBar = new JMenuBar();
	//addBar.setLayout(new BoxLayout(addBar, BoxLayout.Y_AXIS));
	JMenuBar repsBar = new JMenuBar();
	JMenuBar restBar = new JMenuBar();
	JMenuBar maxBar = new JMenuBar();
	JLabel mnuName = new JLabel("Exercise:");
	JLabel mnuCat = new JLabel("Category:");
	JLabel mnuSets = new JLabel("Sets:");
	JLabel mnuReps = new JLabel("Reps:");
	JLabel mnuRest = new JLabel("Rest Time:");
	JLabel mnuMax = new JLabel("Percentage of Max:");
	JTextField mnuStuff = new JTextField(25);
	JComboBox mnuCatStuff = new JComboBox(cat);
	JComboBox mnuStuff2 = new JComboBox(sets);
	JComboBox mnuStuff3 = new JComboBox(sets);
	JComboBox mnuStuff4 = new JComboBox(rest);
	JComboBox mnuStuff5 = new JComboBox(perMax);
	nameBar.add(mnuName);
	nameBar.add(mnuStuff);
	catBar.add(mnuCat);
	catBar.add(mnuCatStuff);
	setsBar.add(mnuSets);
	setsBar.add(mnuStuff2);
	repsBar.add(mnuReps);
	repsBar.add(mnuStuff3);
	restBar.add(mnuRest);
	restBar.add(mnuStuff4);
	maxBar.add(mnuMax);
	maxBar.add(mnuStuff5);
	this.add(nameBar);
	this.add(catBar);
	this.add(setsBar);
	this.add(repsBar);
	this.add(restBar);
	this.add(maxBar);
	}
	
	
}
