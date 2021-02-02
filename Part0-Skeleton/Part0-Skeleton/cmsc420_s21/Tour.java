package cmsc420_s21;

// -------------------------------------------------------------------------
// Add your code here. You may import whatever (standard) packages you like.
// You may also create additional files, if you like, but be sure to upload
// them as well for grading.
// -------------------------------------------------------------------------

public class Tour<Point extends LabeledPoint2D> {

	// -------------------------------------------------------------------------
	// Here is the public interface. You should not change this, but you
	// can add any additional methods and/or data members that you like.
	// -------------------------------------------------------------------------

	public Tour() { } // Constructor

	public String append(Point pt) { return null; } // Append point to end of tour

	public String listTour() { return null; } // List the labels in tour order

	public String listLabels() { return null; } // List the labels in alphabetic order

	public String indexOf(String label) { return null; } // Index of label in tour

	public String reverse(String label1, String label2) { return null; } // Reverse subtour

}
