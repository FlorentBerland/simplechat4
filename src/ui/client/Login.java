package ui.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener {
	
	String name, host;
	int clPort, svPort;
	
	JTextField TXT_nameBox;
	JButton BT_login;
	JButton BT_cancel;
	JButton BT_avatar;
	
	public Login()
	{
		build();
	}

	public Login(String name, String host, int clPort, int svPort) {
		this.name = name;
		this.host = host;
		this.clPort = clPort;
		this.svPort = svPort;
		build();
	}
	
	private void build()
	{
		this.setTitle("simplechat4");
		this.setLayout(new BorderLayout());
		
		JLabel LBL_title = new JLabel();
		JLabel LBL_presentation = new JLabel();
		JLabel LBL_wru = new JLabel("Who are you?");
		JPanel PAN_center = new JPanel(new GridLayout());
		JPanel PAN_south = new JPanel(new FlowLayout());
		JTextField TXT_nameBox = new JTextField();
		
		BT_login = new JButton("Login");
		BT_login.setForeground(Color.white);
		BT_login.setBackground(new Color(150,150,255));
		BT_login.addActionListener(this);
		
		BT_cancel = new JButton("Cancel");
		BT_cancel.setForeground(Color.white);
		BT_cancel.setBackground(new Color(255,150,150));
		BT_cancel.addActionListener(this);
		
		BT_avatar = new JButton("Choose an avatar");
		BT_avatar.addActionListener(this);
		
		LBL_title.setText("<html><h1><font size=-1 color=grey>Simple</font><i><font color=blue>chat</font></i><font size=-1 color=grey>4</font></h1></html>");
		TXT_nameBox.grabFocus();
		
		
		PAN_center.add(LBL_presentation);
		PAN_center.add(LBL_wru);
		PAN_center.add(TXT_nameBox);
		PAN_south.add(BT_login);
		PAN_south.add(BT_cancel);
		this.add(LBL_title, BorderLayout.NORTH);
		this.add(BT_avatar, BorderLayout.WEST);
		this.add(PAN_center, BorderLayout.CENTER);
		this.add(PAN_south, BorderLayout.SOUTH);
		
		this.pack();
		this.setVisible(true);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getClPort() {
		return clPort;
	}

	public void setClPort(int clPort) {
		this.clPort = clPort;
	}

	public int getSvPort() {
		return svPort;
	}

	public void setSvPort(int svPort) {
		this.svPort = svPort;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == BT_login)
		{
			
		}
		else if(arg0.getSource() == BT_avatar)
		{
			
		}
		else if(arg0.getSource() == BT_cancel)
		{
			System.exit(0);
		}
	}
	
	
}
