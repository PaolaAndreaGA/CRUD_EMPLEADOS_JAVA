package sistema.empleadosDAL;
import java.sql.*;

public class conexion {
    String strConexionDB = "jdbc:sqlite:C:/Users/tinys/OneDrive/AppData/Escritorio/proyectoJDBC/sistema.db"; // VARIABLE PARA CX CON BD
    Connection conn = null;
    // try - catch establece conexion o genera eeror cuando hay inconveniente
    
    public conexion (){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConexionDB);
            System.out.println("Conexion estrablecida");
        }
        
        catch (Exception e){
            System.out.println("Error en la conexion" + e);
        }
    }
    
    public int ejecutarSentenciaSQL(String strSentenciaSQL){
        try{
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        }
        catch (Exception e){
            System.out.println(e);   
            return 0;
        }
    }
    
    public ResultSet consultarRegistros(String strSentenciaSQL){
        try{
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        }
        catch (Exception e){
            System.out.println(e);   
            return null;
        }
    }
    
    
}
