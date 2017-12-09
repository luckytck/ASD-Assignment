package ADTs;

import java.io.Serializable;

/**
 * LinkedList.java A class that implements the ADT list by using a circular
 * doubly chain of nodes, with the node implemented as an inner class.
 */
public class LinkedList<T> implements ListInterface<T>, Serializable {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedList() {
        clear();
    }

    private class Node implements Serializable{

        private T data;
        private Node next;
        private Node previous;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
            firstNode.next = firstNode;
            firstNode.previous = firstNode;
        } else {
            Node lastNode = firstNode.previous;
            lastNode.next = newNode;
            newNode.previous = lastNode;
            newNode.next = firstNode;
            firstNode.previous = newNode;
        }
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        Node newNode = new Node(newEntry);
        boolean isAdded = false;
        if (newPosition >= 1 && newPosition <= numberOfEntries + 1) {
            if (isEmpty() || newPosition == 1) {
                newNode.previous = firstNode.previous;
                newNode.next = firstNode;
                firstNode = newNode;
            } else {
                Node nodeBefore = firstNode;
                for (int i = 1; i < newPosition - 1; i++) {
                    nodeBefore = nodeBefore.next;
                }
                Node nodeAfter = nodeBefore.next;
                newNode.next = nodeAfter;
                newNode.previous = nodeBefore;
                nodeBefore.next = newNode;
                nodeAfter.previous = newNode;
            }
            numberOfEntries++;
            isAdded = true;
        }
        return isAdded;
    }

    @Override
    public T remove(int givenPosition) {
        T data = null;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            if (givenPosition == 1) {
                data = firstNode.data;
                Node lastNode = firstNode.previous;
                firstNode = firstNode.next;
                firstNode.previous = lastNode;
            } else {
                Node nodeBefore = firstNode;
                for (int i = 1; i < givenPosition - 1; i++) {
                    nodeBefore = nodeBefore.next;
                }
                data = nodeBefore.next.data;
                Node nodeAfter = nodeBefore.next.next;
                nodeBefore.next = nodeAfter;
                nodeAfter.previous = nodeBefore;
            }
            numberOfEntries--;
        }
        return data;
    }

    @Override
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isReplaced = false;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            if (givenPosition == 1) {
                firstNode.data = newEntry;
            } else {
                Node nodeBefore = firstNode;
                for (int i = 1; i < givenPosition - 1; i++) {
                    nodeBefore = nodeBefore.next;
                }
                Node nodeCurrent = nodeBefore.next;
                nodeCurrent.data = newEntry;
            }
            isReplaced = true;
        }
        return isReplaced;
    }

    @Override
    public T getEntry(int givenPosition) {
        T data = null;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            if (givenPosition == 1) {
                return firstNode.data;
            } else {
                Node nodeBefore = firstNode;
                for (int i = 1; i < givenPosition - 1; i++) {
                    nodeBefore = nodeBefore.next;
                }
                data = nodeBefore.next.data;
                return data;
            }
        }
        return data;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean isContains = false;
        for (int i = 1; i <= numberOfEntries; i++) {
            if (getEntry(i) == anEntry) {
                isContains = true;
            }
        }
        return isContains;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        if (firstNode == null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    public static void main(String[] args) {
        ListInterface<Integer> list = new LinkedList<>();
        System.out.println("Add 1: " + list.add(1));
        System.out.println("Add 3: " + list.add(3));
        System.out.println("Add 2 at position 2: " + list.add(2, 2));
        System.out.println("Add 4 at position 4: " + list.add(4, 4));
        System.out.println("Add 0 at position 1: " + list.add(1, 0));
        System.out.print("List: ");
        for (int i = 1; i <= list.getNumberOfEntries(); i++) {
            System.out.print(list.getEntry(i) + " ");
        }
        System.out.println("\nReplace 10 at position 1: " + list.replace(1, 10));
        System.out.print("List: ");
        for (int i = 1; i <= list.getNumberOfEntries(); i++) {
            System.out.print(list.getEntry(i) + " ");
        }
        System.out.println("\nRemove data at position 1: " + list.remove(1));
        System.out.print("List: ");
        for (int i = 1; i <= list.getNumberOfEntries(); i++) {
            System.out.print(list.getEntry(i) + " ");
        }
        System.out.println("\nContains 1: " + list.contains(1));
        System.out.println("Contains 10: " + list.contains(10));
        System.out.println("Is Full? : " + list.isFull());
        System.out.println("Is Empty? : " + list.isEmpty());
        
    }
}
