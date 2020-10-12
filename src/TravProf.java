public class TravProf extends MedCond{
    /** variables **/
    String travAgentID;
    String firstName;
    String lastName;
    String address;
    String phone;
    float tripCost;
    String travelType;
    String paymentType;
    MedCond medCondInfo;

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
    private void updateFirstName(String name){
        firstName = name;
    }
    private void updateLastName(String name){
        lastName = name;
    }
    private void updateAddress(String add){
        address = add;
    }
    private void updatePhone(String num){
        phone = num;
    }
    private void updateTripCost(float cost){
        tripCost = cost;
    }
    private void updateTravelType(String type){
        travelType = type;
    }
    private void updatePaymentType(String type){
        paymentType = type;
    }
    private void updateMedCondInfo(MedCond info){
        // somehow update the info here..idk how yet
    }
}
