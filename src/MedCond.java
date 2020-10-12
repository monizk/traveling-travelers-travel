public class MedCond {
    /** variables **/
    String mdContact;
    String mdPhone;
    String algType;
    String illType;

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
        algType = type;
    }
    private void updateIllType(String type){
        illType = type;
    }
}

