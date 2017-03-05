import static java.lang.Math.pow;

//32x^6-48x^4+18x^2-x-1=0
public class Polinom1 extends Function {
    @Override
    public double f (double x){   //значение функции в точке x
        return 32*pow(x,6)-48*pow(x,4)+18*pow(x,2)-x-1;
    }

    @Override
    public  double df (double x){  //значение произв. функции в точке x
        return 192*pow(x,5)-192*pow(x,3)+36*x-1;
    }

    public static void main(String[] args) {
        double [] a={32, 0, -48, 0, 18, -1, -1};
        Polinom1 polinom1= new Polinom1();
        double[] k=polinom1.makloren(a);
        outk(k);
        polinom1.decision(k);
    }
}
