package src.ex02;

import java.io.Serializable;

/**
 * Клас, що представляє результат обчислень.
 * Реалізує інтерфейс Serializable для можливості збереження об'єктів в файл.
 */
public class Result implements Serializable {

    public void setArg(int argument) {
        this.argument = argument;
    }

    /**
     * Значення результату.
     */
    private String value;
    private int argument;
    private int choice;

    /**
     * Конструктор за замовчуванням, що ініціалізує значення результату пустим рядком.
     */
    public Result() {
        value = "";
    }

    public void setValue(String value, int input, int choice) {
        this.value = value;
        this.argument = input;
        this.choice = choice;
    }

    /**
     * Метод, що повертає значення результату.
     *
     * @return Значення результату.
     */

    public String getValue() {

        return String.format("Argument %d: %s (%s)", argument, value, getChoiceName());
    }

    public String getArg(){
        return String.format("%s", argument);

    }

    public int getArgInt(){
        return  argument;

    }

    public String getVal(){
        return  String.format("%s", value);

    }

    public String getChoice(){
        return  String.format("%s", getChoiceName());

    }


    public int getValInt(){
        return  Integer.parseInt(value);

    }



    private String getChoiceName() {
        return switch (choice) {
            case 1 -> "binary";
            case 2 -> "octal";
            case 3 -> "hexadecimal";
            default -> "unknown";
        };
    }

    /**
     * Метод, що встановлює значення результату.
     *
     * @param argument Вихідний аргумент
     */
    public void setVal(int argument) {
        this.value = String.valueOf(argument);

    }

    public void setValue() {
    }
}
