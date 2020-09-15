import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.*;

class View extends JPanel implements ActionListener{

	JLabel btLabel= new JLabel("BOOK YOUR TOUR..");
	
	JLabel nmLabel=new JLabel("Name");
	JLabel arLabel = new JLabel("Address");
	JLabel mnLabel=new JLabel("Mobile No.");
	JLabel eiLabel=new JLabel("Email Id");
	JLabel auLabel=new JLabel("Adult");
	JLabel clLabel=new JLabel("Children");
	JLabel tLabel= new JLabel("Tour Package");
	JLabel tfLabel=new JLabel("Traveling from");
	JLabel fLabel= new JLabel("Rate");
	JLabel aLabel=new JLabel("Amount");
	JLabel hnLabel = new JLabel("Hotel Name");
	JLabel nrLabel = new JLabel("No of Room");
	JTextField nmText = new JTextField(30);
	JTextField arText = new JTextField(30);
	JTextField mnText = new JTextField(30);
	JTextField eiText = new JTextField(30);
	JTextField au=new JTextField(30);
	JTextField cl=new JTextField(30);
	JTextField tText = new JTextField(30);
	JTextField tfText = new JTextField(30);
	JTextField fText = new JTextField(30);
	JTextField aText = new JTextField(30);
	JTextField hn=new JTextField(30);
	JTextField nr=new JTextField(30);
	
	JButton baButton = new JButton ("BACK");
	JButton logButton = new JButton ("LOGOUT");
	JButton deButton = new JButton ("DELETE");
	JFrame fr;
	String id;
	ImageIcon icon = new ImageIcon("view.png");	 
	JMenuItem iconMenuItem = new JMenuItem(icon);	
	
	View (JFrame fr,String id) {
		this.fr=fr;
		this.id=id;
		setLayout(null);
		setBackground(Color.white);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setResizable(false);

		btLabel.setFont(new Font("algerian", Font.BOLD, 44));
		nmLabel.setFont(new Font("algerian", Font.BOLD, 20));
		arLabel.setFont(new Font("algerian", Font.BOLD, 20));
		mnLabel.setFont(new Font("algerian", Font.BOLD, 20));
		eiLabel.setFont(new Font("algerian", Font.BOLD, 20));
		tLabel.setFont(new Font("algerian", Font.BOLD, 20));
		aLabel.setFont(new Font("algerian", Font.BOLD, 20));
		fLabel.setFont(new Font("algerian", Font.BOLD, 20));
		tfLabel.setFont(new Font("algerian", Font.BOLD, 20));
		auLabel.setFont(new Font("algerian", Font.BOLD, 20));
		clLabel.setFont(new Font("algerian", Font.BOLD, 20));
		hnLabel.setFont(new Font("algerian", Font.BOLD, 20));
		nrLabel.setFont(new Font("algerian", Font.BOLD, 20));
		fLabel.setFont(new Font("algerian", Font.BOLD, 20));
		aLabel.setFont(new Font("algerian", Font.BOLD, 20));
		
		iconMenuItem.setBounds(0,0,1300,750);	
		btLabel.setBounds(50,50,600,50);
		nmLabel.setBounds(100,200,150,40);
		arLabel.setBounds(100,250,150,40);
		mnLabel.setBounds(100,300,150,40);	
		eiLabel.setBounds(100,350,150,40);
		auLabel.setBounds(100,400,150,40);
		clLabel.setBounds(100,450,150,40);
		
		tLabel.setBounds(600,200,200,40);
		tfLabel.setBounds(600,250,200,40);
		fLabel.setBounds(600,300,200,40);
		aLabel.setBounds(600,350,200,40);
		hnLabel.setBounds(600,400,200,40);
		nrLabel.setBounds(600,450,200,40);
		
		baButton.setBounds(350,600,150,50);
		logButton.setBounds(550,600,150,50);
		deButton.setBounds(750,600,150,50);
		
		nmText.setBounds(250,200,150,20);
		arText.setBounds(250,250,150,20);
		mnText.setBounds(250,300,150,20);
		eiText.setBounds(250,350,150,20);
		au.setBounds(250,400,150,20);
		cl.setBounds(250,450,150,20);
		
		tText.setBounds(800,200,150,20);
	    tfText.setBounds(800,250,150,20);
		fText.setBounds(800,300,150,20);
		aText.setBounds(800,350,150,20);
		hn.setBounds(800,400,150,20);
		nr.setBounds(800,450,150,20);

		deButton.addActionListener(this);
		baButton.addActionListener(this);
		logButton.addActionListener(this);
		
		
		add(fLabel);
		add(aLabel);
		add(fText);
		add(aText);
		add(tText);
		add(nmLabel);
		add(arLabel);
		add(mnLabel);
		add(eiLabel);
		add(tLabel);
		add(tfLabel);
		add(auLabel);
		add(clLabel);
		add(btLabel);
		add(deButton);
		add(baButton);
		add(logButton);
		add(au);
		add(cl);
		add(nmText);
		add(arText);
		add(nmText);
		add(eiText);
		add(tfText);
		add(hnLabel);
		add(nrLabel);
		add(hn);
		add(nr);
		add(mnText);

		add(iconMenuItem);
		try{
			
				OracleDriver driver = new OracleDriver();
				DriverManager.registerDriver(driver);
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:scott/tiger@localhost:1521/XE");
				System.out.println("Connection: " + con);
		
				PreparedStatement ps = con.prepareStatement("select name,address,phno,email,adult,child,tour,city,hotel,room,fare,amt from customer where id=?");
				ps.setString(1,id);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					nmText.setText(rs.getString(1));
					arText.setText(rs.getString(2));
					mnText.setText(rs.getString(3));
					eiText.setText(rs.getString(4));
					au.setText(rs.getString(5));
					cl.setText(rs.getString(6));
					tText.setText(rs.getString(7));
					tfText.setText(rs.getString(8));
					fText.setText(rs.getString(11));
					aText.setText(rs.getString(12));
					hn.setText(rs.getString(9));
					nr.setText(rs.getString(10));
				}
			}
			catch (SQLException e) {
				System.out.println("SQL error");
			}
	}

	public void actionPerformed(ActionEvent fd){
		Object src=fd.getSource();
		if(src==baButton){
			
			fr.dispose();
			
			JFrame frame=new JFrame("INDIA");
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
			
			frame.setVisible(true);

		}
		else if(src==deButton){
		
			try{
			
				OracleDriver driver = new OracleDriver();
				DriverManager.registerDriver(driver);
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:scott/tiger@localhost:1521/XE");
				System.out.println("Connection: " + con);
		
				PreparedStatement ps = con.prepareStatement("delete from customer where id=?");
				ps.setString(1,id);
				ResultSet rs = ps.executeQuery();
			}
			catch (SQLException e) {
				System.out.println("SQL error");
			}
			nmText.setText("");
			arText.setText("");
			mnText.setText("");
			eiText.setText("");
			au.setText("");
			cl.setText("");
			tText.setText("");
			tfText.setText("");
			fText.setText("");
			aText.setText("");
			hn.setText("");
			nr.setText("");
		}
	}
}