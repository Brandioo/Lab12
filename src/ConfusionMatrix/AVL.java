package ConfusionMatrix;


/* Class AVLTree */
class AVL
{


    class AVLNode {

        AVLNode left, right;
        int info;
        int height;

        /* Constructor */
        public AVLNode() {
            left = null;
            right = null;
            info = 0;
            height = 0;
        }

        /* Constructor */
        public AVLNode(int n) {
            left = null;
            right = null;
            info = n;
            height = 0;
        }
    }

    private AVLNode root;
    /* Constructor */

    public AVL() {
        root = null;
    }

    /* Function to check if tree is empty */

    public boolean isEmpty() {
        return root == null;
    }

    /* Function to get height of node */
    private int height(AVLNode t) {
        return t == null ? -1 : t.height;
    }

    /* Function to max of left/right node */
    private int max(int lhs, int rhs) {
        return lhs > rhs ? lhs : rhs;
    }

    /* Function to insert data */
    public void insert(int data) {
        root = insert(data, root);
    }

    /* Function to insert data recursively */
    private AVLNode insert(int x, AVLNode t) {

        if (t == null)
            t = new AVLNode(x);
        else if (x < t.info) {
            t.left = insert(x, t.left);

            if (height(t.left) - height(t.right) == 2)
                if (x < t.left.info)
                    t = rotateWithLeftChild(t); // left - left tree
                else
                    t = doubleWithLeftChild(t); // left-right tree
        }

        else if (x > t.info) {
            t.right = insert(x, t.right);

            if (height(t.right) - height(t.left) == 2)

                if (x > t.right.info)
                    t = rotateWithRightChild(t); // right -right tree
                else
                    t = doubleWithRightChild(t); // right - left tree
        } else

            ; // Duplicate; do nothing

        t.height = max(height(t.left), height(t.right)) + 1;
        return t;

    }

    /* Rotate binary tree node with left child */
    private AVLNode rotateWithLeftChild(AVLNode k2) {

        AVLNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), k2.height) + 1;
        return k1;

    }

    /* Rotate binary tree node with right child */

    private AVLNode rotateWithRightChild(AVLNode k1) {

        AVLNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.right), k1.height) + 1;

        return k2;

    }

    /**
     *
     * Double rotate binary tree node: first left child with its right child; then
     * node k3 with new left child
     */
    private AVLNode doubleWithLeftChild(AVLNode k3) {

        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     *
     * Double rotate binary tree node: first right child with its left child; then
     * node k1 with new right child
     */
    private AVLNode doubleWithRightChild(AVLNode k1) {

        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);

    }

    public void print() {
        System.out.print("Tree contains (value_height): { ");
        print(root);
        System.out.print("}");
    }

    private void print(AVLNode r) {
        if (r.left != null)
            print(r.left);
        System.out.print(r.info + "_" + height(r) + ", ");
        if (r.right != null)
            print(r.right);
    }
}
