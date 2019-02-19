import java.util.*;

public class Main {

  public static void main(String[] args) {
    DynamicList myListE = new DynamicList();

    DynamicList myList = new DynamicList();

    myList.insertFirst(7);
    myList.insertFirst(2);
    myList.insertFirst(1);

    System.out.print("List: ");
    myList.print();

    DynamicList myList2 = new DynamicList();
    myList2.insertFirst(4);
    myList2.insertFirst(5);
    System.out.print("List: ");
    myList2.print();

    System.out.print("Empty List: ");
    myListE.print();

    System.out.println();
    System.out.println("Append...");
    myList.appendList(myList2);
    myList.print();

    System.out.println();
    myList.print();
    System.out.println("Reverse...");
    myList.reverse(myList2);
    myList.print();
    System.out.println();

    System.out.println("Reverse Empty List...");
    myListE.reverse(myListE);
    myListE.print();

    System.out.println();
    myList.print();
    System.out.println("Delete mid...");
    myList.deleteMid(myList);
    myList.print();
    System.out.println();

    System.out.println("Delete mid in Empty List...");
    myListE.deleteMid(myListE);
    myListE.print();
  }
}

class DynamicNode {

  private Object info;
  private DynamicNode next;

  public DynamicNode(Object x, DynamicNode n) {
    info = x;
    next = n;
  }

  public Object getInfo() {
    return info;
  }

  public DynamicNode getNext() {
    return next;
  }

  public void setInfo(Object x) {
    info = x;
  }

  public void setNext(DynamicNode n) {
    next = n;
  }

  public String toString() {
    return info.toString();
  }
}

class DynamicList {

  private DynamicNode head;

  public DynamicList() {
    head = null;
  }

  public DynamicList(DynamicNode head) {
    this.head = head;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void insertFirst(Object x) {
    DynamicNode q = new DynamicNode(x, null);
    if (!isEmpty()) {
      q.setNext(head);
    }
    head = q;
  }

  public DynamicNode getList() {
    return head;
  }

  public void print() {
    if (head == null) {
      System.out.println("null");
    }
    DynamicNode p = head;
    while (p != null) {
      System.out.print(p.getInfo() + ((p.getNext() != null) ? "->" : ""));
      p = p.getNext();
    }
    System.out.println();
  }

  public boolean appendList(DynamicList othrList) {
    DynamicNode next;
    DynamicNode last = null;
    DynamicNode nd = head;

    if(!isEmpty()) {
      while (nd != null) {

        next = nd.getNext();          //sets next to be the 2nd item in the list
        last = nd;                    //sets the last item to be the current item
        nd = next;                    //sets current item to the next item

      }

      last.setNext(othrList.head);

      return true;

    }else{
      System.out.println("Error: List is empty");
      return false;
    }

  }

  public void reverse(DynamicList list) {
    DynamicNode next = null;
    DynamicNode last = null;
    DynamicNode nd = head;

    if(!isEmpty()) {
      while (nd != null) {
        next = nd.getNext();        //sets next to next item in list
        nd.setNext(last);           //sets next item to last item
        last = nd;                  //sets last to current item
        nd = next;                  //sets current to next

      }

      head = last;                   //sets head to the last item
    }else{
      System.out.println("Error: List is empty");
    }


  }

  public Object deleteMid(DynamicList list) {

    DynamicNode top = head;
    DynamicNode fast = head;
    DynamicNode slow = head;
    DynamicNode last = null;

    if(!isEmpty()) {
      while (top != null
          && top.getNext() != null) {      //checks if top is null and if next is null
        top = top.getNext().getNext();                    //sets top to the next next item
      }

      //after going through the while, if top is null then there is an even amount of items in list
      if (top == null) {
        System.out.println("Error: The list is even, no middle node to remove.");

        return list;
      } else {                                            //if amount of items is odd it continues

        while (fast != null && fast.getNext() != null) {
          fast = fast.getNext().getNext();              //sets fast to next next item
          last = slow;                                  //sets last item to slow
          slow = slow.getNext();                        //sets slow to next item
        }

        last.setNext(last.getNext().getNext());
        return list;

      }

    }else{
      System.out.println("Error: List is empty");
      return  list;
    }
  }
}
