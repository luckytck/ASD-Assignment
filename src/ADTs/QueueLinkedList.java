/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADTs;

import java.io.Serializable;

/**
 *
 * @author ShiouChein
 */
public class QueueLinkedList <T> implements QueueInterface<T>, Serializable{

    private Node firstNode, lastNode;
    private int numberOfEntries;
    
    public QueueLinkedList() {
        clear();
    }
        
    private class Node implements Serializable {

        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry);
        Node oldRear = lastNode;
        lastNode = newNode;
        lastNode.data = newEntry;
        lastNode.next = null;
        
        if(isEmpty())
            firstNode = lastNode;
        else
            oldRear.next = lastNode;
        
        numberOfEntries ++;
    }

    @Override
    public T dequeue() {
        T data = null;
        data = firstNode.data;
        firstNode = firstNode.next;
        
        if(isEmpty())
            lastNode = null;
        
        numberOfEntries --;
        return data;
    }

    @Override
    public T getFront() {
        T data = null;
        if (!isEmpty()) {
            data = firstNode.data;
        }
        return data;
    }

    //check is this queue empty?
    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }
    
    public static void main(String[] args) {
        QueueInterface<Integer> test = new QueueLinkedList<>();
        
        test.enqueue(123);
        test.enqueue(145);
        System.out.println(test.dequeue());
        System.out.println("Front:" + test.getFront());
    }
    
}
