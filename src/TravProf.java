import java.io.Serializable;

public class TravProf implements Serializable {
    /** variables **/
    // these variables are all assigned in the constructor
    private String travAgentID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private float tripCost;
    private String travelType;
    private String paymentType;
    private MedCond medCondInfo;

    /** constructor **/
    // creates an instance of this class
    public TravProf(String agentID, String fName, String lName, String addy, String fone, float tCost, String travType, String payType, MedCond mc) {
        travAgentID = agentID;
        firstName = fName;
        lastName = lName;
        address = addy;
        phone = fone;
        tripCost = tCost;
        travelType = travType;
        paymentType = payType;
        medCondInfo = mc;
    }

    /** getter methods **/
    // get the travel agent id
    public String getTravAgentID(){
        return travAgentID;
    }
    // get the first name
    public String getFirstName(){
        return firstName;
    }
    // get the last name
    public String getLastName(){
        return lastName;
    }
    // get the address
    public String getAddress(){
        return address;
    }
    // get the phone number
    public String getPhone(){
        return phone;
    }
    // get the trip cost
    public float getCost(){
        return tripCost;
    }
    // get the type of travel
    public String getTravelType(){
        return switch (travelType) {
            case "1" -> "Business";
            case "2" -> "Pleasure";
            default -> travelType;
        };
    }
    // get the type of payment
    public String getPaymentType(){
        return switch (paymentType) {
            case "1" -> "Credit";
            case "2" -> "Check";
            case "3" -> "Debit";
            case "4" -> "Invoice";
            default -> paymentType;
        };
    }
    // get the medical information--which is a MedCond object
    public MedCond getMedCondInfo(){
        return medCondInfo;
    }

    /** update methods **/
    // update the first name
    public void updateFirstName(String name){
        firstName = name;
    }
    // update the last name
    public void updateLastName(String name){
        lastName = name;
    }
    // update the address
    public void updateAddress(String add){
        address = add;
    }
    // update the phone number
    public void updatePhone(String num){
        phone = num;
    }
    // update the cost of the trip
    public void updateTripCost(float cost){
        tripCost = cost;
    }
    // update the travel type
    public void updateTravelType(String type){
        if(type.equals("Pleasure") || type.equals("Business")) {
            travelType = type;
        }
    }
    // update the payment type
    public void updatePaymentType(String type){
        switch (type) {
            case "1" -> paymentType = "Credit";
            case "2" -> paymentType = "Check";
            case "3" -> paymentType = "Debit";
            default -> paymentType = "Invoice";
        }
    }
    // update the medical info--which is found in the MedCond object
    public void updateMedCondInfo(MedCond info){
        medCondInfo = info;
    }
}
