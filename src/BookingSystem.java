import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.text.*;


public class BookingSystem {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws ParseException {
        startProgram();



    }
    public static void startProgram() throws ParseException{
        boolean validation = false;
        System.out.println("Welcome to Event Planner 2000");
        System.out.println("\nCreate new event - Press 1\n" +
                "See all upcoming events - Prss 2");
        String userChoice = scanner.next();
        do {
            if(userChoice.equals("1")){
                validation=true;
                createNewEvent();
            } else if (userChoice.equals("2")){
                validation=true;
                seeUpcomingEvents();
            } else{
                System.out.println("Invalid input - Please enter valid input");
                userChoice= scanner.next();
            }
        } while (!validation);
    }

    public static void createNewEvent() throws ParseException{
        System.out.println("What is the name of your venue?");
        String venueName = getStringInput();

        System.out.println("What is the address of your venue?");
        String venueAddress = getStringInput();

        System.out.println("What is the capacity of your venue?");
        int venueCapacity = scanner.nextInt();
        Spillested designatedVenue = new Spillested(venueName,venueAddress,venueCapacity);

        System.out.println("How many acts for your event?");
        BandKunstner[] actLineupArray = new BandKunstner[scanner.nextInt()];
        for (int i = 0; i < actLineupArray.length; i++) {
            System.out.println("What is the name of your act?");
            String actName = getStringInput();
            System.out.println("What is the price set for your act?");
            int actPrice = scanner.nextInt();
            System.out.println("What time is the act playing?");
            Date actStartTime = getDate();
            actLineupArray[i]=new BandKunstner(actName,actPrice,actStartTime);
        }
        for (int i = 0; i < actLineupArray.length; i++) {
            System.out.println(actLineupArray[i].toString());

        }
    }

    public static void seeUpcomingEvents(){
    }

    public static String getStringInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static Date getDate() throws ParseException{
        //https://codegym.cc/groups/posts/parse-methods-in-java?fbclid=IwAR10UVq34Njts7qZsppYUeWVasBkGok2X5uFmw_X4xajDq5QiQh8XB66t5c
        System.out.println("YYYY-MM-DD HH:MM");
        String date = getStringInput();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        Date formattedDate = format.parse(date);
        return formattedDate;
    }
}
