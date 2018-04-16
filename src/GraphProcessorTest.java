import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


////////////////////////////////////////////////////////////////////////////
//Semester:         CS400 Spring 2018
//PROJECT:          P3 Dictionary Graph
//FILES:            Graph.java
//					GraphProcessor.java
//					GraphTest.java
//					WordProcessor.java
//
//USER:             tschmidt6@wisc.edu | Teryl Schmidt
//					alsilverman3@wisc.edu | Avi Silverman
//					jsoukup2@wisc.edu | Joe Soukup
//					ssrivastav26@wisc.edu | Shashwat Srivastava
//					jstamn@wisc.edu | Joshua Stamn
//
//
//Instructor:       Deb Deppeler (deppeler@cs.wisc.edu)
//Bugs:             no known bugs
//
//Due:				2018 Apr 16, 2018 GraphProcessorTest.java 
////////////////////////////80 columns wide //////////////////////////////////

//	Still need to:
//		1. Impliment tests
//		2. Fix assertion statements
//		3. Fix any problems that arise


public class GraphProcessorTest {
    
    GraphProcessor gproc = null;
    String expected = null;
    String actual = null;
	File smallDictionary = new File("small_word_list.txt");
	File mediumDictionary = new File("medium_word_list.txt");
//	File mediumDictionary = new File("Uniquetest.txt");
	File largeDictionary = new File("large_word_list.txt");

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        gproc = new GraphProcessor();
    }

    @After
    public void tearDown() throws Exception {
    }
    
	@Test
	public void test01_total_vertecies_on_small_graph() {;
		System.out.println(smallDictionary.getAbsolutePath());
		expected = "" + 12;
		actual = "" + gproc.populateGraph(smallDictionary.getAbsolutePath());
		assertEquals("Expected: " + expected + ", Actual: " + actual, expected, actual);
	}
	
	@Test
	public void test02_total_vertecies_on_medium_graph() {
		expected = "" + 427;
		actual = "" + gproc.populateGraph(mediumDictionary.getAbsolutePath());
		assertEquals("Expected: " + expected + ", Actual: " + actual, expected, actual);
	}
	
	@Test
	public void test03_total_vertecies_on_large_graph() {
		expected = "" + 2468;
		actual = "" + gproc.populateGraph(largeDictionary.getAbsolutePath());
		assertEquals("Expected: " + expected + ", Actual: " + actual, expected, actual);
	}
	
	@Test
	public void test04_path_on_empty_graph() {
		expected = "null";
		actual = "" + gproc.getShortestPath("no", "words");
		assertEquals("Expected: " + expected + ", Actual: " + actual, expected, actual);
	}
	
	@Test
	public void test05_path_on_small_graph() {
		gproc.populateGraph(smallDictionary.getAbsolutePath());
		expected = "[]";
		actual = "" + gproc.getShortestPath("", "");
		assertEquals("Expected: " + expected + ", Actual: " + actual, expected, actual);
	}
	
	@Test
	public void test06_path_on_medium_graph() {
		gproc.populateGraph(mediumDictionary.getAbsolutePath());
		expected = "[]";
		actual = "" + gproc.getShortestPath("", "");
		assertEquals("Expected: " + expected + ", Actual: " + actual, expected, actual);
		
	}
	
	@Test
	public void test07_shortest_path_length_on_empty_graph() {
		expected = "" + -1;
		actual = "" + gproc.getShortestDistance("", "");
		assertEquals("Expected: " + expected + ", Actual: " + actual, expected, actual);
	}
	
	@Test
	public void test08_shortest_path_length_on_small_graph() {
		gproc.populateGraph(smallDictionary.getAbsolutePath());
		expected = "";
		actual = "" + gproc.getShortestDistance("", "");
		assertEquals("Expected: " + expected + ", Actual: " + actual, expected, actual);
	}
	
	@Test
	public void test09_shortest_path_length_on_medium_graph_1() {
		gproc.populateGraph(mediumDictionary.getAbsolutePath());
		expected = "" + 49;
		actual = "" + gproc.getShortestDistance("COMEDO", "CHARGE");
		assertEquals("Expected: " + expected + ", Actual: " + actual, expected, actual);
	}
	
	@Test
	public void test10_shortest_path_length_on_medium_graph_2() {
		gproc.populateGraph(mediumDictionary.getAbsolutePath());
		expected = "" + 78;
		actual = "" + gproc.getShortestDistance("CHARGE", "GIMLETS");
		assertEquals("Expected: " + expected + ", Actual: " + actual, expected, actual);
	}
	
	@Test
	public void test11_shortest_path_length_on_medium_graph_3() {
		gproc.populateGraph(mediumDictionary.getAbsolutePath());
		expected = "" + 2;
		actual = "" + gproc.getShortestDistance("BELLIES", "JOLLIES");
		assertEquals("Expected: " + expected + ", Actual: " + actual, expected, actual);
	}
	
	@Test
	public void test12_shortest_path_length_on_medium_graph_4() {
		gproc.populateGraph(mediumDictionary.getAbsolutePath());
		expected = "" + 26;
		actual = "" + gproc.getShortestDistance("DEFINE", "SHINNY");
		assertEquals("Expected: " + expected + ", Actual: " + actual, expected, actual);
	}
	
	@Test
	public void test13_remove_vertex_after_removing_all_words() {
		gproc.populateGraph(smallDictionary.getAbsolutePath());
		gproc.removeVertex("at");
		gproc.removeVertex("it");
		gproc.removeVertex("cat");
		gproc.removeVertex("hat");
		gproc.removeVertex("hot");
		gproc.removeVertex("rat");
		gproc.removeVertex("heat");
		gproc.removeVertex("neat");
		gproc.removeVertex("major");
		gproc.removeVertex("wheat");
		gproc.removeVertex("streak");
		gproc.removeVertex("husband");
		expected = null;
		actual = gproc.removeVertex("");
		assertEquals("Expected: " + expected + ", Actual: " + actual, expected, actual);
	}
	
	@Test
	public void test14_shortest_path_after_removing_all_words() {
		gproc.populateGraph(smallDictionary.getAbsolutePath());
		gproc.removeVertex("at");
		gproc.removeVertex("it");
		gproc.removeVertex("cat");
		gproc.removeVertex("hat");
		gproc.removeVertex("hot");
		gproc.removeVertex("rat");
		gproc.removeVertex("heat");
		gproc.removeVertex("neat");
		gproc.removeVertex("major");
		gproc.removeVertex("wheat");
		gproc.removeVertex("streak");
		gproc.removeVertex("husband");
		expected = "";
		actual = gproc.getShortestPath("at", "rat").toString();
		assertEquals("Expected: " + expected + ", Actual: " + actual, expected, actual);
	}
	
	@Test
	public void test15_shortest_path_length_after_removing_all_words() {
		gproc.populateGraph(smallDictionary.getAbsolutePath());
		gproc.removeVertex("at");
		gproc.removeVertex("it");
		gproc.removeVertex("cat");
		gproc.removeVertex("hat");
		gproc.removeVertex("hot");
		gproc.removeVertex("rat");
		gproc.removeVertex("heat");
		gproc.removeVertex("neat");
		gproc.removeVertex("major");
		gproc.removeVertex("wheat");
		gproc.removeVertex("streak");
		gproc.removeVertex("husband");
		expected = "";
		actual = gproc.getShortestDistance("at", "rat").toString();
		assertEquals("Expected: " + expected + ", Actual: " + actual, expected, actual);
	}
	
	@Test
	public void test16_total_vertecies_after_removing_some_words() {
	}
	
	@Test
	public void test17_shortest_path_after_removing_some_words() {
	}
	
	@Test
	public void test18_shortest_path_length_after_removing_some_words() {
	}
	
	@Test
	public void test19_adding_words_to_populated_graph() {
	}
	
	@Test
	public void test20_populating_graph_with_nonexistant_file() {
        int actual = gproc.populateGraph("nonexistant_file.txt");
        int expected = -1;
        if (expected != actual) {
            System.out.println("Failed: expected: "+expected+ " actual: "+actual);
            fail("expected: "+expected+ " actual: "+actual);
        }
    }
	
	@Test
	public void test21_getWordStream_throws_IOException_on_nonexistant_file() {
        Stream<String> stream;
        try {
            stream = WordProcessor.getWordStream("nonexistant_file.txt");
            System.out.println("Failed: expected: "+"exception thrown"+ " actual: "+"no exception thrown");
            fail("expected: "+"exception thrown"+ " actual: "+"no exception thrown");   
        } catch (IOException e) {
        }
    }
	
	@Test
	public void test22_getShortestPath_returns_empty_on_equal_parameters() { 
        gproc.populateGraph(smallDictionary.getAbsolutePath()); 
        List<String> actualList = gproc.getShortestPath("dog","dog");      
        List<String> expectedList = new ArrayList<String>();
        if (expectedList.size() != actualList.size()) {
            System.out.println("Failed: expected: "+expectedList+ " actual: "+actualList);
            fail("expected: "+expectedList+ " actual: "+actualList);
        }
    }
}