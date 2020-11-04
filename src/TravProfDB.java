import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TravProfDB {
    /** initialize variables **/
    // these variables are all assigned in the constructor
    int numTravelers;
    private int currentTravelerIndex;
    private String fileName;
    ArrayList<TravProf> travelerList = new ArrayList<>();

    /** constructor **/
    // creates an instance of this class
    public TravProfDB(String newFile){
        // set variables to base values
        fileName = newFile;
        numTravelers = 0;
        currentTravelerIndex = 0;
    }

    /** create traveler profile **/
    // inserts a given traveler profile into the list of profiles
    public void insertNewProfile(TravProf prof){
        // add profile to list
        travelerList.add(prof);
        // increase the number of total travelers
        numTravelers = travelerList.size();
    }

    /** delete traveler profile **/
    // remove a traveler profile from the list
    public boolean deleteProfile(String agent, String last){
        // loop through profiles to find the one to be deleted
        for(int i = 0; i < travelerList.size(); i++) {
            // when found, remove from the list, reduce the index, reduce the size, and return true
            if(travelerList.get(i).getLastName().equals(last) && travelerList.get(i).getTravAgentID().equals(agent)) {
                // remove profile from the list
                travelerList.remove(i);
                // adjust the total number of travelers
                numTravelers = travelerList.size();
                return true;
            }
        }
        // if the provided information doesn't line up with an existing profile, return false
        return false;
    }

    /** find traveler profile **/
    // search for a given profile
    public TravProf findProfile(String agent, String last){
        // loop through travelers to find the one to be returned
        for(int i = 0; i < travelerList.size(); i++) {
            // if found, return the given traveler
            if(travelerList.get(i).getLastName().equals(last) && travelerList.get(i).getTravAgentID().equals(agent)) {
                return travelerList.get(i);
            }
        }
        // if not found, return null
        return null;
    }

    /** return the first profile **/
    // returns the first profile in the list (if applicable)
    public TravProf findFirstProfile() {
        // checks if the list of profiles is completely empty--if so, return null
        if(travelerList.size() == 0){
            return null;
        } else {
            // otherwise, increase the current index and return the first profile
            currentTravelerIndex = 1;
            return travelerList.get(0);
        }
    }

    /** return the next profile **/
    // returns the next profile (relative, if applicable)
    public TravProf findNextProfile() {
        // check if there is a profile in the desired location, if not, return null
        if (currentTravelerIndex == travelerList.size()) {
            return null;
        } else {
            // if there is, return said profile & increment the current index
            TravProf prof = travelerList.get(currentTravelerIndex);
            currentTravelerIndex++;
            return prof;
        }
    }

    /** write the profiles to the database/file **/
    // writes all of the profiles in the list to the provided database/file
    public void writeAllTravProf(String file){
        // using try here because an error could be thrown
        fileName = file;
        try{
            // open up a stream to write the objects
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            // write the list of objects to the file
            objectOut.writeObject(travelerList);
            // close the stream
            objectOut.close();
        } catch(Exception e){
            // if an exception is raised, print a statement & the stack trace
            System.out.println("An error occurred while writing to file");
            e.printStackTrace();
        }
    }

    /** read profiles to database/file **/
    // reads all of the profiles in the given database/file
    public void initializeDatabase(String file){
        // make a file object
        fileName = file;
        File newFile = new File(fileName);
        try {
            // check if the file is not empty
            if(newFile.length() > 0){
                // if true, open up a stream to read the objects
                FileInputStream fileIn = new FileInputStream(fileName);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                this.travelerList = (ArrayList<TravProf>)objectIn.readObject();
            }
        } catch (Exception e) {
            // if an exception is raised, print a statement & the stack trace
            System.out.println("An error occurred while initializing the database");
            e.printStackTrace();
        }
    }
}
