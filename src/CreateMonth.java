import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class CreateMonth extends CreateWeek {
    public static LinkedList<LinkedHashMap<String, Double>> fullMonth(){

        LinkedList<LinkedHashMap<String, Double>> month= new LinkedList<>();
        LinkedHashMap<String, Double> cWeek;
        LinkedList<String> d = CreateWeek.dayList();

        int counter = 0;
        int weekNum = 1;

        while(counter < 4){
            System.out.println("Enter hours for week " + weekNum + ":");
            List<Double> h = hours();
            cWeek = createMap(d,h);
            month.add(cWeek);
            System.out.println("You have entered hours for week " + weekNum + ".");
            System.out.println();
            weekNum++;
            counter++;
        }

        try{
            FileWriter fileWriter = new FileWriter("output.txt");
            String strDate = LocalDate.now(ZoneId.of("Europe/London")).toString();

            fileWriter.write("Your TimeSheet created on: " + strDate);
            fileWriter.write(System.getProperty("line.separator"));

            int count = 1;
            for(int i=0; i<month.size(); i++){
                fileWriter.write(System.getProperty("line.separator"));
                fileWriter.write("Week " + count + ":");
                fileWriter.write(month.get(i).toString());
                fileWriter.write(System.getProperty("line.separator"));
                count++;
            }
            fileWriter.close();

        }catch (IOException e){
            System.out.println("An error occurred:");
            e.printStackTrace();
        }
        return month;
    }


}
