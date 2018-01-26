package dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import obj.User;
import obj.Character;
import obj.Item;
import obj.Contact;
import obj.Inventory;

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
        String select= "select * from user";
        Statement st=conexion.createStatement();
        ResultSet rs=st.executeQuery(select);
        while(rs.next()){
         User u= new User();
         users.add(u);
        }
        return users;
    }
    
    public List<Character> selectAllCharacter() throws SQLException {
        List<Character> characters = new ArrayList<>();
        String select="select * from character";
        Statement st=conexion.createStatement();
        ResultSet rs=st.executeQuery(select);
        while(rs.next()){
            Character c=new Character();
            characters.add(c);
        }
        return characters;
    }
    
    public List<Item> selectAllItem() throws SQLException {
        List<Item> items = new ArrayList<>();
        String select="select * from item";
        Statement st=conexion.createStatement();
        ResultSet rs=st.executeQuery(select);
        while(rs.next()){
            Item i=new Item();
            items.add(i);
        }
        return items;
    }
    
    public List<Contact> selectAllContact() throws SQLException {
        List<Contact> contacts = new ArrayList<>();
        String select="select * from contact";
        Statement st=conexion.createStatement();
        ResultSet rs=st.executeQuery(select);
        while(rs.next()){
            Contact c=new Contact();
            contacts.add(c);
        }
        return contacts;
    }
    
    public List<Inventory> selectAllInventory() throws SQLException {
        List<Inventory> inventories = new ArrayList<>();
        String select="select * from inventory";
        Statement st=conexion.createStatement();
        ResultSet rs=st.executeQuery(select);
        while(rs.next()){
            Inventory i=new Inventory();
            inventories.add(i);
        }
        return inventories;
    }
    
    
}
