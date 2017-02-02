/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Divij Bhatia
 */
public class DirectoryOperations {

    public void printPhoneNumbers(String path) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        String phoneNumberRegex = "(?:\\s+|)((0|(?:(\\+|)91))(?:\\s|-)*(?:(?:\\d(?:\\s|-)*\\d{9})|(?:\\d{2}(?:\\s|-)*\\d{8})|(?:\\d{3}(?:\\s|-)*\\d{7}))|\\d{10})(?:\\s+|)";
        Pattern pattern = Pattern.compile(phoneNumberRegex);
        BufferedReader br;
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try {
                    br = new BufferedReader(new FileReader(listOfFiles[i].getAbsolutePath()));
                    String strLine;
                    while ((strLine = br.readLine()) != null) {
                        String words[] = strLine.split(" ");
                        for (String w : words) {
                            Matcher matcher = pattern.matcher(w);
                            if (matcher.matches()) {
                                System.out.println(w);
                            }
                        }
                    }
                    br.close();
                } catch (Exception ex) {
                    System.out.println(ex.toString());
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            DirectoryOperations dl = new DirectoryOperations();
            BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
            String path=input.readLine();
            dl.printPhoneNumbers(path);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

}
