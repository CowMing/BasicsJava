package heap;


import java.util.ArrayList;

/**
 * Binary Heap, 堆中某节点的值总是不大于父节点的值, 当然, 也可以是最小堆
 * @author Ming
 * @date 2019-12-26
 */
public class MaxBinaryHeap<E extends Comparable> {

    private ArrayList<E> array;

    public MaxBinaryHeap(){
        array = new ArrayList<>();
    }

    /**
     * if index from zero start: (index -1) / 2
     * if index from one start: index/2
     * @param index
     * @return
     */
    public int parentIndex(int index){
        return (index - 1) / 2;
    }

    /**
     * if index from zero start: index * 2 + 1
     * if index from one start: index * 2
     * @param index
     * @return
     */
    public int leftIndex(int index){
        return index * 2 + 1;
    }

    /**
     * if index from zero start: index * 2 + 2
     * if index from one start: index * 2 + 1
     * @param index
     * @return
     */
    public int rightIndex(int index){
        return index * 2 + 2;
    }

    public void foreach(){
        for(E e : this.array) {
            System.out.println(e);
        }
    }

    public void add(E e){
        array.add(e);
        siftUp(array.size() - 1);
    }

    public void removeMax(){
        array.set(0, array.get(array.size() - 1));
        array.remove(array.size() - 1);
        siftDown(0);
    }

    /**
     * 向上判断，判断新加的元素是否大于父节点,如果大于调整位置。添加元素为此操作
     * @param index
     */
    private void siftUp(int index){
        while (index > 0 && array.get(index).compareTo(array.get(parentIndex(index))) > 0){
            int parentIndex = parentIndex(index);
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    /**
     * 向下判断，是否小于左右节点,如果小于调整位置,删除元素为此操作
     * @param index
     */
    private void siftDown(int index){
        while(index < array.size() &&
                array.get(index).compareTo(array.get(leftIndex(index))) < 0){
            E rightEle = array.get(rightIndex(index));
            int swapIndex;
            if (array.get(index).compareTo(rightEle) < 0){
                E leftEle= array.get(leftIndex(index));
                swapIndex = leftEle.compareTo(rightEle) > 0 ? leftIndex(index) : rightIndex(index);
            } else {
                swapIndex = rightIndex(index);
            }
            swap(index, swapIndex);
        }
    }

    private void swap(int i, int j){
        E e = array.get(i);
        array.set(i, array.get(j));
        array.set(j, e);
    }
}
