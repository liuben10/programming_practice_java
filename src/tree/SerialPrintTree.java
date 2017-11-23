package tree;

/**
 */
public class SerialPrintTree {

  public static class BSTNode {
    char val;
    BSTNode left;
    BSTNode right;

    public BSTNode(char val, BSTNode left, BSTNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public String serialized(BSTNode node) {
    int depth = maxDepth(node);
    int length = (int) Math.pow(2, depth) - 1;
    char[] serialArray = new char[length];
    serialize(node, serialArray, 0);
    return new String(serialArray);
  }

  private void serialize(BSTNode node, char[] serialArray, int idx) {
    if (node == null) {
      serialArray[idx] = '\0';
    } else {
      serialArray[idx] = node.val;
      if (2 * idx + 1 < serialArray.length) serialize(node.left, serialArray, 2 * idx + 1);
      if (2 * idx + 2 < serialArray.length) serialize(node.right, serialArray, 2 * idx + 2);
    }
  }

  public BSTNode deserialize(String serialized) {
    char[] charArray = serialized.toCharArray();
    return deserializeHelper(charArray, 0);
  }

  private BSTNode deserializeHelper(char[] charArray, int idx) {
    if (idx < charArray.length) {
      if (charArray[idx] != '\0') {
        return new BSTNode(charArray[idx],
                deserializeHelper(charArray, 2 * idx + 1),
                deserializeHelper(charArray, 2 * idx + 2));
      } else {
        return null;
      }
    } else {
      return null;
    }
  }

  private int maxDepth(BSTNode node) {
    if (node == null) {
      return 0;
    } else {
      return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
  }

  public static void main(String...args) {
    BSTNode node = new BSTNode('A',
            new BSTNode('B',
                    new BSTNode('C', null, null),
                    null),
            new BSTNode('D', null, null));

    SerialPrintTree s = new SerialPrintTree();
    String serialized = s.serialized(node);
    System.out.println(serialized);

    BSTNode deserialize = s.deserialize(serialized);
    System.out.println(deserialize.val);
    System.out.println(deserialize.left.left.val);
  }
}
