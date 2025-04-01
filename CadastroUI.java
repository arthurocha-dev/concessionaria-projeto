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
import java.awt.GridLayout;
import java.text.ParseException;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import pacote.LoginUI;

public class CadastroUI extends JFrame {

	 private JTextField txtNome, txtEmail;

	    private JButton btnRegistrar;
	    private JTextField textTelef;
	    private JTextField textEnder;
	    private JTextField textCPF;



	    public CadastroUI() {

	        setTitle("Cadastro de Usuário");

	        setSize(455, 360);

	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        setLocationRelativeTo(null);
	        getContentPane().setLayout(null);



	        JLabel label = new JLabel("Nome:");
	        label.setBounds(38, 4, 39, 29);
	        getContentPane().add(label);

	        txtNome = new JTextField();
	        txtNome.setBounds(87, 8, 187, 20);

	        getContentPane().add(txtNome);



	        JLabel label_1 = new JLabel("Email:");
	        label_1.setBounds(48, 32, 39, 29);
	        getContentPane().add(label_1);

	        txtEmail = new JTextField();
	        txtEmail.setBounds(87, 35, 187, 22);

	        getContentPane().add(txtEmail);



	        btnRegistrar = new JButton("Registrar Usuário");
	        btnRegistrar.setBounds(242, 265, 187, 45);

	        getContentPane().add(btnRegistrar);



	        JLabel label_3 = new JLabel("");
	        label_3.setBounds(87, 153, 187, 45);
	        getContentPane().add(label_3); // Espaçamento na grade
	        
	        JLabel lblNewLabel = new JLabel("CPF:");
	        lblNewLabel.setBounds(48, 72, 39, 14);
	        getContentPane().add(lblNewLabel);
	        
	        JLabel lblNewLabel_1 = new JLabel("Telefone:");
	        lblNewLabel_1.setBounds(37, 100, 50, 14);
	        getContentPane().add(lblNewLabel_1);
	        
	        JLabel lblNewLabel_2 = new JLabel("Endereco:");
	        lblNewLabel_2.setBounds(37, 125, 50, 14);
	        getContentPane().add(lblNewLabel_2);
	        
	        textTelef = new JTextField();
	        textTelef.setBounds(87, 97, 187, 20);
	        getContentPane().add(textTelef);
	        textTelef.setColumns(10);
	        
	        textEnder = new JTextField();
	        textEnder.setBounds(87, 122, 187, 20);
	        getContentPane().add(textEnder);
	        textEnder.setColumns(10);
	        
	        textCPF = new JTextField();
	        textCPF.setBounds(87, 69, 187, 20);
	        getContentPane().add(textCPF);
	        textCPF.setColumns(10);



	        btnRegistrar.addActionListener(new ActionListener() {

	            @Override

	            public void actionPerformed(ActionEvent e) {

	                registrarUsuario();

	            }

	        });



	        setVisible(true);

	    }



	    private void registrarUsuario() {

	        String nome = txtNome.getText().trim();

	        String email = txtEmail.getText().trim();
	        
	        String CPF = textCPF.getText().trim();
	        
	        int telefone = Integer.parseInt(textTelef.getText().trim());
	        
	        String endereco = textEnder.getText().trim();

	        



	        // Verificação de campos vazios

	        if (nome.isEmpty() || email.isEmpty() || CPF.isEmpty() || telefone == 0 || endereco.isEmpty()) {

	            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);

	            return;

	        }



	        // Validação do formato do e-mail

	        if (!isValidEmail(email)) {

	            JOptionPane.showMessageDialog(this, "Por favor, insira um e-mail no formato correto.", "Erro", JOptionPane.ERROR_MESSAGE);

	            return;

	        }



	        // Registro do usuário

	        Cadastro cadastro = new Cadastro();

	        boolean sucesso = cadastro.registerCliente(nome, email, CPF, telefone, endereco);



	        if (sucesso) {

	            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");

	            txtNome.setText("");

	            txtEmail.setText("");

	            textCPF.setText("");
	            
	            textTelef.setText("");
	            
	            textEnder.setText("");

	        } else {

	            JOptionPane.showMessageDialog(this,

	                "Falha ao cadastrar o usuário. Verifique se a conta já existe ou tente novamente.",

	                "Erro",

	                JOptionPane.ERROR_MESSAGE

	            );

	        }

	    }


	    private boolean isValidEmail(String email) {

	        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

	        return Pattern.matches(emailRegex, email);

	    }
	    
	    public static boolean verificarUsuario(String nome, String cpf) {
	        String sql = "SELECT * FROM usuarios WHERE nome = ? AND cpf = ?"; 
	        
	        try (Connection conn = ConectionUI.connect();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, nome);
	            stmt.setString(2, cpf);
	            
	            ResultSet rs = stmt.executeQuery();

	            return rs.next(); // Retorna `true` se encontrou o usuário, `false` caso contrário.
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	



	    public static void main(String[] args) {

	        new CadastroUI();

	    }
}









