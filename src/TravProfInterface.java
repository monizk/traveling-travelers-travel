import java.util.Scanner;

public class TravProfInterface{
    /** variables **/
    // these variables are all assigned in the constructor
    String userChoice;
    String travAgentID;
    String lname;
    String file;
    Scanner scan;
    TravProfDB db;

    /** constructor **/
    // creates an instance of this class
    public TravProfInterface(String fileName){
        // create a new database object
        db = new TravProfDB(fileName);
        userChoice = "0";
        file = fileName;
        scan = new Scanner(System.in);
    }

    /** display the options & get the user's choice **/
    // prompt the user & get their selection
    public void getUserChoice(){
        // print out all the options
        System.out.println("==================================================================================");
        System.out.println("1. Create New Profile");
        System.out.println("2. Edit Existing Profile");
        System.out.println("3. Delete Profile");
        System.out.println("4. Search Profiles");
        System.out.println("5. Display All Profiles");
        System.out.println("6. Save Database");
        System.out.println("7. Exit ITS");
        System.out.println("==================================================================================");
        System.out.print("\t   Please choose the number from above corresponding to your selection: ");
        // get the user's choice
        userChoice = scan.nextLine();
    }

    /** delete traveler profile **/
    // delete an existing profile
    public void deleteTravProf(){
        System.out.println("==================================================================================");

        if(db.deleteProfile(travAgentID, lname)){
            // if the profile exists & can be deleted, delete it
            System.out.println("Profile Successfully Deleted");
        } else {
            // if the profile does not exist or can't be deleted, don't delete it
            System.out.println("Profile Not Deleted: Either Does Not Exist OR Was Created By A Different Travel Agent");
        }

        System.out.println("==================================================================================");
    }

    /** search for a profile **/
    // search for an existing profile & display the information
    public void findTravProf(){
        if(db.findProfile(travAgentID, lname) != null){
            // if the profile exists, display the information
            displayTravProf(db.findProfile(travAgentID, lname));
        } else {
            // otherwise, no profiles exist/should be returned
            System.out.println("==================================================================================");
            System.out.println("There are no profiles that match that description.");
            System.out.println("==================================================================================");
        }
    }

    /** update an existing profile **/
    // edit an existing profile
    public void updateTravProf(){
        // create a prof object
        TravProf prof = db.findProfile(travAgentID, lname);
        if(prof != null){
            // if the object is not null, that means it exists & the related information should be displayed
            displayTravProf(prof);
        }else{
            // otherwise, the profile does not exist
            System.out.println("==================================================================================");
            System.out.println("There are no profiles that match the provided description.");
            System.out.println("==================================================================================");
            return;
        }

        // display the different attributes to edit
        System.out.println("Select the number that corresponds to the information you'd like to change: ");
        System.out.println("==================================================================================");
        System.out.println("1. Address");
        System.out.println("2. Phone Number");
        System.out.println("3. Travel Type");
        System.out.println("4. Trip Cost");
        System.out.println("5. Payment Type");
        System.out.println("6. Doctor Name");
        System.out.println("7. Doctor Phone Number");
        System.out.println("8. Illness");
        System.out.println("9. Allergies");
        System.out.println("==================================================================================");
        // get the user's choice
        String choice = scan.nextLine();

        // get the necessary variables to create MedCond objects
        String ill = prof.getMedCondInfo().getIllType();
        String alg = prof.getMedCondInfo().getAlgType();
        String phone = prof.getMedCondInfo().getMdPhone();
        String doc = prof.getMedCondInfo().getMdContact();

        // switch case to deal with all possible options
        switch (Integer.parseInt(choice)) {
            // update address
            case 1 -> {
                System.out.println("Update address: ");
                String newAddress = scan.nextLine();
                prof.updateAddress(newAddress);
            }
            // update phone number
            case 2 -> {
                System.out.println("Update phone number: ");
                String newPhone = scan.nextLine();
                prof.updatePhone(newPhone);
            }
            case 3 -> {
                // update travel type
                System.out.println("Update travel type: ");
                String newTrav = scan.nextLine();
                prof.updateTravelType(newTrav);
            }
            case 4 -> {
                // update trip cost
                System.out.println("Update trip cost");
                String newCost = scan.nextLine();
                prof.updateTripCost(Float.parseFloat(newCost));
            }
            case 5 -> {
                // update payment type
                System.out.println("Update payment type");
                String newPay = scan.nextLine();
                prof.updatePaymentType(newPay);
            }
            case 6 -> {
                // update doctor name
                System.out.println("Update doctor name");
                String newDoc = scan.nextLine();
                MedCond md = new MedCond(newDoc, phone, alg, ill);
                prof.updateMedCondInfo(md);
            }
            case 7 -> {
                // update doctor phone number
                System.out.println("Update doctor phone number");
                String newP = scan.nextLine();
                MedCond md2 = new MedCond(doc, newP, alg, ill);
                prof.updateMedCondInfo(md2);
            }
            case 8 -> {
                // update illness type
                System.out.println("Update illness");
                String newIll = scan.nextLine();
                MedCond md3 = new MedCond(doc, phone, newIll, alg);
                prof.updateMedCondInfo(md3);
            }
            case 9 -> {
                // update allergy type
                System.out.println("Update allergies");
                String newAlg = scan.nextLine();
                MedCond md4 = new MedCond(doc, phone, ill, newAlg);
                prof.updateMedCondInfo(md4);
            }
        }
        System.out.println("==================================================================================");
        System.out.println("Profile Successfully Updated");
        System.out.println("==================================================================================");
    }

    /** display all information about a given travel profile **/
    // display all information that corresponds to a given profile
    public void displayTravProf(TravProf prof){
        // print all information
        System.out.println("==================================================================================");
        System.out.println("First Name: " + prof.getFirstName());
        System.out.println("Last Name: " + prof.getLastName());
        System.out.println("Address: " + prof.getAddress());
        System.out.println("Phone: " + prof.getPhone());
        System.out.println("User ID: " + prof.getTravAgentID());
        System.out.println("Travel Type: " + prof.getTravelType());
        System.out.println("Travel Cost: " + prof.getCost());
        System.out.println("Payment Type: " + prof.getPaymentType());
        System.out.println("Doctor Name: " + prof.getMedCondInfo().getMdContact());
        System.out.println("Doctor Phone: " + prof.getMedCondInfo().getMdPhone());
        System.out.println("Allergies: " + prof.getMedCondInfo().getAlgType());
        System.out.println("Illness: " + prof.getMedCondInfo().getIllType());
        System.out.println("==================================================================================");
    }

    /** display all profiles in the database **/
    // display all information that corresponds to all profiles in the database/file
    public void displayAllTravProf(){
        // variables
        boolean valid = true;
        int shown = 0;

        if(db.findFirstProfile() != null){
            // if the first profile is not null, get the corresponding object
            TravProf first = db.findFirstProfile();
            if(travAgentID.equals(first.getTravAgentID())){
                // if the object shares the agent ID of the current user, display the information
                displayTravProf(first);
                shown++;
            }
            while(valid){
                // get the next profile object
                TravProf prof = db.findNextProfile();
                if(prof != null){
                    if(travAgentID.equals(prof.getTravAgentID())){
                        // if the travel agent of the object & the user are the same, display the information
                        displayTravProf(prof);
                        shown++;
                    }
                } else {
                    // if the next profile is null, there are no more to read
                    valid = false;
                }
            }
        }
        if(shown == 0){
            // if no profiles were shown, display the following message
            System.out.println("==================================================================================");
            System.out.println("There are no profiles to display.");
            System.out.println("==================================================================================");
        }else{
            // if some were shown & there are none left, display the following message
            System.out.println("There are no more profiles to display.");
            System.out.println("==================================================================================");
        }

    }

    /** write changes to the database **/
    // write the recent changes to the database/file
    public void writeToDB(){
        db.writeAllTravProf(file);
    }

    /** initialize the database **/
    // initialize the database/file
    public void initDB(){
        db.initializeDatabase(file);
    }

    /** create profile **/
    // create a new traveler profile
    public TravProf createNewTravProf(){
        // prompt the user to enter all of the required information in order to create a profile
        System.out.println("*   \t To create a profile, you'll need to provide the following information   \t *");

        System.out.print("First Name: ");
        String fname = scan.nextLine();

        System.out.print("Last Name: ");
        String lname = scan.nextLine();

        System.out.print("Address: ");
        String add = scan.nextLine();

        System.out.print("Phone Number: ");
        String phone = scan.nextLine();

        System.out.print("Trip Cost: ");
        String cost = scan.nextLine();

        System.out.println("Travel Type:");
        System.out.println("(1) Business \t (2) Pleasure");
        String travType = scan.nextLine();

        System.out.println("Payment Type:");
        System.out.println("(1) Credit \t (2) Check \t (3) Debit \t (4) Invoice");
        String payType = scan.nextLine();

        // create the TravProf & MedCond objects
        MedCond mc = createNewMedCond();
        TravProf newProf = new TravProf(travAgentID, fname, lname, add, phone, Float.parseFloat(cost), travType, payType, mc);

        // add the new profile to the database
        db.insertNewProfile(newProf);

        // return the new object
        return newProf;
    }

    /** create MedCond object **/
    // create a new MedCond object
    public MedCond createNewMedCond(){
        // prompt the user to enter the necessary information to create a MedCond object
        System.out.print("Doctor Name: ");
        String docName = scan.nextLine();

        System.out.print("Doctor Phone Number: ");
        String docPhone = scan.nextLine();

        System.out.println("Allergies:");
        System.out.println("(1) None \t (2) Food \t (3) Medication \t (4) Other");
        String allergies = scan.nextLine();

        System.out.println("Illness:");
        System.out.println("(1) None \t (2) Heart \t (3) Diabetes \t (4) Asthma \t (5) Other");
        String illness = scan.nextLine();

        //return the object
        return new MedCond(docName, docPhone, allergies, illness);
    }

    /** main method **/
    // method to actually facilitate the interface
    public static void main(String[] args){
        // create an Interface object
        TravProfInterface profInterface = new TravProfInterface(args[0]);
        // initialize the database
        profInterface.initDB();

        // welcome the user to the system
        System.out.println("==================================================================================");
        System.out.println("* \t\t\t\t\t Welcome to the Integrated Travel System \t\t\t\t\t *");
        System.out.println("==================================================================================");

        // prompt the user until they quit the program
        while(!profInterface.userChoice.equals("7")) {
            // get the agent id prior to each selection
            System.out.print("\t Enter your ITS ID: ");
            profInterface.travAgentID = profInterface.scan.nextLine();
            profInterface.getUserChoice();

            // switch case to deal with all the possible choices
            switch (profInterface.userChoice) {
                /* create new profile */
                case "1" -> {
                    System.out.println("==================================================================================");
                    profInterface.displayTravProf(profInterface.createNewTravProf());
                    System.out.println("Profile Successfully Created!");
                    System.out.println("==================================================================================");
                }
                /* edit profile */
                case "2" -> {
                    System.out.print("Last Name: ");
                    profInterface.lname = profInterface.scan.nextLine();
                    profInterface.updateTravProf();
                }
                /* delete profile */
                case "3" -> {
                    System.out.print("Last Name: ");
                    profInterface.lname = profInterface.scan.nextLine();
                    profInterface.deleteTravProf();
                }
                /* search for a profile */
                case "4" -> {
                    System.out.print("Last Name: ");
                    profInterface.lname = profInterface.scan.nextLine();
                    profInterface.findTravProf();
                }
                /* display all profiles*/
                case "5" -> profInterface.displayAllTravProf();
                /* save database */
                case "6" -> {
                    profInterface.writeToDB();
                    System.out.println("==================================================================================");
                    System.out.println("Database Successfully Saved!");
                    System.out.println("==================================================================================");
                }
            }
        }
    }
}