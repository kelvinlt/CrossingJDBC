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
        System.out.println("Conectado con la base datos...");
        System.out.println("----------------------------------");
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
            System.out.println("Desconectado de la base datos...");
        }
    }

    public void insertarUser(User u) throws SQLException {
        String insert = "insert into user values(?,?,?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, u.getUsername());
        ps.setString(2, u.getPassword());
        ps.setInt(3, 100);
        ps.setInt(4, 0);
        ps.setString(5, u.getPlace());
        ps.setInt(6, 0);
        ps.executeUpdate();
        ps.close();
        System.out.println("----------------------------------");
    }

    public List<User> selectAllUser() throws SQLException {
        List<User> users = new ArrayList<>();
        String select = "select * from user";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        while (rs.next()) {
            User u = new User();
            u.setUsername(rs.getString("username"));
            users.add(u);
        }
        return users;
    }

    public void selectOneUser(String searchName) throws SQLException {
        User userReturn = new User();
        
        String select = "select * from user where username='"  + searchName+"'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);

        System.out.println("Buscando usuario: "+searchName);
        while (rs.next()) {
            System.out.println("Username: "+rs.getString("username"));
            System.out.println("Password: "+rs.getString("password"));
            System.out.println("Level: "+rs.getInt("level"));
            System.out.println("Points: "+rs.getInt("points"));
            System.out.println("Stucoins: "+rs.getInt("stucoins"));
            System.out.println("Place: "+rs.getString("place"));
            System.out.println("----------------------------------");
        }
    }

    public boolean checkUser(String username) throws SQLException {
        boolean check = false;
        List<User> users = new ArrayList<>();
        String select = "select * from user";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        while (rs.next()) {
            User u = new User();
            u.setUsername(rs.getString("username"));
            if (username.equals(u.getUsername())) {
                check = true;
                System.out.println("-El usuario " + username + " ya existe");
                System.out.println("----------------------------------");
            }
        }
        return check;
    }

    public List<Character> selectAllCharacter() throws SQLException {
        List<Character> characters = new ArrayList<>();
        String select = "select * from character";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        while (rs.next()) {
            Character c = new Character();
            characters.add(c);
        }
        return characters;
    }
    
        public void insertarCharacter(Character c) throws SQLException {
        String insert = "insert into stucomcrossing.character values(?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, c.getName());
        ps.setString(2, c.getStudy());
        ps.setString(3, c.getPlace());
        ps.setString(4, c.getPreference());
        ps.executeUpdate();
        ps.close();
        System.out.println("----------------------------------");
    }
        
    public boolean checkCharacter(String name) throws SQLException {
        boolean check = false;
        List<Character> characters = new ArrayList<>();
        String select = "select * from stucomcrossing.character";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        while (rs.next()) {
            Character c = new Character();
            c.setName(rs.getString("name"));
            if (name.equals(c.getName())) {
                check = true;
                System.out.println("-El personaje " + name + " ya existe");
                System.out.println("----------------------------------");
            }
        }
        return check;
    }    
    

    public List<Item> selectAllItem() throws SQLException {
        List<Item> items = new ArrayList<>();
        String select = "select * from item";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        while (rs.next()) {
            Item i = new Item();
            items.add(i);
        }
        return items;
    }

    public List<Contact> selectAllContact() throws SQLException {
        List<Contact> contacts = new ArrayList<>();
        String select = "select * from contact";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        while (rs.next()) {
            Contact c = new Contact();
            contacts.add(c);
        }
        return contacts;
    }

    public List<Inventory> selectAllInventory() throws SQLException {
        List<Inventory> inventories = new ArrayList<>();
        String select = "select * from inventory";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        while (rs.next()) {
            Inventory i = new Inventory();
            inventories.add(i);
        }
        return inventories;
    }

}
