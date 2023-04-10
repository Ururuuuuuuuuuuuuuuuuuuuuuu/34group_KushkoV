package src.ex04;
import src.ex02.View;

import java.util.Scanner;

/** Консольная команда
 * Generate;
 * шаблон Command
 * @author xone
 * @version 1.0
 */
public class GenerateConsoleCommand implements ConsoleCommand {
    /** Объект, реализующий интерфейс {@linkplain View};
     * обслуживает коллекцию объектов {@linkplain src.ex02.Result}
     */
    private final View view;
    /** Инициализирует поле {@linkplain GenerateConsoleCommand#view}
     * @param view объект, реализующий интерфейс {@linkplain View}
     */
    public GenerateConsoleCommand(View view) {
        this.view = view;
    }
    @Override
    public char getKey() {
        return 'g';
    }
    @Override
    public String toString() {
        return "'g'enerate";
    }
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        int choice = 0;

        while (num == 0) {
            System.out.print("Введіть ціле число: ");

            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
            } else {
                System.out.println("Введено невірне значення. Спробуйте ще раз.");
                scanner.next();
            }
        }

        while (choice == 0) {
            System.out.println("Выберіть тип представлення:");
            System.out.println("1 - Двійкове");
            System.out.println("2 - Вісімкове");
            System.out.println("3 - Шістнадцяткове");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 3) {
                    System.out.println("Введено некорректное значение. Попробуйте ще раз.");
                    choice = 0;
                }
            } else {
                System.out.println("Введено невірне значення. Спробуйте ще раз.");
                scanner.next();
            }
        }

        view.viewInit(choice, num);
        view.viewShow();
    }
}
