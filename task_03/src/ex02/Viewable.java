package src.ex02;

import src.ex03.ViewTable;

/** Creator
 * (шаблон проектирования
 * Factory Method)<br>
 * Объявляет метод,
 * "фабрикующий" объекты
 * @author xone
 * @version 1.0
 * @see Viewable#getView()
 */
public interface Viewable {
    /**
     * Создаёт объект, реализующий {@linkplain View}
     */
    ViewTable getView();
}
