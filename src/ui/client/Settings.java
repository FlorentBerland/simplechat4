package ui.client;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import common.AdaptedObservable;

@SuppressWarnings("serial")
public class Settings extends JFrame implements ActionListener {

	JTextField TXT_name, TXT_host, TXT_port;
	JButton BT_ok, BT_cancel;
	Observable obs;
	
	public Settings(Observer obs)
	{
		this.obs = new AdaptedObservable(obs);
		this.setLayout(new BorderLayout());
		JPanel PAN_north = new JPanel(new FlowLayout());
		JPanel PAN_south = new JPanel(new FlowLayout());
		JPanel PAN_center = new JPanel(new GridLayout(0,2));
		JLabel LBL_title = new JLabel("<html><font size=+2 color=#6495ED>Settings</font></html>");
		TXT_name = new JTextField();
		TXT_host = new JTextField();
		TXT_port = new JTextField();
		BT_ok = new JButton("Ok");
		BT_cancel = new JButton("Cancel");
		
		PAN_center.add(new JLabel("Your name: "));
		PAN_center.add(TXT_name);
		PAN_center.add(new JLabel("Host:"));
		PAN_center.add(TXT_host);
		PAN_center.add(new JLabel("Port:"));
		PAN_center.add(TXT_port);
		
		BT_ok.setForeground(Color.white);
		BT_ok.setBackground(new Color(170,240,150));
		BT_ok.addActionListener(this);
		
		BT_cancel.setForeground(Color.white);
		BT_cancel.setBackground(new Color(240,150,150));
		BT_cancel.addActionListener(this);
		
		PAN_north.add(LBL_title);
		PAN_south.add(BT_ok);
		PAN_south.add(BT_cancel);
		this.add(PAN_north, BorderLayout.NORTH);
		this.add(PAN_center, BorderLayout.CENTER);
		this.add(PAN_south, BorderLayout.SOUTH);
		
		this.setPreferredSize(new Dimension(300, 170));
		this.pack();
	}
	
	public String getName(){ return TXT_name.getText(); }
	public String getHost(){ return TXT_host.getText(); }
	public String getPort(){ return TXT_port.getText(); }
	public void setName(String value){ TXT_name.setText(value); }
	public void setHost(String value){ TXT_host.setText(value); }
	public void setPort(String value){ TXT_port.setText(value); }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		obs.notifyObservers();
	}

}
