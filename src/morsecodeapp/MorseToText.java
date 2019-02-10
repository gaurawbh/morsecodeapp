package morsecodeapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author g90_s This app reads the morse code from a file, converts and writes
 * it to a plain text file.
 */
public class MorseToText {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileToRead = "C:\\Users\\g90_s\\Desktop\\morseCode.txt";
        String fileToWrite = "C:\\Users\\g90_s\\Desktop\\decodedMorse.txt";
//        String fileToRead = "your file path";
//        String fileToWrite = "your file path";
        MorseCode morseCode = new MorseCode();
        List<String> morseCodeList = morseCode.getFullMorseList();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite))) {
            Scanner scan = new Scanner(new File(fileToRead));
            while (scan.hasNext()) {
                String s = scan.next();
                writer.write((char) morseCodeList.indexOf(s));
            }
        }
    }

}
