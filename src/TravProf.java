public class TravProf extends MedCond{
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
    public TravProf(String agentID){
        travAgentID = agentID;
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
        return travelType;
    }
    public String getPaymentType(){
        return paymentType;
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
        if(type == "Pleasure" || type == "Business") {
            travelType = type;
        }
    }
    public void updatePaymentType(String type){
        if(type == "Credit" || type == "Check" || type == "Debit" || type == "Invoice"){
            paymentType = type;
        }

    }
    public void updateMedCondInfo(MedCond info){
        MedCond conditions = new MedCond();

    }
}
