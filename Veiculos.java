package pacote;
import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.SQLException;

public class Veiculos {

    private Connection connection;



  

    public Veiculos() {

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



  

    public boolean registerVeiculo(int idV, String marca, String modelo, int ano, float preco) {

        String sql = "INSERT INTO TMaquina (idM, Disponibilidade) VALUES (?, ?)";



        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
         

            stmt.setInt(1, idV);
            stmt.setString(2, marca);
            stmt.setString(3, modelo);
            stmt.setInt(4, ano);
            stmt.setFloat(5, preco);
            
            int rowsAffected = stmt.executeUpdate();



            return rowsAffected > 0; 

        } catch (SQLException e) {

            if ("23505".equals(e.getSQLState())) {

                System.out.println("Erro: Esse veículo ja foi criado");

            } else {

                System.out.println("Erro ao registrar o veículo: " + e.getMessage());

            }

            return false;

        }

    }
    }
