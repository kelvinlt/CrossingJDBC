package crossingjdbc;
import dao.CrossingDao;

public class CrossingJDBC {

    public static void main(String[] args) {
        System.out.println("Conectado con la base datos...");
        CrossingDao crossingDao = new CrossingDao();
        try {
            //iniciar conexion con base de datos
            crossingDao.conectar();
        } catch (Exception e) {
        }
    }
    
}
