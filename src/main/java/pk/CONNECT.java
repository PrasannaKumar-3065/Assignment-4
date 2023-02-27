package pk;
import java.util.logging.*;

public class CONNECT{
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