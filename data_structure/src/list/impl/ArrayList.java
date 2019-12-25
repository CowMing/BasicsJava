package list.impl;

import list.List;

import java.util.Iterator;

/**
 * 该类的数据结构为顺序线性结构，可以参考参考，源码中的arrayList也是使用顺序线性结构
 * 何为顺序线性结构，就像军队一样，一个连的成员数量基本变化浮动不是很大，且每个人都在连的站位是有编号的且连续性的。
 * 例如我们指定21号就是21号，这种就是顺序线性结构，按编号来排序，就很清楚谁谁没来。
 * 鄙人描述可能抽象的点，可以先看看线性结构，就明白啦
 * @author tangyangming
 * @date 2019/3/18 22:26
 */
public class ArrayList<E> implements List<E> {


    /**
     * 这是一个大房子
     */
    private Object[] dataStore;

    /**
     * 这个房子构造之前要建多大
     */
    private int length;

    /**
     * 这个是房子所住成员
     */
    private int actualSize= 0;

    /**
     * 土地资源有限，以后拓展到海洋吧,为什么减8，留一点绿化植物不好吗
     */
    private static final int MAX_STORE = Integer.MAX_VALUE - 8;

    /**
     * 本金不足，后期赚钱盖房子
     */
    public ArrayList(){
        this.length = 10;
        this.dataStore = new Object[this.length];
    }

    /**
     * 欧洲人造房子
     * @param length
     */
    public ArrayList(int length){
        this.length = length;
        this.dataStore = new Object[this.length];
    }

    /**
     * 这个屋子住了多少人（返回容器元素大小）
     * @return
     */
    @Override
    public int size(){
        return actualSize;
    }

    /**
     * 看看这个屋子是否没住人(容器有无元素)
     * @return
     */
    @Override
    public boolean isEmpty(){
        return actualSize == 0;
    }

    /**
     * 新租客（实际添加新元素）
     * @param e
     */
    @Override
    public void add(E e) {
        //房子不足，在建嘛
        grow();
        dataStore[actualSize++] = e;

    }

    /**
     * 富二代，选定了已租的房子，现在插队（实际根据下标自行插入）
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if(isSpill(index)){
            System.out.println("本人很懒，不写异常");
            return;
        }
        //检查
        grow();
        //嗯，此方法是底层的拷贝，建议看一下，不懂看for循环
        System.arraycopy(dataStore, index, dataStore, index + 1, actualSize - index + 1);
        //为了方便理解，在此加上for循环吧
//        for(int i = dataStore.length - 1; i > index; i--){
//            dataStore[i] = dataStore[i - 1];
//        }
        dataStore[index] = e;
        actualSize++;
    }

    /**
     * 这个房子破了，拆了把，建新的（实际根据下标来删除元素）
     * @param index
     */
    @Override
    public void remove(int index){
        if(isSpill(index)){
            System.out.println("本人很懒，不写异常");
            return;
        }
        int numMoved = actualSize - index - 1;
        if (numMoved > 0) {
            System.arraycopy(dataStore, index + 1, dataStore, index, numMoved);
        }
        dataStore[--actualSize] = null;

    }

    /**
     * 可能这个租客拉仇恨，这个房子的主人要踢了它（根据值来删除元素）
     * @param e
     */
    public void remove(E e){
        if (e == null){
            System.out.println("本人很懒，没有异常,参数不要为null");
            return;
        }
        for(int i = 0; i < actualSize; i++){
            if (e.equals(dataStore[i])){
                //能不用for循环尽量不用，不过这个东西底层还是使用循环把
                System.arraycopy(dataStore, i + 1, dataStore, i, actualSize - i -1);
                break;
            }
        }
        dataStore[--actualSize] = null;
    }

    /**
     * 房东根据谁没交房租来催债了（实际根据下标来获取元素）
     * @param index
     * @return
     */
    @Override
    public E get(int index){
        if(isSpill(index)){
            System.out.println("本人很懒，不写异常");
            return null;
        }
        return (E)dataStore[index];
    }

    /**
     * 主动来交房租不错，可以考虑降租（实际参数值来查询数组）
     * @param e
     * @return
     */
    @Override
    public int indexOf(E e){
        if(e == null){
            System.out.println("本人很懒，不写异常");
        }
        int backIndex = -1;
        for (int i =0; i < actualSize; i++){
            if (e.equals(dataStore[i])){
                backIndex = i;
                break;
            }
        }
        return backIndex;
    }

    /**
     * 某个租客外面闯祸被查了吧（返回容器是否有这个元素）
     */
    @Override
    public boolean contains(E e){
        return indexOf(e) >= 0;
    }

    /**
     * 二房东（其实是根据下标替换原来的元素）
     */
    @Override
    public void set(int index, E e){
        if(isSpill(index)){
            System.out.println("本人很懒，不写异常");
            return;
        }
        dataStore[index] = e;
    }

    /**
     * 有人模仿我的脸，还把我租客额。。。。。也复制走了（我也不知道是深拷贝还是什么拷贝），有同学了解的话告诉我哦
     * @return
     */
    @Override
    public Object clone(){
        try {
            ArrayList<?> v = (ArrayList<?>) super.clone();
            v.dataStore = new Object[length];
            System.arraycopy(dataStore, 0, v.dataStore, 0, length);
            v.actualSize = 0;
            return v;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    /**
     * 唉，都走吧，走吧
     */
    public void clear(){
        // clear to let GC do its work
        for (int i = 0; i < length; i++) {
            dataStore[i] = null;
        }
        actualSize = 0;
    }

    /**
     * 检查是否足够给客人入住，如无法就造房子（此方法为扩容，跟java源码可能不同，但是意思是一样）
     */
    private void grow(){
        boolean flag = this.length == this.actualSize;
        if (flag){
            //嗯，有钱造房子，造出原来的1.5倍
            int newSize = this.length + (this.length >> 1);
            //土地资源有限啊,不能超过啊
            if (newSize > MAX_STORE){
                newSize = MAX_STORE;
            }

            //这里跟源码不同，但道理一样
            this.length = newSize;
            Object[] newObject = new Object[newSize];

            //此方法就是原数组值给新数组
            System.arraycopy(dataStore, 0, newObject, 0, dataStore.length);
            dataStore = newObject;
        }
    }

    /**
     * 检查这个租客是否拿错钥匙(实际检查下标是否无脑)
     * @return true
     */
    private boolean isSpill(int index) {
        //其实这里可能要注意，根据下标插入，是按有元素的来，可能index > length 是多余的，有新的写法可以参考
        if (index > length || index < 0 || index > actualSize) {
            return true;
        }
        return false;
    }

    public Iterator<E> listIterator(){
        return new ListItr();
    }


    /**
     * 此迭代器
     */
    private class ListItr implements Iterator<E> {

        /**
         * 咱们理解它为游标
         */
        int cursor;

        /**
         * 这个呢，就是记录我们下标的东西
         */
        int lastRet;

        public ListItr(){
            cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor != actualSize;
        }

        /**
         * 看源码的迭代器，嗯，what,the this 什么东西，没事，看我这个
         * @return
         */
        @Override
        public E next() {
            if (cursor >= actualSize) {
                System.out.println("小弟弟，别越界喔");
                return null;
            }
            lastRet = cursor;
            cursor++;
            return (E)dataStore[lastRet];
        }

        /**
         * 写迭代器最要考虑的是这个删除操作吧，因为会破坏掉原先的数组，且集合中有一个modCount专门储存修改集合数据的总数量
         * 所以，在源码的迭代器中，如果修改次数与本迭代器中存储修改次数不匹配，则会报错，详细可参考源码，这里我就不记录modCount了
         */
        @Override
        public void remove() {
            //调用最外层的remove，原因你懂的
            ArrayList.this.remove(lastRet);
            //这个时候，就是要重置一下游标了，打个笔方，游标现在为4，咱们现在删除的是下标3，好了，删除了，原先下标4后面的，
            //全部往前挪了一个位置，而游标没修改的话，就已经指向原来下标5，所以，咱们要后退，知道吗，退一步海阔天空
            //下面是游标减1,我直接拿原先的下标来
            cursor = lastRet;
            //这个也别忘了
            lastRet -= 1;
        }

        /**
         * 调用此方法，清空迭代器的游标，此方法源码没有，因为迭代器遍历完后好像没什么用了，所以我重新写出一个出来，就不用在new新的迭代器了
         */
        public void clear(){
            cursor = 0;
        }
    }
}