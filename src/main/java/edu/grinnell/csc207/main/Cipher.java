package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;
/**
 * Encode and decode with Ciphers.
 */
public class Cipher {
  /**
   * @param int
   */
  public static final int EXPECTEDARGS = 4;
  /**
   * @param str
   * @return int
   * Checks if a String is all lower case.
   */
  private static int allLowerCase(String str) {
    for (int i = 0; i < str.length(); i++) {
      if ((int) (str.charAt(i)) < 'a' || ((int) (str.charAt(i)) > 'z')) {
        return -1;
      } // if
    } // for
    return 1;
  } // allLowerCase (String)
  /**
   * @param c
   * @return int
   * Checks if a char is all lower case.
   */
  private static int allLowerCase(char c) {
    if ((int) (c) < 'a' || ((int) (c) > 'z')) {
      return -1;
    } // if
    return 1;
  } // allLowerCase (char)
  /**
   * @param args
   * Encodes and decodes text.
   */
  public static void main(String[] args) {
    if (args.length != EXPECTEDARGS) {
      System.err.println("Error: Incorrect number of arguments");
      return;
    } // if
    char eORd = 'A';
    for (int i = 0; i < EXPECTEDARGS; i++) {
      if (args[i].equals("-encode")) {
        eORd = 'E';
      } else if (args[i].equals("-decode")) {
        eORd = 'D';
      } // elseif
    } // for
    if (eORd == 'A') {
      System.err.println("Error: Please select to \"-encode\" or \"-decode\".");
      return;
    } // if

    char cORv = 'A';
    for (int i = 0; i < EXPECTEDARGS; i++) {
      if (args[i].equals("-caesar")) {
        cORv = 'C';
      } else if (args[i].equals("-vigenere")) {
        cORv = 'V';
      } // elseif
    } // for
    if (cORv == 'A') {
      System.err.println("Error: Please select to \"-caesar\" or \"-vigenere\".");
      return;
    } // if

    String sentance = "";
    int sentancePos = 0;
    for (int i = 0; i < EXPECTEDARGS; i++) {
      if (!(args[i].equals("-encode") || args[i].equals("-decode") || args[i].equals("-caesar")
          || args[i].equals("-vigenere"))) {
        sentance = args[i];
        sentancePos = i + 1;
        break;
      } // if
    } // for

    if (allLowerCase(sentance) == -1) {
      System.err.println("Error: Valid sentance not found");
      return;
    } // if

    PrintWriter pen = new PrintWriter(System.out, true);


    if (cORv == 'V') {
      String key = "";
      for (int i = sentancePos; i < EXPECTEDARGS; i++) {
        if (!(args[i].equals("-encode") || args[i].equals("-decode") || args[i].equals("-caesar")
            || args[i].equals("-vigenere"))) {
          key = args[i];
        } // if
      } // for

      if (key.equals("")) {
        System.err.println("Error: Key is too short");
        return;
      } // if

      if (allLowerCase(key) == -1) {
        System.err.println("Error: Valid key not found");
        return;
      } // if


      if (eORd == 'E') {
        pen.println(CipherUtils.vigenereEncrypt(sentance, key));
      } else {
        pen.println(CipherUtils.vigenereDecrypt(sentance, key));
      } // else
    } else {
      char key = ' ';
      int keyFound = 0;
      for (int i = sentancePos; i < EXPECTEDARGS; i++) {
        if (args[i].length() == 1) {
          key = args[i].charAt(0);
          keyFound = 1;
        } // if
      } // for
      if (keyFound == 0) {
        System.err.println("Error: No acceptable key found");
        return;
      } // if

      if (allLowerCase(key) == -1) {
        System.err.println("Error: Please enter a key from 'a' to 'z'.");
        return;
      } // if
      if (eORd == 'E') {
        pen.println(CipherUtils.caesarEncrypt(sentance, key));
      } else {
        pen.println(CipherUtils.caesarDecrypt(sentance, key));
      } // else
    } // else
  } // main (Sting[])
} // class Cipher
