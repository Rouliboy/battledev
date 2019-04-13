package org.jvi.battledev;

import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;

public class UtilityClass {

  @Test
  public void testAllPermutationsOfStringWithoutRepeat() {
    System.out.println(allPermutationsOfStringWithoutRepeat("ABCD"));
  }

  @Test
  public void testAllPermutationsOfStringWithRepeat() {
    System.out.println(allPermutationsOfStringWithRepeat("ABC"));
  }

  @Test
  public void testAllPermutationsOfStringArrayWithRepeat() {
    System.out.println(allPermutationsOfStringArrayWithRepeat(new String[] {"A", "B", "C"}));
  }

  @Test
  public void testDisplayMatrix() {
    final String[][] matrix = new String[2][3];
    matrix[0] = new String[] {"1", "2", "3"};
    matrix[1] = new String[] {"4", "5", "6"};
    displayMatrix(matrix);
  }

  /***************************************************************/
  /** All permutations of String Array WITH repetition of character */
  /***************************************************************/

  private static Set<String> allPermutationsOfStringArrayWithRepeat(final String[] array) {
    final Set<String> result = new LinkedHashSet<>();
    allPermutationsOfStringArrayWithRepeat(new String[0], array, array.length, result);
    return result;
  }

  private static void allPermutationsOfStringArrayWithRepeat(final String[] prefix,
      final String[] array, final int size, final Set<String> result) {
    if (prefix.length == size) {
      result.add(String.join("", prefix));
      return;
    }
    for (int i = 0; i < array.length; ++i) {
      final String[] tab = new String[prefix.length + 1];
      for (int k = 0; k < prefix.length; ++k) {
        tab[k] = prefix[k];
      }
      // ici, tab = prefix + array[i]
      tab[prefix.length] = array[i];
      allPermutationsOfStringArrayWithRepeat(tab, array, size, result);
    }
  }

  /***************************************************************/
  /** All permutations of String WITH repetition of character */
  /***************************************************************/

  private static Set<String> allPermutationsOfStringWithRepeat(final String str) {
    final Set<String> result = new LinkedHashSet<>();
    allPermutationsOfStringWithRepeat("", str, str.length(), result);
    return result;
  }

  private static void allPermutationsOfStringWithRepeat(final String prefix, final String str,
      final int size, final Set<String> result) {
    if (prefix.length() == size) {
      result.add(prefix);
      return;
    }
    for (int i = 0; i < str.length(); ++i) {
      allPermutationsOfStringWithRepeat(prefix + str.charAt(i), str, size, result);
    }
  }

  /***************************************************************/
  /** All permutations of String WITHOUT repetition of character */
  /***************************************************************/

  private static Set<String> allPermutationsOfStringWithoutRepeat(final String str) {
    final Set<String> result = new LinkedHashSet<>();
    allPermutationsWithoutRepeat("", str, str.length(), result);
    return result;
  }

  private static void allPermutationsWithoutRepeat(final String prefix, final String str,
      final int size, final Set<String> result) {
    if (prefix.length() == size) {
      result.add(prefix);
    }
    for (int i = 0; i < str.length(); ++i) {
      allPermutationsWithoutRepeat(prefix + str.charAt(i),
          str.substring(0, i) + str.substring(i + 1), size, result);
    }
  }

  /*******************/
  /** Display matrix */
  /*******************/

  private static <T> void displayMatrix(final T[][] matrix) {
    for (int i = 0; i < matrix.length; ++i) {
      String line = "";
      for (int j = 0; j < matrix[0].length; ++j) {
        line = line + matrix[i][j] + " ";
      }
      System.out.println(line);
    }
  }
}
