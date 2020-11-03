import java.io.Serializable;

public class TravProf implements Serializable {
    /** variables **/
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
    public String getTravAgentID(){
        return travAgentID;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getAddress(){
        return address;
    }
    public String getPhone(){
        return phone;
    }
    public float getCost(){
        return tripCost;
    }
    public String getTravelType(){
        if(travelType.equals("1")){
            return "Business";
        }else{
            return "Pleasure";
        }
    }
    public String getPaymentType(){
        return switch (paymentType) {
            case "1" -> "Credit";
            case "2" -> "Check";
            case "3" -> "Debit";
            default -> "Invoice";
        };
    }
    public MedCond getMedCondInfo(){
        return medCondInfo;
    }

    /** update methods **/
    public void updateFirstName(String name){
        firstName = name;
    }
    public void updateLastName(String name){
        lastName = name;
    }
    public void updateAddress(String add){
        address = add;
    }
    public void updatePhone(String num){
        phone = num;
    }
    public void updateTripCost(float cost){
        tripCost = cost;
    }
    public void updateTravelType(String type){
        if(type.equals("Pleasure") || type.equals("Business")) {
            travelType = type;
        }
    }
    public void updatePaymentType(String type){
        switch (type) {
            case "1" -> paymentType = "Credit";
            case "2" -> paymentType = "Check";
            case "3" -> paymentType = "Debit";
            default -> paymentType = "Invoice";
        }
    }
    public void updateMedCondInfo(MedCond info){
        medCondInfo = info;
    }
}
