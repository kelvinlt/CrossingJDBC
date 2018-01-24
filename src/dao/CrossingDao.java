package dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import obj.User;

public class CrossingDao {

    private Connection conexion;

    public void conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/stucomcrossing";
        String user = "root";
        String pass = "";
        conexion = DriverManager.getConnection(url, user, pass);
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
    
    public void insertarUser(User u) throws SQLException {
        String insert = "insert into user values(?,?,?,?,?,?)";
        PreparedStatement ps=conexion.prepareStatement(insert);
        ps.setString(1, u.getUsername());
        ps.setString(2, u.getPassword());
        ps.setInt(3, 100);
        ps.setInt(4, 0);
        ps.setString(5, u.getPlace());
        ps.setInt(6, 0);
        ps.executeUpdate();
        ps.close();
    }
    
    public List<User> selectAllUser() throws SQLException {
        List<User> users = new ArrayList<>();
        
        return users;
    }
    
}
