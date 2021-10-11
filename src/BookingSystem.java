import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.*;


public class BookingSystem {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Event> eventsCreated = new ArrayList<Event>();

    public static void main(String[] args) {
        startProgram();
    }

    static void startProgram() {
        boolean validation = false;
        System.out.println("Welcome to Event Planner 2000");
        System.out.println("\nCreate new event - Press 1\n" +
                "See all upcoming events - Press 2");
        String userChoice = scanner.next();
        do {
            if(userChoice.equals("1")){
                validation=true;
                createNewEvent();
            } else if (userChoice.equals("2")){
                validation=true;
            } else{
                System.out.println("Invalid input - Please enter valid input");
                userChoice= scanner.next();
            }
        } while (!validation);
    }

    static void createNewEvent() {
        System.out.println("What is the name of your venue?");
        String venueName = getStringInput();

        System.out.println("What is the address of your venue?");
        String venueAddress = getStringInput();

        System.out.println("What is the capacity of your venue?");
        int venueCapacity = scanner.nextInt();
        Venue designatedVenue = new Venue(venueName,venueAddress,venueCapacity);

        System.out.println("How many acts for your event?");
        Act[] actLineupArray = new Act[scanner.nextInt()];
        for (int i = 0; i < actLineupArray.length; i++) {
            System.out.println("What is the name of your act?");
            String actName = getStringInput();
            System.out.println("What is the price set for your act?");
            int actPrice = scanner.nextInt();
            System.out.println("What time is the act playing?");
            Date actStartTime = getDate();
            actLineupArray[i]=new Act(actName,actPrice,actStartTime);
        }
        double ticketPrice = getTicketPrice(actLineupArray,venueCapacity);
        System.out.println("What is the name of your event?");
        String eventName = getStringInput();
        Event eventCreated = new Event(eventName,venueCapacity,designatedVenue,actLineupArray,ticketPrice);
        eventsCreated.add(eventCreated);
    }

    static String getStringInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static Date getDate(){
        //https://codegym.cc/groups/posts/parse-methods-in-java?fbclid=IwAR10UVq34Njts7qZsppYUeWVasBkGok2X5uFmw_X4xajDq5QiQh8XB66t5c
        System.out.println("YYYY-MM-DD HH:MM");
        String date = getStringInput();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        Date formattedDate = null;
        try{
            formattedDate = format.parse(date);
        } catch (ParseException e){
            e.printStackTrace();
        }
        return formattedDate;
    }

    static double getTicketPrice(Act[] actLineupArray, int capacity){
        int sum=0;
        for (int i = 0; i < actLineupArray.length; i++) {
            sum+=actLineupArray[i].getPrice();
        }
        return sum/capacity;
    }
}
