import java.io.File;

public class hello {
    public static void main(String[] args) {
        try {
            int z = calculate();
            System.out.println(z);
            System.out.println("Hello world!");
        } catch (ArithmeticException exception) {
            exception.printStackTrace();
        }

//        var configFile = new File("sandbox/build.gradle");
//        System.out.println(configFile.getAbsolutePath());
//        System.out.println(configFile.exists());
    }

    private static int calculate() {
        var x = 1;
        var y = 1;
        var z = divide(x, y);
        return z;
    }

    private static int divide(int x, int y) {
        var z = x / y;
        return z;
    }
}
