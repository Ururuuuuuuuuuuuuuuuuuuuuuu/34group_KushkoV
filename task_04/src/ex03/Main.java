package src.ex03;
import src.ex02.View;

/** Вычисление и отображение результатов<br>
 * Содержит реализацию статического метода main()
 * @author xone
 * @version 3.0
 * @see Main#main
 * */
public class Main extends src.ex02.Main {
    /** Инициализирует поле  */
    public Main(View view) {
        super(view);
    }
    /** Выполняется при запуске программы;
     * вызывает метод {@linkplain src.ex02.Main#menu menu()}
     * @param args - параметры запуска программы
     */
    public static void main(String[] args) {
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}