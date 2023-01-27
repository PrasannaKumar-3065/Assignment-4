package pk;
import java.util.*;
import java.util.logging.*;
/*"1. Design a class for a simple database connection pool. The class should have the following features:
    - A private constructor to prevent the class from being instantiated directly.
    - A static method that returns an instance of the class (following the singleton pattern).
    - A method that returns a new connection to the database.
    - A method that closes all open connections and releases them back to the pool.*/
class CONNECT{
    String con;
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    static CONNECT instance(String s){
        CONNECT c = new CONNECT(s);
        return c;
    }
    private CONNECT(String con){
        this.con = con;
        String s = ""+con;
        LOGGER.info(s);
    }
    void close() {
        this.con = "closed";
        LOGGER.info("Connection closed");
    }
}
public class App 
{
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        LOGGER.info("Enter connection: ");
        String s = sc.next();
        int n = 0;
        do{
            LOGGER.info("1.Change connection 2.close 3.exit");
            int m = sc.nextInt();
            if(m == 1){
                s = sc.next();
                LOGGER.info("Enter connection: ");
                CONNECT c = CONNECT.instance(s);
                String msg = "Connected "+c.con;
                LOGGER.info(msg);
            }
            else if(m == 2){
                CONNECT c = CONNECT.instance(s);
                c.close();
            }
            else{
                n = 1;
            }
        }while(n == 0);
    }
}
