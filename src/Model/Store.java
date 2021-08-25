package Model;

public class Store {
    protected int  food_id, food_number;
    protected double food_price;
    protected String food_name, food_kind, food_dateInput, food_dayMade, food_expired, food_origin;

    public Store( int food_id, String food_name,String food_kind , int food_number,double food_price , String food_dateInput, String food_dayMade, String food_expired, String food_origin) {

        this.food_id = food_id;
        this.food_number = food_number;
        this.food_price = food_price;
        this.food_name = food_name;
        this.food_kind = food_kind;
        this.food_dateInput = food_dateInput;
        this.food_dayMade = food_dayMade;
        this.food_expired = food_expired;
        this.food_origin = food_origin;
    }

    public Store(int food_id) {
        this.food_id = food_id;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getFood_number() {
        return food_number;
    }

    public void setFood_number(int food_number) {
        this.food_number = food_number;
    }

    public double getFood_price() {
        return food_price;
    }

    public void setFood_price(double food_price) {
        this.food_price = food_price;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_kind() {
        return food_kind;
    }

    public void setFood_kind(String food_kind) {
        this.food_kind = food_kind;
    }

    public String getFood_dateInput() {
        return food_dateInput;
    }

    public void setFood_dateInput(String food_dateInput) {
        this.food_dateInput = food_dateInput;
    }

    public String getFood_dayMade() {
        return food_dayMade;
    }

    public void setFood_dayMade(String food_dayMade) {
        this.food_dayMade = food_dayMade;
    }

    public String getFood_expired() {
        return food_expired;
    }

    public void setFood_expired(String food_expired) {
        this.food_expired = food_expired;
    }

    public String getFood_origin() {
        return food_origin;
    }

    public void setFood_origin(String food_origin) {
        this.food_origin = food_origin;
    }


}