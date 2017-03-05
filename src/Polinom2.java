import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;

//x^3+3x^2-3=0
public class Polinom2 extends Function{
    @Override
    public double f (double x){   //значение функции в точке x
        return pow(x,3)+3*pow(x,2)-3;
    }

    @Override
    public double df (double x){  //значение произв. функции в точке x
        return 3*pow(x,2)+6*x;
    }

    public static void main(String[] args) {
        double [] a={1, 3, 0, -3};
        Polinom2 polinom2= new Polinom2();
        double[] k=polinom2.makloren(a);
        outk(k);
        polinom2.decision(k);
    }
}