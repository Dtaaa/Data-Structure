package cmsc420_s21;
import java.util.ArrayList;
import java.util.TreeMap;
// -------------------------------------------------------------------------
// Add your code here. You may import whatever (standard) packages you like.
// You may also create additional files, if you like, but be sure to upload
// them as well for grading.
// -------------------------------------------------------------------------

public class Tour<Point extends LabeledPoint2D> {
	private int index;
	private ArrayList<Point> points;
	TreeMap<String, Integer> tm;
	// -------------------------------------------------------------------------
	// Here is the public interface. You should not change this, but you
	// can add any additional methods and/or data members that you like.
	// -------------------------------------------------------------------------

	public Tour() {
		points = new ArrayList<Point>();
		 tm = new TreeMap<String, Integer>();
		index = 0;
	} // Constructor

	public String append(Point pt) {
		String result = "append(" + pt.getLabel() +"): ";
		if (tm.containsKey(pt.getLabel())) {
			result += "Error - Label exists (operation ignored)";
		}
		else {
			points.add(pt);
			tm.put(pt.getLabel(), index);
			result += "Added to tour at index " + index++;
		}
		return result;
	} // Append point to end of tour

	public String listTour() {
		String result = "list-tour:";
		int count = 0;
		for (Point p : points) {
			result += " " + count++ +":"+ p.getLabel(); 
		}
	
		return result;
	} 

	public String listLabels() {
		String result;
		
		result = tm.entrySet().toString();
		result = result.replaceAll("=", ":");
		result = result.replaceAll(",", "");

		return  "list-labels: " + result.substring(1, result.length()-1); 
		} // List the labels in alphabetic order

	public String indexOf(String label) { 
		String result = "index-of(" + label + "): ";
		
		if (tm.containsKey(label)) {
			result += tm.get(label);
		}
		else {
			result += "Not-found";
		}
			
		return result;
		} // Index of label in tour

	public String reverse(String label1, String label2) { 
		String result = "reverse(" + label1 + "," + label2 + "): ";
		Point temp = null;
		
		if (!tm.containsKey(label1)) {
			result += "Error - Label "+ label1 + " does not exist (operation ignored)";
		}
		else if (!tm.containsKey(label2)){
			result += "Error - Label " +label2+ " does not exist (operation ignored)";
		}
		else if (label1.equals(label2)) {
			result += "Error - Labels are equal (operation ignored)";
		}
			
			
		else {
			int i, j;
			if (tm.get(label1) > tm.get(label2)) {
				i = tm.get(label2);
				j = tm.get(label1);
			}
			else {
				i = tm.get(label1);
				j = tm.get(label2);
			}
			
			for (int count = 0; count < (int)(Math.ceil((j - i)/2.0)); count++) {
				temp = points.get(i + count);
				
				points.set(i + count, points.get(j - count));
				points.set(j - count, temp);
				
				tm.replace(points.get(i + count).getLabel(), i + count);
				tm.replace(points.get(j -  count).getLabel(), j - count);
				
			}
			result += "Successfully reversed subtour of length " + (j - i + 1);
		}
		return result; } // Reverse subtour 

}
