package crossingjdbc;
import dao.CrossingDao;
import java.util.ArrayList;
import java.util.List;
import obj.User;
import obj.Character;
import obj.Item;

public class CrossingJDBC {

    public static void main(String[] args) {
        CrossingDao crossingDao = new CrossingDao();
        List<User> users = new ArrayList<>();
        try {
            //iniciar conexion con base de datos
            crossingDao.conectar();
            
            System.out.println("");//(1)creacion de un usuario y insercion con chekeo si ya esta introducido
            User kelvin= new User("kelvin", "123", 0, 0, "barcelona", 0);
            System.out.println("Insertando usuario "+kelvin.getUsername()+"...");
            if(crossingDao.checkUser(kelvin.getUsername()) == false){
                crossingDao.insertarUser(kelvin);
            }else{
                System.out.println("No se ha insertado");
            };
            linea();
            //(1)creacion de un usuario y insercion con chekeo si ya esta introducido
            User saiden= new User("saiden", "123", 0, 0, "barcelona", 0);
            System.out.println("Insertando usuario "+saiden.getUsername()+"...");
            if(crossingDao.checkUser(saiden.getUsername()) == false){
                crossingDao.insertarUser(saiden);
            };
            linea();
             //(2)select de un usuario a partir de username(nombre) y impresion de todos sus datos
            crossingDao.selectOneUser("kelvin"); 
            
            //(3)creacion de un personaje y insercion con chekeo si ya esta introducido
            Character nameless = new Character("emiya","daw","tejado","sofa");
            System.out.println("Insertando personaje " + nameless.getName()+ " a la base datos...");
            if(crossingDao.checkCharacter(nameless.getName()) == false){
                crossingDao.insertarCharacter(nameless);
            };
            linea();
            Character npc1 = new Character("npc1","dam","barcelona","juego");
            System.out.println("Insertando personaje " + npc1.getName()+ " a la base datos...");
            if(crossingDao.checkCharacter(npc1.getName()) == false){
                crossingDao.insertarCharacter(npc1);
            };
            linea();
            Character npc2 = new Character("npc2","asix","barcelona","lapiz");
            System.out.println("Insertando personaje " + npc2.getName()+ " a la base datos...");
            if(crossingDao.checkCharacter(npc2.getName()) == false){
                crossingDao.insertarCharacter(npc2);
            };
            linea();
            //(4)creacion de un item y insercion con chekeo si ya esta introducido
            Item sofa = new Item("sofa", 1, 2, "mueble", "classico");
            System.out.println("Insertando item " + sofa.getName()+ " a la base datos...");
            if(crossingDao.checkItem(sofa.getName()) == false){
                crossingDao.insertarItem(sofa);
            };
            linea();
            //(5)ejemplo de login correcto
            crossingDao.login(kelvin);
            
            //(5)ejemplo de login erroneo
            User faker = new User("faker", "fake123");
            crossingDao.login(faker);
            
            //(6) ejemplo de update de username de un usuario
            crossingDao.updateUsername("kelvin", "kelvinew");
            //(7) ejeplo de update de lugar de un usuario
            crossingDao.updatePlaceUser("saiden", "casitanew");
            //(8) ejemplo de update de lugar de un personaje
            crossingDao.updatePlaceCharacter("emiya", "mansion");
            //(9) ejemplo de update de precio de un item
            crossingDao.updatePrecioItem("sofa", 12);
            
            //(10) ejemplo de obtener los personajes que estan en el mismo lugar que un usuario dado
            crossingDao.selectCharactersFromUserPlace("kelvin");
            
            //(11) 
            
            
            
//            users = crossingDao.selectAllUser();
//                System.out.println("Lista de usuarios en la base de datos:");
//                for(User user : users) {
//                    System.out.println("Username: "+user.getUsername());
//                }
//            linea();
            //cerrar conexion con base de datos
            crossingDao.desconectar();
            
            
            
        } catch (Exception e) {
        }
    }
    public static void linea(){
        System.out.println("----------------------------------");
    }
}
