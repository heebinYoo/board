import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;


public class TestTest {
    static final Logger logger =
            LoggerFactory.getLogger(TestTest.class);

    @Before
    public void setup(){
        logger.info("@Before");
    }

    @After
    public void tearDown(){
        logger.info("@After ");
    }

    @BeforeClass
    public static void setupForClass(){
        logger.info("@BeforeClass");
    }

    @AfterClass
    public static void tearDownForClass(){
        logger.info("@AfterClass");
    }


    @Test(expected=RuntimeException.class) //예외 발생을 예상
    public void test1(){
        logger.info("@Test1");
        throw new RuntimeException();
    }

    @Test(timeout=100) //100 millisecond 초과시 에러
    public void test2(){
        logger.info("@Test 2");

        // fail(String)
        // assertTrue(true);
        // assertsEquals([String message], expected, actual)
        // assertsEquals([String message], expected, actual, tolerance)
        // assertNull([message], object)
        // assertNotNull([message], object)
        // assertSame([String], expected, actual)
        // assertNotSame([String], expected, actual)
        // assertTrue([message], boolean condition)

    }
}