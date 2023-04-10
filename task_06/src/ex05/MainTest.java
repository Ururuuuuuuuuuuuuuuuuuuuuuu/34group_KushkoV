package src.ex05;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import src.ex02.ViewResult;
/** Тестирование
 * разработанных классов
 * @author xone
 * @version 5.0
 * @see CommandQueue
 * @see MaxCommand
 * @see AvgCommand
 * @see MinMaxCommand
 */
public class MainTest {
    private final static int N = 1000;
    private static final ViewResult view = new ViewResult(N);
    private static final MaxCommand max1 = new MaxCommand(view);
    private static final MaxCommand max2 = new MaxCommand(view);

    private static final AvgCommand avg1 = new AvgCommand(view);
    private static final AvgCommand avg2 = new AvgCommand(view);
    private static final MinMaxCommand min1 = new MinMaxCommand(view);
    private static final MinMaxCommand min2 = new MinMaxCommand(view);
    private final CommandQueue queue = new CommandQueue();
    /** Выполняется первым */
    @BeforeClass
    public static void setUpBeforeClass() {
        view.viewInit(2,34);
        Assert.assertEquals(N, view.getItems().size());
    }
    /** Выполняется последним */
    @AfterClass
    public static void tearDownAfterClass() {
        Assert.assertEquals(max1.getResult(), max2.getResult());
        Assert.assertEquals(avg1.getResult(), avg2.getResult(), 0.1);
        Assert.assertEquals(min1.getResultMax(), min2.getResultMax());
        Assert.assertEquals(min1.getResultMin(), min2.getResultMin());
    }
    /** Проверка основной функциональности класса {@linkplain MaxCommand} */
    @Test
    public void testMax() {
        max1.execute();
        Assert.assertTrue( max1.getResult() > -1);
    }
    /** Проверка основной функциональности класса {@linkplain AvgCommand} */
    @Test
    public void testAvg() {
        avg1.execute();
        Assert.assertTrue( avg1.getResult() != 0.0);
    }
    /** Проверка основной функциональности класса {@linkplain MinMaxCommand} */
    @Test
    public void testMin() {
        min1.execute();
        Assert.assertTrue( min1.getResultMin() > -1);
    }
    /** Проверка основной функциональности класса
     * {@linkplain CommandQueue} с задачей {@linkplain MaxCommand}
     */
    @Test
    public void testMaxQueue() {
        queue.put(max2);
        try {
            while (max2.running()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue.shutdown();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            Assert.fail(e.toString());
        }
    }
    /** Проверка основной функциональности класса
     * {@linkplain CommandQueue} с задачей {@linkplain AvgCommand}
     */
    @Test
    public void testAvgQueue() {
        queue.put(avg2);
        try {
            while (avg2.running()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue.shutdown();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            Assert.fail(e.toString());
        }
    }
    /** Проверка основной функциональности класса
     * {@linkplain CommandQueue} с задачей {@linkplain MinMaxCommand}
     */
    @Test
    public void testMinQueue() {


        queue.put(min2);
        try {
            while (min2.running()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue.shutdown();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            Assert.fail(e.toString());
        }
    }
}