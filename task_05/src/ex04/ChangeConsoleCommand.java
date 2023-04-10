package src.ex04;
import src.ex02.Result;
import src.ex02.View;
import src.ex02.ViewResult;
import java.util.Random;

/** Консольная команда
 * Change item;
 * шаблон Command
 * @author xone
 * @version 1.0
 */
public class ChangeConsoleCommand
        extends ChangeItemCommand
        implements ConsoleCommand {
    /** Объект, реализующий интерфейс {@linkplain View};
     * обслуживает коллекцию объектов {@linkplain src.ex02.Result}
     */
    private View view;
    /** Возвращает поле {@linkplain ChangeConsoleCommand#view}
     * @return значение {@linkplain ChangeConsoleCommand#view}
     */
    public View getView() {
        return view;
    }
    /** Устанавливает поле {@linkplain ChangeConsoleCommand#view}
     * @param view значение для {@linkplain ChangeConsoleCommand#view}
     * @return новое значение {@linkplain ChangeConsoleCommand#view}
     */
    public View setView(View view) {
        return this.view = view;
    }
    /** Инициализирует поле {@linkplain ChangeConsoleCommand#view}
     * @param view объект, реализующий интерфейс {@linkplain View}
     */
    public ChangeConsoleCommand(View view) {
        this.view = view;
    }
    @Override
    public char getKey() {
        return 'c';
    }
    @Override
    public String toString() {
        return "'c'hange";
    }
    @Override
    public void execute() {
        Random ran = new Random();
        System.out.println("Change item: scale factor " + setOffset(ran.nextInt(50)));
        for (Result item : ((ViewResult)view).getItems()) {
            super.setItem(item);
            super.execute();
        }
        view.viewShow();
    }
}