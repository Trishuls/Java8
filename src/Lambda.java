@FunctionalInterface
interface Inter {
    void show();
}

public class Lambda {
    public static void main(String[] args) {
        Inter obj = ()-> System.out.println("Showing");
        obj.show();
    }
}
