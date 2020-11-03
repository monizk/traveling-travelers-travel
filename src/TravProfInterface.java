import java.util.Scanner;

// TESTING NOTES:
// create works
// edit works
// search works
// delete works

// OVERARCHING ISSUE:
// these things are isolated to individual runs of the program--I DON'T KNOW IF THAT'S HOW IT SHOULD BE OR NOT
// I feel like if I make an account and save it to the database, it should stay there even if I stop & restart
// the program--but I don't know!!

public class TravProfInterface{
    /** display all information about a given travel profile **/
    public static void displayInformation(TravProf prof){
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

    /** display all profiles **/
    public static void displayProfiles(TravProfDB db){
        db.initializeDatabase();
    }

    /** print out the main menu of options (1-7) **/
    public static void options(){
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
    }

    /** create profile **/
    public static void create(String id, TravProfDB db){
        Scanner scan = new Scanner(System.in);

        System.out.println("==================================================================================");
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

        // create the TravProf & MedCond objects
        MedCond mc = new MedCond(docName, docPhone, allergies, illness);
        TravProf newProf = new TravProf(id, fname, lname, add, phone, Float.parseFloat(cost), travType, payType, mc);

        // add the new profile to the database
        db.insertNewProfile(newProf);
        db.writeAllTravProf();

        displayInformation(newProf);
        System.out.println("==================================================================================");
        System.out.println("Profile Successfully Created!");
        System.out.println("==================================================================================");
    }

    /** edit profile **/
    public static void edit(String lname, String id, TravProfDB db){
        // get & display relevant information
        Scanner scan = new Scanner(System.in);
        TravProf prof = db.findProfile(id, lname);
        String ill = prof.getMedCondInfo().getIllType();
        String alg = prof.getMedCondInfo().getAlgType();
        String phone = prof.getMedCondInfo().getMdPhone();
        String doc = prof.getMedCondInfo().getMdContact();
        displayInformation(prof);

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

    /** delete profile **/
    public static void delete(String lname, String id, TravProfDB db){
        System.out.println("==================================================================================");
        if(db.deleteProfile(id, lname)){
            System.out.println("Profile Successfully Deleted");
        }else {
            System.out.println("Profile Not Deleted: Either Does Not Exist OR Is Under A Different Travel Agent");
        }
        System.out.println("==================================================================================");
    }

    /** search for a profile **/
    public static void search(String lname, String id, TravProfDB db){
        displayInformation(db.findProfile(id, lname));
    }

    /** main method **/
    public static void main(String[] args){
        System.out.println("==================================================================================");
        System.out.println("* \t\t\t\t\t Welcome to the Integrated Travel System \t\t\t\t\t *");
        System.out.println("==================================================================================");

        TravProfDB db = new TravProfDB();
        db.initializeDatabase();        //HHEEEEERRRRRRRRRREEEEEEEEE
        String option = "0";

        while(!option.equals("7")) {
            System.out.print("\t Enter your ITS ID: ");
            Scanner scan = new Scanner(System.in);
            String id = scan.nextLine();
            options();
            option = scan.nextLine();
            switch (option) {
                /* create new profile */
                case "1" -> create(id, db);
                /* edit profile */
                case "2" -> {
                    System.out.println("Last Name: ");
                    String lname = scan.nextLine();
                    // maybe add a universal db object and just pass it as a parameter to each of these helper method things
                    edit(lname, id, db);
                }
                /* delete profile */
                case "3" -> {
                    System.out.println("Last Name: ");
                    String lName = scan.nextLine();
                    delete(lName, id, db);
                }
                /* search for a profile */
                case "4" -> {
                    System.out.println("Last Name: ");
                    String lnAme = scan.nextLine();
                    search(lnAme, id, db);
                }
                /* display all profiles*/
                case "5" -> displayProfiles(db);
                /* save database */
                case "6" -> db.writeAllTravProf();          //HEEEEEERRRREEE
            }
        }
    }
}
