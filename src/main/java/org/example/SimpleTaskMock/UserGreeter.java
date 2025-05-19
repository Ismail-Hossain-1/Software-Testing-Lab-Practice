package org.example.SimpleTaskMock;

public class UserGreeter {

    TimeService timeService;
    public UserGreeter(TimeService timeService){
        this.timeService= timeService;
    }
    String generateWelcomeMessage(String username){
        String name= (username==null || username.isEmpty())?  "Guest" : username;
        return "Good " +timeService.getCurrentPeriod()+ " "+name+ "! Welcome.";
    }

}
