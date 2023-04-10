package src.ex05;

import java.util.Vector;
import src.ex04.Command;

/**
 * Класс CommandQueue создает обработчик потока для выполнения объектов с интерфейсом Command
 * и реализует шаблон Worker Thread.
 *
 * @author xone
 * @version 1.0
 * @see Command
 */
public class CommandQueue implements Queue {
    // Очередь задач
    private final Vector<Command> tasks;
    // Флаг ожидания
    private boolean waiting;
    // Флаг завершения
    private boolean shutdown;
    private src.ex04.Command Command;

    /**
     * Конструктор инициализирует очередь задач и запускает поток для обработки очереди.
     */
    public CommandQueue() {
        tasks = new Vector<>();
        waiting = false;
        new Thread(new Worker()).start();
    }

    /**
     * Метод put добавляет задачу в очередь.
     *
     * @param r задача
     */
    @Override
    public void put(Command r) {
        tasks.add(r);
        if (waiting) {
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /**
     * Метод take извлекает задачу из очереди, если она есть.
     * Если очередь пуста, поток засыпает и ждет, пока появится задача.
     *
     * @return задачу
     */
    @Override
    public Command take() {
        if (tasks.isEmpty()) {
            synchronized (this) {
                waiting = true;
                try {
                    wait();
                } catch (InterruptedException ie) {
                    waiting = false;
                }
            }
        }
        return (Command);
    }

    /**
     * Метод setCommand устанавливает команду для выполнения.
     *
     * @param command команда
     */
    public void setCommand(src.ex04.Command command) {
        Command = command;
    }

    /**
     * Метод shutdown устанавливает флаг завершения работы.
     */
    public void shutdown() {
        shutdown = true;
    }

    /**
     * Класс Worker реализует поток для обработки очереди задач.
     * Извлекает задачи из очереди и выполняет их.
     */
    private class Worker implements Runnable {
        /**
         * Метод run запускает поток для обработки очереди задач.
         */
        public void run() {
            while (!shutdown) {
                Command r = take();
                if (r != null) {
                    Command.execute();
                }
            }
        }
    }
}
