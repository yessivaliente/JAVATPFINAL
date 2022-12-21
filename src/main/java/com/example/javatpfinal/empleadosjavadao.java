package com.example.javatpfinal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class empleadosjavadao extends empleadosjava {
    private AdministradoDeConexiones AdministradorDeConexiones;

    public empleadosjavadao(int idPersona, String nombre, String apellido, int edad) {
        super();

    }

    /*metodos del crud*/
    public empleadosjavadao obtenerPorId_persona(int id) {
        String sql = "SELECT * FROM empleadosjavatest WHERE ID_PERSONA="+id;

        //Connection
        Connection con = AdministradorDeConexiones.getConnection();

        empleadosjavadao empleadosjavaFromDb = null;

        //Statement
        try {
            Statement st = con.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(sql);

            //VIENE UN SOLO REGISTRO!!!

            if(rs.next()) {//si existe, hay uno solo
                // rs > sacando los datos
                int id_persona = rs.getInt(1);//tomar la primer columna
                String Nombre = rs.getString(2);
                String Apellido = String.valueOf(rs.getInt(3));
                int Edad = rs.getInt(4);

                //campos crear un objeto????
                empleadosjavaFromDb = new empleadosjavadao(id_persona,Nombre,Apellido,Edad);
            }
        } catch (SQLException e) {
            // ERRORES
            e.printStackTrace();
        }
        return empleadosjavaFromDb;
    }


    /*metodos del crud*/
    public List<empleadosjava> listarempleadosjava() {
        String sql = "SELECT * FROM empleadosjava ";

        //Connection
        Connection con = AdministradorDeConexiones.getConnection();

        List<empleadosjava> list = new ArrayList<>();

        //Statement
        try {
            Statement st = con.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(sql);

            //VIENE UN SOLO REGISTRO!!!

            while(rs.next()) {//
                // rs > sacando los datos
                int id_persona = rs.getInt(1);//tomar la primer columna
                String Nombre = rs.getString(2);
                String Apellido = String.valueOf(rs.getInt(3));
                int Edad = rs.getInt(4);


                //campos crear un objeto????
                empleadosjavadao empleadosjavaFromDb = new empleadosjavadao(id_persona,Nombre,Apellido,Edad);

                //agrego a la lista
                list.add(empleadosjavaFromDb);
            }

            //cierro la conexion
            con.close();
        } catch (SQLException e) {
            // ERRORES
            e.printStackTrace();
        }
        return list;
    }

    /*crear un producto en la db*/
    public void crearProducto(String Nombre, int id_persona, String Apellido, int Edad) {

        Connection con = AdministradorDeConexiones.getConnection();

        if(con != null) {
            // insert en la db > SQL: INSERT INTO....
            String sql = "INSERT INTO empleadosjava(id_persona,Nombre,Apellido,Edad) ";

            String s = "	CURRENT_DATE,'" + Edad + "')";
            sql += String.format("VALUES('%d','%s','%snull", id_persona, Nombre, Apellido);

            //control de errores
            try {
                Statement st = con.createStatement();
                st.execute(sql);

                //cierre de conexion
                con.close();

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void actualizarempleadosjava(String id_persona, String Nombre, String Apellido, String Edad, DatabaseMetaData AdministradorDeConexiones) throws SQLException {
        Connection con = AdministradorDeConexiones.getConnection();
        if(con != null) {
            String sql = "UPDATE empleadosjava "
                    + " set id_persona='"+id_persona+"',"
                    + "Nombre ='"+Nombre+"'"
                    + "Apellido ='"+Apellido+"'"
                    + " WHERE Edad = '"+Edad+"'";

            try {
                Statement st = con.createStatement();
                st.executeUpdate(sql);

                con.close();

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*metodos del crud*/
    public List<empleadosjava> buscar(String clave) throws SQLException {
        String sql = "SELECT * FROM empeladosjava WHERE Nombre LIKE '%"+clave+"%' ";

        //Connection
        DatabaseMetaData AdministradorDeConexiones = null;
        Connection con = AdministradorDeConexiones.getConnection();

        List<empleadosjava> listado = new ArrayList<empleadosjava>();

        //Statement
        try {
            Statement st = con.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(sql);

            //VIENE UN SOLO REGISTRO!!!

            if(rs.next()) {//si existe, hay uno solo
                // rs > sacando los datos
                int id_persona = rs.getInt(1);//tomar la primer columna
                String Nombre = rs.getString(2);
                String Apellido = String.valueOf(rs.getInt(3));
                int Edad = rs.getInt(4);

                //campos crear un objeto????
                empleadosjavadao empleadosjavaFromDb = new empleadosjavadao(id_persona,Nombre,Apellido,Edad);

                listado.add(empleadosjavaFromDb);
            }
        } catch (SQLException e) {
            // ERRORES
            e.printStackTrace();
        }

        return listado;
    }
}

