package Java;

public class Main {

    public static void main(String[] args) {
        display object1=new display();
        object1.helloWorld();
        array object2=new array();
        object2.define(1);
        random object3=new random();
        int m=object3.randomize();
        calculations object4=new calculations();
        int n=object4.calcul(m);
        sumofdigits object5=new sumofdigits();
        n=object5.sumdigits(n);
        finaldisplay object6=new finaldisplay();
        object6.learn(n);
    }
}
