package ex1;

import java.io.Serializable;
import java.util.Scanner;

public class Calc implements Serializable {
    int number; // Значення, для якого потрібно знайти представлення

    private String binary; // Двійкове представлення
    private String octal; // Вісімкове представлення
    private String hex; // Шістнадцяткове представлення

    /**
     * Метод, який генерує випадкові числа
     */
    public void generateNumber(){
        number = (int) (Math.random() * (10000 - 1) + 1);
        calculate();
    }

    /**
     * Метод, який записує число введене з клавіатури
     */
    public void printNubmer(){
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        calculate();
    }


    /**
     * Метод, який обчислює число
     */
    public void calculate(){
        binary = Integer.toBinaryString(number);
        octal = Integer.toOctalString(number);
        hex = Integer.toHexString(number);
    }

    /**
     * Метод, який відображає результати
     */
    public void displayCalculate(){
        System.out.println("Двійкове: " + binary);
        System.out.println("Вісімкове: " + octal);
        System.out.println("Шістнадцяткове: " + hex);
    }

    public Calc() {
    }

    public String getBinary() {
        return binary;
    }

    public void setBinary(String binary) {
        this.binary = binary;
    }

    public String getOctal() {
        return octal;
    }

    public void setOctal(String octal) {
        this.octal = octal;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }
}
