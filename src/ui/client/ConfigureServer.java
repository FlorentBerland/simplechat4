package ui.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import common.AdaptedObservable;

@SuppressWarnings("serial")
public class ConfigureServer extends JFrame implements ActionListener, Observer {
	
	JButton BT_connect;
	JButton BT_cancel;
	JButton BT_return;
	JTextField TXT_ip;
	JTextField TXT_port;
	Observable obs;
	Login log;
	
	public ConfigureServer(Observer obs)
	{
		
		log = new Login(this);
		log.setVisible(true);
		
		this.obs = new AdaptedObservable(obs);
		this.setLayout(new BorderLayout());
		this.setTitle("simplechat4");
		
		JPanel PAN_south = new JPanel(new FlowLayout());
		JPanel PAN_center = new JPanel(new GridLayout(2,0));
		BT_connect = new JButton("Connect");
		BT_cancel = new JButton("Cancel");
		BT_return = new JButton("<< Return to login");
		TXT_ip = new JTextField("localhost");
		TXT_port = new JTextField("5555");
		
		BT_connect.setForeground(Color.white);
		BT_connect.setBackground(new Color(150,255,150));
		BT_connect.addActionListener(this);
		
		BT_cancel.setForeground(Color.white);
		BT_cancel.setBackground(new Color(255,150,150));
		BT_cancel.addActionListener(this);
		
		BT_return.setForeground(Color.white);
		BT_return.setBackground(new Color(255,230,150));
		BT_return.addActionListener(this);
		
		PAN_center.add(new JLabel("Server ip:"));
		PAN_center.add(TXT_ip);
		PAN_center.add(new JLabel("On port:"));
		PAN_center.add(TXT_port);
		PAN_south.add(BT_return);
		PAN_south.add(BT_connect);
		PAN_south.add(BT_cancel);
		this.add(new JLabel("<html><font size=+1><b>It is almost finished!</b></font>"
				+ "<p>Now choose a server to join your friends</p></html>"), BorderLayout.NORTH);
		this.add(PAN_center, BorderLayout.CENTER);
		this.add(PAN_south, BorderLayout.SOUTH);
		
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public String getIp(){ return TXT_ip.getText(); }
	public void setIp(String value){ TXT_ip.setText(value); }
	public int getPort(){ return Integer.parseInt(TXT_port.getText()); }
	public void setPort(int value){ TXT_port.setText(String.valueOf(value)); }
	public String getName(){ return log.getName(); }
	public void setName(String value){ log.setName(value); }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == BT_connect)
		{
			this.setVisible(false);
			obs.notifyObservers();
		}
		else if(arg0.getSource() == BT_return)
		{
			this.setVisible(false);
			log.setVisible(true);
			
		}
		else if(arg0.getSource() == BT_cancel)
		{
			System.exit(0);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.setVisible(true);
	}
}
