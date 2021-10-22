package Question3;

import java.util.Arrays;

public class NewString {
  private final char[] c; // unchanged character array
  int length;

  /**
   * A constructor based on a NewString
   *
   * @param s NewString object
   */
  public NewString(NewString s) {
    this.c = s.c;
    this.length = s.length;
  }

  /**
   * A constructor copy and concat all the characters in an Array
   *
   * @param s Array
   */
  public NewString(char[] s) {
    this.c = Arrays.copyOf(s, s.length);
    this.length = s.length;
  }

  /**
   * Construct a NewString with 3 indexes
   *
   * @param s Array of characters
   * @param begin index of begin
   * @param count number of characters
   */
  public NewString(char[] s, int begin, int count) throws Exception {
    if (begin < 0) {
      throw new Exception(); // begin index should > 0
    }
    if (count <= 0) { // exception
      if (count < 0) { // count should > 0 if you want to copy
        throw new Exception();
      } else { // count = 0
        if (begin <= s.length) { // just one character
          this.c = s;
          return;
        }
      }
    }
    if (begin > s.length - count) { // exceed the length
      throw new StringIndexOutOfBoundsException(begin + count);
    } else { // generally
      this.c = Arrays.copyOfRange(s, begin, begin + count);
    }
  }

  /**
   * Compare two NewString objects
   *
   * @param s NewString object s
   * @return An integer
   */
  public int compare(NewString s) throws Exception {
    int l1 = this.c.length;
    int l2 = s.c.length;
    if (l1 != l2) {
      return -1;
    }
    for (int i = 0; i < this.c.length; i++) {
      if (this.c[i] != s.c[i]) {
        return 0;
      }
    }
    return 1;
  }

  /**
   * Create a NewString object of subtype
   * @param begin Index to begin copy
   * @return Subtype of NewSting obejct
   * @throws Exception
   */
  public NewString substring(int begin) throws Exception {
    if (begin < 0) {
      throw new Exception(); // index should >= 0
    }
    int subLen = c.length - begin; // remain length
    if (subLen < 0) { // exceed the bound of Array
      throw new Exception();
    }
    return (begin == 0)
        ? this
        : new NewString(c, begin, subLen); // construct a NewString object with those 3 indexes
  }

  /**
   * Make all characters in the Array to uppercase
   *
   * @return A new NewString object
   */
  public NewString toUppercase() throws Exception {
    int length = this.c.length;
    for (int i = 0; i < length; i++) {
      if ((int) this.c[i] >= 97 && (int) this.c[i] <= 122) {
        this.c[i] -= 32;
      } else {
        throw new Exception(); // With some Upper case already
      }
    }
    return this;
  }

  /**
   * Change the Object to chars with arraycopy methods
   *
   * @return An array of all characters
   */
  public char[] toChars() { // Change into characters
    char[] result = new char[c.length];
    System.arraycopy(c, 0, result, 0, c.length);
    return result;
  }

  /**
   * Decide a true or false return
   *
   * @param b A boolean value
   * @return A NewString object
   */
  public static NewString valueOf(boolean b) {
    int myInt = b ? 1 : 0;
    char[] c1 = {'t', 'r', 'u', 'e'};
    char[] c2 = {'f', 'a', 'l', 's', 'e'};
    if (myInt == 1) {
      return new NewString(c1);
    } else {
      return new NewString(c2);
    }
  }

}
