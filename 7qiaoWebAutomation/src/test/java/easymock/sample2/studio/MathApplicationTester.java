package easymock.sample2.studio;



import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EasyMockRunner.class)
public class MathApplicationTester {
	
	@TestSubject
	MathApplication mathApplication = new MathApplication();
	
	@Mock
	CalculatorService calcService;
	
	@Test
	public void testAdd(){
		EasyMock.expect(calcService.add(20.0, 10.0)).andReturn(30.00);
		
		EasyMock.replay(calcService);
		
		Assert.assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);
	}
}
