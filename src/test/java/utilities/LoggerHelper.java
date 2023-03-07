package utilities;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import java.util.Date;
import java.text.SimpleDateFormat;

public class LoggerHelper {

    private static boolean root=false;

    static{

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }

    public static Logger getLogger(Class cls){

        if(root){
            return Logger.getLogger(cls);
        }
        PropertyConfigurator.configure("log4j.properties");
        root=true;
        return Logger.getLogger(cls);

    }

    public static void main(String[] args) {
//        Logger log = LoggerHelper.getLogger(LoggerHelper.class);
//        log.trace(" I am testing");
//        log.debug(" I am testing");
//        log.info(" I am testing");
//        log.warn(" I am testing");
//        log.error(" I am testing");
    }
}
