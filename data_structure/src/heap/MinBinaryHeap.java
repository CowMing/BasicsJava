package heap;

import java.util.ArrayList;

/**
 * Min Binary Heap
 * @author Ming
 * @date 2019-12-27
 */
public class MinBinaryHeap<E extends Comparable> {

    private ArrayList<E> list;

    private MinBinaryHeap(){
        list = new ArrayList<>();
    }

    public void add(E e){
        list.add(e);
        siftUp(list.size() - 1);
    }

    public void foreach(){
        this.list.forEach(System.out::println);
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


    public int rightIndex(int index){
        return index * 2 + 2;
    }

    private void siftUp(int index){
        while (index > 0 && list.get(index).compareTo(list.get(parentIndex(index))) < 0){
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private void siftDown(int index){
        while(list.get(index).compareTo(list.get(leftIndex(index))) > 0){
            if (list.get(index).compareTo(list.get(rightIndex(index))) > 0){
                swap(index, leftIndex(index));
                index = leftIndex(index);
            } else {
                swap(index, rightIndex(index));
                index = rightIndex(index);
            }
        }
    }

    private void swap(int i, int j){
        E e = list.get(i);
        list.set(i, list.get(j));
        list.set(j, e);
    }
}
