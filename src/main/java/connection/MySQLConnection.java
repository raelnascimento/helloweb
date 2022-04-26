package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Gerencia a conexão com o banco de dados. Possui as instruções necessarias para
 * conectar ao banco. 
 * @author devsys-a
 */
public class MySQLConnection {

    // Define string de conexão com o banco.
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://172.16.0.30:3306/ikn_dukemarket";
            
    private static final String USER = "israel";
    private static final String PASS = "21262805";
                       
    /**
     * Cria conexão com  o banco de dados MySQL
     * @author devsys-a
     */   

    public static Connection getConnection() {
        
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro na Conexão com o BD. Verifique!", ex);
        }  
        catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("NOVO CATH!", ex);
        }  
    }

    /**
     * Fecha a conexão com  o DB.
     * @param conn Connection a ser fechada.
     */
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Fecha a conexão com  o DB.
     * @param conn Conexão
     * @param stmt Statement
     */
    public static void closeConnection(Connection conn, PreparedStatement stmt) {
        closeConnection (conn);
        
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {
        closeConnection (conn, stmt);
        
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
