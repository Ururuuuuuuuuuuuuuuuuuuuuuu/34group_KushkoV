package src.ex05;

import java.util.concurrent.TimeUnit;
import src.ex02.View;
import src.ex02.ViewResult;
import src.ex04.ConsoleCommand;


/**
 * Консольная команда
 * Execute all threads;
 * шаблон Command
 *
 * @author xone
 * @version 1.0
 */
public class ExecuteConsoleCommand implements ConsoleCommand {

    /** Объект, реализующий интерфейс {@linkplain View};
     * обслуживает коллекцию объектов {@linkplain src.ex02.Result}
     */
    private final View view;

    /** Возвращает поле {@linkplain ExecuteConsoleCommand#view}
     *
     * @return значение {@linkplain ExecuteConsoleCommand#view}
     */
    public View getView() {
        return view;
    }

    /** Инициализирует поле {@linkplain ExecuteConsoleCommand#view}
     *
     * @param view объект, реализующий {@linkplain View}
     */
    public ExecuteConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'e';
    }

    @Override
    public String toString() {
        return "'e'xecute";
    }

    @Override
    public void execute() {
        CommandQueue queue = new CommandQueue();
        MaxCommand maxCommand = new MaxCommand((ViewResult)view);
        AvgCommand avgCommand = new AvgCommand((ViewResult)view);
        MinMaxCommand minMaxCommand = new MinMaxCommand((ViewResult)view);
        System.out.println("Execute all threads...");
        queue.put(minMaxCommand);
        queue.put(maxCommand);
        queue.put(avgCommand);
        try {
            while (avgCommand.running() || maxCommand.running() || minMaxCommand.running()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue.shutdown();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.err.println(e.toString());
        }
        System.out.println("All done.");
    }
}