package src.ex04;
import src.ex02.Result;
/** Команда
 * Change item;
 * шаблон Command
 * @author xone
 * @version 1.0
 */
public class ChangeItemCommand implements Command {
    /** Обрабатываемый объект; шаблон Command */
    private Result item;
    /** Параметр команды; шаблон Command */
    private int offset;
    /**
     * Устанавливаент поле {@linkplain ChangeItemCommand#item}
     *
     * @param item значение для {@linkplain ChangeItemCommand#item}
     */
    public void setItem(Result item) {
        this.item = item;
    }
    /** Возвращает поле {@linkplain ChangeItemCommand#item}
     * @return значение {@linkplain ChangeItemCommand#item}
     */
    public Result getItem() {
        return item;
    }
    /** Устанавливаент поле {@linkplain ChangeItemCommand#offset}
     * @param offset значение для {@linkplain ChangeItemCommand#offset}
     * @return новое значение {@linkplain ChangeItemCommand#offset}
     */
    public int setOffset(int offset) {
        return this.offset = offset;
    }
    /** Возвращает поле {@linkplain ChangeItemCommand#offset}
     * @return значение {@linkplain ChangeItemCommand#offset}
     */
    public double getOffset() {
        return offset;
    }
    @Override
    public void execute() {
        item.setVal(item.getValInt() * offset);
    }
}