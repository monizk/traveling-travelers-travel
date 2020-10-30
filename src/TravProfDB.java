import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TravProfDB {
    /** initialize variables **/
    static int numTravelers = 0;
    static private int currentTravelerIndex = 0;
    static private String fileName;
    static ArrayList<TravProf> travelerList =  new ArrayList<TravProf>();

    /** constructor **/
    public TravProfDB(){
        fileName = "out/Database.txt";
    }

    /** create traveler profile **/
    public void insertNewProfile(TravProf input){
        // update variables accordingly
        // (add new traveler to list, increase the total num of travelers & increment current traveler to the new one)
        travelerList.add(input);
        System.out.println("ITS BEEN ADDED!!!");
        currentTravelerIndex++;
        numTravelers = travelerList.size();
        System.out.println("num of profiles: " + numTravelers);
    }

    /** delete traveler profile **/
    public boolean deleteProfile(String agent, String last){
        // loop through profiles to find the one to be deleted
        for(int i = 0; i < travelerList.size(); i++) {
            // when found, remove from the list, reduce the index, reduce the size, and return true
            if(travelerList.get(i).getLastName().equals(last) && travelerList.get(i).getTravAgentID().equals(agent)) {
                travelerList.remove(i);
                currentTravelerIndex--;
                numTravelers = travelerList.size();
                return true;
            }
        }
        // if the provided information doesn't line up with an existing profile, return false
        return false;
    }

    /** find traveler profile **/
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
    public TravProf findFirstProfile() {
        return travelerList.get(0);
    }

    /** return the next profile **/
    public TravProf findNextProfile() {
        return travelerList.get(currentTravelerIndex + 1);
    }

    /** write the profiles to the database/file **/
    public void writeAllTravProf(){
        String file = "out/Database.txt";
        try{
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            // loop through objects & add them to the file
            for(int i = 0; i < travelerList.size(); i++){
                objectOut.writeObject(travelerList.get(i));
            }
        } catch(Exception e){
            System.out.println("An error occurred while writing to file");
            e.printStackTrace();
        }

    }

    /** read profiles to database/file **/
    public void initializeDatabase(){
        String file = "out/Database.txt";
        try {
            FileInputStream fileIn = new FileInputStream("out/Database.txt");
            boolean cont = true;
                try (ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
                    while (cont) {
                        TravProf prof = (TravProf) objectIn.readObject();
                        if (prof != null) {
                            TravProfInterface.displayInformation(prof);
                        } else {
                            cont = false;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error occurred trying to display information (read from database)");
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
