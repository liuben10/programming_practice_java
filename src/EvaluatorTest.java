import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

import org.junit.Before;
import org.junit.Test;

import string.Evaluator;

public class EvaluatorTest {
	
	Evaluator evaluator;
	
	@Before
	public void setup() {
		evaluator = new Evaluator();
	}
	
	@Test
	public void simpleParse() {
		List<String> parsed = evaluator.parse("3+4*55*66");
		System.out.println(parsed);
		assertEquals(Arrays.asList("3", "+", "4", "*", "55", "*", "66"), parsed);
	}
	
	@Test
	public void complexParse() {
		List<String> parsed = evaluator.parse("3+4*(55+66)");
		System.out.println(parsed);
		assertEquals(Arrays.asList("3", "+", "4", "*", "55+66"), parsed);	
	}
	
	@Test
	public void nestedParse() {
		List<String> parsed = evaluator.parse("3 + (4 * (5 + 6)) - 12");
		System.out.println(parsed);
		assertEquals(Arrays.asList("3", "+", "4*(5+6)", "-", "12"), parsed);
	}
	
	@Test
	public void doubleNestedParse() { 
		List<String> parsed = evaluator.parse("3 + ((4 * 12 + 3) * (5 + 6)) - 12");
		System.out.println(parsed);
		assertEquals(Arrays.asList("3", "+", "(4*12+3)*(5+6)", "-", "12"), parsed);
	}
	
	@Test
	public void simpleEvaluation() {
		assertEquals(7, evaluator.evaluate("3+4"));
	}
	
	@Test
	public void secondCaseSimpleEvaluation() {
		assertEquals(12, evaluator.evaluate("3+4+5"));
	}
	
	@Test
	public void multipleSimpleEvaluation() {
		assertEquals(18, evaluator.evaluate("3+4+5+6"));
	}
	
	@Test
	public void orderOfOperations() {
		assertEquals(23, evaluator.evaluate("3+4*5"));
	}
	
	@Test
	public void orderOfOperationsMultiple() {
		assertEquals(38, evaluator.evaluate("3*6+4*5"));
	}
	
	@Test
	public void nestedOperation() {
		assertEquals(23, evaluator.evaluate("3 + 4*(2+3)"));
	}
	
	@Test
	public void doublyNestedOperations() {
		assertEquals(23, evaluator.evaluate("3 + 4 * ((1 + 1) + 3)"));
	}
	
	@Test
	public void careerCupCases() {
		assertEquals(31, evaluator.evaluate("19 + 12 / 4 - ((4 - 7) * 3 / 1)")); 
		assertEquals(-2855, evaluator.evaluate("1 + (2 - 3) * 4 + 5 - 6 * 8 - (18 * 12 * 13) - (11 / (5 + 2 + 4))"));
		assertEquals(1, evaluator.evaluate("((2 + 4) / 3 - 2 + 1)"));
	}
	
}
