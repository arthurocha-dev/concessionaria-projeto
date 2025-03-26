package pacote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FuncionarioUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFuncionario;
	private JPasswordField passwordF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionarioUI frame = new FuncionarioUI();
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
	public FuncionarioUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginFuncionario = new JLabel("Login Funcionário");
		lblLoginFuncionario.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLoginFuncionario.setBounds(99, 11, 246, 31);
		contentPane.add(lblLoginFuncionario);
		
		JLabel lblFuncionario = new JLabel("Funcionário:");
		lblFuncionario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFuncionario.setBounds(72, 78, 74, 14);
		contentPane.add(lblFuncionario);
		
		textFuncionario = new JTextField();
		textFuncionario.setBounds(72, 91, 246, 20);
		contentPane.add(textFuncionario);
		textFuncionario.setColumns(10);
		
		JLabel lblSenhaF = new JLabel("Senha:");
		lblSenhaF.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenhaF.setBounds(72, 137, 46, 14);
		contentPane.add(lblSenhaF);
		
		passwordF = new JPasswordField();
		passwordF.setBounds(72, 149, 246, 20);
		contentPane.add(passwordF);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFuncionario.getText().equals("Arthur Rocha") && new String (passwordF.getPassword()).equals("011974ac")) {
					JOptionPane.showMessageDialog(null, "Funcionário confirmado!");
					VeiculosUI arv = new VeiculosUI();
					arv.setVisible(true);
					dispose();
					
				}
				
			else if(textFuncionario.getText().equals("Thiago Victor") && new String (passwordF.getPassword()).equals("2411")) {
				VeiculosUI arv = new VeiculosUI();
				arv.setVisible(true);
				dispose();
				}
				
			else if(textFuncionario.getText().equals("Victor Natã") && new String (passwordF.getPassword()).equals("pedroteamo")){
				VeiculosUI arv = new VeiculosUI();
				arv.setVisible(true);
				dispose();
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Credenciais erradas! Tente novamente");
				}
				
				
			
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEntrar.setBounds(147, 201, 89, 23);
		contentPane.add(btnEntrar);
	}
}
