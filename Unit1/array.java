/**
 * 
 * @author Asia
 * @version 1.0
 * 
 * 
 */

public class Array<V>{
    private Object[] elements;
    private int size = 0; //数组中元素的数量
    private int capacity; //数组的容量

    public Array(int capacity){
        this.capacity = capacity;
        if (capacity<=0){
            throw new IllegalArgumentException("capacity must > 0");
        }
        elements = new Object[capacity];
    }

    public void insert(V v){
        if (size == capacity - 1){// 达到容量限制
            throw new IndexOutOfBoundsException();
        }

        elements[size++] = v; // 插入元素
    }

    public boolean remove(V v){
        for (int i = 0;i < size; i++){
            if (elements[i].equals(v)){
                elements[i] = null; //删除
                moveUp(i,size); // 讲后面的所有数据都前移一个位置
                size--; // 元素数量 - 1；
                return true; // 找到第一个要删除的项，返回true
            }
        }
        return false;  // 遍历所有元素，没有找到删除项
    }

    public V find(V v){
        for (int i = 0; i < size; i++){
            if (elements[i].equals(v)){
                return (V) elements[i];
            }
        }
        return null;
    }

    private void moveUp(int i, int size){
        while (i < size - 1){
            elements[i] = elements[++i];
        }
        elements[size-1] = null;  //最后一个元素置位null
    }

    /**
     * 返回指定下标的元素
     * @param index
     * @return
     */

    public V get(int index){
        if (index > capacity - 1){
            throw new IndexOutOfBoundsException();
        }
        return (V) elements[index];
    }

    /**
     * 返回数组中元素的数量
     */
    
    public int size(){
        return size;
    }

    /**
     * 显示所有元素
     */

    public void display(String prefix){
        System.out.print(prefix);
        for (int i = 0; i < elements.length; i++){
            if (i < size){
                System.out.print(elements[i] + "    ");
            }
            else{
                System.out.print("null" + "     ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<Integer>(5);
        array.insert(1);
        array.insert(5);
        array.insert(3);
        array.display("Init 1 5 3:  ");
        array.insert(4);
        array.display("add 4      : ");
        array.remove(3);
        array.display("delete 3      :  ");
        System.out.println("find 4: " + array.find(4));
        System.out.println("find 3: " + array.find(3));
        
    }

}
