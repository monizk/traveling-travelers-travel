import java.util.ArrayList;
import java.util.Map;

public class TravProfDB {
    Map<String, String> travelerList = (Map<String, String>) new ArrayList();
    int currentTravelerIndex = 0;
    int numTravelers = 0;
    String filename;

    /** constructor **/
    public static void TravProfDB(String file){

    }

    public void insertNewProfile(TravProf input){
        travelerList.put(input.getTravAgentID(), input.getLastName());
        currentTravelerIndex++;
        numTravelers = travelerList.size();
    }

    /** public TravProf findProfile(String agent, String last){
        // returns the traveler profile when given the agent and last name
    } **/

    public boolean deleteProfile(String agent, String last){
        /** if (travelerList.containsKey(agent,last)){
            return false;
        } else {
            travelerList.remove(agent, last);
            return true;
        } **/
    return true;
    }

    public void writeAllTravlProf(){
        // writes all the TravProf stored in the travelerList array to a file
    }

    public void initializeDatabase(){
        // read the existing traveler profiles placed in the file?
    }
}
