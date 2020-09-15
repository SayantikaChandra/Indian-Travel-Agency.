import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.*;

class Booke extends JPanel implements ActionListener{

	JLabel btLabel= new JLabel("BOOK YOUR TOUR..");
	
	JLabel nmLabel=new JLabel("Name");
	JLabel arLabel = new JLabel("Address");
	JLabel mnLabel=new JLabel("Mobile No.");
	JLabel eiLabel=new JLabel("Email Id");
	JLabel auLabel=new JLabel("Adult");
	JLabel clLabel=new JLabel("Children");
	JTextField nmText = new JTextField(30);
	JTextField arText = new JTextField(30);
	JTextField mnText = new JTextField(30);
	JTextField eiText = new JTextField(30);
	JComboBox au=new JComboBox();
	JComboBox cl=new JComboBox();
	
	JLabel tLabel= new JLabel("Tour Package");
	JLabel tfLabel=new JLabel("Traveling from");
	JLabel deLabel = new JLabel("Departure Date");
	JTextField tText = new JTextField(30);
	JTextField tfText = new JTextField(30);
	JComboBox de=new JComboBox();
	JComboBox dem=new JComboBox();
	JComboBox dey=new JComboBox();
	
	JLabel hnLabel = new JLabel("Hotel Name");
	JLabel nrLabel = new JLabel("No of Room");
	JComboBox hn=new JComboBox();
	JComboBox nr=new JComboBox();
	
	JButton baButton = new JButton ("BACK");
	JButton logButton = new JButton ("LOGOUT");
	JButton bkButton = new JButton ("BOOK");
	JButton rButton = new JButton ("RESET");
	
	JFrame fr;
	String dest;
	ImageIcon icon = new ImageIcon("tourbooking.png");	 
	JMenuItem iconMenuItem = new JMenuItem(icon);	
	
	Booke (JFrame fr,String dest) {
		this.fr=fr;
		this.dest=dest;
		setLayout (null);
		setBackground(Color.white);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setResizable(false);

		btLabel.setFont(new Font("algerian", Font.BOLD, 44));
		nmLabel.setFont(new Font("algerian", Font.BOLD, 20));
		arLabel.setFont(new Font("algerian", Font.BOLD, 20));
		mnLabel.setFont(new Font("algerian", Font.BOLD, 20));
		eiLabel.setFont(new Font("algerian", Font.BOLD, 20));
		tLabel.setFont(new Font("algerian", Font.BOLD, 20));
		deLabel.setFont(new Font("algerian", Font.BOLD, 20));
		tfLabel.setFont(new Font("algerian", Font.BOLD, 20));
		auLabel.setFont(new Font("algerian", Font.BOLD, 20));
		clLabel.setFont(new Font("algerian", Font.BOLD, 20));
		hnLabel.setFont(new Font("algerian", Font.BOLD, 20));
		nrLabel.setFont(new Font("algerian", Font.BOLD, 20));

		nr.addItem(1);
		nr.addItem(2);
		
		au.addItem("0");
		au.addItem("1");
		au.addItem("2");
		au.addItem("5");
		
		cl.addItem("0");
		cl.addItem("1");
		cl.addItem("2");
		cl.addItem("5");

		de.addItem("1");de.addItem("2");de.addItem("3");de.addItem("4");de.addItem("5");de.addItem("6");de.addItem("7");de.addItem("8");de.addItem("9");de.addItem("10");
		de.addItem("11");de.addItem("12");de.addItem("13");de.addItem("14");de.addItem("15");de.addItem("16");de.addItem("17");de.addItem("18");de.addItem("19");de.addItem("20");
		de.addItem("21");de.addItem("22");de.addItem("23");de.addItem("24");de.addItem("25");de.addItem("26");de.addItem("27");de.addItem("28");de.addItem("29");de.addItem("30");
		de.addItem("31");
		
		dem.addItem("Jan");dem.addItem("Feb");dem.addItem("Mar");dem.addItem("Apr");
		dem.addItem("May");dem.addItem("Jun");dem.addItem("Jul");dem.addItem("Aug");
		dem.addItem("Sep");dem.addItem("Oct");dem.addItem("Nov");dem.addItem("Dec");
		
		dey.addItem("2012");dey.addItem("2013");dey.addItem("2014");dey.addItem("2015");
		dey.addItem("2016");dey.addItem("2017");dey.addItem("2018");dey.addItem("2019");
		
		tText.setText(dest);
		
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
		deLabel.setBounds(600,300,200,40);
		hnLabel.setBounds(600,350,200,40);
		nrLabel.setBounds(600,400,200,40);
		
		bkButton.setBounds(150,600,150,50);
		baButton.setBounds(350,600,150,50);
		logButton.setBounds(550,600,150,50);
		rButton.setBounds(720,600,150,50);
		
		nmText.setBounds(250,200,150,20);
		arText.setBounds(250,250,150,20);
		mnText.setBounds(250,300,150,20);
		eiText.setBounds(250,350,150,20);
		au.setBounds(250,400,150,20);
		cl.setBounds(250,450,150,20);
		
		tText.setBounds(800,200,150,20);
	    tfText.setBounds(800,250,150,20);
		de.setBounds(800,300,50,20);
		dem.setBounds(850,300,50,20);
		dey.setBounds(900,300,50,20);
		hn.setBounds(800,350,150,20);
		nr.setBounds(800,400,150,20);

		de.addActionListener(this);
		dem.addActionListener(this);
		dey.addActionListener(this);
		bkButton.addActionListener(this);
		baButton.addActionListener(this);
		logButton.addActionListener(this);
		
		add(tText);
		add(nmLabel);
		add(arLabel);
		add(mnLabel);
		add(eiLabel);
		add(tLabel);
		add(deLabel);
		add(tfLabel);
		add(auLabel);
		add(clLabel);
		add(btLabel);
		add(bkButton);
		add(baButton);
		add(logButton);
		add(rButton);
		add(au);
		add(de);
		add(dem);
		add(dey);
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
		
			PreparedStatement ps = con.prepareStatement("select hotel from east where name=?");
			ps.setString(1,dest);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				hn.addItem(rs.getString(1));
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
			East mp = new East(frame);
						
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
		else if(src==rButton){
			nmText.setText("");
			arText.setText("");
			mnText.setText("");
			eiText.setText("");
			tText.setText("");
			tfText.setText("");
		}
		else if(src==dem)
		{
			Object m=dem.getSelectedItem();
			if(m=="Feb"){
				de.removeItem("29");
				de.removeItem("30");
				de.removeItem("31");
				}
			else if(m=="Jan"||m=="Mar"||m=="May"||m=="Jul"||m=="Aug"||m=="Oct"||m=="Dec"){
				int x=de.getItemCount();
				if(x==28){
					de.addItem("29");
					de.addItem("30");
					de.addItem("31");
				}
				else if(x==30){
					de.addItem("31");
				}
				
			}
			else if(m=="Apr"||m=="Jun"||m=="Sep"||m=="Nov"){
				int y=de.getItemCount();
				if(y==28){
					de.addItem("29");
					de.addItem("30");
				}
				else if(y==31){
					de.removeItem("31");
				}
			}
		}
		else if(src==dey){
			Object m2=dey.getSelectedItem();
			Object m3=dem.getSelectedItem();
			if((m2=="2012"||m2=="2016") && m3=="Feb"){
				int y2=de.getItemCount();
				if(y2==28){
					de.addItem("29");
				}
			}
			else if((m2!="2012"||m2!="2016") && m3=="Feb"){
				int y2=de.getItemCount();
				if(y2==29){
					de.removeItem("29");
				}
			}
		}
		else if(src==bkButton){
		
			String name = nmText.getText();
			String address = arText.getText();
			String phNo = mnText.getText();
			String email = eiText.getText();
			Object adult1 = au.getSelectedItem();
			String adult = adult1.toString();
			Object child1 = cl.getSelectedItem();
			String child = child1.toString();
			String tour = tText.getText();
			String city = tfText.getText();
			
			
			Object hotel1 = hn.getSelectedItem();
			String hotel = hotel1.toString();
			Object r1 = nr.getSelectedItem();
			Integer r2 = new Integer(r1.toString());
			int room = r2.intValue(); 
		
			int fare=0,amt=0;
			String y=null,c1=null;
			Object a1 =au.getSelectedItem();
			Integer a2 = new Integer(a1.toString());
			int a = a2.intValue(); 
			Object b1 =cl.getSelectedItem();
			Integer b2 = new Integer(a1.toString());
			int b =b2.intValue();
			int error=0;
		
			try{
			
				OracleDriver driver = new OracleDriver();
				DriverManager.registerDriver(driver);
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:scott/tiger@localhost:1521/XE");
				System.out.println("Connection: " + con);
		
				PreparedStatement ps = con.prepareStatement("select fare from east where name=?");
				ps.setString(1,dest);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					fare =rs.getInt(1);
				}
				amt =(a+b/2)*fare;
				
				PreparedStatement ps1 = con.prepareStatement("select bookid.nextval from india");
				ResultSet rs1 = ps1.executeQuery();
				if(rs1.next())
				{
					y = String.valueOf(rs1.getInt(1));
				}
				
				Statement s = con.createStatement();
				ResultSet rs2 = s.executeQuery("select count(name) n from customer");
				rs2.next();
				int n = rs2.getInt("n");
				rs2.close();
				s.close();
				
				PreparedStatement ps2 = con.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps2.setString(1,y);
				ps2.setString(2,name);
				ps2.setString(3, address);
				ps2.setString(4, phNo);
				ps2.setString(5, email);
				ps2.setString(6, adult);
				ps2.setString(7, child);
				ps2.setString(8, tour);
				ps2.setString(9, city);
				
				ps2.setString(10, hotel);
				ps2.setInt(11, room);
				ps2.setInt(12, fare);
				ps2.setInt(13, amt);
				ps2.executeUpdate();
				con.commit();
				
			}
			catch (SQLException e) {
				System.out.println("SQL error");
				error=1;
			}
			
			c1= String.valueOf(amt);
			y="Booking id = "+y+"Total Amount = "+c1;
			if(error==0)
				JOptionPane.showMessageDialog(fr,y);
			else if(error==1)
				JOptionPane.showMessageDialog(fr,"Error");
		}
	}
}