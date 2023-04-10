package src.ex1;

import org.junit.Assert;

import static org.junit.Assert.*;

public class MainTest {
    Main main = new Main();
    Calc calc = new Calc();

    @org.junit.Test
    public void generateNumber(){
        calc.generateNumber();
    }

    @org.junit.Test
    public void seriaizable() {
        Assert.assertTrue(main.seriaizable(calc));
    }

    @org.junit.Test
    public void deseriaizable() {
        Calc calc1 = main.deseriaizable();

        Assert.assertTrue(calc.getOctal() == calc1.getOctal());
        Assert.assertTrue(calc.getHex() == calc1.getHex());
        Assert.assertTrue(calc.getBinary() == calc1.getBinary());
    }
}