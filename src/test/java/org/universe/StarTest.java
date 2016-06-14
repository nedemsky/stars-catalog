package org.universe;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.universe.model.Star;

public class StarTest {

	Star star = new Star();
	
	@Test
	public void testStarClazz() {
		System.out.println("-------> testStarClazz");

		star.setName("Sun");
		star.setClazz("G");

		String cl = star.getClazz();
		Assert.assertEquals(cl, "G", "Class not equals 'G'"); 
	}
}
