import java.text.SimpleDateFormat;
import java.util.Date;

public class Reflection {

    public static void main(String[] args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("E");
        SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY");
        Date date = new Date();
        Date datePlus60 = new Date("29.06.1996");
        System.out.println("Today: " + sdf.format(date));
        System.out.println("to60: " + sdf2.format(datePlus60));
    }
}



