package src.ex02;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;


public class MainTest {

    private ViewResult viewResult;

    @Before
    public void setup() {
        viewResult = new ViewResult();
    }

    @Test
    public void testGetItems() {
        ArrayList<Result> items = viewResult.getItems();
        assertEquals(10, items.size());
    }

    @Test
    public void testInit() {
        ViewResult testResult = new ViewResult();
        testResult.init(1, 2);
        ArrayList<Result> items = testResult.getItems();
        assertEquals("Argument 0: 0 (binary)", items.get(0).getValue());
        assertEquals("Argument 2: 10 (binary)", items.get(1).getValue());
        assertEquals("Argument 4: 100 (binary)", items.get(2).getValue());
    }

    @Test
    public void testSaveAndRestore() throws Exception {
        ViewResult testResult = new ViewResult();
        testResult.init(1, 2);
        testResult.viewSave();

        try {
            testResult.viewRestore();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ArrayList<Result> restoredItems = testResult.getItems();
        assertEquals("Argument 0: 0 (binary)", restoredItems.get(0).getValue());
        assertEquals("Argument 2: 10 (binary)", restoredItems.get(1).getValue());
        assertEquals("Argument 4: 100 (binary)", restoredItems.get(2).getValue());
    }
}

