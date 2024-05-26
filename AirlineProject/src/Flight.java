public class Flight {

    String flightNumber;
    String destination;
    int capacity;
    int bookedSeatsEconomy;
    int bookedSeatsBusiness;

    public Flight(String flightNumber, String destination, int capacity) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.capacity = capacity;
        this.bookedSeatsEconomy = 0;
        this.bookedSeatsBusiness = 0;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableEconomySeats() {
        return capacity - bookedSeatsEconomy;
    }

    public int getAvailableBusinessSeats() {
        return capacity - bookedSeatsBusiness;
    }


    public boolean bookSeat(int numPassaengers, boolean isBusinessClass) {
        if (isBusinessClass) {
            if (bookedSeatsBusiness + numPassaengers <= capacity) {

                bookedSeatsBusiness += numPassaengers;

                return true;

            }


        } else {
            if (bookedSeatsEconomy + numPassaengers <= capacity) {
                bookedSeatsEconomy += numPassaengers;


                return true;
            }


        }


return  false;

    }


}
