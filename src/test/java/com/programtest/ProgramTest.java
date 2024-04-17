package test.java.com.programtest;


import main.java.com.listofsubstring.ListStrings;
import main.java.com.listofsubstring.ListStringsGUI;

import javax.swing.*;
import java.util.Scanner;

public class ProgramTest {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Show with interface? (y/n)");
            switch (scanner.nextLine()) {
                case "y" -> listStringGUITest();
                case "n" -> listStringTest();
                default -> {
                    System.out.println("Incorrect input!");
                    continue;
                }
            }
            break;
        }
    }

    private static void listStringTest() {
        ListStrings listStrings = new ListStrings();
        listStrings.loadFromFile("ListOfSubstrings/src/resource/Strings.txt");

        System.out.println("Enter a substring to search for (case sensitive): ");
        String substring = scanner.nextLine();

        ListStrings searchResults = listStrings.search(substring);
        if (!searchResults.isEmpty()) {
            System.out.println("Found strings with \"" + substring + "\":");
            searchResults.iterateList(System.out::println);
        } else {
            System.out.println("No matches found.");
        }
    }

    private static void listStringGUITest() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListStringsGUI();
            }
        });
    }
}