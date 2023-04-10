package src.ex03;
import src.ex02.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MainTest {
    private static ViewTable viewTable;


    @BeforeEach
    public void setUp() {
        viewTable = new ViewTable();
    }


    @Test
    public void testSetWidth() {
        int expectedWidth = 50;
        assertEquals(expectedWidth, viewTable.getWidth());
        int newWidth = 100;
        viewTable.setWidth(newWidth);
        int actualWidth = viewTable.getWidth();
        assertEquals(newWidth, actualWidth);
    }

    @Test
    public void testSaveAndRestore() throws Exception {
        ViewTable tbl1 = new ViewTable();
        ViewTable tbl2 = new ViewTable();
        tbl1.init(1, 2);

        ArrayList<Result> expectedResults = tbl1.getItems();
        tbl1.viewSave();

        try {
            tbl2.viewRestore();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ArrayList<Result> actualResults = tbl2.getItems();
        int expectedSize = expectedResults.size();
        int actualSize = actualResults.size();
        assertEquals(expectedSize, actualSize);

        Result expectedResult = expectedResults.get(1);
        Result actualResult = actualResults.get(1);
        assertEquals(expectedResult.getValue(), actualResult.getValue());
    }
}

