
public class Main {

    public static void main(String[] args) {
        Display object1=new Display();
        object1.helloWorld();
        Array object2=new Array();
        object2.define(1);
        Random object3=new Random();
        int m=object3.randomize();
        Calculations object4=new Calculations();
        int n=object4.calcul(m);
        SumOfDigits object5=new SumOfDigits();
        n=object5.sumdigits(n);
        FinalDisplay object6=new FinalDisplay();
        object6.learn(n);
    }
}
