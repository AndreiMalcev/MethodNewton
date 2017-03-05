import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.StrictMath.sin;
import static java.lang.StrictMath.sqrt;

//x-sin(x)=0.25
public class Sin extends Function{

    @Override
    public double f (double x){   //значение функции в точке x
        return x-sin(x)-0.25;  //pow(x,7)/5040-pow(x,5)/120+pow(x,3)/6-0.25-ряд Тейлора
    }

    @Override
    public  double df (double x){  //значение произв. функции в точке x
        return 1-cos(x);  //pow(x,6)/720-pow(x,4)/24+pow(x,2)/2- произв. ряда
    }

    public static void main(String[] args) {
        double [] a={1.0/5040.0, 0, -1.0/120.0, 0, 1.0/6.0, 0, 0, -0.25};
        Sin sin= new Sin();
        double[] k=sin.makloren(a);
        outk(k);
        sin.decision(k);
    }
}