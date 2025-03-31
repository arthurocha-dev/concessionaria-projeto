package pacote;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

public class InterfaceConexao extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private JButton botaoConectar;
    private JLabel statusLabel;
    private static final String URL = "jdbc:postgresql://localhost:5432/Concessionaria";

    public InterfaceConexao() {
        setTitle("Conexão PostgreSQL");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        campoUsuario = new JTextField("");
        campoUsuario.setBounds(167, 0, 167, 40);
        campoSenha = new JPasswordField();
        campoSenha.setBounds(167, 40, 167, 40);
        botaoConectar = new JButton("Testar Conexão");
        botaoConectar.setBounds(84, 91, 167, 40);

        botaoConectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testarConexao();
            }
        });
        getContentPane().setLayout(null);

        JLabel label = new JLabel("Usuário:");
        label.setBounds(0, 0, 167, 40);
        getContentPane().add(label);
        getContentPane().add(campoUsuario);
        JLabel label_1 = new JLabel("Senha:");
        label_1.setBounds(0, 40, 167, 40);
        getContentPane().add(label_1);
        getContentPane().add(campoSenha);
        getContentPane().add(botaoConectar);

        setVisible(true);
    }
   

    private void testarConexao() {
        String usuario = campoUsuario.getText();
        String senha = new String(campoSenha.getPassword());

        try (Connection connection = DriverManager.getConnection(URL, usuario, senha)) {
            if (connection != null) {
                JOptionPane.showMessageDialog(this, "Conexão estabelecida!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfaceConexao());
        
    }

}
