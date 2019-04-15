import java.util.Scanner;

public class Polynomial {
    static Node root1 = null;
    static Node root2 = null;
    static Node root3 = null;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int c,e;
        System.out.println("Polynomial Equations");
        System.out.println("Enter number of terms in equation 1");
        int n1;
        n1 = sc.nextInt();
        System.out.println("Enter number of terms in equation 2");
        int n2;
        n2 = sc.nextInt();

        System.out.println("Enter exponents in decreasing order");
        //Take 1st polynomial equation from user
        while(n1 != 0){
            System.out.print("Enter coefficient and exponent : ");
            c = sc.nextInt();
            e = sc.nextInt();
            createFirst(c,e);
            n1--;
        }
        System.out.println();

        System.out.println("Enter exponents in decreasing order");
        //Take 2nd polynomial equation from user
        while(n2 != 0){
            System.out.println("Enter coefficient and exponent : ");
            c = sc.nextInt();
            e = sc.nextInt();
            createSecond(c,e);
            n2--;
        }
        System.out.println();

        //The two polynomial equations are
        System.out.println("Polynomial equation 1 is");
        display(root1);
        System.out.println("Polynomial equation 2 is");
        display(root2);
        System.out.println();

        //Adding two polynomials
        Node p = root1,q = root2;
        while(p.next != null && q.next != null){
            if(p.exp == q.exp){
                c = p.coef + q.coef;
                createThird(c,p.exp);
                p = p.next;
                q = q.next;
            }
            else if(p.exp > q.exp){
                createThird(p.coef,p.exp);
                p = p.next;
            }
            else{
                createThird(q.coef,q.exp);
                q = q.next;
            }
        }
        while(p != null){
            createThird(p.coef,p.exp);
            p = p.next;
        }
        while(q != null){
            createThird(q.coef,q.exp);
            q = q.next;
        }

        //Added Linked List is
        System.out.println("Addition of two polynomial equation is ");
        display(root3);

        p = root1;
        q = root2;
        root3 = null;
        Node r = root3;

        //MULTIPLYING TWO POLYNOMIAL LINKED LIST
        int flag = 0;
        while(p != null){
            while(q != null){
                c = p.coef * q.coef;
                e = p.exp + q.exp;
                while(r != null){
                    if(r.exp == e){
                        r.coef = r.coef + c;
                        flag = 1;
                    }
                    r = r.next;
                }
                if(flag == 0) {
                    createThird(c, e);
                }
                r = root3;
                q = q.next;
                flag = 0;
            }
            q = root2;
            p = p.next;
        }

        //Multiplied equation is
        System.out.println("Multiplied Equation is");
        display(root3);
    }

    //display Linked List
    private static void display(Node temp){
        while(temp != null){
            System.out.print(temp.coef + "x^" + temp.exp + " + ");
            temp = temp.next;
        }
        System.out.println();
    }

    //Create Added Linked List
    private static void createThird(int c, int exp) {
        Node n = new Node(c,exp);
        n.next = null;
        if(root3 == null){
            root3 = n;
        }else{
            Node p = root3;
            while(p.next != null){
                p = p.next;
            }
            p.next = n;
        }
    }

    //Create First linked list
    private static void createFirst(int c, int e) {
        Node n = new Node(c,e);
        n.next = null;
        if(root1 == null){
            root1 = n;
        }else{
            Node p = root1;
            while(p.next != null){
                p = p.next;
            }
            p.next = n;
        }
    }

    //Create Second linked list
    private static void createSecond(int c, int e) {
        Node n = new Node(c,e);
        n.next = null;
        if(root2 == null){
            root2 = n;
        }else{
            Node p = root2;
            while(p.next != null){
                p = p.next;
            }
            p.next = n;
        }
    }
}
