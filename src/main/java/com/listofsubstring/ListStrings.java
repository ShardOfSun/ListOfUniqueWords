package main.java.com.listofsubstring;

import main.java.com.listofsubstring.ListSubstrings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

public class ListStrings {

    private Node head;

    private static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    public void iterateList(Consumer<String> action) {
        Node current = head;
        while (current != null) {
            action.accept(current.data);
            current = current.next;
        }
    }

    public void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void printList(Consumer<String> action) {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public ListStrings search(String substring) {
        ListStrings resultList = new ListStrings();
        Node current = head;
        while (current != null) {
            if (current.data.contains(substring)) {
                resultList.add(current.data);
            }
            current = current.next;
        }

        return resultList;
    }

    public void loadFromFile(String strings) {
        try (BufferedReader reader = new BufferedReader(new FileReader(strings))) {
            String line;
            while ((line = reader.readLine()) != null) {
                add(line);
            }
        } catch (IOException e) {
            System.out.println("File reading error: " + e.getMessage());
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}