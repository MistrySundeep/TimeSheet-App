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
        return month;
    }
}
