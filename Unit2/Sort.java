/**
 * Sort 接口
 * 《参考：算法》
 * 
 * @author Asia
 * @version 1.0
 */

public interface Sort{
    void selectSort(int[] array);                               //  选择排序
    void insertionSort(int[] array);                            //  插入排序
    void shellSort(int[] array);                                //  希尔排序
    void mergeSort(int[] array, int[] aux, int lo, int hi);     //  自顶向下归并排序
    void mergeSortBU(int[] array);                              //  自下向上归并排序
    void qSort(int[] array, int lo, int hi);                    //  快速排序
    void headSort(int[] array);                                 //  堆排序(小根堆)
}