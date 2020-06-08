import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class CalcPay extends CreateMonth {
    private final static double PAY_RATE = 8.75;
    List<Double> h = new ArrayList<>();

    private static double round(double val, int places){
        if(places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(val);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static List<Double> collateHours(){
        LinkedList<LinkedHashMap<String, Double>> m = CreateMonth.fullMonth();
        List<Double> hours = new ArrayList<>();
        int counter = 0;
        int i = 0;

        while(i <= m.size()){
            while(counter < 7){
                for(double tmp : m.get(counter).values()){
                    hours.add(tmp);
                    counter++;
                }
            }
            i++;
            counter = 0;
        }
        return hours;
    }

    public static void totalPay(){
        List<Double> h = CalcPay.collateHours();
        int j = 0;
        double total = 0.0;
        double hours = 0.0;

        while(j <  h.size()){
            hours = h.get(j);
            total += hours;
            j++;
        }

        total *= PAY_RATE;

        System.out.printf("You made £" + round(total, 2) + " this month.");
    }

}
