/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Mayank
 */
public class ReservationDirectory {
    private ArrayList<Reservation> reservationList;
    private int count=0;
    
    public ReservationDirectory() {
        this.reservationList = new ArrayList<>();
    }
    
    public ArrayList<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(ArrayList<Reservation> reservationList) {
        this.reservationList = reservationList;
    }    
    
    public void addReservation(Reservation reservation) {
        count++;
        reservation.setReservationId("Res"+count);
        reservationList.add(reservation);
    }
}
