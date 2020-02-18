/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Mayank
 */
public class Flight {
    private String flightId;
    private String flightName;
    private boolean isActive;
    private Airliner airliner;
    private Airplane airplane;
    private Journey journey;
    private FlightSchedule flightSchedule;
    private ArrayList<Seat> flightSeatList;
    private Seat seatLock;

    public Seat getSeatLock() {
        return seatLock;
    }

    public void setSeatLock(Seat seatLock) {
        this.seatLock = seatLock;
    }
    
    
    public Flight() {
        this.flightSeatList = new ArrayList<>();
    }
    public ArrayList<Seat> getFlightSeatList() {
        return flightSeatList;
    }

    public void setFlightSeatList(ArrayList<Seat> flightSeatList) {
        this.flightSeatList = flightSeatList;
    }
    
    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
    
    
    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public Airliner getAirliner() {
        return airliner;
    }

    public void setAirliner(Airliner airliner) {
        this.airliner = airliner;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public FlightSchedule getFlightSchedule() {
        return flightSchedule;
    }

    public void setFlightSchedule(FlightSchedule flightSchedule) {
        this.flightSchedule = flightSchedule;
    }
    
    @Override
    public String toString() {
        return flightId; //To change body of generated methods, choose Tools | Templates.
    }
}
