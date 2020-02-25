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
public class Airliner {
    private String airlinerId;
    private String airlinerName;
    private int fleetSize;
    private String headquarter;
    private ArrayList<FlightSchedule> flightScheduleList;
    private ArrayList<Flight> flightList;
    private ArrayList<Airplane> airplaneList;
    private int count = 0;
    public boolean isActive;

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    
    public Airliner() {
        this.flightScheduleList = new ArrayList<>();
        this.flightList = new ArrayList<>();
        this.airplaneList = new ArrayList<>();
    }

    public ArrayList<Airplane> getAirplaneList() {
        return airplaneList;
    }

    public void setAirplaneList(ArrayList<Airplane> airplaneList) {
        this.airplaneList = airplaneList;
    }
    
    public ArrayList<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(ArrayList<Flight> flightList) {
        this.flightList = flightList;
    }
    
    public void addFlightSchedule(FlightSchedule flightSchedule) {
        count++;
        flightSchedule.setFlightScheduleId("FS" + count);
        flightScheduleList.add(flightSchedule);
    }
    
    public void addFlight(Flight flight) {
        count++;
        flight.setFlightId("Flight" + count);
        flightList.add(flight);
    }
    
    public void addAirplane(Airplane airplane) {
        count++;
        //flight.setFlightId("Flight" + count);
        airplaneList.add(airplane);
    }

    public ArrayList<FlightSchedule> getFlightScheduleList() {
        return flightScheduleList;
    }

    public void setFlightScheduleList(ArrayList<FlightSchedule> flightScheduleList) {
        this.flightScheduleList = flightScheduleList;
    }
    
    /*
    public ArrayList<Airplane> getAirplaneList() {
        return airplaneList;
    }

    public void setAirplaneList(ArrayList<Airplane> airplaneList) {
        this.airplaneList = airplaneList;
    }
    */
    public String getAirlinerId() {
        return airlinerId;
    }

    public void setAirlinerId(String airlinerId) {
        this.airlinerId = airlinerId;
    }

    public String getAirlinerName() {
        return airlinerName;
    }

    public void setAirlinerName(String airlinerName) {
        this.airlinerName = airlinerName;
    }

    public int getFleetSize() {
        return fleetSize;
    }

    public void setFleetSize(int fleetSize) {
        this.fleetSize = fleetSize;
    }

    public String getHeadquarter() {
        return headquarter;
    }

    public void setHeadquarter(String headquarter) {
        this.headquarter = headquarter;
    }
    
    public void addFlightScheduleList(FlightSchedule flightSchedule) {
        flightScheduleList.add(flightSchedule);
    }

    @Override
    public String toString() {
        return airlinerName; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
