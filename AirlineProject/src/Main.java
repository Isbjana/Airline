import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Flight[][] flights = new Flight[3][3];

        //krijimi i airline te pare
        flights[0][0] = new Flight("AA101", "New York", 100);
        flights[0][1] = new Flight("AA101", "New York", 80);
        flights[0][2] = new Flight("AA101", "New York3", 200);

        //krijimi i airline te dyte
        flights[1][0] = new Flight("BA111", "Vienna", 150);
        flights[1][1] = new Flight("BA111", "Vienna1", 100);
        flights[1][2] = new Flight("BA111", "Vienna2", 110);

        //krijimi i airline te trete
        flights[2][0] = new Flight("CA222", "Germany", 100);
        flights[2][1] = new Flight("CA222", "Germany1", 150);
        flights[2][2] = new Flight("CA222", "Germany2", 200);


        while (true) {
            System.out.println("Available Flights");
            System.out.println("1.Luftanca (AA)");
            System.out.println("2.Wizz (BA)");
            System.out.println("3.Pegasus (CA)");
            System.out.println("0. Exit");
            System.out.println("Select an airline or 0 to exit");


            int airlineChoice = scanner.nextInt();

            if (airlineChoice == 0) {
                System.out.println("GoodBay");
                break;
            } else if (airlineChoice >= 1 && airlineChoice <= 3) {
                System.out.println("Available flights for selected airline");
                for (int i = 0; i < 3; i++) {
                    System.out.println((i + 1) + "." + flights[airlineChoice - 1][i].getFlightNumber() + "to" + flights[airlineChoice - 1][i].getDestination()
                            + "Avilable economy seat" + flights[airlineChoice - 1][i].getAvailableEconomySeats() +
                            "Avilable business seat" + flights[airlineChoice - 1][i].getAvailableBusinessSeats());

                }
                System.out.println("Select a flight");
                int flighChoice = scanner.nextInt();
                if (flighChoice >= 1 && flighChoice <= 3) {
                    Flight selectedFlight = flights[airlineChoice - 1][flighChoice - 1];
                    System.out.println("Enter the number of passangers");
                    int numPassangers = scanner.nextInt();

                    System.out.println("Select the class(1.Economy, 2.Bussines)");
                    int seatChoice = scanner.nextInt();
                    boolean isBussinesClass = false;
                    if (seatChoice == 2) {
                        isBussinesClass = true;
                    }
                    if (selectedFlight.bookSeat(numPassangers, isBussinesClass)) {
                        System.out.println("Booking confirmed to " + selectedFlight.getDestination());
                        int remainingEconomySeats = selectedFlight.getAvailableEconomySeats();
                        int remainingBussinesSeats = selectedFlight.getAvailableBusinessSeats();
                        System.out.println("Remainingv economy seats " + remainingEconomySeats);
                        System.out.println("Remainingv economy seats " + remainingBussinesSeats);
                    } else {
                        System.out.println("Sorry ,not enought seats");
                    }

                } else {
                    System.out.println("Invalide flight");
                }
            } else {
                System.out.println("Invalid airline");
            }

        }


    }
}