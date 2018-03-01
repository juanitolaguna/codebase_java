package hackerrank_01;

/**
 * Created on 07.09.17.
 * Binary search tree.
 */
public class _07Node {
    _07Node left;
    _07Node right;
    int data;

    public _07Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new _07Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if (value >= data) {
                right = new _07Node(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value) {
        if (value == data) {
            return true;
        } else if (value <= data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else if (right == null) {
            return false;
        } else {
            return right.contains(value);
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(data);
        if (right != null) {
            right.printInOrder();
        }
    }

    //my bad solution... #rev.

    public boolean checkBST(_07Node root) {
        return checkBSTrecursive(root, true);
    }
    public boolean checkBSTrecursive(_07Node root, boolean b) {
        if (root.left != null) {
            b = root.left.data < root.data;
            b = b && checkBST(root.left);
        }

        if (root.right != null) {
            b = root.right.data > root.data;
            b = b && checkBST(root.right);

        }
        return b;
    }

    //not my solution.

    boolean checkBST2(_07Node root) {
        return recursiveCheck(root, -1, 10001);
    }
    boolean recursiveCheck(_07Node root, int min, int max) {

        if (root == null) return true;

        if (root.data <= min || root.data >= max) return false;

        return (recursiveCheck(root.left, min, root.data) && recursiveCheck(root.right, root.data, max));
    }

    public static void main(String[] args) {
        System.out.println();
    }

}

