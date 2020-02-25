/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
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
    
    
    
    public ArrayList<Flight> searchOneWayFlight(String source, String destination, LocalDate dDate) {
        
        ArrayList<Flight> oneWayFlightList = new ArrayList<Flight>();
        
        for (Flight flight : this.masterFlightList) {
            
            int seatCount = 0;
            
            for(Seat s : flight.getFlightSeatList()) {
                if(s.getStatus().equals("Not Available")) {
                    seatCount++;
                }
            }
            
            if(flight.getFlightSchedule().getSource().equals(source) &&
                flight.getFlightSchedule().getDestination().equals(destination) &&
                    flight.getFlightSchedule().getDepartureDate().equals(dDate) &&
                        seatCount != flight.getFlightSeatList().size() &&
                            flight.isIsActive() && flight.getAirplane().isIsActive()) {
                
                oneWayFlightList.add(flight);          
            }
        }
        return oneWayFlightList;        
    }
    
    public ArrayList<Flight> searchRoundTripFlight(String source, String destination, LocalDate dDate, LocalDate aDate) {
        
        ArrayList<Flight> roundTripFlightList = new ArrayList<Flight>();
        
        for (Flight flight : this.masterFlightList) {
            
            int seatCount = 0;
            
            for(Seat s : flight.getFlightSeatList()) {
                if(s.getStatus().equals("Not Available")) {
                    seatCount++;
                }
            }
            
            if(aDate == null) {
                if(flight.getFlightSchedule().getSource().equals(source) &&
                    flight.getFlightSchedule().getDestination().equals(destination) &&
                        flight.getFlightSchedule().getDepartureDate().equals(dDate) &&
                            seatCount != flight.getFlightSeatList().size() &&
                                flight.isIsActive() && flight.getAirplane().isIsActive()) {

                    roundTripFlightList.add(flight);          
                }
            }
            if(dDate == null){
                if(flight.getFlightSchedule().getSource().equals(source) &&
                    flight.getFlightSchedule().getDestination().equals(destination) &&
                        flight.getFlightSchedule().getArrivalDate().equals(aDate) &&
                            seatCount != flight.getFlightSeatList().size() &&
                                flight.isIsActive() && flight.getAirplane().isIsActive()) {

                    roundTripFlightList.add(flight);          
                }
            }
            
            /*
            if(flight.getFlightSchedule().getSource().equals(destination) &&
                flight.getFlightSchedule().getDestination().equals(source) &&
                    flight.getFlightSchedule().getArrivalDate().equals(aDate)) {
                
                roundTripFlightList.add(flight);          
            }
            */
        }
        return roundTripFlightList;        
    }
    
    
    
    public ArrayList<Flight> searchFlight(String flightNumber, String source, String destination, LocalDate dDate, LocalDate aDate, String price, String depDay, String arrDay, String airlineName, String fStatus, int notBlankCount) {
        System.out.println("FLIGHT NO :  **" + flightNumber);
        System.out.println("SOURCE NO :  **" + source);
        System.out.println("DESTINATION NO :  **" + destination);
        System.out.println();
        
        System.out.println("Mayank Date**" + dDate + "==== " + aDate);
        
        
        ArrayList<Flight> list = new ArrayList<Flight>();
        String[] priceRange = null;
        LocalTime t1 = null;
        LocalTime t2 = null;
        boolean flStatus = false;
        
        if(!("-- None --".equals(price))) {
            priceRange = price.split(" ");
            System.out.println("~~~~~~ " + priceRange[0] + "===" + priceRange[2]);
        }
        
        if(depDay.equals("Morning") || arrDay.equals("Morning")) {
            t1 = LocalTime.parse("05:00");
            t2 = LocalTime.parse("11:59");
        }else if(depDay.equals("Afternoon") || arrDay.equals("Morning")) {
            t1 = LocalTime.parse("12:00");
            t2 = LocalTime.parse("16:59");
        }else if(depDay.equals("Evening") || arrDay.equals("Morning")) {
            t1 = LocalTime.parse("17:00");
            t2 = LocalTime.parse("20:59");
        }else if(depDay.equals("Night") || arrDay.equals("Morning")) {
            t1 = LocalTime.parse("21:00");
            t2 = LocalTime.parse("04:59");
        }
        
        if(fStatus.equals("Active")) {
            flStatus = true;
        }else {
            flStatus = false;
        }
        
        for (Flight flight : this.masterFlightList) {
            if(flight.getAirplane().isIsActive()) {
            int count = 0;
            
            ArrayList<Double> seatPriceList = new ArrayList<>();            
            for(Seat s : flight.getFlightSeatList()) {
                seatPriceList.add(s.getPrice());
            }            
            double n = Collections.min(seatPriceList);
            
            if(flightNumber.equals(flight.getFlightName())) {
                count++;
            }
            if(source.equals(flight.getFlightSchedule().getSource())) {
                count++;
            }
            if(destination.equals(flight.getFlightSchedule().getDestination())) {
                count++;
            }
            if(null != dDate && dDate.equals(flight.getFlightSchedule().getDepartureDate())) {
                count++;
            }
            if(null != aDate && aDate.equals(flight.getFlightSchedule().getArrivalDate())) {
                count++;
            }
            if(!("-- None --".equals(price)) && n >= Double.parseDouble(priceRange[0]) && n <= Double.parseDouble(priceRange[2])) {
                count++;
            }
            if(!("-- None --".equals(depDay)) && flight.getFlightSchedule().getDepartureTime().isAfter(t1) && flight.getFlightSchedule().getDepartureTime().isBefore(t2)) {
                count++;
            }
            if(!("-- None --".equals(arrDay)) && flight.getFlightSchedule().getArrivalTime().isAfter(t1) && flight.getFlightSchedule().getArrivalTime().isBefore(t2)) {
                count++;
            }
            if(!("-- None --".equals(airlineName)) && flight.getAirliner().getAirlinerName().equals(airlineName)) {
                count++;
            }
            if(!("-- None --".equals(flStatus)) && flight.isIsActive() == flStatus) {
                count++;
            }
            
            System.out.println("COUNT2 >>>> " + notBlankCount);
            System.out.println("COUNT3 >>>> " + count);
            
            if(notBlankCount == count) {
                list.add(flight);
            }
            
            /*
            if(flightNumber.equals(flight.getFlightName()) ||
                source.equals(flight.getFlightSchedule().getSource()) ||
                destination.equals(flight.getFlightSchedule().getDestination()) ||   
                dDate.equals(flight.getFlightSchedule().getDepartureDate()) ||
                aDate.equals(flight.getFlightSchedule().getArrivalDate()) ||
                aDate.equals(flight.getFlightSchedule().getArrivalDate()) ||
                (n >= Double.parseDouble(priceRange[0]) && n <= Double.parseDouble(priceRange[0])) || 
                  
                    
                    ) {
                
            }
            */
        }
        }
        
        return list;
    }
}
