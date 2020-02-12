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
public class AirplaneDirectory {
    private ArrayList<Airplane> airplaneList;
    
    public AirplaneDirectory() {
        this.airplaneList = new ArrayList<Airplane>();
    }

    public ArrayList<Airplane> getAirplaneList() {
        return airplaneList;
    }

    public void setAirplaneList(ArrayList<Airplane> airplaneList) {
        this.airplaneList = airplaneList;
    }
    
    public void addAirplane(Airplane airplane) {
        airplaneList.add(airplane);        
    }
    
}
