import javax.swing.border.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.*;
import java.awt.event.*;

import java.net.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.*;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.*;

public class LogInPanel extends JPanel implements ActionListener {


	protected JTextField user = new JTextField(10);
	protected JPasswordField pwd = new JPasswordField(10);
	protected JButton ok = new JButton("OK");
	protected JButton cancel = new JButton("Cancel");
	protected static JFrame frame;
	
	public LogInPanel() {
		setLayout(new BorderLayout(20, 20));
		setBackground(Color.white);
		
		setBorder(new EmptyBorder(150, 150, 150, 150));
		
		JPanel west = new JPanel();
		JPanel central = new JPanel();
		JPanel south = new JPanel();
		JPanel north = new JPanel();
		JLabel hLabel = new JLabel("       WELCOME TO");
		JLabel h1Label = new JLabel("INDIAN TRAVEL AGENCY");
		JLabel uLabel = new JLabel("User name");
		JLabel pLabel = new JLabel("Password");
		
		add(BorderLayout.WEST, west);
		add(BorderLayout.CENTER, central);
		add(BorderLayout.SOUTH, south);
		add(BorderLayout.NORTH, north);
		
		hLabel.setFont(new Font("Segoe Script", Font.BOLD, 28));
		hLabel.setForeground(new Color(49, 176, 58));
		h1Label.setFont(new Font("Segoe Script", Font.BOLD, 28));
		h1Label.setForeground(new Color(49, 176, 58));
		Font fu = new Font("Segoe Script", Font.BOLD, 18);
		uLabel.setFont(fu);
		uLabel.setForeground(new Color(49, 176, 58));
		pLabel.setFont(fu);
		pLabel.setForeground(new Color(49, 176, 58));		
		
		north.setLayout(new GridLayout(2,1,0,10));
		north.setBackground(Color.white);
		north.add(hLabel);
		north.add(h1Label);
		
		west.setLayout(new GridLayout(2, 1, 0, 10));
		west.setBackground(Color.white);
		west.add(uLabel);
		west.add(pLabel);
		
		central.setLayout(new GridLayout(2, 1, 0, 10));
		central.setBackground(Color.white);
		central.add(user);
		central.add(pwd);
		
		south.setLayout(new FlowLayout());
		south.setBackground(Color.white);
		south.add(ok);
		south.add(cancel);
		
		ok.addActionListener(this);
		user.addActionListener(this);
		pwd.addActionListener(this);
		cancel.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == cancel)
			System.exit(0);

		String name = user.getText();
		String pw = new String(pwd.getPassword());		
		
		try {
		OracleDriver driver = new OracleDriver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:scott/tiger@localhost:1521/XE");
		System.out.println("Connection: " + con);
		
		String sql = "select * from user1 where uid1=? and pwd=?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, name);
		ps.setString(2, pw);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
		
			frame.dispose();
			frame = new JFrame("INDIA TOURISM");
			
			frame.setSize(1300,750);
			MainPanel mp = new MainPanel(frame);
						
			frame.setContentPane(mp);
			LogInPanel.frame.dispose();
			frame.setVisible(true);
		}
		else
			JOptionPane.showMessageDialog(this, "Invalid User name or password");
		Statement s = con.createStatement();		
		
		rs.close();
		ps.close();
		con.close();
		}
		catch (Exception ee) {
			System.err.println(ee.getMessage());
		}
	}

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		JFrame.setDefaultLookAndFeelDecorated(true);
		LogInPanel panel = new LogInPanel();
		frame = new JFrame("User login");
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter1());
		
		frame.setContentPane(panel);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	private static class WindowAdapter1 extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			int option = 0;

			option = JOptionPane.showConfirmDialog(frame, "Do u really want to close", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null);
			if (option == JOptionPane.YES_OPTION)
				System.exit(0);
		}		
	}
}