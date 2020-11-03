import java.util.Scanner;

// TESTING NOTES:

// OVERARCHING ISSUE:
// these things are isolated to individual runs of the program--I DON'T KNOW IF THAT'S HOW IT SHOULD BE OR NOT
// I feel like if I make an account and save it to the database, it should stay there even if I stop & restart
// the program--but I don't know!!

public class TravProfInterface{
    /** variables **/
    static String userChoice = "0";
    static String travAgentID;
    static String lname;
    static Scanner scan = new Scanner(System.in);

    static TravProfDB db = new TravProfDB();
    static TravProf prof = db.findProfile(travAgentID, lname);

    /** constructor **/
    public TravProfInterface(String id){
        travAgentID = id;
    }

    /** display the options & get the user's choice **/
    public static void getUserChoice(){
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
        userChoice = scan.nextLine();
    }

    /** delete traveler profile **/
    public static void deleteTravProf(){
        System.out.println("==================================================================================");

        if(db.deleteProfile(travAgentID, lname)){
            System.out.println("Profile Successfully Deleted");
        } else {
            System.out.println("Profile Not Deleted: Either Does Not Exist OR Is Under A Different Travel Agent");
        }

        System.out.println("==================================================================================");
    }

    /** search for a profile **/
    public static void findTravProf(){
        if(db.findProfile(travAgentID, lname) != null){
            displayTravProf(db.findProfile(travAgentID, lname));
        } else {
            System.out.println("There are no profiles that match that description.");
        }
    }

    /** update an existing profile **/
    public static void updateTravProf(){
        // get & display relevant information
        String ill = prof.getMedCondInfo().getIllType();
        String alg = prof.getMedCondInfo().getAlgType();
        String phone = prof.getMedCondInfo().getMdPhone();
        String doc = prof.getMedCondInfo().getMdContact();
        displayTravProf(prof);

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
        // repeat this like 9 times or something stupid like that
        String choice = scan.nextLine();

        switch (Integer.parseInt(choice)) {
            case 1 -> {
                System.out.println("Update address: ");
                String newAddress = scan.nextLine();
                prof.updateAddress(newAddress);
            }
            case 2 -> {
                System.out.println("Update phone number: ");
                String newPhone = scan.nextLine();
                prof.updatePhone(newPhone);
            }
            case 3 -> {
                System.out.println("Update travel type: ");
                String newTrav = scan.nextLine();
                prof.updateTravelType(newTrav);
            }
            case 4 -> {
                System.out.println("Update trip cost");
                String newCost = scan.nextLine();
                prof.updateTripCost(Float.parseFloat(newCost));
            }
            case 5 -> {
                System.out.println("Update payment type");
                String newPay = scan.nextLine();
                prof.updatePaymentType(newPay);
            }
            case 6 -> {
                System.out.println("Update doctor name");
                String newDoc = scan.nextLine();
                MedCond md = new MedCond(newDoc, phone, alg, ill);
                prof.updateMedCondInfo(md);
            }
            case 7 -> {
                System.out.println("Update doctor phone number");
                String newP = scan.nextLine();
                MedCond md2 = new MedCond(doc, newP, alg, ill);
                prof.updateMedCondInfo(md2);
            }
            case 8 -> {
                System.out.println("Update illness");
                String newIll = scan.nextLine();
                MedCond md3 = new MedCond(doc, phone, newIll, alg);
                prof.updateMedCondInfo(md3);
            }
            case 9 -> {
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
    public static void displayTravProf(TravProf prof){
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
    public static void displayAllTravProf(){
        boolean valid = true;

        if(db.findFirstProfile() != null){
            displayTravProf(db.findFirstProfile());
            while(valid){
                TravProf prof = db.findNextProfile();
                if(prof != null && travAgentID == prof.getTravAgentID()){
                    displayTravProf(prof);
                } else {
                    valid = false;
                }
            }
            System.out.println("There are no more profiles to display.");
            System.out.println("==================================================================================");
        } else {
            System.out.println("==================================================================================");
            System.out.println("There are no profiles to display.");
            System.out.println("==================================================================================");
        }
    }

    /** write changes to the database **/
    public static void writeToDB(){
        db.writeAllTravProf();
    }

    /** initialize the database **/
    public static void initDB(){
        db.initializeDatabase();
    }

    /** create profile **/
    public static TravProf createNewTravProf(){
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

    /** create medCond object **/
    public static MedCond createNewMedCond(){
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
        MedCond mc = new MedCond(docName, docPhone, allergies, illness);

        return mc;
    }

    /** test method **/
    public static void test(){
        // initialize the database at the start of ever session
        // initDB();

        // only welcome them once
        System.out.println("==================================================================================");
        System.out.println("* \t\t\t\t\t Welcome to the Integrated Travel System \t\t\t\t\t *");
        System.out.println("==================================================================================");

        // prompt the user until they quit the program
        while(!userChoice.equals("7")) {
            // get their id prior to each selection
            System.out.print("\t Enter your ITS ID: ");
            travAgentID = scan.nextLine();
            getUserChoice();

            switch (userChoice) {
                /* create new profile */
                case "1" -> {
                    System.out.println("==================================================================================");
                    displayTravProf(createNewTravProf());
                    System.out.println("Profile Successfully Created!");
                    System.out.println("==================================================================================");
                }
                /* edit profile */
                case "2" -> {
                    System.out.println("Last Name: ");
                    lname = scan.nextLine();
                    updateTravProf();
                }
                /* delete profile */
                case "3" -> {
                    System.out.println("Last Name: ");
                    lname = scan.nextLine();
                    deleteTravProf();
                }
                /* search for a profile */
                case "4" -> {
                    System.out.println("Last Name: ");
                    lname = scan.nextLine();
                    findTravProf();
                }
                /* display all profiles*/
                case "5" -> displayAllTravProf();
                /* save database */
                case "6" -> {
                    writeToDB();
                    System.out.println("==================================================================================");
                    System.out.println("Database Successfully Saved!");
                    System.out.println("==================================================================================");
                }
            }
        }
    }

    /** main method **/
    public static void main(String[] args){
        test();
    }
}