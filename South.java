import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.*;;
import java.io.*;
import java.util.*;
import oracle.jdbc.*;
import java.sql.*;

class South extends JPanel implements ActionListener{

	JLabel nLabel = new JLabel("SOUTH INDIA");
	JLabel pLabel = new JLabel("Packages of South India");
	
	JLabel fText = new JLabel();
	JLabel sText = new JLabel();
	JLabel pText = new JLabel();
	
	JButton bookButton = new JButton ("BOOK NOW");
	JButton fButton = new JButton ("SHOW FARE");
	JButton vButton = new JButton ("SHOW DETAILS");
	JButton backButton = new JButton ("BACK");	
	JButton logButton = new JButton ("LOGOUT");

	ImageIcon icon = new ImageIcon("south1.png");
	JMenuItem iconMenuItem = new JMenuItem(icon);
	
	JComboBox nPackages = new JComboBox();
	
	JFrame fr;

	South (JFrame fr) {
		nLabel.setFont(new Font("algerian", Font.BOLD, 44));
		pLabel.setFont(new Font("algerian", Font.BOLD, 32));
		fText.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sText.setFont(new Font("Times New Roman", Font.BOLD, 18));
		pText.setFont(new Font("Times New Roman", Font.BOLD, 18));
	
		this.fr=fr;
		setLayout (null);
		setBackground(Color.white);
		fr.setResizable(false);
		
		nLabel.setBounds (400,00,500,100);
		pLabel.setBounds (50,120,500,100);
		nPackages.setBounds(100,200,220,35);
		fButton.setBounds(100,300,120,35);
		fText.setBounds(250,300,80,35);
		sText.setBounds(300,400,400,35);
		pText.setBounds(300,450,700,35);
		vButton.setBounds(100,400,150,35);
		bookButton.setBounds(150,500,150,35);
		backButton.setBounds(350,500,150,35);
		logButton.setBounds(550,500,150,35);
		iconMenuItem.setBounds(0,0,1300,750);
		
		nPackages.addActionListener(this);
		fButton.addActionListener(this);
		bookButton.addActionListener(this);
		backButton.addActionListener(this);
		logButton.addActionListener(this);
		vButton.addActionListener(this);
		
		add(vButton);
		add(nPackages);
		add(fButton);
		add(fText);
		add(sText);
		add(pText);
		add(nLabel);
		add(pLabel);
		add(bookButton);
		add(backButton);
		add(logButton);
		add(iconMenuItem);
		
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try{
		
			OracleDriver driver = new OracleDriver();
			DriverManager.registerDriver(driver);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:scott/tiger@localhost:1521/XE");
			System.out.println("Connection: " + con);
		
			PreparedStatement ps = con.prepareStatement("select area from india where region=?");
			ps.setString(1,"south");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				nPackages.addItem(rs.getString(1));
			}
		}
		catch (SQLException e) {
			System.out.println("SQL error");
		}	
	}

	public void actionPerformed(ActionEvent fd){
		
		Object src=fd.getSource();
		if(src==fButton){
		String s = (String)nPackages.getSelectedItem();
		System.out.println(s);
		try{
			
			OracleDriver driver = new OracleDriver();
			DriverManager.registerDriver(driver);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:scott/tiger@localhost:1521/XE");
			System.out.println("Connection: " + con);
		
			PreparedStatement ps = con.prepareStatement("select fare from south where name=?");
			ps.setString(1,s);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				fText.setText(("Rs. "+String.valueOf(rs.getInt(1))));
			}
		}
		catch (SQLException e) {
			System.out.println("SQL error");
		}

		}
     	else if(src==vButton){
		String s = (String)nPackages.getSelectedItem();
		System.out.println(s);
		try{
			
			OracleDriver driver = new OracleDriver();
			DriverManager.registerDriver(driver);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:scott/tiger@localhost:1521/XE");
			System.out.println("Connection: " + con);
		
			PreparedStatement ps = con.prepareStatement("select stay,places from south where name=?");
			ps.setString(1,s);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				sText.setText("Duration : "+rs.getString(1));
				pText.setText("Places : "+rs.getString(2));
			}
			
		}
		catch (SQLException e) {
			System.out.println("SQL error");
		}
		}
		else if(src==bookButton){
			
			fr.dispose();
			String s = (String)nPackages.getSelectedItem();
			JFrame frame=new JFrame("INDIA TOURISM");
			frame.setSize(1300,750);
			Books mp = new Books(frame,s);
			frame.setContentPane(mp);
			
			frame.setVisible(true);
			
		}
		else if(src==backButton){
			
			fr.dispose();
			
			JFrame frame=new JFrame("INDIA TOURISM");
			frame.setSize(1300,750);
			MainPanel mp = new MainPanel(frame);
						
			frame.setContentPane(mp);
			
			frame.setVisible(true);
			}
		else if(src==logButton){
			
			fr.dispose();
			
			JFrame frame=new JFrame("LOGIN");
			frame.setSize(750,600);
			LogInPanel mp = new LogInPanel();
						
			frame.setContentPane(mp);
			frame.pack();
			frame.setVisible(true);

		}
	}
}