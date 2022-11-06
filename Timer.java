public class Timer {

    int hour;   //for hours
    int minute; //for minutes
    int vxtime; //for vaccination time

    public Timer (String pTime) {

        String[] arrOfStr = pTime.split(":");   //split the passed string with :
        hour = Integer.parseInt(arrOfStr[0]);   //sets the first element in array as hour
        minute = Integer.parseInt(arrOfStr[1]); //sets the second element in array as minute

    }

    /**This method increases time by 1 minute and reset vx time
     * @return  true if vaccination is done
     */
    public boolean increase() {
        boolean vxDone = false;
        if ( minute < 60) {
            minute++;
        } else {
            minute = 0;
            hour++;
        }
        if (vxtime < 15) {
            vxtime++;
        } else {
            vxtime = 0;
            vxDone = true;
        }
        return vxDone;
    }   //increase

    /**This method compares the current patient and the next patient
     * in the queue and returns number.
     * @param cTime time to be compared with current patient time.
     * @return  -1 (less than), 0 (equal), or 1 (greater than).
     */
    public int compare(String cTime) {
        int tempHour=0;
        int tempMin=0;
        int result=0;

        String[] ar = cTime.split(":");
        tempHour = Integer.parseInt(ar[0]);
        tempMin = Integer.parseInt(ar[1]);

        if (tempHour < hour) {
            result = -1;
        } else if (tempHour > hour) {
            result = 1;
        } else {
            if (tempMin < minute) {
                result = -1;
            } else if (tempMin > minute) {
                result = 1;
            } else {
                result =0;
            }
        }
        return result;
    }   //compare
}
