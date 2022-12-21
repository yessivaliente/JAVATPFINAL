package com.example.javatpfinal;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdministradoDeConexiones {

    public static Connection getConnection() {
		/*String url = "jdbc:mysql://127.0.0.1/negociojava&table=empleadosjava&pos=0";
		String username = "root";
		String password = "root";

		String driverName = "com.mysql.cj.jdbc.Driver";//mysql|postrges
		*/
        String url = System.getenv("DATASOURCE_URL");
        String user = System.getenv("DATASOURCE_USERNAME");
        String password = System.getenv("DATASOURCE_PASSWORD");
        String driverName = System.getenv("DATASOURCE_DRIVER");

        //control errores
        Connection con = null;
        try {
            Class.forName(driverName);//carga en memoria el Diver
            con = DriverManager.getConnection(url,user,password);
        }catch(Exception e) {
            e.printStackTrace();//se que paso lo o porque fallo.
        }
        return con;
    }

    public static void main(String[] args) throws SQLException {
        DatabaseMetaData AdministradorDeConexiones = null;
        Connection con = AdministradorDeConexiones.getConnection();//f5
        if(con != null) {
            System.out.println("Conexion ok");
        }else {
            System.err.println("Conexion fail");
        }
    }
}
