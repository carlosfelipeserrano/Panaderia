/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import com.mysql.cj.jdbc.CallableStatement;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import vistas.DatosCliente;

/**
 *
 * @author carlo
 */
public class Consulta extends ConexionBD {

    public boolean registrarUsuarios(Usuarios usr) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO usuarios (rut, nombre, apellido, correo, direccion, usuario, contrasena, idtipo ) VALUES (?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getRut());
            ps.setString(2, usr.getNombre());
            ps.setString(3, usr.getApellido());
            ps.setString(4, usr.getCorreo());
            ps.setString(5, usr.getDireccion());
            ps.setString(6, usr.getUsuario());
            ps.setString(7, usr.getContrasena());
            ps.setInt(8, usr.getIdtipo());

            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;

    }

    public boolean usuarioExiste(String rut) {
        ConexionBD db = new ConexionBD();

        String query = "SELECT * FROM usuarios WHERE usuarios.rut = ?";
        Connection conexion = db.getConexion();
        try {
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, rut);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, " El usuario con el " + rut + " se encunetra registrado ");

                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean login(Usuarios usr) {
        try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement("SELECT u.idusuario, u.rut, u.nombre, u.apellido, u.usuario, u.contrasena, u.idtipo, t.tipo FROM usuarios AS u INNER JOIN tipo_usuario AS t ON u.idtipo = t.idtipo WHERE usuario = ?"); PreparedStatement updatePs = con.prepareStatement("UPDATE usuarios SET ultima_sesion = ? WHERE idusuario = ?")) {

            ps.setString(1, usr.getUsuario());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String dbPassword = rs.getString("contrasena");
                    if (usr.getContrasena().equals(dbPassword)) {
                        updatePs.setString(1, usr.getUltima_sesion());
                        updatePs.setInt(2, rs.getInt(1));
                        updatePs.execute();

                        usr.setId(rs.getInt(1));
                        usr.setNombre(rs.getString(3));
                        usr.setIdtipo(rs.getInt(7));
                        usr.setTipo(rs.getString(8));

                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        } catch (SQLException e) {
            // Maneja la excepción apropiadamente, lanza una excepción personalizada o registra el error en un archivo de registro
            e.printStackTrace();
        }

        return false;
    }

    public boolean actualizardatos(Usuarios usr) {
        ConexionBD db = new ConexionBD();

        String query = "UPDATE usuarios SET usuario = ?, contrasena = ? WHERE idusuario = 1;";
        Connection conexion = db.getConexion();
        try {
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, usr.getUsuario());
            pstmt.setString(2, usr.getContrasena());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean actualizardatosadmin(Usuarios usr) {
        ConexionBD db = new ConexionBD();

        String query = "UPDATE usuarios SET usuario = ?, contrasena = ? WHERE idusuario = 2;";
        Connection conexion = db.getConexion();
        try {
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, usr.getUsuario());
            pstmt.setString(2, usr.getContrasena());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Panes> getPanes() throws SQLException {
        ConexionBD db = new ConexionBD();
        Connection conexion = db.getConexion();
        Statement st;
        ResultSet rs;
        ArrayList<Panes> listaPanes = new ArrayList<>();

        try {
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT id, tipo FROM panes"); // Asegúrate de seleccionar también el campo "id"

            while (rs.next()) {
                Panes pan = new Panes();
                pan.setId(rs.getInt("id"));
                pan.setCategoria_pan(rs.getString("tipo"));
                listaPanes.add(pan);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprime la traza de errores para identificar posibles problemas
        }

        return listaPanes; // Devuelve la lista de panes poblada
    }

    public Panes getPrecio(String tipoPan) throws SQLException {
        ConexionBD db = new ConexionBD();
        Connection conexion = db.getConexion();
        Statement st;
        ResultSet rs;
        Panes pan = new Panes();

        try {
            st = conexion.createStatement();
            String query = "SELECT * FROM panes where tipo = '" + tipoPan + "'";
            rs = st.executeQuery(query);

            while (rs.next()) {

                pan.setId(rs.getInt("id"));
                pan.setCategoria_pan(rs.getString("tipo"));
                pan.setPrecio(rs.getString("precio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return pan;
    }

    public boolean actualizarPrecioPanes(String tipoPan, String nuevoPrecio) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE panes SET precio = ? WHERE tipo = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nuevoPrecio);
            ps.setString(2, tipoPan);

            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean registrarPan(Panes pan) throws SQLException {
        Connection con = getConexion();

        // Verificar si ya existe un pan con el mismo nombre
        String checkSql = "SELECT * FROM panes WHERE tipo = ?";
        try (PreparedStatement psCheck = con.prepareStatement(checkSql)) {
            psCheck.setString(1, pan.getCategoria_pan());
            ResultSet rs = psCheck.executeQuery();
            if (rs.next()) {
                return false; // Ya existe un pan con este nombre
            }
        }

        // Si no existe, insertarlo
        String sql = "INSERT INTO panes (tipo, precio) VALUES (?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, pan.getCategoria_pan());
            ps.setString(2, pan.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /*
public void agregarpanes() {
        ConexionBD db = new ConexionBD();
        Connection conexion = db.getConexion();
        Statement st;
        ResultSet rs;
        String sql = "insert into tipo, precio values (?,?);";
        try {
            st = conexion.createStatement();

        }
    }*/
    public boolean actualizarseguridad(Usuarios usr) {
        ConexionBD db = new ConexionBD();

        String query = "UPDATE seguridad SET contrasena = ? WHERE idSeguridad = 1;";
        Connection conexion = db.getConexion();
        try {
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, usr.getContrasena());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean validarCliente(String rut) {
        ConexionBD db = new ConexionBD();

        String query = "SELECT * FROM cliente WHERE rut = ?";
        Connection conexion = db.getConexion();
        try {
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, rut);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, " El Rut " + rut + " ya se encuentra registrado", "AVISO", JOptionPane.INFORMATION_MESSAGE);

                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean validarAdmin(String rut) {
        ConexionBD db = new ConexionBD();

        String query = "SELECT * FROM usuarios WHERE rut = ?";
        Connection conexion = db.getConexion();
        try {
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, rut);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, " El Rut " + rut + " ya se encuentra registrado", "AVISO", JOptionPane.INFORMATION_MESSAGE);

                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean validarEmpleado(String rut) {
        ConexionBD db = new ConexionBD();

        String query = "SELECT * FROM usuarios WHERE rut = ?";
        Connection conexion = db.getConexion();
        try {
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, rut);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, " El Rut " + rut + " ya se encuentra registrado", "AVISO", JOptionPane.INFORMATION_MESSAGE);

                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public DefaultTableModel mostrarAdministradores() {
        ConexionBD db = new ConexionBD();
        String[] nombresColumnas = {"Id", "Rut", "Nombre", "Apellidos", "Correo Electronico", "Dirección", "Usuario"};
        String[] registros = new String[7];
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String sql = "SELECT usuarios.idusuario, usuarios.rut, usuarios.nombre, usuarios.apellido, usuarios.correo, usuarios.direccion, usuarios.usuario FROM usuarios WHERE idtipo = 2;";

        PreparedStatement st = null;
        ResultSet rs = null;
        Connection conexion = db.getConexion();

        try {
            conexion = db.getConexion();
            st = conexion.prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                for (int i = 0; i < registros.length; i++) {
                    registros[i] = rs.getString(i + 1);
                }

                modelo.addRow(registros);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (st != null) {
                    st.close();
                }

                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
            }
        }

        return modelo;
    }

    public DefaultTableModel mostrarEmpleados() {
        ConexionBD db = new ConexionBD();
        String[] nombresColumnas = {"Id", "Rut", "Nombre", "Apellidos", "Correo Electronico", "Dirección", "Usuario"};
        String[] registros = new String[7];
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String sql = "SELECT idusuario, rut, nombre, apellido, correo,  direccion, usuario FROM usuarios where idtipo = 3";

        PreparedStatement st = null;
        ResultSet rs = null;
        Connection conexion = db.getConexion();

        try {
            conexion = db.getConexion();
            st = conexion.prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                for (int i = 0; i < registros.length; i++) {
                    registros[i] = rs.getString(i + 1);
                }

                modelo.addRow(registros);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (st != null) {
                    st.close();
                }

                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
            }
        }

        return modelo;
    }

    public DefaultTableModel mostrarPedido() {
        ConexionBD db = new ConexionBD();
        String[] nombresColumnas = {"Rut", "Nombre", "Apellidos", "Dirección", "Correo Electrónico", "Teléfono", "Fecha", "Kilogramos Comprados", "Precio Total"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        String sql = "SELECT cliente.rut, cliente.nombre, cliente.apellidos, cliente.dirección, cliente.correo, cliente.teléfono, pedido.fecha, pedido.kilos_totales, pedido.precio_total "
                + "FROM cliente INNER JOIN pedido ON cliente.idCliente = pedido.idCliente INNER JOIN panes ON pedido.idPanes = panes.id";

        try (Connection conexion = db.getConexion(); PreparedStatement st = conexion.prepareStatement(sql); ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                String[] registros = new String[nombresColumnas.length];
                for (int i = 0; i < nombresColumnas.length; i++) {
                    registros[i] = rs.getString(i + 1);
                }
                modelo.addRow(registros);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }

        return modelo;
    }

    public DefaultTableModel buscarPorClienteYFecha(String rut, Date fechaInicio, Date fechaFin) {
        ConexionBD db = new ConexionBD();

        String[] nombresColumnas = {"Rut", "Nombre", "Apellidos", "Dirección", "Correo Electronico", "Teléfono", "Fecha", "Hallulla (KG)", "Marraqueta (KG)", "Coliza (KG)", "Molde (KG)", "Amasado (KG)", "Kilos totales", "Precio total"};
        String[] registros = new String[14];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String sql = "SELECT c.rut, c.nombre, c.apellido, c.correo, c.direccion, c.telefono, co.id, co.fecha, "
                + "co.HallullaKG, co.MarraquetaKG, co.ColisaKG, co.AmasadoKG, co.MoldeKG, co.Kilos_totales, co.Precio_total "
                + "FROM cliente c "
                + "JOIN consumo co ON c.idCliente = co.idCliente "
                + "WHERE c.rut = ? AND co.fecha BETWEEN ? AND ?";

        PreparedStatement st = null;
        ResultSet rs = null;
        Connection conexion = db.getConexion();

        if (fechaInicio == null || fechaFin == null) {
            return new DefaultTableModel();
        }

        try {
            st = conexion.prepareStatement(sql);
            st.setString(1, rut);
            st.setDate(2, new java.sql.Date(fechaInicio.getTime()));
            st.setDate(3, new java.sql.Date(fechaFin.getTime()));
            rs = st.executeQuery();

            while (rs.next()) {
                for (int i = 0; i < registros.length; i++) {
                    registros[i] = rs.getString(i + 1);
                }

                modelo.addRow(registros);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (st != null) {
                    st.close();
                }

                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
            }
        }

        return modelo;
    }

    public DefaultTableModel buscarPorClienteYFecha(Date fechaInicio, Date fechaFin) {
        ConexionBD db = new ConexionBD();

        String[] nombresColumnas = {"Rut", "Nombre", "Apellidos", "Dirección", "Correo Electronico", "Teléfono", "Fecha", "Hallulla (KG)", "Marraqueta (KG)", "Coliza (KG)", "Molde (KG)", "Amasado (KG)", "Kilos totales", "Precio total"};
        String[] registros = new String[14];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String sql = "SELECT c.rut, c.nombre, c.apellido, c.correo, c.direccion, c.telefono, co.fecha, "
                + "co.HallullaKG, co.MarraquetaKG, co.ColisaKG, co.AmasadoKG, co.MoldeKG, co.Kilos_totales, co.Precio_total "
                + "FROM cliente c "
                + "JOIN consumo co ON c.idCliente = co.idCliente "
                + "WHERE co.fecha BETWEEN ? AND ?";

        PreparedStatement st = null;
        ResultSet rs = null;
        Connection conexion = db.getConexion();

        if (fechaInicio == null || fechaFin == null) {
            return new DefaultTableModel();
        }

        try {
            st = conexion.prepareStatement(sql);
            st.setDate(1, new java.sql.Date(fechaInicio.getTime()));
            st.setDate(2, new java.sql.Date(fechaFin.getTime()));
            rs = st.executeQuery();

            while (rs.next()) {
                for (int i = 0; i < registros.length; i++) {
                    registros[i] = rs.getString(i + 1);
                }

                modelo.addRow(registros);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (st != null) {
                    st.close();
                }

                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
            }
        }

        return modelo;
    }

    public DefaultTableModel RUT(int rut) {
        ConexionBD db = new ConexionBD();

        String[] nombresColumnas = {"Rut", "Nombre", "Apellidos", "Dirección", "Correo Electronico", "Teléfono"};
        String[] registros = new String[6];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        String sql = "SELECT c.rut, c.nombre, c.apellido, c.direccion, c.correo, c.telefono";

        PreparedStatement st = null;
        ResultSet rs = null;
        Connection conexion = db.getConexion();

        try {
            st = conexion.prepareStatement(sql);
            st.setInt(1, rut);

            rs = st.executeQuery();

            while (rs.next()) {
                for (int i = 0; i < registros.length; i++) {
                    registros[i] = rs.getString(i + 1);
                }

                modelo.addRow(registros);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (st != null) {
                    st.close();
                }

                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
            }
        }

        return modelo;
    }

    public DefaultTableModel Cliente() {
        ConexionBD db = new ConexionBD();

        String[] nombresColumnas = {"Id", "Rut", "Nombre", "Apellidos", "Correo Electronico", "Dirección", "Teléfono", "Estado"};
        String[] registros = new String[8];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String sql = "SELECT c.idCliente, c.rut, c.nombre, c.apellidos, c.correo, c.direccion, c.telefono, a.accion \n"
                + "FROM cliente c \n"
                + "JOIN accion a ON c.idAccion = a.idaccion ";

        PreparedStatement st = null;
        ResultSet rs = null;
        Connection conexion = db.getConexion();

        try {
            conexion = db.getConexion();
            st = conexion.prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                for (int i = 0; i < 7; i++) { // iterate from 0 to 6, since we're handling the 7th index separately
                    registros[i] = rs.getString(i + 1);
                }
                String estadoString = rs.getString(8); // get the 8th column
                if (estadoString == null) {
                    estadoString = "Estado desconocido"; // or any other default value
                }
                registros[7] = estadoString;

                modelo.addRow(registros);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (st != null) {
                    st.close();
                }

                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
            }
        }

        return modelo;
    }

    public DefaultTableModel Empleado() {
        ConexionBD db = new ConexionBD();

        String[] nombresColumnas = {"Rut", "Nombre", "Apellidos", "Correo Electronico", "Dirección"};
        String[] registros = new String[5];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String sql = "SELECT rut, nombre, apellido, correo, direccion FROM usuarios where idtipo = 3";

        PreparedStatement st = null;
        ResultSet rs = null;
        Connection conexion = db.getConexion();

        try {
            conexion = db.getConexion();
            st = conexion.prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                for (int i = 0; i < registros.length; i++) {
                    registros[i] = rs.getString(i + 1);
                }

                modelo.addRow(registros);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (st != null) {
                    st.close();
                }

                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
            }
        }

        return modelo;
    }

    public DefaultTableModel Administrador() {
        ConexionBD db = new ConexionBD();

        String[] nombresColumnas = {"Rut", "Nombre", "Apellidos", "Correo Electronico", "Dirección"};
        String[] registros = new String[5];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String sql = "SELECT rut, nombre, apellido, correo, direccion FROM usuarios where idtipo = 2";

        PreparedStatement st = null;
        ResultSet rs = null;
        Connection conexion = db.getConexion();

        try {
            conexion = db.getConexion();
            st = conexion.prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                for (int i = 0; i < registros.length; i++) {
                    registros[i] = rs.getString(i + 1);
                }

                modelo.addRow(registros);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (st != null) {
                    st.close();
                }

                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
            }
        }

        return modelo;
    }

    public void guardarCliente(String rut, String nombre, String apellido, String correo, String direccion, String telefono) throws java.sql.SQLException {
        ConexionBD db = new ConexionBD();
        String sql = "INSERT INTO cliente (rut, nombre, apellidos, correo, direccion, telefono, idAccion) VALUES ('" + rut + "', '" + nombre + "','" + apellido + "','" + correo + "','" + direccion + "','" + telefono + "', 1);";
        Statement st;
        Connection conexion = db.getConexion();
        try {
            st = conexion.createStatement();
            int rs = st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void EliminarClientes(int Hallulla) {
        ConexionBD db = new ConexionBD();
        int res = 0;

        String sql = "DELETE FROM consumos WHERE hallulla = " + Hallulla;
        Statement st;
        Connection conexion = db.getConexion();
        try {

            st = conexion.createStatement();
            int rs = st.executeUpdate(sql);
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado el Cliente correctamente");

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void exportarExcel(JTable t) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
                hoja.setDisplayGridlines(false);
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = (Row) hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(t.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 1;
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (t.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                        } else if (t.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                        } else {
                            celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                        }
                    }
                }
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
    }

    public int buscarut(JTextField Rut, JTextField nombre, JTextField apellido, JTextField correo, JTextField direccion, JTextField telefono) {

        int idCliente = -1;
        String consulta = "select idCliente, rut, nombre, apellidos, correo, direccion, telefono, idAccion from cliente where cliente.rut =(?) ";

        ConexionBD db = new ConexionBD();
        try {
            CallableStatement cs = (CallableStatement) db.getConexion().prepareCall(consulta);
            cs.setString(1, Rut.getText());
            cs.execute();

            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                int estado = rs.getInt("idAccion");
                if (estado == 2) {
                    JOptionPane.showMessageDialog(null, "El Cliente se encuentra Inactivo");
                    idCliente = rs.getInt("idCliente");
                    DatosCliente f1 = new DatosCliente();
                    f1.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Cliente encontrado");
                    Rut.setText(rs.getString("rut"));
                    nombre.setText(rs.getString("nombre"));
                    apellido.setText(rs.getString("apellidos"));
                    correo.setText(rs.getString("correo"));
                    direccion.setText(rs.getString("dirección"));
                    telefono.setText(rs.getString("teléfono"));

                }

            } else {
                JOptionPane.showMessageDialog(null, "El Rut ingresado no se encuentra registrado");
                DatosCliente f1 = new DatosCliente();
                f1.setVisible(true);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return idCliente;
    }

    public int buscarut1(JTextField Id, JTextField Rut, JTextField nombre, JTextField apellido, JTextField correo, JTextField direccion, JTextField telefono) {

        int idCliente = -1;
        String consulta = "select idCliente, rut, nombre, apellidos, correo, dirección, teléfono from cliente where cliente.rut =(?)";

        ConexionBD db = new ConexionBD();
        try {
            CallableStatement cs = (CallableStatement) db.getConexion().prepareCall(consulta);
            cs.setString(1, Rut.getText());
            cs.execute();

            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Cliente encontrado");
                Id.setText(rs.getString("idCliente"));

                Rut.setText(rs.getString("rut"));
                nombre.setText(rs.getString("nombre"));
                apellido.setText(rs.getString("apellidos"));
                correo.setText(rs.getString("correo"));
                direccion.setText(rs.getString("dirección"));
                telefono.setText(rs.getString("teléfono"));

                idCliente = rs.getInt("idCliente");
            } else {
                JOptionPane.showMessageDialog(null, "El Rut ingresado no se encuentra registrado");
                DatosCliente f1 = new DatosCliente();
                f1.setVisible(true);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return idCliente;
    }

    public DefaultTableModel mostrarClientes() {
        ConexionBD db = new ConexionBD();
        String[] nombresColumnas = {"Rut", "Nombre", "Apellidos", "Dirección", "Correo Electrónico", "Teléfono", "Fecha", "Pan Comprado", "Kilogramos Comprados", "Precio Total"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        String sql = "SELECT cliente.rut, cliente.nombre, cliente.apellidos, cliente.direccion, cliente.correo, cliente.telefono, pedido.fecha, panes.tipo, pedido.kilos_totales, pedido.precio_total "
                + "FROM cliente INNER JOIN pedido ON cliente.idCliente = pedido.idCliente INNER JOIN panes ON pedido.idPanes = panes.id";

        try (Connection conexion = db.getConexion(); PreparedStatement st = conexion.prepareStatement(sql); ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                String[] registros = new String[nombresColumnas.length];
                for (int i = 0; i < nombresColumnas.length; i++) {
                    registros[i] = rs.getString(i + 1);
                }
                modelo.addRow(registros);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }

        return modelo;
    }

    public Map<String, Double> obtenerPreciosPanes() {
        Map<String, Double> preciosPanes = new HashMap<>();
        ConexionBD db = new ConexionBD();
        String sql = "SELECT tipo, precio FROM panes";
        Connection conexion = db.getConexion();
        try {
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String tipo = rs.getString("tipo");
                double precio = rs.getDouble("precio");
                preciosPanes.put(tipo, precio);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return preciosPanes;
    }

    public boolean actualizarCliente(Cliente cl) {
        ConexionBD db = new ConexionBD();

        String query = "UPDATE cliente SET rut = ?, nombre = ?, apellidos = ?, correo = ?, direccion = ?, telefono = ?, idAccion = ? WHERE idCliente = ?;";
        try {
            Connection conexion = db.getConexion();

            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, cl.getRut());
            pstmt.setString(2, cl.getNombre());
            pstmt.setString(3, cl.getApellido());
            pstmt.setString(4, cl.getCorreo());
            pstmt.setString(5, cl.getDireccion());
            pstmt.setString(6, cl.getTelefono());
            pstmt.setInt(7, "habilitado".equals(cl.getEstado()) ? 1 : 2);
            pstmt.setInt(8, cl.getIdCliente());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                pstmt.close();
                conexion.close();
                return true;
            }
            pstmt.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void guardarPan(Date fecha, String kilos, String precio, int idCliente, int idPanes) throws java.sql.SQLException {
        ConexionBD db = new ConexionBD();
        String sql = "insert into pedido(fecha, kilos_totales, precio_total, idCliente, idPanes) values ( ?, ?, ?, ?, ?)";
        Connection conexion = db.getConexion();
        try {
            PreparedStatement pstmt = conexion.prepareStatement(sql);

            pstmt.setDate(1, new java.sql.Date(fecha.getTime()));
            pstmt.setString(2, kilos);
            pstmt.setString(3, precio);
            pstmt.setInt(4, idCliente);
            pstmt.setInt(5, idPanes);

            int rs = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean seguridad(String clave) throws SQLException {
        String sql = "SELECT * FROM seguridad WHERE contrasena = MD5(?)";

        try {
            Connection con = getConexion();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, clave);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String claveDB = rs.getString("contrasena");
                System.out.println("clave db: " + claveDB);

                return claveDB.equals(Hash.md5(clave));
            } else {
                return false; // No se encontraron registros en la consulta
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

}
