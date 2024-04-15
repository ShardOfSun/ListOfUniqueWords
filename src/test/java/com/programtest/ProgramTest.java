package test.java.com.programtest;

import main.java.com.listofsubstring.ListStrings;
import main.java.com.listofsubstring.ListSubstrings;

import java.util.Scanner;

public class ProgramTest {
    public static void main(String[] args) {
        ListStrings listStrings = new ListStrings();
        Scanner scanner = new Scanner(System.in);
        listStrings.loadFromFile("ListOfSubstrings/src/resourse/Strings.txt");

        System.out.println("Enter a substring to search for (case sensitive): ");
        String substring = scanner.nextLine();

        ListStrings searchResults = listStrings.search(substring);
        if (!searchResults.isEmpty()) {
            System.out.println("Found strings with \"" + substring + "\":");
            searchResults.printList();
        } else {
            System.out.println("No matches found.");
        }
    }
}