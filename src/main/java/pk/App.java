package pk;
import java.io.IOException;
import java.util.*;
import java.util.logging.*;
class CONNECT{
    String con;
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    static Object instance(String con){
        return new CONNECT(con); 
    }
    private CONNECT(String con){
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
        try{
        Object c = CONNECT.instance(s);
        }catch(ClassNotFoundException e){
            s = ""+e.getClass();
            LOGGER.info(s);
        }
        int n = 0;
        while(n==0){
            LOGGER.info("1.Edit conection 2.view connection 3.close 4.exit");
            int m = sc.nextInt();
            if(m==1){
                LOGGER.info("Enter connection string: "); 
                ((CONNECT)c).con = sc.next();
                s = "Connection changed to: "+((CONNECT)c).con;
                LOGGER.info(s); 

            }
            else if(m==2){
                s = "Connected to: "+((CONNECT)c).con;
                LOGGER.info(s);
            }
            else if(m==3){
                ((CONNECT)c).close();
            }
            else{
                n=1;
            }
        }

        ((CONNECT)c).close();
    }
}
