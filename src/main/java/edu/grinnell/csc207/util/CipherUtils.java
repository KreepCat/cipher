package edu.grinnell.csc207.util;
/**
 * Methods used to encode and decode text.
 */
public class CipherUtils {
  /**
   * @param letter
   * @return int
   * Converts a char into an int. i.e. 'a' goes to '1'.
   */
  private static int letter2int(char letter) {
    int numRep = (((int) letter) - 'a');
    return numRep;
  } // letter2int(char)

  /**
   * @param i
   * @return char
   * Converts an int into a char. i.e. '1' goes to 'a'.
   */
  private static char int2letter(int i) {
    char charRep = (char) ((i + 'a'));
    return charRep;
  } // int2letter(int)

  /**
   * @param str
   * @param letter
   * @return String
   * Encrypts a string with a Caesar cipher key.
   */
  public static String caesarEncrypt(String str, char letter) {
    char[] asChar = str.toCharArray();
    int key = letter2int(letter);

    for (int i = 0; i < asChar.length; i++) {
      int letterVal = (letter2int(asChar[i]) + key) % ('z' - 'a' + 1);
      asChar[i] = int2letter(letterVal);
    } // for
    return new String(asChar);
  } // caesarEncrypt(String, char)

  /**
   * @param str
   * @param letter
   * @return String
   * Decrypts a string with a Caesar cipher key.
   */
  public static String caesarDecrypt(String str, char letter) {
    char[] asChar = str.toCharArray();
    int key = letter2int(letter);
    for (int i = 0; i < asChar.length; i++) {
      int letterVal = (letter2int(asChar[i]) - key) % ('z' - 'a' + 1);
      if (letterVal < 0) {
        letterVal += ('z' - 'a' + 1);
      } // if
      asChar[i] = int2letter(letterVal);
    } // for
    return new String(asChar);
  } // caesarDecrypt(String, char)

  /**
   * @param str
   * @param key
   * @return String
   * Encrypts a string with a Vigenere cipher key.
   */
  public static String vigenereEncrypt(String str, String key) {
    char[] asChar = str.toCharArray();
    for (int i = 0; i < asChar.length; i++) {
      int shift = letter2int(key.charAt(i % key.length()));
      asChar[i] = int2letter((letter2int(asChar[i]) + shift) % ('z' - 'a' + 1));
    } // for
    return new String(asChar);
  } // vigenereEncrypt(String, String)

  /**
   * @param str
   * @param key
   * @return String
   * Decrypts a string with a Vigenere cipher key.
   */
  public static String vigenereDecrypt(String str, String key) {
    char[] asChar = str.toCharArray();
    for (int i = 0; i < asChar.length; i++) {
      int shift = letter2int(key.charAt(i % key.length()));
      int letterVal = (letter2int(asChar[i]) - shift) % ('z' - 'a' + 1);
      if (letterVal < 0) {
        letterVal += ('z' - 'a' + 1);
      } // if
      asChar[i] = int2letter(letterVal);
    } // for
    return new String(asChar);
  } // vigenereDecrypt(String, String)
} // class CipherUtils
