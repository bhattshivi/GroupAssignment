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
public class MasterTravelSchedule {
    private ArrayList<FlightSchedule> masterFlightScheduleList;

    public ArrayList<FlightSchedule> getMasterFlightList() {
        return masterFlightScheduleList;
    }

    public void setMasterFlightList(ArrayList<FlightSchedule> masterFlightScheduleList) {
        this.masterFlightScheduleList = masterFlightScheduleList;
    }
    
}
