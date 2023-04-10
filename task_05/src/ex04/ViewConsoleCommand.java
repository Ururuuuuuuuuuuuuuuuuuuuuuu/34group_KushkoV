package src.ex04;
import src.ex02.View;
/** Консольная команда
 * View;
 * шаблон Command
 * @author xone
 * @version 1.0
 */
public class ViewConsoleCommand implements ConsoleCommand {
    /** Объект, реализующий интерфейс {@linkplain View};
     * обслуживает коллекцию объектов {@linkplain src.ex02.Result}
     */
    private final View view;
    /** Инициализирует поле
     * @param view объект, реализующий интерфейс {@linkplain View}
     */
    public ViewConsoleCommand(View view) {
        this.view = view;
    }
    @Override
    public char getKey() {
        return 'v';
    }
    @Override
    public String toString() {
        return "'v'iew";
    }
    @Override
    public void execute() {
        System.out.println("View current.");
        view.viewShow();
    }
}