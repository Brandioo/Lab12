package BuyTheCheapest;


public class AVL {
    //create an inner AVLNode class
    class AVLNode {

        AVLNode left, right;
        int avg;
        String gr;
        int height;

        public AVLNode(int avg, String gr) {
            this.avg=avg;
            this.gr=gr;
        }

        public AVLNode() {
        }
    }

    private AVLNode root;



    public AVL() {
        root = null;
    }



    public boolean isEmpty() {
        return root == null;
    }

    private int height(AVLNode t) {
        return t == null ? -1 : t.height;
    }


    private int max(int lhs, int rhs) {
        return Math.max(lhs, rhs);
    }



    public void insert(int avg,String gr) {
        root = insert(avg,gr,root);
    }


    private AVLNode insert(int avg,String gr, AVLNode root) {


        if (root == null) {
            root = new AVLNode(avg,gr);
        }

        else if (avg<root.avg) {
            root.left = insert(avg,gr,root.left);


            if (height(root.left) - height(root.right) == 2) {
                if (avg<root.left.avg) {
                    root = rotateWithLeftChild(root); // left - left tree
                } else {
                    root = doubleWithLeftChild(root); // left-right tree
                }

            }
        }

        else if (avg>root.avg) {
            root.right = insert(avg,gr, root.right);

            if (height(root.right) - height(root.left) == 2)

                if (avg>root.right.avg) {
                    root = rotateWithRightChild(root); // right -right tree
                } else {
                    root = doubleWithRightChild(root); // right - left tree
                }
        }
        // Duplicate; do nothing

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



    public int search(int id) {
        return search(root, id);
    }

    private int search(AVLNode root, int avg) {


        if (root == null) {
            return 0;
        }

        else if (root.avg == avg) {
            return avg;
        }


        if (avg>root.avg) {
            return search(root.right, avg);
        }

        return search(root.left, avg);
    }
    public String[] print(int n) {

        return print(root,n);
    }


    private String[] print(AVLNode r,int m) {

        int cnt = 0;
        String [] print=new String[m];
        while (cnt <m && root!=null) {
            print[cnt]=root.gr;
            root=root.right;
            cnt++;
        }
        return print;
    }
}
