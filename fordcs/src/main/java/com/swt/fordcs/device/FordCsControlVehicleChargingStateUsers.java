package com.swt.fordcs.device;

import java.util.ArrayList;

// For the time being, the User list is populated hard coded! Later over configuration file!
//
// Users are defined in https://app.swaggerhub.com/apis/karacankos/fordcs/1.0-oas3
//
public class FordCsControlVehicleChargingStateUsers {
	
    // Static variable reference of single_instance
    // of type Singleton
    private static FordCsControlVehicleChargingStateUsers single_instance = null;
 
    // Declaring a variable of type String
    private ArrayList<String> userlist = new ArrayList<String>();
 
    // Constructor
    // populate the userlist
    private FordCsControlVehicleChargingStateUsers()
    {
        // add elements in the list
    	userlist.add("service");
    }
 
    // Static method
    // Static method to create instance of Singleton class
    public static FordCsControlVehicleChargingStateUsers getInstance()
    {
        if (single_instance == null) single_instance = new FordCsControlVehicleChargingStateUsers();
 
        return single_instance;
    }
    // returns the user if found, otherwise null!
    public String findUser(String user) {
        for (String element : userlist){
            if (element.compareTo(user) == 0){
                  return(user);
            }
         }
        return (null);
    }


  

}
