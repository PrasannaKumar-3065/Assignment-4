package pk;
import java.util.*;
import java.util.logging.*;
class CONNECT{
    String con;
    static CONNECT c=null;
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    static CONNECT instance(String con){
        c = new CONNECT(con);
        return c; 
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
            Object c = CONNECT.instance(s);
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
                        s = c+" Connected to: "+((CONNECT)c).con;
                        LOGGER.info(s);
                    }
                    else if(m==3){
                        ((CONNECT)c).close();
                        CONNECT.c = null;
                    }
                    else{
                        n=1;
                    }
            }
        
    }
}
