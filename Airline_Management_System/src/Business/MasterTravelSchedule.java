/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    
    public ArrayList<Flight> searchFlight(String flightNumber,String source, String destination) {
        System.out.println("FLIGHT NO :  **" + flightNumber);
        System.out.println("SOURCE NO :  **" + source);
        System.out.println("DESTINATION NO :  **" + destination);
        System.out.println();
        ArrayList<Flight> list = new ArrayList<Flight>();
        for (Flight flight : this.masterFlightList) {
            if(((flightNumber.isEmpty() || flight.getFlightId().equalsIgnoreCase(flightNumber))
                    && (source.isEmpty() || flight.getFlightSchedule().getSource().equalsIgnoreCase(source))
                   && (destination.isEmpty() ||flight.getFlightSchedule().getDestination().equalsIgnoreCase(destination)))){
                  System.out.println("Flight Number# ,Source, Destination Location  matched");
                   list.add(flight);
            }
                //else if(flight.getFlightSchedule().getSource().equalsIgnoreCase(source) && ){
                        
                        
               
                //return prod;
            //}
        }
        
        return list;
    }
}
