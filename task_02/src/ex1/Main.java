package src.ex1;

import java.io.*;

public class Main {
    private static Calc calc = new Calc();

    /** Метод який сериалізує об'єкт calc
     */
    public boolean seriaizable(Calc calc){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("config.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(calc);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    /** Метод який сериалізує об'єкт calc
     */
    public Calc deseriaizable(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("config.dat");
            ois = new ObjectInputStream(fis);
            calc = (Calc) ois.readObject();



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return calc;
    }


    /**
     * MENU
     */
    private void menu() {
        Calc calc = new Calc();

        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Enter command...");
                System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
                try {
                    s = in.readLine();
                } catch(IOException e) {
                    System.out.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            switch (s.charAt(0)) {
                case 'q':
                    System.out.println("Exit.");
                    break;
                case 'v':
                    System.out.println("View current.");
                    calc.displayCalculate();
                    break;
                case 'g':
                    System.out.println("Random generation.");
                    calc.generateNumber();
                    calc.displayCalculate();
                    break;
                case 's':
                    System.out.println("Save current.");
                    seriaizable(calc);
                    calc.displayCalculate();
                    break;
                case 'r':
                    System.out.println("Restore last saved.");
                    deseriaizable();
                    calc.displayCalculate();
                    break;
                default:
                    System.out.print("Wrong command. ");
            }
        } while(s.charAt(0) != 'q');
    }
    /** Выполняется при запуске программы.
     * Вычисляется значение функции для различных аргументов.
     * Результаты вычислений выводятся на экран.
     * @param args - параметры запуска программы.
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }
}
