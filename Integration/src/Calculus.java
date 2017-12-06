import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Calculus {
	
	public static final double INCREMENT = 0.00001; //change of dx between every value
	
	public static void main(String[] args) {
		System.out.println(d_Integral(x -> {return Math.cos(x)*Math.pow(Math.sin(x), 2);}, 0, 5*Math.PI/4)); // -> is apart of the lambda expressions. It's for storing functions for calculation
	} //Math.pow(Math.E, Math.pow(x, -2))
	
	public static String d_Integral(Function f, double lb, double ub) {  //using the trapezoidal method
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
}
