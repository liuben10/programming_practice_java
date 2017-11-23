package tree;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;

/**
 */
public class PrintTreeInOrder {

  @AllArgsConstructor
  public static class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;
  }

  public static String printTreeInOrder(TreeNode input) {
    ArrayList<Character> inOrder = new ArrayList<>();
    inOrder(input, inOrder);

    ArrayList<String> lines = new ArrayList<>();
    printTreeInOrderHelper(input, 0, inOrder, lines);


    StringBuilder treeString = new StringBuilder();

    for (String line : lines) {
      treeString.append(line).append("\n");
    }

    return treeString.toString();
  }

  private static void inOrder(TreeNode input, List<Character> inOrder) {
    if (input != null) {
      inOrder(input.left, inOrder);
      inOrder.add(input.val);
      inOrder(input.right, inOrder);
    }
  }

  private static void printTreeInOrderHelper(TreeNode input, int depth, List<Character> inOrder, List<String> lines) {
    if (input != null) {
      int padding = inOrder.indexOf(input.val);
      printTreeInOrderHelper(input.left, depth + 1, inOrder, lines);

      if (depth >= lines.size()) {
        String stringToAdd = StringUtils.leftPad("", padding, " ");
        stringToAdd += Character.toString(input.val);
        for (int i = lines.size(); i < depth; i++) {
          lines.add(i, "");
        }
        lines.add(stringToAdd);
      } else {
        String toPad = lines.get(depth);
        int actualPadLength = padding - toPad.length();
        String paddingString = StringUtils.leftPad("", actualPadLength, " ");
        String newString = lines.get(depth) + paddingString + Character.toString(input.val);
        lines.remove(depth);
        lines.add(depth, newString);
      }

      printTreeInOrderHelper(input.right, depth + 1, inOrder, lines);
    }

  }

  public static void main(String...args) {
    TreeNode t = new TreeNode('A',
            new TreeNode(
                    'B',
                      new TreeNode(
                              'C',
                              null,
                              null
                      ),
                    null
            ),
            new TreeNode(
                    'D',
                      new TreeNode('E',
                              new TreeNode('F', null, null),
                              new TreeNode('G', null, null)),
                    new TreeNode('K',
                            new TreeNode('L',
                                    new TreeNode('Z',
                                            new TreeNode('X', null, null),
                                            null),
                                    new TreeNode('M', null, null)),
                            new TreeNode('H', null, null))
                    )

    );
    String result = printTreeInOrder(t);
    System.out.println(result);
  }
}
