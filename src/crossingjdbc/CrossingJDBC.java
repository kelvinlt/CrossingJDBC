package crossingjdbc;
import dao.CrossingDao;
import java.util.ArrayList;
import java.util.List;
import obj.User;
import obj.Character;

public class CrossingJDBC {

    public static void main(String[] args) {
        CrossingDao crossingDao = new CrossingDao();
        List<User> users = new ArrayList<>();
        try {
            //iniciar conexion con base de datos
            crossingDao.conectar();
            
            User kelvin= new User("kelvin", "123", 0, 0, "Barcelona", 0);
            System.out.println("Insertando usuario "+kelvin.getUsername()+"...");
            if(crossingDao.checkUser(kelvin.getUsername()) == false){
                crossingDao.insertarUser(kelvin);
            };
            
            User saiden= new User("saiden", "123", 0, 0, "Barcelona", 0);
            System.out.println("Insertando usuario "+saiden.getUsername()+"...");
            if(crossingDao.checkUser(saiden.getUsername()) == false){
                crossingDao.insertarUser(saiden);
            };

            crossingDao.selectOneUser("kelvin"); 
            
            Character nameless = new Character("emiya","daw","tejado","flecha");
            System.out.println("Insertando personaje " + nameless.getName()+ " a la base datos...");
            if(crossingDao.checkCharacter(nameless.getName()) == false){
                crossingDao.insertarCharacter(nameless);
            };
            
            users = crossingDao.selectAllUser();
            System.out.println("Lista de usuarios en la base de datos:");
            for(User user : users) {
                System.out.println("Username: "+user.getUsername());
            }
            System.out.println("----------------------------------");
            
            //cerrar conexion con base de datos
            crossingDao.desconectar();
            
            
            
        } catch (Exception e) {
        }
    }
    
    public static void menu(){
        System.out.println("------------------------------------");
        System.out.println("1-Registrar nuevo usario");
        System.out.println("2-Buscar usuario apartir de un nombre");
        System.out.println("3-Registrar nuevo personaje");
        System.out.println("4-Registrar nuevo item");
        System.out.println("5-Login de usuario");
        System.out.println("");
        System.out.println("------------------------------------");
    }
    
}
