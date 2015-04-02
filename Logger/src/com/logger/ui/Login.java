package com.logger.ui;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JPasswordField;

import com.logger.db.DbResult;
import com.logger.driver.XMLParser;
import com.logger.hash.HashComparator;
import com.logger.hash.HashGenerator;


@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("LogMe\r\n");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUserName.setBounds(45, 86, 73, 20);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(45, 139, 73, 20);
		contentPane.add(lblPassword);
		
		JLabel lblWeclomeToLogme = new JLabel("Weclome to LogMe!");
		lblWeclomeToLogme.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		lblWeclomeToLogme.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeclomeToLogme.setBounds(126, 11, 225, 28);
		contentPane.add(lblWeclomeToLogme);
		
		textField = new JTextField();
		textField.setBounds(166, 87, 116, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLogme = new JButton("LogMe\r\n");
		btnLogme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
				DbResult db = new DbResult();				
				String uname = textField.getText();
				db.setQuery ("select password from " +db.getTable()+ " where name =" +"'" + uname + "'" );
				db.executeMatchQuery();
				String strPassword = new String(passwordField.getPassword());
				HashGenerator hashGen = new HashGenerator(strPassword,"SHA-256", "UTF-8");
				String hash2Str= null;
				try {
					byte[] hash1 = hashGen.getHash();

					
					while(db.getRes().next()){
						hash2Str = db.getRes().getString("password");
					}
					HashComparator hashComp = new HashComparator(Arrays.toString(hash1), hash2Str);
				    boolean cond =	hashComp.compareHash();
					if(cond){ // login successful
						XMLParser xml = new XMLParser();
						xml.readFile();
						String packName = xml.getPack();
						String uiName = xml.getUi();					
						String fullName = packName + "." + uiName;
						Object obj = null;
						Class classDefinition = Class.forName(fullName);
				        try {
							obj = classDefinition.newInstance();
							((Window) obj).setVisible(true);
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					}
					else{
						LoginError le = new LoginError();
						le.setVisible(true);
					}
					db.getCon().close();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		btnLogme.setBounds(305, 193, 89, 23);
		contentPane.add(btnLogme);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(166, 140, 116, 20);
		contentPane.add(passwordField);
		
		JButton btnSignup = new JButton("SignUP");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signup su = new Signup();
				su.setVisible(true);
			}
		});
		btnSignup.setBounds(305, 237, 89, 23);
		contentPane.add(btnSignup);
		
		JLabel lblNotRegistered = new JLabel("Not registered?");
		lblNotRegistered.setBounds(206, 241, 102, 14);
		contentPane.add(lblNotRegistered);
	}
}
