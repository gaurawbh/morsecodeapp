package morsecodeapp;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

/**
 * @author g90_s gets an instance of the Morse code list. Reads from a plain
 * text file and converts it to a Morse code text file.
 */
public class TextToMorse {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String fileToRead = "C:\\Users\\g90_s\\Desktop\\plainText.txt";
        String fileToWrite = "C:\\Users\\g90_s\\Desktop\\morseCode.txt";
//        String fileToRead = "your file path";
//        String fileToWrite = "your file path";
        MorseCode morseCode = new MorseCode();
        List<String> morseCodeList = morseCode.getFullMorseList();

        InputStream in = new FileInputStream(fileToRead);
        Reader r = new InputStreamReader(in);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite))) {
            int i;
            while ((i = r.read()) != -1) {
                writer.write(morseCodeList.get(i));
                /**
                 * Using space Delimiter to read each morse code as a word from
                 * a file when converting the morse code to a plain text file.
                *
                 */
                writer.write(" ");

            }
        }
    }

}
