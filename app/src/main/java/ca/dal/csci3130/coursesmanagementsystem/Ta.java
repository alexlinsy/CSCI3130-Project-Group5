package ca.dal.csci3130.coursesmanagementsystem;

public class Ta {
    public Ta(String name,String email){
        this.name = name;
        this.email = email;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
}
