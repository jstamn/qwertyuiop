import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GraphProcessorTest {
    
    GraphProcessor gproc = null;
    String expected = null;
    String actual = null;
	File smallDictionary = new File("small_word_list.txt");
	File mediumDictionary = new File("medium_word_list.txt");
	File largeDictionary = new File("large_word_list.txt");

	/**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        gproc = new GraphProcessor();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }
    
	/**
	 * 
	 */
	@Test
	public void test01_total_vertecies_on_small_graph() {;
		expected = "" + 12;
		actual = "" + gproc.populateGraph(smallDictionary.getAbsolutePath());
		assertEquals("Expected: " + expected + ", Actual: " + actual, expected, actual);
	}
	
	/**
	 * 
	 */
	@Test
	public void test02_total_vertecies_on_medium_graph() {
	}
	
	/**
	 * 
	 */
	@Test
	public void test03_total_vertecies_on_large_graph() {
	}
	
	/**
	 * 
	 */
	@Test
	public void test04_path_on_empty_graph() {
	}
	
	/**
	 * 
	 */
	@Test
	public void test05_path_on_small_graph() {

	}
	
	/**
	 * 
	 */
	@Test
	public void test06_path_on_medium_graph() {
	}
	
	/**
	 * 
	 */
	@Test
	public void test07_shortest_path_length_on_empty_graph() {
	}
	
	/**
	 * 
	 */
	@Test
	public void test08_shortest_path_length_on_small_graph() {
	}
	
	/**
	 * GIVEN
	 */
	@Test
	public void test09_shortest_path_length_on_medium_graph_1() {
	}
	
	/**
	 * 
	 */
	@Test
	public void test10_shortest_path_length_on_medium_graph_2() {
	}
	
	/**
	 * 
	 */
	@Test
	public void test11_shortest_path_length_on_medium_graph_3() {
	}
	
	/**
	 * 
	 */
	@Test
	public void test12_total_vertecies_after_removing_all_words() {
	}
	
	/**
	 * 
	 */
	@Test
	public void test13_shortest_path_after_removing_all_words() {
	}
	
	/**
	 * 
	 */
	@Test
	public void test14_shortest_path_length_after_removing_all_words() {
	}
	
	/**
	 * 
	 */
	@Test
	public void test15_total_vertecies_after_removing_some_words() {
	}
	
	/**
	 * 
	 */
	@Test
	public void test16_shortest_path_after_removing_some_words() {
	}
	
	/**
	 * 
	 */
	@Test
	public void test17_shortest_path_length_after_removing_some_words() {
	}
	
	/**
	 * 
	 */
	@Test
	public void test18_adding_words_to_populated_graph() {
	}
	
	/**
	 * Should throw IOException...
	 */
	@Test
	public void test19_populating_graph_with_nonexistant_file() {
	}
}
