import java.util.*;

class BSTNode {
    int data;
    BSTNode left, right;

    BSTNode(int value) {
        data = value;
        left = right = null;
    }
}

public class KthSmallestBST {

    // Root of the BST
    static BSTNode root;

    // Insert into BST
    public static BSTNode insert(BSTNode root, int value) {
        if (root == null) {
            root = new BSTNode(value);
            return root;
        }

        if (value < root.data)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        return root;
    }

    // Function to store inorder traversal in list
    public static void inorderTraversal(BSTNode node, List<Integer> list) {
        if (node == null)
            return;

        inorderTraversal(node.left, list);
        list.add(node.data);
        inorderTraversal(node.right, list);
    }

    // Function to find Kth smallest element
    public static int findKthSmallest(int k) {
        List<Integer> sortedValues = new ArrayList<>();
        inorderTraversal(root, sortedValues);

        if (k > sortedValues.size() || k <= 0) {
            System.out.println("Invalid value of k!");
            return -1;
        }

        return sortedValues.get(k - 1); // because indexing starts at 0
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n-------- Kth Smallest Element in BST --------");

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter BST values:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            root = insert(root, value);
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = findKthSmallest(k);

        if (result != -1)
            System.out.println("\nThe " + k + "th smallest element is: " + result);

        sc.close();
    }
}