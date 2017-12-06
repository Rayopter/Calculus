/**
 * Warning: Uses Java 1.8
 * Name: Raymond Ngo
 * Date: 12/06/17
 */
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Calculus{
 
 public static final double INCREMENT = 0.00001; //change of dx between every value
 
 public static void main(String[] args) {
   System.out.println("You have a Java version of " + getVersion());
   if (getVersion().startsWith("1.8.")) {
     System.out.println(d_Integral_8(x -> {return Math.cos(x)*Math.pow(Math.sin(x), 2);}, 0, 5*Math.PI/4)); // -> is apart of the lambda expressions. More info: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
   //Math.pow(Math.E, Math.pow(x, -2))
   }
   else {
     System.out.println(d_Integral(0, 5*Math.PI/4, 20);
   }
 } 
 
 public static String d_Integral_8(Function f, double lb, double ub) {  //using the trapezoidal method: Java 1.8
  double area = 0;
  if (lb > ub) {
   lb = lb+ub;
   ub = lb-ub;
   lb = lb-ub;
  }
  for (double i = lb + INCREMENT; i <= ub; i+=INCREMENT) {
   double dx = i - lb;
   area += (INCREMENT / 2)*(f.func(lb+dx) + f.func(lb + dx - INCREMENT)); //average of long length and short length of a trapezoid multiplied by "height" of Increment
  }
  
  DecimalFormat f_area = new DecimalFormat("#.####"); //defines how many decimal places there will be in the answer
  f_area.setRoundingMode(RoundingMode.CEILING);
  return f_area.format(area);  //output is in a string format
 }
 
 public static double d_Integral(double lb, double ub, int n) { //Using Boole's rule: Java 1.7 or less
   return 0;
 }
 
  public static double function(double x) { //Java 1.7 or less
   return x*x;
 }
  
 public static String getVersion() {
   return System.getProperty("java.version");
 }
}
 
