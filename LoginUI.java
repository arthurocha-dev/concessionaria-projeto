package pacote;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class LoginUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField inputNomeL;
	
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public LoginUI() throws ParseException {
		getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLogin.setBounds(161, 11, 97, 31);
		getContentPane().add(lblLogin);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(84, 65, 46, 14);
		getContentPane().add(lblNome);
		
		inputNomeL = new JTextField();
		inputNomeL.setBounds(84, 79, 218, 20);
		getContentPane().add(inputNomeL);
		inputNomeL.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setBounds(84, 120, 46, 14);
		getContentPane().add(lblCpf);
		
		
		MaskFormatter mascaraCpf = new MaskFormatter("************");
		JFormattedTextField formattedCpfL = new JFormattedTextField(mascaraCpf);
		formattedCpfL.setBounds(84, 132, 218, 20);
		getContentPane().add(formattedCpfL);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inputNomeL.getText().equals(CadastroUI.getNomeUsuario()) && new String(formattedCpfL.getText()).equals(CadastroUI.getCpfUsuario())) {
					JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
					Menu menu = new Menu();
					menu.setVisible(true);
					dispose();
					
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Error 1326! Nome ou CPF incorretos, tente novamente");
				}
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEntrar.setBounds(148, 206, 89, 23);
		getContentPane().add(btnEntrar);
	}

	/**
	 * Create the frame.
	 */
	
}