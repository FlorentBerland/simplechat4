import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import client.*;
import common.ChatIF;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

import ui.client.*;

@SuppressWarnings("serial")
public class ClientWindow extends JFrame implements ChatIF, ActionListener, Observer {

	public final static int DEFAULT_PORT = 5555;
	
	ChatClient client;
	
	JTextArea ta;
	JTextField tf;
	JButton envoyer;
	JButton deconnexion;
	JButton parametres;
	ConfigureServer conf;
	
	@SuppressWarnings("unused")
	public ClientWindow(String host, int port)
	{
		try 
		{
			client = new ChatClient(host, port, this);
		} 
		catch(IOException exception) 
		{
			System.out.println("Error: Can't setup connection!"
					+ " Terminating client.");
			System.exit(1);
		}
		
		conf = new ConfigureServer(this);

		this.setLayout(new BorderLayout());
		this.setTitle("simplechat4");
		
		JPanel autresPersonnes = new JPanel(new GridLayout(1,0));
		JPanel zoneChat = new JPanel(new BorderLayout());
		JPanel zonesControles = new JPanel(new FlowLayout());
		JPanel entreeTexte = new JPanel(new FlowLayout());
		tf = new JTextField();
		ta = new JTextArea();
		envoyer = new JButton();
		parametres = new JButton();
		deconnexion = new JButton();
		/*deconnexion = new JButton("<html><h1><i>Déconnexion</i></h1>"
				+ "<ul>"
				+ "<li color=blue>Déconnecte</li>"
				+ "<li color=red>Ferme la socket</li>"
				+ "<li color=yellow>Vous avertit de la déconnexion</li>"
				+ "</html>");*/
		
		tf.setPreferredSize(new Dimension(300,25));
		
		// Bouton envoyer
		envoyer.setForeground(Color.white);
		envoyer.setBorderPainted(false);
		envoyer.setIcon(new ImageIcon("envoyer.jpg"));
		//envoyer.setBackground(new Color(90,240,50));
		envoyer.setPreferredSize(new Dimension(envoyer.getIcon().getIconWidth(), envoyer.getIcon().getIconHeight()));
		envoyer.setCursor(new Cursor(Cursor.HAND_CURSOR));
		envoyer.addActionListener(this);
		
		// Bouton déconnexion
		deconnexion.setForeground(Color.white);
		deconnexion.setBorderPainted(false);
		deconnexion.setIcon(new ImageIcon("deconnexion.jpg"));
		deconnexion.setPreferredSize(new Dimension(deconnexion.getIcon().getIconWidth(), deconnexion.getIcon().getIconHeight()));
		//deconnexion.setBackground(new Color(255,100,80));
		deconnexion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		deconnexion.addActionListener(this);
		
		// Bouton paramètres
		parametres.setForeground(Color.white);
		parametres.setBorderPainted(false);
		parametres.setIcon(new ImageIcon("parametres.png"));
		parametres.setPreferredSize(new Dimension(parametres.getIcon().getIconWidth(), parametres.getIcon().getIconHeight()));
		//parametres.setBackground(new Color(210,190,30));
		parametres.setCursor(new Cursor(Cursor.HAND_CURSOR));
		parametres.addActionListener(this);
		
		// Zone de chat
		ta.setEnabled(false);
		ta.setBorder(new LineBorder(Color.lightGray));
		ta.setDisabledTextColor(Color.black);
		ta.setPreferredSize(new Dimension(300, 200));
		ta.setForeground(Color.black);
		
		// Tout ajouter dans la fenêtre
		entreeTexte.add(tf);
		entreeTexte.add(envoyer);
		zoneChat.add(entreeTexte, BorderLayout.SOUTH);
		zoneChat.add(ta, BorderLayout.CENTER);	
		zonesControles.add(parametres);
		zonesControles.add(deconnexion);
		this.add(autresPersonnes, BorderLayout.WEST);
		this.add(zoneChat, BorderLayout.CENTER);
		this.add(zonesControles, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		tf.grabFocus();
	}
	
	@Override
	public void display(String message) {
		ta.setText(ta.getText() + message + '\n');
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String host = "";
		try
		{
			host = args[0];
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			host = "localhost";
		}
		ClientWindow chat = new ClientWindow(host, DEFAULT_PORT);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == envoyer){
			if(!tf.getText().isEmpty()){
				client.handleMessageFromClientUI(tf.getText());
				tf.setText("");
			}
		} else if(arg0.getSource() == deconnexion){
			client.handleMessageFromClientUI("#logoff");
		} else if(arg0.getSource() == parametres){
			
		}
	}

	/*
	 * Is notified when ConfigureServer is modified
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		this.setVisible(true);
		client.handleMessageFromClientUI("#sethost " + conf.getIp());
		client.handleMessageFromClientUI("#setport " + conf.getPort());
		client.handleMessageFromClientUI("#login " + conf.getName());
	}
}
