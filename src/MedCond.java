public class MedCond {
    /** variables **/
    String mdContact;
    String mdPhone;
    String algType;
    String illType;
    /** constructor **/
    public MedCond (String contact, String phone, String alergyType, String illnessType) {
        mdContact = contact;
        mdPhone = phone;
        algType = alergyType;
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
        return algType;
    }
    public String getIllType(){
        return illType;
    }
    /** update methods **/
    private void updateMdContact(String contact){
        mdContact = contact;
    }
    private void updateMdPhone(String phone){
        mdPhone = phone;
    }
    private void updateAlgType(String type){
        if(type.equals("none") || type.equals("food") || type.equals("medication") || type.equals("other")) {
            algType = type;
        }
    }
    private void updateIllType(String type){
        if(type.equals("none") || type.equals("heart") || type.equals("diabetes") || type.equals("asthma") || type.equals("other")){
            illType = type;
        }
    }
}