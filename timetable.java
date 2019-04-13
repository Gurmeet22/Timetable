import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

public class timetable extends JFrame{
	
	JButton button1;JButton button2;JButton button3;JButton button4;
	ArrayList<String> subjects1 = new ArrayList<String>();
	ArrayList<String> subjects2 = new ArrayList<String>();
	ArrayList<String> subjects3 = new ArrayList<String>();
	ArrayList<String> subjects4 = new ArrayList<String>();
	HashSet<String> subject = new HashSet<String>();
	HashMap<String,Integer> map = new HashMap<String,Integer>();
	JTextField maxcl;
	JTextField cw;
	JTextField clr;
	
	timetable(){
		super("TimeTable");
		setLayout(new FlowLayout());
		getContentPane().setBackground(new Color(173,255,47));
		JPanel myPanel = new JPanel();
		maxcl = new JTextField(2);
		cw = new JTextField(2);
		clr = new JTextField(2);
	    myPanel.add(new JLabel("Maximum classes per day :"));
	    myPanel.add(maxcl);
	    myPanel.add(Box.createHorizontalStrut(15));
	    myPanel.add(new JLabel("Number of classes per week for each subject :"));
	    myPanel.add(cw);
	    myPanel.add(Box.createHorizontalStrut(15));
	    myPanel.add(new JLabel("Number of classrooms alloted :"));
	    myPanel.add(clr);
	    int result = JOptionPane.showConfirmDialog(null, myPanel,
	            "Enter Values", JOptionPane.OK_CANCEL_OPTION);
		button1 = new JButton("Enter subjects of 1st year");
		button2 = new JButton("Enter subjects of 2nd year");
		button3 = new JButton("Enter subjects of 3rd year");
		button4 = new JButton("Enter subjects of 4th year");
		button1.addActionListener(new handler());
		button2.addActionListener(new handler());
		button3.addActionListener(new handler());
		button4.addActionListener(new handler());
		button1.setFont(new Font("Serif", Font.BOLD, 25));button1.setForeground(new Color(255,255,255));button1.setBackground(new Color(11, 12, 16));
		button2.setFont(new Font("Serif", Font.BOLD, 25));button4.setForeground(new Color(255,255,255));button2.setBackground(new Color(11, 12, 16));
		button3.setFont(new Font("Serif", Font.BOLD, 25));button3.setForeground(new Color(255,255,255));button3.setBackground(new Color(11, 12, 16));
		button4.setFont(new Font("Serif", Font.BOLD, 25));button2.setForeground(new Color(255,255,255));button4.setBackground(new Color(11, 12, 16));
		JTextField t1 = new JTextField("Maximum classes per day is "+maxcl.getText()+",");t1.setBackground(new Color(173,255,47));
		add(t1);add(Box.createVerticalStrut(15));t1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		JTextField t2 = new JTextField("Number of classes per week for each subject is "+cw.getText()+" and");t2.setBackground(new Color(173,255,47));
		add(t2);add(Box.createVerticalStrut(15));t2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		JTextField t3 = new JTextField("Number of classrooms alloted is "+clr.getText()+".");t3.setBackground(new Color(173,255,47));
		add(t3);add(Box.createVerticalStrut(15));t3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		t1.setFont(new Font("Serif", Font.BOLD, 25));t2.setFont(new Font("Serif", Font.BOLD, 25));t3.setFont(new Font("Serif", Font.BOLD, 25));
		button1.setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());button2.setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());button3.setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());button4.setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
		add(button1);
		add(Box.createVerticalStrut(15));
		add(button2);
		add(Box.createVerticalStrut(15));
		add(button3);
		add(Box.createVerticalStrut(15));
		add(button4);	
		
		
					
	}
	private class handler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			HashSet<String> subjects = new HashSet<String>();
			int result = JOptionPane.OK_OPTION;
			while(result == JOptionPane.OK_OPTION) {
				JPanel mypanel = new JPanel();
				mypanel.add(new JLabel("Subject :"));
				JTextField sub = new JTextField(20);
				mypanel.add(sub);
				result = JOptionPane.showConfirmDialog(null, mypanel,
			            "Enter Subjects", JOptionPane.OK_CANCEL_OPTION);
				if(sub.getText().length()==0) continue;
				subjects.add(sub.getText());subject.add(sub.getText());
				
				if(map.get(sub.getText())==null) map.put(sub.getText(), 1);
				else map.put(sub.getText(), map.get(sub.getText())+1);
			}
			if(event.getSource()==button1) subjects1.addAll(subjects);
			if(event.getSource()==button2) subjects2.addAll(subjects);
			if(event.getSource()==button3) subjects3.addAll(subjects);
			if(event.getSource()==button4) {subjects4.addAll(subjects);print();}
				
				
			
			
		}
	}
	void print() {
		JLabel text = new JLabel("Timetables of 1st, 2nd, 3rd and 4th year are :");text.setFont(new Font("Serif", Font.BOLD, 25));text.setBackground(new Color(173,255,47));
		add(text);
		button1.setVisible(false);button2.setVisible(false);button3.setVisible(false);button4.setVisible(false);
		String[] colnames = {"Days","8:00 - 9:00","9:00 - 10:00","10:00 - 11:00","11:00 - 12:00","1:00 - 2:00","2:00 - 3:00","3:00 - 4:00","4:00 - 5:00"};
		Object[][] sub1 = new Object[5][9];
		for(Object[] row : sub1) Arrays.fill(row, null);
		sub1[0][0] = "Mon";sub1[1][0] = "Tue";sub1[2][0] = "Wed";sub1[3][0] = "Thu";sub1[4][0] = "Fri";
		Object[][] sub2 = new Object[5][9];
		for(Object[] row : sub2) Arrays.fill(row, null);
		sub2[0][0] = "Mon";sub2[1][0] = "Tue";sub2[2][0] = "Wed";sub2[3][0] = "Thu";sub2[4][0] = "Fri";
		Object[][] sub3 = new Object[5][9];
		for(Object[] row : sub3) Arrays.fill(row, null);
		sub3[0][0] = "Mon";sub3[1][0] = "Tue";sub3[2][0] = "Wed";sub3[3][0] = "Thu";sub3[4][0] = "Fri";
		Object[][] sub4 = new Object[5][9];
		for(Object[] row : sub4) Arrays.fill(row, null);
		sub4[0][0] = "Mon";sub4[1][0] = "Tue";sub4[2][0] = "Wed";sub4[3][0] = "Thu";sub4[4][0] = "Fri";
		String sub11 = subjects1.get(0);int cl = Integer.parseInt(cw.getText());int x = cl;x--;int c=1;
		while(x>=0) {sub1[x][x+1] = sub11;x--;}		
		while(c<subjects1.size()) {
			x=cl;System.out.println(c);
			while(x>=0) {
				if(x==(c-1)) {x--;if(x<0) break;sub1[x][c]=subjects1.get(c);continue;}
				sub1[x][c]=subjects1.get(c);x--;
			}c++;
		}int i;
		for(i=0;i<Math.min(subjects3.size()-1,subjects1.size()-1);i++) {
			if(subjects1.get(i) == subjects3.get(i)) {
				String t = subjects3.get(i);
				subjects3.set(i,subjects3.get(i+1));
				subjects3.set(i+1,t);
			}
		}
		if(subjects1.get(i) == subjects3.get(i)) {
			String t = subjects3.get(i);
			subjects3.set(i,subjects3.get(i+1));
			subjects3.set(i+1,t);
		}
		x=cl-1;String sub31 = subjects3.get(0);c=1;
		while(x>=0) {sub3[x][x+1] = sub31;x--;}		
		while(c<subjects3.size()) {
			x=cl;
			while(x>=0) {
				if(x==(c-1)) {x--;if(x<0) break;sub3[x][c]=subjects3.get(c);continue;}
				
				sub3[x][c]=subjects3.get(c);x--;
			}c++;
		}
		String sub21 = subjects2.get(0);x=cl-1;c=1;
		while(x>=0) {sub2[x][x+5] = sub21;x--;}		
		while(c<subjects2.size()) {
			x=cl;
			while(x>=0) {
				if(x==(c-1)) {x--;if(x<0) break;if(c>=5) {
					sub2[x][c-4]=subjects2.get(c);}
					else sub2[x][c+4]=subjects2.get(c);continue;}
				if(c>=5) {
				sub2[x][c-4]=subjects2.get(c);}
				else sub2[x][c+4]=subjects2.get(c);
				x--;
			}c++;
		}
		for(i=0;i<Math.min(subjects2.size()-1,subjects4.size()-1);i++) {
			if(subjects2.get(i) == subjects4.get(i)) {
				String t = subjects4.get(i);
				subjects4.set(i,subjects4.get(i+1));
				subjects4.set(i+1,t);
			}
		}
		if(subjects2.get(i) == subjects4.get(i)) {
			String t = subjects4.get(i);
			subjects4.set(i,subjects4.get(i+1));
			subjects4.set(i+1,t);
		}
		String sub41 = subjects4.get(0);x=cl-1;c=1;
		while(x>=0) {sub4[x][x+5] = sub41;x--;}		
		while(c<subjects4.size()) {
			x=cl;
			while(x>=0) {
				if(x==(c-1)) {x--;if(x<0) break;if(c>=5) {
					sub4[x][c-4]=subjects4.get(c);}
					else sub4[x][c+4]=subjects4.get(c);continue;}
				if(c>=5) {
				sub4[x][c-4]=subjects4.get(c);}
				else sub4[x][c+4]=subjects4.get(c);
				x--;
			}c++;
		}
		
		JTable table1 = new JTable(sub1, colnames);
		table1.setFont(new Font("Serif", Font.BOLD, 10));
		table1.setForeground(new Color(102, 252, 241));
		table1.setBackground(new Color(11, 12, 16));
		table1.getTableHeader().setFont(new Font("Serif", Font.BOLD, 10));
		table1.getTableHeader().setBackground(new Color(69, 162, 158));
		table1.setBounds(50, 200, 150, 200);
		JScrollPane scrollPane1 = new JScrollPane(table1);
		table1.setFillsViewportHeight(true);
		add(scrollPane1);
		JTable table2 = new JTable(sub2, colnames);table2.setFont(new Font("Serif", Font.BOLD, 10));
		table2.getTableHeader().setFont(new Font("Serif", Font.BOLD, 10));
		table2.getTableHeader().setBackground(new Color(69, 162, 158));
		table2.setForeground(new Color(102, 252, 241));
		table2.setBackground(new Color(11, 12, 16));
		table2.setBounds(50, 200, 150, 200);
		JScrollPane scrollPane2 = new JScrollPane(table2);
		table2.setFillsViewportHeight(true);
		add(scrollPane2);
		JTable table3 = new JTable(sub3, colnames);table3.setFont(new Font("Serif", Font.BOLD, 10));
		table3.getTableHeader().setFont(new Font("Serif", Font.BOLD, 10));
		table3.getTableHeader().setBackground(new Color(69, 162, 158));
		table3.setForeground(new Color(102, 252, 241));
		table3.setBackground(new Color(11, 12, 16));
		table3.setBounds(50, 200, 150, 200);
		JScrollPane scrollPane3 = new JScrollPane(table3);
		table3.setFillsViewportHeight(true);
		add(scrollPane3);
		JTable table4 = new JTable(sub4, colnames);table4.setFont(new Font("Serif", Font.BOLD, 10));
		table4.getTableHeader().setFont(new Font("Serif", Font.BOLD, 10));
		table4.getTableHeader().setBackground(new Color(69, 162, 158));
		table4.setForeground(new Color(102, 252, 241));
		table4.setBackground(new Color(11, 12, 16));
		table4.setBounds(50, 200, 150, 200);
		JScrollPane scrollPane4 = new JScrollPane(table4);
		table4.setFillsViewportHeight(true);
		add(scrollPane4);
		
		
	}
	
	public static void main(String args[]) {
		timetable ob = new timetable();
		ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ob.setVisible(true);
		ob.setSize(550,400);
	}

}
