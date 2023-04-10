package src.ex02;

import src.ex03.ViewTable;

/** ConcreteCreator
 * (шаблон проектирования
 * Factory Method)<br>
 * Объявляет метод,
 * "фабрикующий" объекты
 * @author xone
 * @version 1.0
 * @see Viewable
 * @see ViewableResult#getView()
 */
public class ViewableResult implements Viewable {
    /**
     * Создаёт отображаемый объект {@linkplain ViewResult}
     */
    @Override
    public ViewTable getView() {
        return new ViewTable();
    }
}