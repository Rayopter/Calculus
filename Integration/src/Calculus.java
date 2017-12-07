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
	   	System.out.println("Through small Trapezoidal rule: " + d_Integral_8(x -> {return Math.pow(Math.E, Math.cos(x));}, 0, 2)); // -> is apart of the lambda expressions. More info: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
	   	System.out.println("Through Simpson's approximation: " + simpson2_Integral(0, 2));
   	}
   	else {
	   	System.out.println("Through small Trapezoidal rule: " + d_Integral(0, 2));
	   	System.out.println("Through Simpson's approximation: " + simpson2_Integral(0, 2));
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
 
 public static String d_Integral(double lb, double ub) {  //using the trapezoidal method: Java 1.7
	 double area = 0;
	 if (lb > ub) {
		 lb = lb+ub;
		 ub = lb-ub;
		 lb = lb-ub;
	 }
	 
	 for (double i = lb + INCREMENT; i <= ub; i+=INCREMENT) {
		 double dx = i - lb;
		 area += (INCREMENT / 2)*(function(lb+dx) + function(lb + dx - INCREMENT)); //average of long length and short length of a trapezoid multiplied by "height" of Increment
	 }
  
	 DecimalFormat f_area = new DecimalFormat("#.####"); //defines how many decimal places there will be in the answer
	 f_area.setRoundingMode(RoundingMode.CEILING);
	 return f_area.format(area);  //output is in a string format
 }
 
 public static String simpson2_Integral(double lb, double ub) { //Using Simpson's 3/8 rule, No N provided. Has reasonable accuracy for non-oscillating or discontinuous functions
	 double area = (ub-lb)/8 * (function(lb) + 3*function((2*lb+ub)/3) + 3*function((lb+2*ub)/3) + function(ub));
	 
	 DecimalFormat f_area = new DecimalFormat("#.####");
	 f_area.setRoundingMode(RoundingMode.CEILING);
	 return f_area.format(area);
 }
 
 /*public static String simpson_Integral(double lb, double ub, int N) { //Using Simpson's rule, Requires N provided. WARNING: Does not work as intended
	 int dx = (int) (ub-lb)/N;
	 double area = 1.0/3 * (function(lb) + function(ub)) ;
	 
	 for (int i = 1; i<= N-1; i+=2)
		 area+= 4.0/3 * function(lb+dx*i);
	 
	 for (int i = 2; i<= N-1; i+=2)
		 area += 2.0/3 * function(lb+dx*i);
	 
	 DecimalFormat f_area = new DecimalFormat("#.####");
	 f_area.setRoundingMode(RoundingMode.CEILING);
	 return f_area.format(area);
 }*/
 
 public static double function(double x) { //Java 1.7 or less
	 return Math.pow(Math.E, Math.cos(x));
 }
  
 public static String getVersion() {
	 return System.getProperty("java.version");
 }
}