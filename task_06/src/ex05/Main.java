package src.ex05;
import src.ex02.View;
import src.ex02.ViewableResult;
import src.ex04.ChangeConsoleCommand;
import src.ex04.GenerateConsoleCommand;
import src.ex04.Menu;
import src.ex04.ViewConsoleCommand;
/** Вычисление и отображение
 * результатов; содержит реализацию
 * статического метода main()
 * @author xone
 * @version 5.0
 * @see Main#main
 */
public class Main {
    /** Объект, реализующий интерфейс {@linkplain View};
     * обслуживает коллекцию объектов {@linkplain src.ex02.Result};
     * инициализируется с помощью Factory Method
     */
    private final View view = new ViewableResult().getView();
    /** Объект класса {@linkplain Menu};
     * макрокоманда (шаблон Command)
     */
    private final Menu menu = new Menu();
    /** Обработка команд пользователя */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new ExecuteConsoleCommand(view));
        menu.execute();
    }
    /** Выполняется при запуске программы
     * @param args параметры запуска программы
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}