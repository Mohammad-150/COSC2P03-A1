

public class WaitQueue {

    private Node	front;		// front node in the queue
    private Node	tail;		// rear node in the queue
    private int		count;		// number of nodes in the queue
    private Timer clock;        // timer for clock

    public WaitQueue() {
        front = null;
        tail = front;
        count = 0;

    } //constructor

    /**This method removes the first node which is the highest priority
     * @return  Patient that will be removed
     */
    public Patient removeMax(){
        Node deleted;   //node that will store the deleted patient
        deleted = front;
        if (front.next != null){
            front.next.prev = null;
        }
        front = front.next;

        return deleted.item; //return the removed patient
    }

    /**This method traverses the queue to find the correct spot to insert the patient
     * @param pt  patient to be inserted
     */
    public void insert(Patient pt) {
        Node nNode;     //new node
        Node p;         //pointer
        Node q = null;  //pointer
        nNode = new Node(null,pt,null); //New node to be inserted
        clock = new Timer(pt.getArrival()); //To compare the time arrivals of the patients
        int temp =0;    //determines who should go first if the priority is equal

        if (front == null){ //if list is empty
            front = nNode;  //new node is front
        }
        else if (front.item.getPriority() <= nNode.item.getPriority()) {//if front node has less priority than new node
            nNode.next = front;
            nNode.next.prev = nNode;
            front = nNode;
        }
        else { //look for the correct position to insert the new node
            p = front;
            while (p != null && p.item.getPriority() > nNode.item.getPriority() ){ //traverse until p is null or where new node has higher priority
                q = p;
                p = p.next;
            }
            nNode.prev = q;
            q.next = nNode;
            nNode.next = p;
            if (p != null){
                p.prev = nNode;
            }

            while (front.prev !=null){
                front = front.prev;
            }
        }

    }   //insert


    //To test the queue
    public void display() {
        while (front.prev != null){
            front = front.prev;
        }
        Node temp = front;
        while (temp != null){
            System.out.println(temp.item.getName() +"\t"+  temp.item.getArrival() +"\tPriority=" + temp.item.getPriority());
            temp = temp.next;
        }
    }

    /**This method removes the first patent in the queue
     * @return  Patient removed patient
     */
    public Patient leave() {
        Patient p = null;  //patient to be removed

        if (front == null) {
            System.out.println("No item in the queue.");
        } else {
            p = front.item;
            front = front.next;
            count = count - 1;
            if (count <= 0) {
                tail = null;
            }
        }
        return p;
    }   //leave

}   //WaitQueue
