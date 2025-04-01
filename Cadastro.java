package pacote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cadastro {

    private Connection connection;

 
    public Cadastro() {
        try {
            this.connection = ConectionUI.connect();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

 
    public Connection getConnection() {
        return connection;
    }

   
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

 
    public boolean registerCliente(String nome, String email, String CPF, int telefone, String endereco) {
        String sql = "INSERT INTO TUsuario (nome, email, CPF, telefone, endereco) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
         
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, CPF);
            stmt.setInt(4, telefone);
            stmt.setString(5, endereco);

         
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            if ("23505".equals(e.getSQLState())) {
                System.out.println("Erro: Já existe uma conta com esse nome ou e-mail!");
            } else {
                System.out.println("Erro ao registrar usuário: " + e.getMessage());
            }
            return false;
        }
    }}
