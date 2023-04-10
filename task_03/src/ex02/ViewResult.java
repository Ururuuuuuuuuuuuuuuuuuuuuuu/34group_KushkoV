package src.ex02;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * ConcreteProduct
 * (Шаблон проектирования
 * Factory Method)<br>
 * Вычисление функции,
 * сохранение и отображение
 * результатов
 *
 * @author xone
 * @version 1.0
 * @see View
 */
public class ViewResult implements View {


    /**
     * Имя файла, используемое при сериализации
     */
    private static final String FNAME = "items.bin";
    /**
     * Определяет количество значений для вычисления по умолчанию
     */
    private static final int DEFAULT_NUM = 10;
    /**
     * Коллекция аргументов и результатов вычислений
     */
    private ArrayList<Result> items = new ArrayList<>();

    /**
     * Вызывает {@linkplain ViewResult#ViewResult(int n) ex02.ViewResult(int n)}
     * с параметром {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
     */
    public ViewResult() {
        this(DEFAULT_NUM);
    }

    /**
     * Инициализирует коллекцию {@linkplain ViewResult#items}
     *
     * @param n начальное количество элементов
     */
    public ViewResult(int n) {
        for (int ctr = 0; ctr < n; ctr++) {
            items.add(new Result());
        }
    }

    /**
     * Получить значение {@linkplain ViewResult#items}
     *
     * @return текущее значение ссылки на объект {@linkplain ArrayList}
     */
    public ArrayList<Result> getItems() {
        return items;
    }


    /**
     * Вычисляет значение функции
     * <p>
     * 11
     *
     * @param x аргумент вычисляемой функции
     * @return результат вычисления функции
     */
    private String calc(int choice, int x) {
        String res;
        switch (choice) {
            case 1 -> res = Integer.toBinaryString(x);
            case 2 -> res = Integer.toOctalString(x);
            case 3 -> res = Integer.toHexString(x);
            default -> throw new IllegalArgumentException("Некоректний вибір: " + choice);
        }
        return res;
    }

    /**
     * Вычисляет значение функции и сохраняет
     * результат в коллекции {@linkplain ViewResult#items}
     *
     * @param num шаг приращения аргумента
     */
    public void init(int choice, int num) {
        int input = 0;
        for (Result item : items) {
            item.setValue(calc(choice, input), input, choice);
            input += num;
        }
    }

    /**
     * Вызывает <b>init(double stepX)</b> со случайным значением аргумента<br>
     * {@inheritDoc}
     */
    @Override
    public void viewInit(int choice, int num) {
        init(choice, num);
    }

    /**
     * Реализация метода {@linkplain View#viewSave()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(items);
        os.flush();
        os.close();
    }

    /**
     * Реализация метода {@linkplain View#viewRestore()}<br>
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        items = (ArrayList<Result>) is.readObject();
        is.close();
    }

    /**
     * Реализация метода {@linkplain View#viewHeader()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewHeader() {
        System.out.println("Results:");
    }

    /**
     * Реализация метода {@linkplain View#viewBody()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewBody() {
        for (Result item : items) {
            System.out.printf(item.getValue() +"\n");
        }
        System.out.println();
    }

    /**
     * Реализация метода {@linkplain View#viewFooter()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewFooter() {
        System.out.println("End.");
    }

    /**
     * Реализация метода {@linkplain View#viewShow()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}
