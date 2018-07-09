package ca.dal.csci3130.coursesmanagementsystem;

public class TA {

    private String email;
    private String name;

    public TA(String name,String email){
        this.name = name;
        this.email = email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
}

