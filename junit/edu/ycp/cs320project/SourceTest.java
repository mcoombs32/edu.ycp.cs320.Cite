package edu.ycp.cs320project;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.project.Book;
import edu.ycp.cs320.project.Journal;
import edu.ycp.cs320.project.Website;

public class SourceTest {
	// When comparing floating point values for equality, allow
	// a small "fudge factor" to account for the fact that floating
	// point arithmetic is not exact
	private static final double DELTA = 0.00001;
	
	// test fixture objects
	private Book book;;
	private Journal journal;
	private Website website;
	
	@Before
	public void setUp() {
		// create test fixture objects
		
		
	}
	
	@Test
	public void testGetX() throws Exception {
		assertEquals(0.0, origin.getX(), DELTA);
		assertEquals(3.0, p2.getX(), DELTA);
		assertEquals(-5.0, p3.getX(), DELTA);
	}
	
	@Test
	public void testGetY() throws Exception {
		assertEquals(0.0, origin.getY(), DELTA);
		assertEquals(4.0, p2.getY(), DELTA);
		assertEquals(-12.0, p3.getY(), DELTA);
	}
	
	@Test
	public void testDistanceTo() throws Exception {
		assertEquals(5.0, origin.distanceTo(p2), DELTA);
		assertEquals(5.0, p2.distanceTo(origin), DELTA);
		assertEquals(13.0, origin.distanceTo(p3), DELTA);
		assertEquals(13.0, p3.distanceTo(origin), DELTA);
	}
}
