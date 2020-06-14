package trabn2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {
		
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Otavio;user=otavio;password=exemplo456";

        String insertString = "INSERT INTO Pessoa (id, nome, idade) VALUES (?, ?, ?)";

        try (
        		Connection con = DriverManager.getConnection(connectionUrl); 
        		PreparedStatement stmt = con.prepareStatement(insertString);
        	) {
        	Pessoa p1 = new Pessoa(1, "Maria", 50);
        	
        	stmt.setInt(1, p1.getId());
        	stmt.setString(2, p1.getNome()); 
        	stmt.setInt(3, p1.getIdade()); 
        	
        	stmt.executeUpdate(); 
        	
        	Pessoa p2 = new Pessoa(2, "Lucia", 24);
        	
        	stmt.setInt(1, p2.getId());
        	stmt.setString(2, p2.getNome()); 
        	stmt.setInt(3, p2.getIdade()); 
        	
        	stmt.executeUpdate();

        } catch (SQLException e) {
        	e.printStackTrace();
        }
        
        
        try (
        		Connection con = DriverManager.getConnection(connectionUrl); 
        		Statement stmt = con.createStatement(); 
        	) {
        	
            String SQL = "SELECT * FROM Pessoa"; 
            ResultSet rs = stmt.executeQuery(SQL); 

           
            while (rs.next()) {
            	Pessoa p = new Pessoa(); 
            	p.setId(rs.getInt("id")); 
            	p.setNome(rs.getString("nome")); 
            	p.setIdade(rs.getInt("idade")); 

            	System.out.println(p); 
            }
        }
       
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        String updateString = "UPDATE Pessoa SET nome = ?, idade = ? WHERE id=?";
        
        // Tentativa de atualizar valor na tabela
        try (
        		Connection con = DriverManager.getConnection(connectionUrl); 
        		PreparedStatement stmt = con.prepareStatement(updateString);
        	) {
        	
        	Pessoa p1 = new Pessoa(1, "Mariano", 20); // a pessoa alterada
        	stmt.setString(1, p1.getNome()); // insira na primeira ? o nome da pessoa
        	stmt.setInt(2, p1.getIdade()); // insira na terceira ? a idade da pessoa
        	// insira na última ? o id da pessoa
        	stmt.setInt(3, p1.getId());	
        	
        	stmt.executeUpdate(); // executa o update
        	
        	System.out.println("Pessoa alterada!");
        	
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        
        String deleteString = "DELETE Pessoa WHERE id=?";
        
        // Tentativa de remover valor na tabela
        try (
        		Connection con = DriverManager.getConnection(connectionUrl); 
        		PreparedStatement stmt = con.prepareStatement(deleteString);
        	) {
        	
        	int personId = 2;
        	// insira na ? o id da pessoa
        	stmt.setInt(1, personId);
        	
        	stmt.executeUpdate(); // executa o delete
        	
        	System.out.println("Pessoa removida!");
        	
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        
        
        try (
                Connection con = DriverManager.getConnection(connectionUrl); 
                Statement stmt = con.createStatement(); 
            ) {
            
            String SQL = "SELECT * FROM Pessoa"; 
            ResultSet rs = stmt.executeQuery(SQL); 

           
            while (rs.next()) {
                Pessoa p = new Pessoa(); 
                p.setId(rs.getInt("id")); 
                p.setNome(rs.getString("nome")); 
                p.setIdade(rs.getInt("idade")); 

                System.out.println(p); 
            }
        }
       
        catch (SQLException e) {
            e.printStackTrace();
        }


        /* FUNÇÕES PARA CONTA */
        Pessoa p1 = new Pessoa(1, "Maria", 50);
        Conta c1 = new Conta(1, "Conta de Luz", p1.getId(), 100);

         insertString = "INSERT INTO Conta (id, idPagador, NomeConta, valor) VALUES (?, ?, ?, ?)";

        try (
                Connection con = DriverManager.getConnection(connectionUrl); 
                PreparedStatement stmt = con.prepareStatement(insertString);
            ) {

            stmt.setInt(1, c1.getId());
            stmt.setInt(2, c1.getIdPagador()); 
            stmt.setString(3, c1.getNomeConta()); 
            stmt.setInt(4, c1.getValor()); 
            
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        updateString = "UPDATE Conta SET id = ?, idPagador = ?, NomeConta = ?, valor = ? WHERE id = ?";

        // Tentativa de atualizar valor na tabela
        try (
                Connection con = DriverManager.getConnection(connectionUrl); 
                PreparedStatement stmt = con.prepareStatement(updateString);
            ) {

            stmt.setInt(1, c1.getId());
            stmt.setInt(2, c1.getIdPagador());
            stmt.setString(3, c1.getNomeConta()); 
            stmt.setInt(4, c1.getValor());
            stmt.setInt(5, p1.getId());

            stmt.executeUpdate();

            System.out.println("Conta alterada!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

         deleteString = "DELETE Conta WHERE id = ?";

        try (
                Connection con = DriverManager.getConnection(connectionUrl); 
                PreparedStatement stmt = con.prepareStatement(deleteString);
            ) {

            stmt.setInt(1, c1.getId());

            stmt.executeUpdate();

            System.out.println("Conta removida!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (
                Connection con = DriverManager.getConnection(connectionUrl); 
                Statement stmt = con.createStatement();
            ) {

            String SQL = "SELECT * FROM Conta";
            ResultSet rs = stmt.executeQuery(SQL); // executa o SELECT

            while (rs.next()) {
                Conta c = new Conta();
                c.setId(rs.getInt("id"));
                c.setIdPagador(rs.getInt("idPagador"));
                c.setNomeConta(rs.getString("NomeConta"));
                c.setValor(rs.getInt("valor"));
 
                System.out.println(c);
            }

        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        Pessoa p2= new Pessoa (1, "Roberto", 40);
        insertString = "INSERT INTO Conta (id, idPagador, NomeConta, valor) VALUES (?, ?, ?, ?)";

        try (
                Connection con = DriverManager.getConnection(connectionUrl); 
                PreparedStatement stmt = con.prepareStatement(insertString);
            ) {

            stmt.setInt(1, c1.getId());
            stmt.setInt(2, p2.getId()); 
            stmt.setString(3, c1.getNomeConta()); 
            stmt.setInt(4, c1.getValor()); 

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        try (
                Connection con = DriverManager.getConnection(connectionUrl); 
                Statement stmt = con.createStatement();
            ) {
        	
            String SQL = "SELECT c.*, p.nome FROM Conta c INNER JOIN Pessoa p ON p.Id = c.idPagador WHERE idPagador = ?";
            PreparedStatement stmt2 = con.prepareStatement(SQL);
            stmt2.setInt(1, p2.getId());
            ResultSet rs = stmt2.executeQuery();

            while (rs.next()) {
                Conta c = new Conta();
                c.setId(rs.getInt("id"));
                c.setNomeConta(rs.getString("NomeConta"));
                c.setValor(rs.getInt("valor"));

                System.out.println("Conta do Pagador: " + rs.getString("nome")); 
                System.out.println(c);
            }

        }

        catch (SQLException e) {
            e.printStackTrace();
        }


	}

}