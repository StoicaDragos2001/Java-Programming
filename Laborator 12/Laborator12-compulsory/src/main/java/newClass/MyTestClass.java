package newClass;

import org.testng.annotations.Test;

public class MyTestClass
{
    @Test
    public static void staticMethod1()
    {
        System.out.println("Hello world");
    }

    @Test
    public static void staticMethod2()
    {
        System.out.println(5+8);
    }

    @Test
    public static void staticMethod3()
    {
        System.out.println(9*9);
    }

    public static void main(String[] args) {

    }
}
