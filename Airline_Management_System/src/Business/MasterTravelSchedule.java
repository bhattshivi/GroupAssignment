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
    private ArrayList<Flight> masterFlightList;
    
    public MasterTravelSchedule() {
        this.masterFlightList = new ArrayList<Flight>();
    }
    
    public ArrayList<Flight> getMasterFlightList() {
        return masterFlightList;
    }

    public void setMasterFlightList(ArrayList<Flight> masterFlightList) {
        this.masterFlightList = masterFlightList;
    }
    
    public void addFLight(Flight flight) {
        masterFlightList.add(flight);
    }
}
