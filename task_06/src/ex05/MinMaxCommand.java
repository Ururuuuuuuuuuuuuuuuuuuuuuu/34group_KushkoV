package src.ex05;
import java.util.concurrent.TimeUnit;
import src.ex02.Result;
import src.ex02.ViewResult;
import src.ex04.Command;
/** Задача, используемая
 * обработчиком потока;
 * шаблон Worker Thread
 * @author xone
 * @version 1.0
 * @see Command
 * @see CommandQueue
 */
public class MinMaxCommand implements Command /*, Runnable */ {
    /** Хранит результат обработки коллекции */
    private int resultMin = -1;
    /** Хранит результат обработки коллекции */
    private int resultMax = -1;
    /** Флаг готовности результата */
    private int progress = 0;
    /** Обслуживает коллекцию объектов {@linkplain src.ex02.Result} */
    private final ViewResult viewResult;

    /** Инициализирует поле {@linkplain MinMaxCommand#viewResult}
     * @param viewResult объект класса {@linkplain ViewResult}
     */
    public MinMaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }
    /** Возвращает результат
     * @return поле {@linkplain MinMaxCommand#resultMin}
     */
    public int getResultMin() {
        return resultMin;
    }
    /** Возвращает результат
     * @return поле {@linkplain MinMaxCommand#resultMax}
     */
    public int getResultMax() {
        return resultMax;
    }
    /** Проверяет готовность результата
     * @return false - если результат найден, иначе - true
     */
    public boolean running() {
        return progress < 100;
    }
    /** Используется обработчиком потока {@linkplain CommandQueue};
     * шаблон Worker Thread
     */
    @Override
    public void execute() {
        progress = 0;
        System.out.println("MinMax executed...");
        int idx = 0, size = viewResult.getItems().size();
        for (Result item : viewResult.getItems()) {
            if (item.getValInt() < 0) {
                if ((resultMax == -1) ||
                        (viewResult.getItems().get(resultMax).getValInt() < item.getValInt())) {
                    resultMax = idx;
                }
            } else {
                if ((resultMin == -1) ||
                        (viewResult.getItems().get(resultMin).getValInt() > item.getValInt())) {
                    resultMin = idx;
                }
            }
            idx++;
            progress = idx * 100 / size;
            if (idx % (size / 5) == 0) {
                System.out.println("MinMax " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(5000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.print("MinMax done. ");
        if (resultMin > -1) {
            System.out.print("Min positive #" + resultMin + " found: " +
                    String.format("%d",
                            viewResult.getItems().get(resultMin).getValInt()));
        } else {


            System.out.print("Min positive not found.");
        }
        if (resultMax >= 0) {
            System.out.println(" Max negative #" + resultMax + " found: " +
                    String.format("%d",
                            viewResult.getItems().get(resultMax).getValInt()));
        } else {
            System.out.println(" Max negative item not found.");
        }
        progress = 100;
    }

}