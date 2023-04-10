package src.ex03;
import src.ex02.ViewableResult;

/** ConcreteCreator
 * (шаблон проектирования
 * Factory Method)<br>
 * Объявляет метод,
 * "фабрикующий" объекты
 * @author xone
 * @version 1.0
 * @see ViewableResult
 * @see ViewableTable#getView()
 */
public class ViewableTable extends ViewableResult {
    /**
     * Создаёт отображаемый объект {@linkplain ViewTable}
     */
    @Override
    public ViewTable getView() {
        return new ViewTable();
    }
}