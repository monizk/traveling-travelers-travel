import java.io.Serializable;

public class MedCond implements Serializable{
    /** variables **/
    String mdContact;
    String mdPhone;
    String algType;
    String illType;

    /** constructor **/
    public MedCond(String contact, String phone, String allergyType, String illnessType) {
        mdContact = contact;
        mdPhone = phone;
        algType = allergyType;
        illType = illnessType;
    }

    /** getter methods **/
    public String getMdContact(){
        return mdContact;
    }
    public String getMdPhone(){
        return mdPhone;
    }
    public String getAlgType(){
        return switch (algType) {
            case "1" -> "None";
            case "2" -> "Food";
            case "3" -> "Medication";
            default -> "Other";
        };
    }
    public String getIllType(){
        return switch (illType) {
            case "1" -> "None";
            case "2" -> "Heart";
            case "3" -> "Diabetes";
            case "4" -> "Asthma";
            default -> "Other";
        };
    }

    /** update methods **/
    public void updateMdContact(String contact){
        mdContact = contact;
    }
    public void updateMdPhone(String phone){
        mdPhone = phone;
    }
    public void updateAlgType(String type){
        if(type.equals("none") || type.equals("food") || type.equals("medication") || type.equals("other")) {
            algType = type;
        }
    }
    public void updateIllType(String type){
        if(type.equals("none") || type.equals("heart") || type.equals("diabetes") || type.equals("asthma") || type.equals("other")){
            illType = type;
        }
    }
}