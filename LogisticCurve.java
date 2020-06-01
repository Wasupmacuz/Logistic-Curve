/**
 * This class will evaluate a point on a specified logistic curve.<br>
 * Optionally, a value for an x-intercept can be given so that the curve can go below zero.
 * @see <a href="https://en.wikipedia.org/wiki/Logistic_function">https://en.wikipedia.org/wiki/Logistic_function</a>
 * @author Grayson Hamari
 * @version 05/30/2020
 */
public class LogisticCurve 
{
	float maxVal;
	float slopeVal;
	float midVal;
	float yOffset = 0;
	boolean inverted = false;
	
	/**
	 * Create a logistic curve
	 * @param maxVal The maximum value of the curve (technically never reaches this value)<br>
	 * The limit of y as x approaches infinity equals L
	 * @param slopeVal The slope of the curve at the inflection point
	 * @param midVal The x value of the inflection point of the logistic function, where the slope is slopeVal
	 * @since 05/13/2020
	 */
	public LogisticCurve(float maxVal, float slopeVal, float midVal, boolean inverted)
	{
		this.maxVal = maxVal;
		this.slopeVal = slopeVal;
		this.midVal = midVal;
		this.inverted = inverted;
	}

	/**
	 * Create a logistic curve
	 * @param maxVal The maximum value of the curve (technically never reaches this value)<br>
	 * The limit of y as x approaches infinity equals L
	 * @param slopeVal The slope of the curve at the inflection point
	 * @param midVal The x value of the inflection point of the logistic function, where the slope is slopeVal
	 * @param xIntercept The value of x at which the user chooses the function to intercept the x-axis
	 * @since 05/15/2020
	 */
	public LogisticCurve(float maxVal, float slopeVal, float midVal, boolean inverted, float xIntercept)
	{
		// Setting the necessary variables before computing the y offset
		this.maxVal = maxVal;
		this.slopeVal = slopeVal;
		this.midVal = midVal;
		this.inverted = inverted;
		
		yOffset = eval(xIntercept); // Computing the y offset now that the necessary variables are set
		this.maxVal += yOffset; // reevaluating the maximum value with the new y offset
		
	}

	/**
	 * Evaluates the logistic curve at a given x value
	 * @param x The x value that the curve will be evaluated at
	 * @return The y value of the curve at the given x value
	 * @since 05/13/2020
	 */
	public float eval(float x)
	{
		float val = maxVal/(1 + (float)Math.pow(Math.E, (inverted ? 1 : -1)*slopeVal*(x - midVal))) - yOffset;
		return val;
	}
}
