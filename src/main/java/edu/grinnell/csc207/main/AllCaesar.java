package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

/**
 * Print out all possible Caesar Ciphers.
 */
public class AllCaesar {
  /**
  * @param args
  * Main method that takes in args
  */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != 2) {
      System.err.println("Error: Incorrect number of parameters.");
    } else {

      if (args[0].equals("encode")) {
        int lowercaseFlag = 0;
        for (int i = 0; i < args[1].length(); i++) {
          if (args[1].charAt(i) < 'a' || args[1].charAt(i) > 'z') {
            lowercaseFlag = 1;
          } // if
        } // for
        if (lowercaseFlag == 1) {
          System.err.println("Error: String contains characters other than lowercase letters");
          return;
        } // if

        for (int i = 0; i < 'z' - 'a' + 1; i++) {
          char shift = (char) ('a' + i);
          String sentance = CipherUtils.caesarEncrypt(args[1], shift);
          pen.println("n = " + shift + ": " + sentance);
        } // for
      } else if (args[0].equals("decode")) {
        int lowercaseFlag = 0;
        for (int i = 0; i < args[1].length(); i++) {
          if (args[1].charAt(i) < 'a' || args[1].charAt(i) > 'z') {
            lowercaseFlag = 1;
          } // if
        } // for
        if (lowercaseFlag == 1) {
          System.err.println("Error: String contains characters other than lowercase letters");
          return;
        } // if

        for (int i = 'z' - 'a'; i > -1; i--) {
          char shift = (char) ('z' - i);
          String sentance = CipherUtils.caesarDecrypt(args[1], shift);
          pen.println("n = " + shift + ": " + sentance);
        } // for
      } else {
        System.err.println("Error: Invalid option: \"" + args[0]
            + "\". Valid options are \"endode\" or \"decode\".");
      } // else
    } // else
  } // main (String[])
} // class AllCaesar
