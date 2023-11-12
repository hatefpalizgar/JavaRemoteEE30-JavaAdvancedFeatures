package generics.comparable;

public class Main {
    public static void main(String[] args) {
        MacBook macBook1 = new MacBook(5);
        MacBook macBook2 = new MacBook(12);
        
        if (macBook1.compareTo(macBook2) > 0) {
            System.out.println("macbook1 is faster");
        } else if (macBook1.compareTo(macBook2) < 0){
            System.out.println("macbook2 is faster");
        } else {
            System.out.println("both macbooks are of the same power");
        }
    }
}
