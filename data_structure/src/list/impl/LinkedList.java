package list.impl;

import list.List;

import java.util.ListIterator;

/**
 * 双向链表线性结构，嗯，就像我们小学升国旗一样，有个大哥排前面，总有大哥排在最后，剩下中间的都是小弟，中间的人永远不知道姓唐名铭的人排在第几位
 * 但却知道前一位和后一位的小小同学。双向链表理解不难，但要实现对其上一位和下一位的指针，要多踩踩坑。对于arrayList来说，双向链表增删快O(1)，查询慢O(n)，成反比把
 * 其实在java的源码中， LinkedList即使双向链表，也是队列(先进先出)和栈(先进后出)，用处也是挺大的。这里功能差不多，但官方更为详细，看完这个参考官方源码更好
 *
 * 这里我们把故事世界富豪榜，一是排名浮动大(世界前几百位打扰了)，二是像咱们小萌新，都快不知道钱包是什么东西了
 * 好了，看码
 * @author tangyangming
 * @date 2019/3/19 21:51
 */
public class LinkedList<E> implements List<E> {

    /**
     * 嗯，富豪榜首富，亚马逊老总，不知道看之前的新闻是不是真的，
     * 前段时间离婚，女方一下子分得的资产可以当女首富了，可见这位老兄资产多雄厚
     */
    private Node<E> first;

    /**
     * 不要小看最后一名，最后一名也是可以潜力巨大，不要问为什么，电视剧一般都是这么演的
     * @param e
     */
    private Node<E> last;

    /**
     * 比作富豪榜人数吧,我们每个人都是有成为富豪的机会的。
     */
    private int size = 0;

    /**
     * 好了，生成富豪榜，(双向链表存储的内存是散乱的，不像数组连续空间)
     */
    public LinkedList(){}

    /**
     * 唉，想当第一名富豪不容易啊，但是，像这位参数大哥，人的梦想还是要有滴
     * @param e
     */
    private void linkFirst(E e){
        Node oleOne = first;
        Node<E> newFirst = new Node<>(null, e, oleOne);
        //新首富产生啦
        first = newFirst;
        //如果富豪榜记录个个富豪，那么第一名是你，最后一名也还是你，人生真是大起大落
        if (oleOne == null) {
            last = newFirst;

        //开始记录富豪啦，这位曾经王者被挤进第二名了
        } else {
            //这时，就要对oleOne的前一指针指向新的第一名
            oleOne.prev = newFirst;
        }

        //这个富豪榜人数增加了。。。。不要在意这个，这个是链表存储了多少
        size++;
    }

    /**
     * 哎呀，富豪榜来新人了，潜力无限，加油
     */
    Node linkLast(E e) {
        Node<E> oleLast = last;
        Node<E> newLast = new Node<>(oleLast, e, null);
        last = newLast;
        if (oleLast == null){
            first = newLast;
        } else {
            oleLast.next = newLast;
        }
        size++;
        return newLast;
    }

    /**
     * 这个就是暴露在外面的方法，隐藏内部结构
     * @param e
     */
    @Override
    public void add(E e) {
        //默认添加到最后到链表的最后一个结点
        linkLast(e);
    }

    /**
     * 在这里写个获取节点的方法吧，发现写到后面根据下标获取Node还是挺多的
     * @param index
     * @return
     */
    Node<E> node(int index){
        if (index < (size >> 1)) {
            Node<E> n = first;
            //遍历，在i=index之前，指针一直指向下一个元素
            for (int i = 0; i < index; i++){
                n = n.next;
            }
            return n;
        } else {
            Node<E> n = last;
            //这个就是指向上一个元素
            for (int i = size - 1; i > index; i--){
                n = n.prev;
            }
            return n;
        }
        //其实看到这里不要害怕，这个只是一个从头遍历和一个从尾开始遍历，只要理清楚什么时候指针指向哪个就行了
    }

    /**
     * 虽然说链表删除元素不麻烦，但要找出要被删除的元素却很麻烦
     * @param index
     */
    @Override
    public void remove(int index) {
        //这里要删除的节点拿到先
        Node<E> reNode = node(index);

        //便于理解，我就不声明三个基佬了

        //先判断prev是否是null，如果是的话，那么它是领头羊，唉，这个领头羊的名称让给了下一代
        if (reNode.prev == null) {
            first = reNode.next;

        //如果不是领头羊，也就是说要被删除的节点，它的上节点的next 指向要被删除的节点的next
        } else {
            reNode.prev.next = reNode.next;
        }

        //判断是不是最尾的先，如果是则指向上一个节点
        if (reNode.next == null) {
            last = reNode.prev;

        //如果不是，则把下一结点的prev给要被删除节点上一位指针
        } else {
            reNode.next.prev = reNode.prev;
        }
        //建议画张图，有三个元素就够了，删除中间一个，把它们指向描述化

        //最后呢，清理空间
        //其实啊，这就是大自然的生存道理，用进废退，所以啊，年轻人，好好学习
        reNode.prev = null;
        reNode.item = null;
        reNode.next = null;
        size--;
    }

    /**
     * 获得元素，唉，链表获取元素是降低性能和时间，能少用就少用吧，性能优先
     * @param index
     */
    @Override
    public E get(int index) {
        if(isSpill(index)){
            System.out.println("本人很懒，不写异常");
            return null;
        }
        return node(index).item;
    }

    /**
     * 查询领头羊
     * @return
     */
    public E getFirst(){
        return first.item;
    }

    /**
     * 查询吊车尾
     */
    public E getLast(){
        return last.item;
    }

    /**
     * 其实在实际项目当中，都是查询多，删改操作不频繁
     * @param e
     * @return
     */
    @Override
    public boolean contains(E e){
        Node<E> nowNode = first;
        boolean falg = false;
        while(nowNode != null){
            if (nowNode.item.equals(e)){
                falg = true;
                break;
            }
            nowNode = nowNode.next;
        }
        return falg;
    }

    /**
     * 看看你在富豪榜第几位，心痛了没
     * @param e
     * @return
     */
    @Override
    public int indexOf(E e){
        Node<E> nowNode = first;
        int falg = -1;
        for (int i = 0; i < size; i++,nowNode = nowNode.next) {
            if(e.equals(nowNode.item)){
                falg = i;
                break;
            }
        }
        return falg;
    }

    /**
     * 写到这里，一些方法还是很常用到下标来获取Node元素
     * @param index
     * @param e
     */
    @Override
    public void set(int index, E e){
        if(isSpill(index)){
            System.out.println("本人很懒，不写异常");
            return;
        }
        Node<E> node = node(index);
        node.item = e;
    }

    /**
     * 检查这个租客是否拿错钥匙(实际检查下标是否无脑)
     * @return true
     */
    private boolean isSpill(int index) {

        if (index > size || index < 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 这里写一些队列的方法吧，其实吧，队列，就好比人，人生的出场顺序是很重要的
     * 有时候，你赶上了某一次的行业浪潮之巅，也许会遇到了冰封寒地，也许在无人地带探寻，每个人的机遇不同。
     * 算了，看码
     */
    public E poll(){
        //如果以后接触到消息队列的话，其特点也会发现，先进入队列的，优先处理事务.
        final Node<E> n = first;

        //当获得节点后，把指针指向下一个元素，并修改prev为null
        if (first != null){
            first = n.next;
            first.prev = null;
            size--;
        } else {
            return null;
        }

        return n.item;
    }

    /**
     * 新加入元素，优先处理，谁让他是VIP呢
     * @param e
     */
    public void peekFirst(E e){
        //直接调用插入头方法
        linkFirst(e);
    }

    /**
     * 向队列添加要待处理的元素
     * @param e
     */
    public void peekLast(E e){
        //直接插入最后即可
        linkLast(e);
    }

    /**
     * 这里写栈的结构吧，先进后出，就好比奶茶，当向一杯空杯子'滴'一滴奶茶，滴到它99次了，那么
     * 我们开始喝了，对，我们首先是会喝到99次的那一滴，然后，在98,97，96...喝完了，对，是不是很刺激
     * 对，栈的方式就是这样的，越是最后一个来的元素，越是优先处理。（不要吐槽举的栗子另类，往往反而印象深刻）
     * 来了，看码
     * 这个方法是添加元素
     */
    public void push(E e){
        linkLast(e);
    }

    /**
     * 这里就是弾栈，最后面的元素往往都会被.....
     * 不过在stack类中，有一个方法是peek，这方法贼狗啊，出去了还进来,这分明就是刁难我胖虎
     * @return
     */
    public E pop(){
        Node<E> n = last;

        if (last != null){
            last = n.prev;
            last.next = null;
            size--;
        } else {
            return null;
        }

        return n.item;
    }


    public ListIterator listIterator(){
        return new ListItr();
    }

    /**
     * 一个全新版本的迭代器，因为是链表，迭代器增删改对原数据的结构影响不大，大可放心就行操作
     * 大部分迭代器都会让你传一个下标的参数，目的表明这个是想让你从哪开始遍历
     * @param
     */
    private class ListItr implements ListIterator<E> {

        /**
         * 表示当前元素
         */
        private Node<E> crNode;

        /**
         * 表示下一元素指针。
         * 其实刚开始写迭代器的时候，省略掉了指向下一个节点的指针。
         * 写到后面会发现如果省略掉的话，在remove方法和set方法中的某些细节会省略掉，一些异常会慢慢暴露出来，可以自己尝试写一下，会发现问题。
         */
        private Node<E> neNode;

        int nextIndex;

        /**
         * 我就不写下标的了，遍历起来也是消耗性能
         */
        public ListItr(){

            crNode = null;
            neNode = first;
            nextIndex = 0;
        }

        /**
         * 指向下一节点是否为空
         * @return
         */
        @Override
        public boolean hasNext() {
            //判断next是否为空就行
            return neNode != null;
        }

        @Override
        public E next() {
            if(neNode == null){
                System.out.println("本人很懒，不写异常");
                return null;
            }
            //表示当前节点
            crNode = neNode;
            //开始指下下一个节点指针
            neNode = neNode.next;
            nextIndex++;
            return crNode.item;
        }

        /**
         * 此方法为判断是否有上一个元素,我们就拿当前节点来判断
         * @return
         */
        @Override
        public boolean hasPrevious() {
            //我们这里只要判断Node.prev是否为空就行，
            return crNode.prev != null;
        }

        /**
         * 返回上一个节点的item，在源码上，调用此方法，也会把指针指向上一个元素
         * @return
         */
        @Override
        public E previous() {
            if(crNode.prev == null){
                System.out.println("本人很懒，不写异常");
                return null;
            }
            //将当前节点移到上一节点，下一节点相应也向上移
            crNode = crNode.prev;
            neNode = neNode.prev;

            return crNode.item;
        }

        /**
         * 写下标我是拒绝的，没必要,毕竟链表内存不连续，有下标只是为了实现接口
         * @return
         */
        @Override
        public int nextIndex() {
            return nextIndex;
        }

        /**
         * 这个也是
         * @return
         */
        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        /**
         * 写链表的增删改，最好就是把链表的结构特性画出来，才能够清晰内部是怎样运行的
         */
        @Override
        public void remove() {
            if (crNode == null){
                System.out.println("小老弟，注意异常啊");
                return;
            }

            //先让当前节点.prev指向.next
            crNode.prev.next = crNode.next;
            //下一节点点指针指向上一位
            neNode.prev = crNode.prev;
            //用进废退
            crNode = null;
            size--;
            nextIndex--;
        }

        @Override
        public void set(E e) {
            crNode.item = e;
        }


        /**
         * add方法有点bug，没想好怎么解决，删除代码先，在源码中迭代器中的add方法也是有bug，在空链表中new迭代器的话，在添加 元素会有不一样的效果
         * 不管改来改去都是有在遍历的时候还是有bug，还是在遍历的时候不要添加元素吧
         * @param e
         */
        @Override
        public void add(E e) {
            if (neNode == null){
                neNode = linkLast(e);
            } else {
               linkLast(e);
            }
            size++;
            nextIndex++;

        }

    }

    /**
     * 这里为什么要设置成静态类呢，可以思考一下，百度没有
     * 鄙人观点：这是基于对象来存储，我们new出来一个对象时，临时存储在堆中(对象嘛，你永远不知道他几时会走，人总是三心二意的，人的话不可信)，
     * CG可能会过段时间清理掉这个对象，所以可能会造成空指针异常，所以，我们new对象是静态类的话，它是会存储到static区，不会马上被CG所回收掉。如有其他想法咱们来沟通交流。
     * @param <E>
     */
    private static class Node<E>{

        /**
         * 在我前面的大哥
         */
        Node<E> prev;

        /**
         * 这是我
         */
        E item;

        /**
         * 在我后面的小老弟
         */
        Node<E> next;

        Node(Node<E> prev, E item, Node<E> next){
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}