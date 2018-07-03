package ca.dal.csci3130.coursesmanagementsystem;
/**
 * Class that defines how the data will be stored in the
 * Firebase databse.
 */
public class UserInformation {
    /**
     * ID User's id
     * Name User's first name and last name
     * Faculty User's faculty
     * MailAddress  User's email address
     * Course Courses that user have already selected
     */
    public String Id;
    public String Name;
    public String Faculty;
    public String MailAddress;
    public String Course;
    public UserInformation(){

    }
    /**
     * Create a new user with the uid, name, faculty, mailaddress, course
     * @param Id A unique id created by Firebase
     * @param Name User's last name and first name
     * @param Faculty User's faculty
     * @param MailAddress User's e-mail address
     * @param Course User's course
     */
    public UserInformation(String Id,String Name,String Faculty,String MailAddress,String Course){
        this.Id = Id;
        this.Name=Name;
        this.Faculty=Faculty;
        this.MailAddress = MailAddress;
        this.Course = Course;

    }
   /* public String getId(){
        return Id;
    }
    public String getName (){
        return Name;
    }
    public String getFaculty (){
        return Faculty;
    }
    public String getMailAddress (){
        return MailAddress;
    }*/
}
