import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class TravProfDB {

    int numTravelers = 0;
    int currentTravelerIndex = 0;
    String fileName;
    ArrayList<TravProf> travelerList =  new ArrayList<TravProf>();

    /** constructor **/
    public TravProfDB(String file){
        fileName = file;
    }

    public void insertNewProfile(TravProf input){
        travelerList.add(input);

        currentTravelerIndex++;
        numTravelers = travelerList.size();
    }

    public boolean deleteProfile(String agent, String last){
        for(int i = 0; i < travelerList.size(); i++) {
            if(travelerList.get(i).getLastName().equals(last) && travelerList.get(i).getTravAgentID().equals(agent)) {
                travelerList.remove(i);

                currentTravelerIndex--;
                numTravelers = travelerList.size();

                return true;
            }
        }
        return false;
    }

    public TravProf findProfile(String agent, String last){
     // returns the traveler profile when given the agent and last name
        for(int i = 0; i < travelerList.size(); i++) {
            if(travelerList.get(i).getLastName().equals(last) && travelerList.get(i).getTravAgentID().equals(agent)) {
                return travelerList.get(i);
            }
        }
        return null;
     }

    public TravProf findFirstProfile() {
        return travelerList.get(0);
    }

    /** NOT SURE ABOUT THIS ONE **/
    public TravProf findNextProfile() {
        return travelerList.get(currentTravelerIndex + 1);
    }

    /** I HAVE A DISAGREEMENT WITH THE NEXT TWO METHODS AND THE PROJECT SHEET **/
    public void writeAllTravlProf(String file){
        // writes all the TravProf stored in the travelerList array to a file
       // try {
       //     File myObj = new File(file);
       //     myObj.createNewFile();
       // } catch (IOException e) {
       //     System.out.println("An error occurred.");
       //     e.printStackTrace();
       // }
        try {
            FileOutputStream Output = new FileOutputStream(file);
            ObjectOutputStream objectPrint = new ObjectOutputStream(Output);
            for(int i = 0; i < travelerList.size(); i++) {
                objectPrint.writeObject(travelerList.get(i));
            }
            objectPrint.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void initializeDatabase(String file){
        // read the existing traveler profiles placed in the file?
    }
}
