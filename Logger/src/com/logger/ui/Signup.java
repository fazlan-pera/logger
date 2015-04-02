package com.logger.ui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import com.logger.db.DbUpdate;
import com.logger.hash.HashGenerator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@SuppressWarnings("serial")
public class Signup extends JFrame {

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
					Signup frame = new Signup();
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
	public Signup() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(58, 75, 89, 14);
		contentPane.add(lblUserName);
		
		JLabel lblPassworf = new JLabel("Password");
		lblPassworf.setBounds(58, 114, 68, 14);
		contentPane.add(lblPassworf);
		
		textField = new JTextField();
		textField.setBounds(157, 72, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 111, 86, 20);
		contentPane.add(passwordField);
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DbUpdate db = new DbUpdate();
				String strPassword = new String(passwordField.getPassword());
				HashGenerator hg = new HashGenerator(strPassword, "SHA-256", "UTF-8");
				try {
					byte[] hash = hg.getHash();
					String password = Arrays.toString(hash);
					String query = "insert into "+db.getTable()+" (name,password)"+" VALUES("+"'"+textField.getText()+"'"+","+"'"+password+"'"+ ")";
					db.setQuery(query) ;
					db.executeUpdateQuery();
					SignupSuccessful ss = new SignupSuccessful();
					ss.setVisible(true);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				
			}
		});
		btnSignup.setBounds(286, 155, 89, 23);
		contentPane.add(btnSignup);
	}

}
