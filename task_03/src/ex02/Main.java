package src.ex02;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Обчислення та відображення результатів.
 * Містить реалізацію статичного методу main().
 *
 * @author xone
 * @version 1.0
 * @see Main#main
 */
public class Main {

    private final View view;

    public Main(View view) {
        this.view = view;
    }

    /**
     * Метод для відображення головного меню та взаємодії з користувачем.
     */
    protected void menu() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        do {
            do {
                System.out.println("Enter command...");
                System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
                try {
                    s = in.readLine();
                } catch (IOException e) {
                    System.out.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);

            switch (s.charAt(0)) {
                case 'q' -> System.out.println("Exit.");
                case 'v' -> {
                    System.out.println("ex02.View current.");
                    view.viewShow();
                }
                case 'g' -> {
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
                case 's' -> {
                    System.out.println("Save current.");
                    try {
                        view.viewSave();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    view.viewShow();
                }
                case 'r' -> {
                    System.out.println("Restore last saved.");
                    try {
                        view.viewRestore();
                    } catch (Exception e) {

                        System.out.println("Serialization error: " + e);
                    }
                    view.viewShow();
                }
                default -> System.out.print("Wrong command. ");
            }
        } while (s.charAt(0) != 'q');
    }

    /**
     * Виконується під час запуску програми.
     * Обчислюється значення функції для різних аргументів.
     * Результати обчислень відображаються на екрані.
     *
     * @param args – параметри запуску програми.
     */
    public static void main(String[] args) {
        Main main = new Main(new ViewableResult().getView());
        main.menu();
    }
}