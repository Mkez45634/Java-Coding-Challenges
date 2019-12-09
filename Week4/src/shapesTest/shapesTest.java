package shapesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import shapes.AllShapes;
import shapes.Circle;
import shapes.Rectangle;
import shapes.RtAngleTriangle;

class shapesTest {
	AllShapes shapes = new AllShapes();
	
	@Test
	void r1r2Test() {
		Rectangle r1 = new Rectangle ("red", 2,3);
		shapes.add(r1);
		
		Rectangle r2 = new Rectangle ("red", 2,3);
		shapes.add (r2);
		
		assertEquals(r2.getColour(),r1.getColour());
		assertEquals(r2.getLength(), r1.getLength());
		assertEquals(r2.getWidth(), r1.getWidth());
	}

	@Test
	void r1r3test(){
		Rectangle r1 = new Rectangle ("red", 2,3);
		shapes.add(r1);
		
		Rectangle r3 = new Rectangle ("green", 2,3);
		shapes.add (r3);
		
		assertNotEquals(r3.getColour(),r1.getColour());
		assertEquals(r3.getLength(), r1.getLength());
		assertEquals(r3.getWidth(), r1.getWidth());
	}
	
	@Test
	void t1Base() {
		RtAngleTriangle t1 = new RtAngleTriangle ("red", 2,4);
		shapes.add(t1);
		
		assertEquals(4,t1.getBase());
	}
	
	@Test
	void fifthLoc() {
		Circle c1 = new Circle ("green", 4);
		shapes.add(c1);
		assertEquals(c1, shapes.getShape(0));
	}
}
