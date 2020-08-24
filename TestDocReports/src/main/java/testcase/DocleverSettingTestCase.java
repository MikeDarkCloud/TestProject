package testcase;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DocleverSettingTestCase {

    @BeforeClass
    public static void beforeclazz(){

        System.out.println("beforeclazz");
    }

    @AfterClass
    public static void  afterclazz(){
        System.out.println("afterclazz£¡");
    }

    @Before
    public  void bofore(){
        System.out.println("bofore");
    }

    @After
    public void after(){
        System.out.println("after");
    }
    @Test
    public void test_demo4(){
        DocleverFanc docleverFanc = new DocleverFanc();
        assertTrue(docleverFanc.fanc1(3,2));
    }
    @Test
    public void test_demo5(){
        DocleverFanc docleverFanc = new DocleverFanc();
        assertEquals(3,docleverFanc.fanc2(1,2));
    }
    @Test
    public void test_demo6(){
        DocleverFanc docleverFanc = new DocleverFanc();
        assertEquals(1,docleverFanc.fanc3(1,2));
    }
}

