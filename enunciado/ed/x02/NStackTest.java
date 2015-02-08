package ed.x02;




import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NStackTest {

	private ArrayNStack<String> S1;
	private ArrayNStack<String> S2;
	
	@Before
	public void setupFixture() {
		
		S1 = new ArrayNStack<String>(5);
		S1.push("A", "B", "C");
		
		S2 = new ArrayNStack<String>(10);
		S2.push("A", "B", "C");
	}
	

	@Test
	public void testDrops() {
		
		ArrayNStack<String> S3 = new ArrayNStack<String>(5);
		S3.push("C", "D", "E", "F", "G");
		
		S1.push("D", "E", "F", "G");
		
		Assert.assertTrue(S3.isEqualTo(S1));
		
		Assert.assertTrue(S1.isFull());
	}
	
	@Test
	public void testEquality() {
		
		Assert.assertTrue(S1.isEqualTo(S2));
	}
	
	@Test
	public void testPop() {
		
		Assert.assertEquals("C", S1.pop());
		Assert.assertEquals("B", S1.pop());
		Assert.assertEquals("A", S1.pop());
		Assert.assertTrue(S1.isEmpty());
	}
	
	@Test(expected=EmptyCollectionException.class)
	public void testPopPastEmpty() {
		
		Assert.assertEquals("C", S1.pop());
		Assert.assertEquals("B", S1.pop());
		Assert.assertEquals("A", S1.pop());
		
		S1.pop();
	}
	
}
