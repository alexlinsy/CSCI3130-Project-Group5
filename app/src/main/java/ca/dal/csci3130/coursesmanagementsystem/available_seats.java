package ca.dal.csci3130.coursesmanagementsystem;

public class available_seats {
    public int max_seat;
    public int avaliable_seat;
    public int current_seat;
    public String percentage;
    public available_seats(){
        max_seat = 0;
        avaliable_seat = 0;
        current_seat = 0;
        percentage  = "%";
    }

    public int getMax_seat() {
        return max_seat;
    }

    public void setMax_seat(int max_seat) {
        this.max_seat = max_seat;
    }

    public int getCurrent_seat() {
        return current_seat;
    }

    public void setCurrent_seat(int current_seat) {
        this.current_seat = current_seat;
    }

    public int getAvaliable_seat() {
        return avaliable_seat;
    }

    public void setAvaliable_seat(int avaliable_seat) {
        this.avaliable_seat = avaliable_seat;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
