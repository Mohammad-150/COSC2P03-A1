import java.util.Scanner;

public class Patient {

    private String name;    //name of patient
    private String gender;  //gender of patient
    private int age;        //age of patient
    private String occp;    //occupation of patient
    private String health;  //health condition of patient
    private String arrival; //time of arrival of patient
    private int level;      //priority of patient

    public Patient (String data) {
        Scanner fetch = new Scanner(data);  //scanner reads the whole line
        fetch.useDelimiter("\t");           //read between tabs

        while (fetch.hasNext() ) { //while scanner has next
            setName(fetch.next());
            setGender(fetch.next());
            setAge(fetch.next());
            setOccp(fetch.next());
            setHealth(fetch.next());
            setArrival(fetch.next());
        }

    }

    //This method returns the priority of the patient depending on his/her age, occupation, health condition
    public int getPriority(){
        level =0;

        if (age >= 60) {
            level++;
        }

        if (occp.equals("Teacher")  | occp.equals("Nurse") | occp.equals("Care Giver")) {
            level++;
        }

        if (health.equals("None") == false) {
            level++;
        }
        return level;
    }

    //This method sets the name of the patient with the parameter
    private void setName(String n) {
        name = n;
    }

    //This method sets the gender of the patient with the parameter
    private void setGender(String g) {
        gender = g;
    }

    //This method sets the age of the patient with the parameter
    private void setAge(String ages) {
        age = Integer.parseInt(ages);
    }

    //This method sets the occupation of the patient with the parameter
    private void setOccp(String occupation) {
        occp = occupation;
    }

    //This method sets the health condition of the patient with the parameter
    private void setHealth(String heal) {
        health = heal;
    }

    //This method sets the arrival time of the patient with the parameter
    private void setArrival(String arri) {
        arrival = arri;
    }

    //This method returns the name of the patient
    public String getName() {
        return name;
    }

    //This method returns the gender of the patient
    public String getGender() {
        return gender;
    }

    //This method returns the age of the patient
    public int getAge() {
        return age;
    }

    //This method returns the occupation of the patient
    public String getOccp() {
        return occp;
    }

    //This method returns the health condition of the patient
    public String getHealth() {
        return health;
    }

    //This method returns the arrival time of the patient
    public String getArrival() {
        return arrival;
    }

}