package pacote;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import pacote.LoginUI;

public class CadastroUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private  JTextField inputNome;
	private JTextField inputEndereco;
	private static String nomeUsuario;
	private static String telefoneUsuario;
	private static String cpfUsuario;
	private static String enederecoUsuario;
	private JFormattedTextField formattedCpf;
	private JFormattedTextField formattedTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUI frame = new CadastroUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public CadastroUI() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCadastro.setBounds(146, 0, 117, 30);
		contentPane.add(lblCadastro);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(71, 41, 86, 14);
		contentPane.add(lblNome);
		
		inputNome = new JTextField();
		inputNome.setBounds(71, 55, 253, 20);
		contentPane.add(inputNome);
		inputNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:\r\n");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setBounds(71, 77, 46, 33);
		contentPane.add(lblCpf);
		
		
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefone.setBounds(71, 129, 86, 14);
		contentPane.add(lblTelefone);
		
		
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  nomeUsuario = inputNome.getText();
			  telefoneUsuario = formattedTelefone.getText(); 
			  cpfUsuario = formattedCpf.getText();
			  enederecoUsuario = inputEndereco.getText();
			  
			  JOptionPane.showMessageDialog(null, "Cadastro realizado");
			  
			  LoginUI login = null;
			try {
				login = new LoginUI();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  login.setVisible(true);
			  dispose();
			  
			 
			}
		});
		btnNewButton.setBounds(163, 227, 92, 23);
		contentPane.add(btnNewButton);
		
		
		MaskFormatter mascaraNumero = new MaskFormatter ("############");
	    formattedTelefone = new JFormattedTextField(mascaraNumero);
		formattedTelefone.setBounds(71, 143, 253, 20);
		contentPane.add(formattedTelefone);
		//mascaraNumero.setValueContainsLiteralCharacters(false);
		
		
		MaskFormatter mascaraCpf = new MaskFormatter("************");
	    formattedCpf = new JFormattedTextField(mascaraCpf);
		formattedCpf.setBounds(71, 100, 253, 20);
		contentPane.add(formattedCpf);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndereco.setBounds(71, 174, 72, 14);
		contentPane.add(lblEndereco);
		
		inputEndereco = new JTextField();
		inputEndereco.setBounds(71, 187, 253, 20);
		contentPane.add(inputEndereco);
		inputEndereco.setColumns(10);
		
		
		
		
		
	}
	
	public static String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public static String getCpfUsuario() {
		return cpfUsuario;
	}
	
	public static String gettelefoneUsuario() {
		return telefoneUsuario;
		
	}
	
	public static String getEnderecoUsuario() {
		return  enederecoUsuario;
	}
	
}









