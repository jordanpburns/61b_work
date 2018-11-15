public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> a1 = new ArrayDeque<Integer>();
        //size test
        if (0 == a1.size()) {
            System.out.println("Passed size test!");
        }
        else {
            System.out.println("!!ERROR!! size should be 0, we got: " + a1.size());
        }

        //empty test
        if (a1.isEmpty() == true) {
            System.out.println("Passed empty test!");
        }
        else {
            System.out.println("!!ERROR!! should get true, we got: " + a1.isEmpty());
        }

        //addFirst tests
        a1.addFirst(0);
        if (a1.size() == 1) {
            System.out.println("Passed addFirst size test!");
        }
        else {
            System.out.println("!!ERROR!! should get 1, we got: " + a1.size());
        }
        if (a1.isEmpty() == false) {
            System.out.println("Passed addFast empty test!");
        }
        else {
            System.out.println("!!ERROR!! should get false, we got: " + a1.isEmpty());
        }

        //addLast tests
        a1.addLast(1);
        if (a1.size() == 2) {
            System.out.println("Passed addLast size test!");
        }
        else {
            System.out.println("!!ERROR!! should get 2, we got: " + a1.size());
        }
        a1.addLast(2);
        System.out.print("printing list should give 0 1 2 and we got: ");
        a1.printDeque();

        //removeFirst tests
        int pop1 = a1.removeFirst();
        if (a1.size() == 2) {
            System.out.println("Passed removeLast size test!");
        }
        else {
            System.out.println("!!ERROR!! should get 2, we got: " + a1.size());
        }
        if (pop1 == 0) {
            System.out.println("Passed removeLast pop test!");
        }
        else {
            System.out.println("!!ERROR!! should get 0, we got: " + pop1);
        }
        System.out.print("printing list should give 1 2 and we got: ");
        a1.printDeque();

        //removeLast tests
        int pop2 = a1.removeLast();
        if (a1.size() == 1) {
            System.out.println("Passed removeLast size test!");
        }
        else {
            System.out.println("!!ERROR!! should get 1, we got: " + a1.size());
        }
        if (pop2 == 2) {
            System.out.println("Passed removeLast pop test!");
        }
        else {
            System.out.println("!!ERROR!! should get 2, we got: " + pop1);
        }
        System.out.print("printing list should give 1 and we got: ");
        a1.printDeque();

        //go to empty and refill tests
        a1.removeFirst();
        if (a1.size() == 0) {
            System.out.println("Passed empty size test!");
        }
        else {
            System.out.println("!!ERROR!! should get 0, we got: " + a1.size());
        }
        a1.addFirst(0);
        a1.addLast(1);
        if (a1.size() == 2) {
            System.out.println("Passed refill size test!");
        }
        else {
            System.out.println("!!ERROR!! should get 2, we got: " + pop1);
        }
        System.out.print("printing list should give 0 1 and we got: ");
        a1.printDeque();


        //get tests
        a1.addLast(2);
        int got = a1.get(2);
        if (got == 2) {
            System.out.println("Passed get test!");
        }
        else {
            System.out.println("!!ERROR!! should get 2, we got: " + got);
        }

        //wrap tests
        a1.addLast(2);
        a1.addLast(3);
        a1.addLast(4);
        a1.addLast(5);
        System.out.print("printing list should give 0 1 2 2 3 4 5 and we got: ");
        a1.printDeque();
        int got1 = a1.get(5);
        if (got1 == 4) {
            System.out.println("Passed wrap get test!");
        }
        else {
            System.out.println("!!ERROR!! should get 4, we got: " + got1);
        }

        //resize larger tests
        a1 = new ArrayDeque<Integer>();
        a1.addLast(2);
        a1.addLast(3);
        a1.addLast(4);
        a1.addLast(5);
        a1.addLast(6);
        a1.addLast(7);
        a1.addLast(8);
        a1.addLast(9);
        a1.addLast(10);
        a1.addLast(11);
        a1.addLast(12);
        a1.addLast(13);
        a1.addFirst(1);
        a1.addFirst(0);
        System.out.print("printing list should give 0 1 2 3 4 5 6 7 8 9 10 11 12 13 and we got: ");
        a1.printDeque();
        for (int i = 0; i < a1.size(); i++){
            System.out.print(a1.get(i) + " ");
        }
        //removeFirst all the way test
        while (!a1.isEmpty()) {
            a1.removeFirst();
        }
        //Fill back up test
        a1.addLast(2);
        a1.addLast(3);
        a1.addLast(4);
        a1.addLast(5);
        a1.addLast(6);
        a1.addLast(7);
        a1.addLast(8);
        a1.addLast(9);
        a1.addLast(10);
        a1.addLast(11);
        a1.addLast(12);
        a1.addLast(13);
        a1.addFirst(1);
        a1.addFirst(0);
        //removeFirst all the way test
        while (!a1.isEmpty()) {
            a1.removeLast();
        }
        a1.addLast(2);
        a1.addLast(3);
        a1.addLast(4);
        a1.addLast(5);
        a1.addLast(6);
        a1.addLast(7);
        a1.addLast(8);
        a1.addLast(9);
        a1.addLast(10);
        a1.addLast(11);
        a1.addLast(12);
        a1.addLast(13);
        a1.addFirst(1);
        a1.addFirst(0);
        while (a1.size() < 100) {
            a1.addFirst(1);
        }
        while (a1.size() > 0) {
            a1.removeFirst();
        }
    }
}