public class Motor {
    public static void main(String args[]) {
        Motorcycle m = new Motorcycle();
        m.make = "Yamaha RZ350";
        m.color = "yellow";

        System.out.println("Calling showAtts...");
        m.showAtts();
        System.out.println("-------");

        System.out.println("Starting engine...");
        m.startEngine();
        System.out.println("-------");

        System.out.println("Calling showAtts...");
        m.showAtts();
        System.out.println("-------");

        System.out.println("Starting engine...");
        m.startEngine();
    }
}

class Motorcycle {
    String make;
    String color;

    void showAtts() {
        System.out.println("Make: " + make);
        System.out.println("Color: " + color);
    }

    void startEngine() {
        System.out.println(make + " engine started!");
    }
}
