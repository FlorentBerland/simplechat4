package ui.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import common.AdaptedObservable;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener, KeyListener {
	
	String name, host;
	int clPort, svPort;
	
	JTextField TXT_nameBox;
	JButton BT_login;
	JButton BT_cancel;
	JButton BT_avatar;
	Observable obs;
	
	public Login(Observer obs)
	{
		this.obs = new AdaptedObservable(obs);
		build();
	}

	public Login(Observer obs, String name, String host, int clPort, int svPort) {
		this.obs = new AdaptedObservable(obs);
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
		this.setPreferredSize(new Dimension(600,200));
		
		JLabel LBL_title = new JLabel();
		JLabel LBL_presentation = new JLabel();
		JLabel LBL_wru = new JLabel("Who are you?");
		JPanel PAN_title = new JPanel(new FlowLayout());
		JPanel PAN_center = new JPanel(new BorderLayout());
		JPanel PAN_center_south = new JPanel(new BorderLayout());
		JPanel PAN_south = new JPanel(new FlowLayout());
		
		TXT_nameBox = new JTextField();
		TXT_nameBox.addKeyListener(this);
		
		BT_login = new JButton("Login");
		BT_login.setForeground(Color.white);
		BT_login.setBackground(new Color(150,150,255));
		BT_login.addActionListener(this);
		
		BT_cancel = new JButton("Cancel");
		BT_cancel.setForeground(Color.white);
		BT_cancel.setBackground(new Color(255,150,150));
		BT_cancel.addActionListener(this);
		
		
		//BT_avatar = new JButton("Choose an avatar");
		//BT_avatar.addActionListener(this);
		
		LBL_title.setText("<html><h1><font size=+2 color=#6495ED>SimpleChat 4</font></h1></html>");
		LBL_presentation.setText("<html><p>Welcome User ! You're going to use one of the MOST IMPRESSIVE APP NEVER CODED SimpleChat ! You will be able to discuss with a lot of people.</p><br/></html>");
		TXT_nameBox.grabFocus();
		
		PAN_title.add(LBL_title);
		PAN_center_south.add(LBL_wru, BorderLayout.WEST);
		PAN_center_south.add(TXT_nameBox);
		PAN_center.add(LBL_presentation, BorderLayout.NORTH);
		PAN_center.add(PAN_center_south, BorderLayout.SOUTH);
		PAN_south.add(BT_login);
		PAN_south.add(BT_cancel);
		this.add(PAN_title, BorderLayout.NORTH);
		//this.add(BT_avatar, BorderLayout.WEST);
		this.add(PAN_center, BorderLayout.CENTER);
		this.add(PAN_south, BorderLayout.SOUTH);
		
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public String getName() {
		return TXT_nameBox.getText();
	}

	public void setName(String name) {
		TXT_nameBox.setText(name);
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
			this.setVisible(false);
			obs.notifyObservers();
		}
	//	else if(arg0.getSource() == BT_avatar)
	//	{
			
	//	}
		else if(arg0.getSource() == BT_cancel)
		{
			System.exit(0);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
		{
			this.setVisible(false);
			obs.notifyObservers();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
