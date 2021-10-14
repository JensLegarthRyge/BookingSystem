import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BookingSystem {
    //Array list put here in order for every method to be able to access it.
    //The same for the scanner and the boolean, so that it is not necessary to make an instance in every method.
    //Thus eliminating redundancy
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Event> eventsCreated = new ArrayList<>();
    static boolean exitProgram = false;

    public static void main(String[] args) {
        //Program is being looped until the user wishes to exit the game.
        while (!exitProgram){
            startProgram();
        }

    }

    static void startProgram() {
        //Could use the exitGame boolean however the variable name is not fitting.
        boolean validation = false;
        System.out.println("Welcome to Event Planner 2000");
        System.out.println("\nCreate new event - Press 1\n" +
                "See all upcoming events - Press 2\n"+
                "Exit program - Press 3");
        String userChoice = scanner.next();
        //Do while loop that takes the user input from the scanner and calls the chosen method.
        do {
            if(userChoice.equals("1")){
                validation=true;
                createNewEvent();
            } else if (userChoice.equals("2")) {
                printAllEvents();
                validation = true;

            } else if (userChoice.equals("3")) {
                //This breaks the loop up in main and ends the program
                validation = true;
                exitProgram = true;
            } else{
                System.out.println("Invalid input - Please enter valid input");
                userChoice= scanner.next();
            }
        } while (!validation);
    }

    static void createNewEvent() {
        //Method that takes a lot of user input and saves it in variables for the new Event in the end of the method
        System.out.println("What is the name of your venue?");
        String venueName = getStringInput();

        System.out.println("What is the address of your venue?");
        String venueAddress = getStringInput();

        System.out.println("What is the capacity of your venue?");
        int venueCapacity = scanner.nextInt();
        Venue designatedVenue = new Venue(venueName,venueAddress,venueCapacity);
        //
        System.out.println("How many acts for your event?");
        //This creates an array the size of the user input
        Act[] actLineupArray = new Act[scanner.nextInt()];
        //A loop that creates an act object and makes it an element in an act array.
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
        //Creates an event which inputs the variables and the array above.
        Event eventCreated = new Event(eventName,venueCapacity,designatedVenue,actLineupArray,ticketPrice);
        //Inputs the created event in an arrayList
        eventsCreated.add(eventCreated);
    }

    static String getStringInput(){
        //Neutralizes the bug that happens when you use the same String scanner multiple times.
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static Date getDate(){
        //The code is taken from this website
        //https://codegym.cc/groups/posts/parse-methods-in-java?fbclid=IwAR10UVq34Njts7qZsppYUeWVasBkGok2X5uFmw_X4xajDq5QiQh8XB66t5c
        //This code prints the format it wants the user to input the date and time of the event.
        //The simpledateformat is a template for what things should be parsed in the input text.
        //The user input is then parsed and returned
        System.out.println("YYYY-MM-DD HH:MM");
        String dateFromUser = getStringInput();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        Date formattedDate = null;
        try{
            formattedDate = format.parse(dateFromUser);
        } catch (ParseException e){
            e.printStackTrace();
        }
        return formattedDate;
    }

    static double getTicketPrice(Act[] actLineupArray, int capacity){
        //Method that takes the price of each of the elements in the actLineupArray and adds it to the sum.
        //It then divides the sum with the capacity in order to get the price per ticket
        int sum=0;
        for (int i = 0; i < actLineupArray.length; i++) {
            sum+=actLineupArray[i].getPrice();
        }
        return sum/capacity;
    }

    static void printAllEvents(){
        //A method that prints all of the arrays in the arrayList.
        Event[] eventsInArrayList = eventsCreated.toArray(new Event[eventsCreated.size()]);
        for (Event event : eventsInArrayList) {
            System.out.println(event.toString());
        }
    }
}