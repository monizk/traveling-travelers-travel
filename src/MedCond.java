import java.io.Serializable;

public class MedCond implements Serializable{
    /** variables **/
    // these variables are all assigned in the constructor
    String mdContact;
    String mdPhone;
    String algType;
    String illType;

    /** constructor **/
    // creates an instance of this class
    public MedCond(String contact, String phone, String allergyType, String illnessType) {
        mdContact = contact;
        mdPhone = phone;
        algType = allergyType;
        illType = illnessType;
    }

    /** getter methods **/
    // gets the doctor's name
    public String getMdContact(){
        return mdContact;
    }
    // gets the doctor's phone number
    public String getMdPhone(){
        return mdPhone;
    }
    // gets the type of allergy
    public String getAlgType(){
        return switch (algType) {
            case "1" -> "None";
            case "2" -> "Food";
            case "3" -> "Medication";
            case "4" -> "Other";
            default -> algType;
        };
    }
    // gets the type of illness
    public String getIllType(){
        return switch (illType) {
            case "1" -> "None";
            case "2" -> "Heart";
            case "3" -> "Diabetes";
            case "4" -> "Asthma";
            case "5" -> "Other";
            default -> illType;
        };
    }

    /** update methods **/
    // updates the doctor's name
    public void updateMdContact(String contact){
        mdContact = contact;
    }
    // updates the doctor's phone number
    public void updateMdPhone(String phone){
        mdPhone = phone;
    }
    // updates the type of allergy
    public void updateAlgType(String type){
        if(type.toLowerCase().equals("none") || type.toLowerCase().equals("food") || type.toLowerCase().equals("medication") || type.toLowerCase().equals("other")) {
            algType = type;
        }
    }
    // updates the type of illness
    public void updateIllType(String type){
        if(type.toLowerCase().equals("none") || type.toLowerCase().equals("heart") || type.toLowerCase().equals("diabetes") || type.toLowerCase().equals("asthma") || type.toLowerCase().equals("other")){
            illType = type;
        }
    }
}