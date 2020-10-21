import java.util.ArrayList;

public class TravProfDB {
    ArrayList travelerList =  new ArrayList();
    int currentTravelerIndex = 0;
    int numTravelers = 0;
    String filename;

    /** constructor **/
    public static void TravProfDB(String file){

    }


    public void insertNewProfile(TravProf input){
        travelerList.add(input);

        currentTravelerIndex++;
        numTravelers = travelerList.size();
    }

    public TravProf findProfile(String agent, String last){
        // this can definitely be done better..but this was my quick solution..we should optimize this later
        for(int i = 0; i < numTravelers; i++){
            if(travelerList.

            }
        }
    }

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
