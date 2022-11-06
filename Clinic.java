import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Clinic {

    private Patient[] patients; //array of patients
    private WaitQueue wq;
    private Timer clock;

    public Clinic () {

        patients = new Patient[15]; //15 patients in the list

    }   //constructor

    public void monitor() {
        clock =  new Timer("09:00"); //Start time
        boolean vxTime = false;
        wq = new WaitQueue();

        for (int i=patients.length-1; i>0; i--){    //insert patients into the priority queue
            wq.insert(patients[i]);
        }
        wq.display();

        for (int i=patients.length-1; i>0; i--){    //insert patients into the priority queue
            wq.removeMax();
        }
        /*
        for (int i=1; i<120; i++){
            vxTime = clock.increase();
            System.out.println(clock.minute);
            if (vxTime){
                System.out.println(wq.removeMax().getName() + clock.hour+":"+clock.minute);
            }
        }
         */
    }

    /**This method reads the data from the txt file
     * then sends each line to Patient class to be saved
     */
    public void readData() {
        Patient person = null;
        
        try {
            File doc = new File("src/patients.txt");
            Scanner scan = new Scanner(doc);
            scan.nextLine();

            int counter = 0;
            while (scan.hasNextLine()) {

                String lineStr = scan.nextLine();
                person = new Patient(lineStr);
                patients[counter] = new Patient(lineStr);
                counter++;
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }   //readData

    public static void main(String[] args) {
        Clinic cl = new Clinic();
        cl.readData();
        cl.monitor();
    }
}   //Clinic
