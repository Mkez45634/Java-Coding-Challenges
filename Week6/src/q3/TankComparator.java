package q3;

//comparing car on tank size
import java.util.Comparator;

public class TankComparator implements Comparator<Car> {

  public int compare (Car c1, Car c2) {
	  int t1 = c1.getTankSize();
	  int t2 = c2.getTankSize();
	  if (t1< t2) return -1;
	  else if (t1 > t2) return 1;
	  else return 0; 
  }
}

