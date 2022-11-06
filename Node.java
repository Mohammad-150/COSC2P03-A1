
//Double linked list

class Node {

    Patient item; //Data stored in Node

    Node next;  //next node
    Node prev;  //previous node

    public Node(Node p, Patient person, Node n) {
        prev = p;
        item = person;
        next = n;
    }
}
