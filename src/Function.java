import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Function {

    public static final double epsilonf = 0.0000001; //погрешность f(x)
    public static final double epsilonx = 0.01; //шаг x
    public static final double [] k=new double[4];

    public static boolean asign(double x,double y) {
        if ((x > 0 && y>0) || (x<0 && y<0))
            return false;
        else
            return true;
    }

    public static void outNewton(double x, double f, int i){
        System.out.print(i+" ");
        System.out.printf("%1.15f",x);
        System.out.print("  ");
        System.out.printf("%1.15f\n",f);
    }

    public static void outk(double [] k){
        for (int i=0;i<4;i++) {
            System.out.print("k"+(i+1)+"=");
            System.out.printf("%1.5f\n",k[i]);
        }
        System.out.println("\n");
    }

    public double f (double x){   //значение функции в точке x
        return 0;
    }

    public  double df (double x){  //значение произв. функции в точке x
        return 0;
    }

    public  double newton(double a, int i){  //метод Ньютона
        double x=a;
        int j=1;
        System.out.println();
        System.out.println(i+"-й корень:");
        for (int temp=0;temp<9;temp++)
            System.out.print(" ");
        System.out.print("x");
        for (int temp=0;temp<18;temp++)
            System.out.print(" ");
        System.out.print("f(x)");
        System.out.println();
        while (abs(f(x))> epsilonf) {
            x = x - f(x) / df(x);
            outNewton(x,f(x),j);
            j++;
        }
        i++;
        return x;
    }

    public  void decision(double [] k){
        double x=k[2]; // нижний предел отриц. корней
        int i=1;
        double temp1,temp2;
        temp1=f(x);
        x+= epsilonx;
        while (x<=k[3]){  //отриц корни
            temp2=f(x);
            if (asign(temp1,temp2)) {
                newton(x,i);
                i++;
            }
            temp1=temp2;
            x+= epsilonx;
        }

        x=k[1];
        temp1=f(x);
        x+= epsilonx;
        while (x<=k[0]){  //положит корни
            temp2=f(x);
            if (asign(temp1,temp2)) {
                newton(x,i);
                i++;
            }
            temp1=temp2;
            x+= epsilonx;
        }
    }

    public double firstNegInd (double [] b){
        int length=b.length, i=0;
        while (b[i]>=0 && i<length){
            i++;
        }
        return i;
    }

    public double maxNegative (double [] b){
        double max=0;
        int length=b.length;
        for (int i=0;i<length;i++){
            if (b[i]<0 && Math.abs(b[i])>max){
                max=Math.abs(b[i]);
            }
        }
        return max;
    }

    public double [] inverse(double [] b){
        int length=b.length;
        double [] c= new double [length];
        for (int i=0;i<length;i++){
            c[i]=b[length-1-i];
        }
        if (c[0]<0){
            return signChange(c);
        }
        return c;
    }

    public double [] negZ (double [] b){
        int length=b.length;
        double [] c= new double [length];
        for (int i=0;i<length;i++){
            if ((length-i-1)%2==1){
                c[i]=-b[i];
            }
            else{
                c[i]=b[i];
            }
        }
        if (c[0]<0){
            return signChange(c);
        }
        return c;
    }

    public double [] signChange (double [] b){
        int length=b.length;
        double [] c=new double [length];
        for (int i=0; i<length;i++){
            c[i]=-b[i];
        }
        return c;
    }

    public double [] makloren(double [] a){
        double [] k= new double[4];
        Function main= new Function();
        double [] inv =main.inverse(a);
        k[0]=1+pow(maxNegative(a)/a[0],1/firstNegInd(a)); //x=x
        k[1]=1/(1+pow(maxNegative(inv)/inv[0],1/firstNegInd(inv))); //x=1/z
        double [] neg= main.negZ(a);  //x=-z
        k[2]=-(1+pow(maxNegative(neg)/neg[0],1/firstNegInd(neg)));
        double [] invneg=main.inverse(neg); //x=-1/z
        k[3]=-1/(1+pow(maxNegative(invneg)/invneg[0],1/firstNegInd(invneg)));
        return k;
    }
}