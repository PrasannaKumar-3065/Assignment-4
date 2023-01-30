package pk;
import java.util.*;
import java.util.logging.*;
class connect{
    String con;
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    static Object instance(String con){
        return new connect(con); 
    }
    private connect(String con){
        this.con = con;
        String s = con;
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
        LOGGER.info("Enter connection string: "); 
        String s = sc.next();
        Object c = connect.instance(s);
        int n = 0;
        do{
            LOGGER.info("1.Edit conection 2.view connection 3.close 4.exit");
            int m = sc.nextInt();
            if(m==1){
                LOGGER.info("Enter connection string: "); 
                ((connect)c).con = sc.next();
                s = "Connection changed to: "+((connect)c).con;
                LOGGER.info(s); 

            }
            else if(m==2){
                s = "Connected to: "+((connect)c).con;
                LOGGER.info(s);
            }
            else if(m==3){
                ((connect)c).close();
            }
            else{
                n=1;
            }
        }while(n == 0);

        ((connect)c).close();
    }
}
