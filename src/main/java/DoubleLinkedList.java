import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DoubleLinkedList {

    private Element first;
    private Stack<Element> deleted;

    DoubleLinkedList() {
        deleted = new Stack();
    }

    public ArrayList toArray() {
        ArrayList summary = new ArrayList();
        if (first == null) {
            return summary;
        }


        summary.add(first.getValue());
        Element next = first.getNext();
        while (next != first) {
            summary.add(next.getValue());
            next = next.getNext();
        }

        return summary;
    }

    public int getFirstValue() {
        return first.getValue();
    }

    public Element findInDDL(int value) {
        if (first.getValue() == value) {
            return first;
        }

        Element next = first.getNext();
        while (next != first) {
            if (next.getValue() == value) {
                return next;
            }
            next = next.getNext();
        }
        return null;
    }

    public boolean chain(int value) {

        // initiate with first element
        if (first == null) {
            first = new Element(value, true);
            first.setNext(first);
            first.setPrev(first);
            return true;
        }

        // chain between first and last
        Element elem = new Element(value);
        Element last = first.getPrev();
        last.setNext(elem);
        elem.setPrev(last);
        first.setPrev(elem);
        elem.setNext(first);
        return true;
    }

    public boolean removeElement(Element elem) throws Exception {
        if (elem == null) {
            throw new Exception("element to delete is null");
        }
        // if we remove the first element
        if (elem.isFirst()) {
            first = first.getNext();
            first.setFirst(true);
        }

        // base case : a different prev and next
        deleted.push(elem);
        elem.getPrev().setNext(elem.getNext());
        elem.getNext().setPrev(elem.getPrev());
        return true;
    }

    public boolean putBackLast() {
        if (deleted.isEmpty()) {
            return false;
        }
        Element put = deleted.pop();
        put.getPrev().setNext(put);
        put.getNext().setPrev(put);

        if (put.isFirst()) {
            first.setFirst(false);
            first = put;
        }
        return true;
    }

    public boolean removeElement(int value) throws Exception {
        return removeElement(this.findInDDL(value));
    }

    public String toString() {
        if(first==null){
            return "empty list";
        }
        String summary = "";

        summary += first.toString();
        Element next = first.getNext();
        while (next != first) {
            summary += next.toString();
            next = next.getNext();
        }

        return summary;
    }

    /**
     *
     * @return true if the list has been modified, false otherwise
     */
    public boolean putBackAll(){
        if(deleted.isEmpty()){ return false ;}
        while(!deleted.isEmpty()){
            this.putBackLast();
        }
        return true;
    }


    public boolean areThereDeletedElements(){
        return !deleted.isEmpty();
    }

    /**
     * class Element
     * An element contains the information of its previous element and of its next element
     */
    private class Element {
        private boolean first = false;
        private Element prev;
        private int value;
        private Element next;

        public boolean equals(Object o) {
            return o.getClass() == this.getClass() && value == ((Element) o).getValue();
        }

        public String toString() {
            return "<- " + value + " -> ";
        }

        Element(int v) {
            value = v;
        }

        Element(int v, boolean first) {
            value = v;
            this.first = first;
        }

        public Element getPrev() {
            return prev;
        }

        public void setPrev(Element prev) {
            this.prev = prev;
        }

        public int getValue() {
            return value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public boolean isFirst() {
            return first;
        }

        public void setFirst(boolean first) {
            this.first = first;
        }
    }
}
