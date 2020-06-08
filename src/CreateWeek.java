import java.util.*;

public class CreateWeek extends TimeSheet {
    //Creates an enum used to make a list of days
    private enum dayOfWeek{
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }

    //Creates a LinkedList of days of the week
    public static LinkedList<String> dayList(){
        LinkedList d = new LinkedList();
        for(dayOfWeek day : dayOfWeek.values()){
            d.add(day.toString());
        }
        return d;
    }

    //Creates a List of double values entered by the user
    public static List<Double> hours(){
        List<Double> hoursWorked = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int i = 0;

        while(i < 7){
            try{
                for(dayOfWeek d : dayOfWeek.values()){
                    System.out.println("Enter hours worked on " + d.toString() + ":");
                    double h = sc.nextDouble();
                    hoursWorked.add(h);
                    System.out.println("Hours worked on " + d.toString() + " is: " + h);
                    i++;
                }
            }
            catch(Exception e){
                System.out.println(e + " encountered");
            }
        }
        return hoursWorked;
    }

    //Creates a LinkedHasMap with types of String and Double which represents 1 week of the month
    public static LinkedHashMap<String, Double> createMap(LinkedList<String> d, List<Double> h){
        LinkedHashMap<String, Double> cWeek = new LinkedHashMap<>();
        int counter = 0;
        while(counter < d.size()){
            cWeek.put(d.get(counter), h.get(counter));
            counter++;
        }
        return cWeek;
    }
}
