package GroupAverage;



/* Class AVLTree */
public class AVL
{

    class AVLNode
    {
        AVLNode left, right;
        String month;
        int height;
        public int cnt;


        public AVLNode(String month) {
            left = null;
            right = null;
            this.month = month;
            cnt = 1;
            height = 0;
        }

    }

    int cnt;
    private AVLNode root;


    public AVL() {
        root = null;
        cnt = 1;
    }


    public boolean isEmpty() {
        return root == null;
    }

    private int height(AVLNode t) {
        return t == null ? -1 : t.height;
    }


    private int max(int lhs, int rhs) {
        return lhs > rhs ? lhs : rhs;
    }


    public void insert(String b) {
        root = insert(b, root);
    }


    private AVLNode insert(String month, AVLNode root) {

        if (root == null)
        {
            root = new AVLNode(month);
        }
        else if (month.compareTo(root.month) < 0)
        {
            root.left = insert(month, root.left);

            if (height(root.left) - height(root.right) == 2)
            {
                if (month.compareTo(root.month) < 0)
                {
                    root = rotateWithLeftChild(root); // left - left tree
                }
                else
                {
                    root = doubleWithLeftChild(root); // left-right tree
                }
            }
        }

        else if (month.compareTo(root.month) > 0) {
            root.right = insert(month, root.right);

            if (height(root.right) - height(root.left) == 2) {
                if (month.compareTo(root.month) > 0) {
                    root = rotateWithRightChild(root); // right -right tree
                } else {
                    root = doubleWithRightChild(root); // right - left tree
                }

            }

        }
        else
        {
            root.cnt++;
        }

        root.height = max(height(root.left), height(root.right)) + 1;

        return root;
    }

    private AVLNode rotateWithLeftChild(AVLNode k2) {

        AVLNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), k2.height) + 1;
        return k1;

    }

    private AVLNode rotateWithRightChild(AVLNode k1) {

        AVLNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.right), k1.height) + 1;

        return k2;

    }


    private AVLNode doubleWithLeftChild(AVLNode k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }


    private AVLNode doubleWithRightChild(AVLNode k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }


    public int search(String month) {
        return search(root, month);
    }

    private int search(AVLNode root, String month) {

        int sum = 0;

        if (root == null) {
            return 0;
        }

        if (root.month.compareTo(month) == 0) {
            return root.cnt;
        }


        if (month.compareTo(root.month) > 0) {
            return  search(root.right, month);
        }

        else
            return  search(root.left, month);

    }
}
