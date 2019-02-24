/**
 * Sort
 */

public class SortImel implements Sort{

    @Override   //  选择排序
    public void selectSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; ++i){
            int min = i;
            for (int j = i + 1; j < n; ++j){
                if (array[j] < array[min])
                    min = j;
            }
            swap(array,i,min);
        }
    }

    
    @Override   //  插入排序
    public void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i){
            for (int j = i-1; j > -1 && array[j] > array[i]; --j){
                swap(array, i, j);
            }
        }
    }

    /**
     * 插入排序的改进
     */
    public void insertX(int[] array){
        int n = array.length;
        int exchanges = 0;
        for (int i = n - 1; i > 0; --i){
            if (array[i] < array[i-1]){
                swap(array,i,i-1);
                ++exchanges;
            }
        }
        if (exchanges == 0)
            return;
        
        for (int i = 2; i < n; ++i){
            int min = array[i];
            int j = i;
            while (min < array[j-1]){
                array[j] = array[j-1];
                --j;
            }
            array[j] = min;
        }
    }
    
    @Override   //  希尔排序
    public void shellSort(int[] array) {
        int n = array.length;
        int h = 1;                      // 间隔h排序
        while (h < n/3) h = h*3 + 1;

        while (h > 1){
            for (int i = h; i < n; ++i){
                for (int j = i; j >= h && array[j] < array[j - h]; j -= h){
                    swap(array, j, j-h);                    
                }
            h /= 3;
            }
        }
    }
    
    
    @Override       // 自顶向下
    public void mergeSort(int[] array, int[] aux, int lo, int hi) {
        if (hi < lo)
        return;
        int mid = lo + (lo + hi) / 2;
        mergeSort(array, aux, lo, mid);
        mergeSort(array, aux, mid+1, hi);
        merge(array,aux,lo,mid,hi);
    }
    
    private static void merge(int[]array, int[] aux, int lo, int mid, int hi){
        for (int i = lo; i <= hi; ++i){
            aux[i] = array[i];
        }
        
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; ++k){
            if (i > mid)                array[k] = aux[j++];
            else if (j > hi)            array[k] = aux[i++];
            else if (aux[i] < aux[j])   array[k] = aux[i++];
            else                        array[k] = aux[j++];
        }
    }
    
    @Override       // 自下向上归并
    public void mergeSortBU(int[] array) {
        int n = array.length;
        int[] aux = new int[n];
        for (int len = 1; len < n; len *= 2){
            for (int lo = 0; lo < n - len; lo += len + len){
                int mid = lo + len - 1;
                int hi = Math.min(lo + len + len - 1, n - 1);
                merge(array, aux, lo, mid, hi);
            }
        }
    }

    @Override       //  快排
    public void qSort(int[] array, int lo, int hi) {
        if  (hi < lo)
            return;
        int value = array[lo];
        int i = lo + 1, j = hi;
        
        while (true){
            while (array[i] < value && i < hi)
                ++i;
            while (array[j] > value && j > lo)
                --j;
            if (i >= j)
                break;
            swap(array, i, j);
        }
        swap(array, (lo + hi) / 2, j);
        qSort(array, lo, j-1);
        qSort(array, j + 1, hi);
    }
    
    @Override   //小根堆
    public void headSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i){
            int temp = (i + 1) / 2 - 1;
            int j = i;
            while (array[temp] > array[j]){
                swap(array, temp, j);
                j = temp;
                temp = (temp + 1) / 2 - 1;
                if (temp < 0)
                    break;
            }
        }
    }

    private void swap(int[] array, int x, int y) {
        int value = array[x];
        array[x] = array[y];
        array[y] = value;
    }

}