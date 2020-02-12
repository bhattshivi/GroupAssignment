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
    
    public Airliner() {
        this.flightScheduleList = new ArrayList<FlightSchedule>();
    }
    
    public void addFlightSchedule(FlightSchedule flightSchedule) {
        flightScheduleList.add(flightSchedule);
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
}
