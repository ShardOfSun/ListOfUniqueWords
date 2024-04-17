package main.java.com.listofsubstring;

import main.java.com.listofsubstring.ListStrings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ListStringsGUI extends JFrame {
    private ListStrings listStrings = new ListStrings();
    private JTextArea textArea = new JTextArea(20, 50);
    private JTextField inputField = new JTextField(20);
    private JButton loadButton = new JButton("Load File");
    private JButton searchButton = new JButton("Search");


    public ListStringsGUI() {
        super("List Strings GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Setup text area
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Setup panel for input and buttons
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter substring:"));
        panel.add(inputField);
        panel.add(loadButton);
        panel.add(searchButton);

        // Add components to frame
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Configure buttons
        searchButton.setEnabled(false);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadFile();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSearch(inputField.getText());
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("ListOfSubstrings/src/resource"));

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            listStrings.loadFromFile(fileChooser.getSelectedFile().getAbsolutePath());
            textArea.setText("File loaded successfully.\n");
            searchButton.setEnabled(true);
        }
    }

    private void performSearch(String substring) {
        ListStrings results = listStrings.search(substring);
        textArea.append("\nResults for \"" + substring + "\":\n");
        if (!results.isEmpty()) {
            results.iterateList(data -> textArea.append(data + "\n"));
        } else {
            textArea.append("No matches found.\n");
        }
    }
}
