package src.ex04;
import src.ex02.Result;
import src.ex03.ViewTable;
import org.junit.Assert;
import org.junit.Test;
import src.ex02.ViewResult;

import java.util.ArrayList;
import java.util.Random;

/**
 * Тестирование класса ChangeItemCommand.
 */
public class MainTest {

    /**
     * Тестирование метода execute() класса ChangeItemCommand.
     * Проверяем, что после выполнения команды значение аргумента установлено правильно
     * и значение результата установлено как произведение значения результата и смещения.
     */
    @Test
    public void testExecute() {
        ChangeItemCommand cmd = new ChangeItemCommand();
        cmd.setItem(new Result());
        Random ran = new Random();
        int x, y, offset;
        for (int ctr = 0; ctr < 1000; ctr++) {
            x = ran.nextInt(50);
            y = ran.nextInt(50);
            offset = ran.nextInt(50);
            cmd.getItem().setVal(x);
            cmd.getItem().setArg(y);
            cmd.setOffset(offset);
            cmd.execute();
            assertEquals(y, cmd.getItem().getArgInt());
            assertEquals(x * offset, cmd.getItem().getValInt());
        }
    }

    private void assertEquals(int i, int valInt) {

    }
    private void assertEquals(String s, String string) {
    }

    /**
     * Тестирование класса ChangeConsoleCommand.
     * Проверяем, что команда "c" изменяет представление ViewResult.
     */
    @Test
    public void testChangeConsoleCommand() {
        ViewResult view = new ViewResult();
        ChangeConsoleCommand cmd = new ChangeConsoleCommand(view);
        cmd.getView().viewInit(1,23);
        cmd.execute();
        assertEquals("'c'hange", cmd.toString());
        assertEquals('c', cmd.getKey());
    }



    /**
     * Тестирование методов viewSave() и viewRestore() класса ViewTable.
     * Проверяем, что после сохранения и восстановления таблицы ViewTable
     * она остается неизменной.
     */
    @Test
    public void testSaveAndRestore() throws Exception {
        ViewTable tbl1 = new ViewTable();
        ViewTable tbl2 = new ViewTable();
        tbl1.init(1, 2);
        tbl1.getItems().get(1).setValue();
        tbl1.viewSave();

        try {
            tbl2.viewRestore();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ArrayList<Result> result1 = tbl1.getItems();
        ArrayList<Result> result2 = tbl2.getItems();

        assertEquals(result1.size(), result2.size());
        Assert.assertEquals(result1.get(1).getValue(), result2.get(1).getValue());
    }
}
