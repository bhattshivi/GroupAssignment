/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Mayank
 */
public class Reservation {
    private boolean isBooked;
    private Seat seat;
    private Flight flight;
    private String reservationId;
    private Customer customer;
    
    public Reservation(){
        this.isBooked = true;
    }

    public boolean isIsBooked() {
        return isBooked;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
     @Override
    public String toString() {
        //return this.getFirstName(); //To change body of generated methods, choose Tools | Templates.
        return this.reservationId; //To change body of generated methods, choose Tools | Templates.
    }
    
}
