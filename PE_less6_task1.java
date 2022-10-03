/* 1. Описать класс для работы с бинарным деревом
1.1 Реализовать три варианта обхода-ru.wikipedia.org/wiki/Обход_дерева#Прямой_обход_(NLR)
1.2 Сделать скобочную запись бинарного дерева
*/

public class PE_less6_task1 {

    public static void main(String[] args) {
        // создали узлы
        Node root = new Node("F", 11);
        Node b = new Node("B", 0);
        Node g = new Node("G", 0);
        Node a = new Node("A", 0);
        Node d = new Node("D", 0);
        Node i = new Node("I", 0);
        Node c = new Node("C", 0);
        Node e = new Node("E", 0);
        Node h = new Node("H", 0);
        // связали узлы
        root.left = b;
        root.right = g;

        b.left = a;
        b.right = d;

        g.right = i;

        d.left = c;
        d.right = e;

        i.left = h;

        System.out.print("Поля узла ");
        root.print();

        b.printAll();
        System.out.println(" - Скобочная запись с любого узла");
        root.printDirect();
        System.out.println("- Прямой обход");
        root.printCentr();
        System.out.println("- Центрированный обход");
        root.printBack();
        System.out.println("- Обратный обход");
    }
}

class Node {
    public Node(String n, Integer v) {
        name = n;
        value = v;
    }

    String name;
    Integer value;
    Node left;
    Node right;

    public void print() {
        System.out.println(String.format("[%s, %d]", name, value));
    }

    public void printAll() {
        if (value != null) {
            System.out.printf("%s", name);
            if (this.left != null) {
                System.out.print("(");
                this.left.printAll();
            } else {
                System.out.print("(null");
            }
            System.out.print(",");
            if (this.right != null) {
                this.right.printAll();
            } else {
                System.out.print("null)");
            }
        }
    }

    public void printDirect() {
        if (value != null) {
            System.out.printf("%s ", name);
            if (this.left != null) {
                this.left.printDirect();
            }
            if (this.right != null) {
                this.right.printDirect();
            }
        }
    }

    public void printCentr() {
        if (value != null) {
            if (this.left != null) {
                this.left.printCentr();
            }
            System.out.printf("%s ", this.name);
            if (this.right != null) {
                this.right.printCentr();
            }
        }
    }

    public void printBack() {
        if (value != null) {
            if (this.left != null) {
                this.left.printBack();
            }
            if (this.right != null) {
                this.right.printBack();
            }
            System.out.printf("%s ", this.name);
        }
    }

}