package list;

/**
 * List接口
 * @author tangyangming
 * @date 2019-03-18
 */
public interface List<E> {

    /**
     * 添加元素
     * @param e
     */
    void add(E e);

    /**
     * 删除
     * @param index
     */
    void remove(int index);

    /**
     * 获取元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 判断是否存在该元素
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 查询该元素的下标
     * @param e
     * @return
     */
    int indexOf(E e);

    /**
     * 提供下标修改元素
     * @param index
     * @param e
     */
    void set(int index, E e);

    /**
     * 容器大小
     * @return
     */
    int size();

    /**
     * 判断是否为空
     * @return
     */
    boolean isEmpty();
}
