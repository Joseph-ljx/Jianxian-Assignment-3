package Question3;

public class Main {
    public static void main(String[] args) throws Exception {
        char[] c1 = {'a','b','c','d'};
        char[] c2 = {'d','c','b','a'};
        char[] c3 = {'b','c','d'};

        NewString n1 = new NewString(c1);
        NewString n2 = new NewString(c2);
        NewString n3 = new NewString(c3);

        NewString n4 = n1.substring(2);
        NewString n6 = n2.toUppercase();

        // print or println?
        // append?

        System.out.println(n1.toChars());
        System.out.println(n4.toChars());

        NewString n5 = NewString.valueOf(true);
        System.out.println(n5.toChars());

        System.out.println(n1.compare(n1));
        System.out.println(n1.compare(n2));
        System.out.println(n1.compare(n3));

        System.out.println(n6.toChars());
//        System.out.println(n6.toUppercase()); Exception here: n6 is already with uppercase


    }
}
