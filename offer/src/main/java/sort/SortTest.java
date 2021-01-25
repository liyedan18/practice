package sort;

import java.util.Arrays;

/**
 * 常用排序算法
 *
 * 冒泡排序
 * 插入排序
 * 希尔排序
 * 归并排序
 * 快速排序
 */
public class SortTest {
    public static void main(String[] args) {

        SortTest s = new SortTest();
        int[] arr = new int[]{2, 1, 8, 3, 4, 3, -1, -6, 15, 0, 10};
        System.out.println(Arrays.toString(arr));

        // s.bubbleSort(arr);
        // s.betterBubbleSort(arr);
        // s.insertSort(arr);
        // s.insertSort2(arr);
        // s.shellSort(arr);
        // s.mergeSort(arr);
        s.quickSort(arr);
    }

    /**
     * 冒泡排序
     */
    private void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i,j);
                }
            }
        }
    }

    /**
     * 冒泡排序优化
     *
     * 时间复杂度：
     *      最好：O(N)
     *      最坏：O(N*N)
     *      平均：O(N*N)
     * 稳定性：
     *      稳定
     */
    private void betterBubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int flag = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                    flag = 1;
                }
            }

            if (flag == 0) {
                return;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 插入排序（直接插入）
     *
     * 当前位置之前的已经排好序，从当前位置向前一个一个比较，找到比当前位置元素小的
     * 查到那个位置后面即可。同时后面的元素要后移。
     *
     * 时间复杂度：
     *      最好：O(N)
     *      最坏：O(N*N)
     *      平均：O(N*N)
     * 稳定性：
     *      稳定
     */
    private void insertSort(int[] arr){
        //第0个位置已经排好序
        for (int i = 1; i < arr.length; i++) {
            //保存当前元素
            int temp = arr[i];
            //和i之前的元素比较，倒序比较
            int j = i - 1;
            // while (j >= 0 && temp < arr[j]) {
            //     //后移
            //     arr[j + 1] = arr[j];
            //     j--;
            // }
            for (; j >= 0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }

            arr[j + 1] = temp;

            System.out.println(Arrays.toString(arr));
        }
    }

    private void insertSort2(int[] arr){
        insertSortHelper(arr, 1);
    }

    /**
     * 插入排序辅助方法
     * gap是插入排序的增量，以增量gap为间隔进行排序
     */
    private void insertSortHelper(int[] arr, int gap){
        for (int i = gap; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - gap;
            for (; j >= 0 && temp < arr[j]; j -= gap) {
                //后移
                arr[j + gap] = arr[j];
            }
            arr[j + gap] = temp;

            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 希尔排序（缩小增量排序）
     *
     * 其实是插入排序的优化，插入排序内层增量是1，
     * 希尔排序采用多个增量
     *
     * 时间复杂度：
     *      最坏：O(N^1.3)
     * 稳定性：
     *      不稳定
     *      增量变化会破坏稳定性
     *
     * 参考：
     *  https://blog.csdn.net/qq_39207948/article/details/80006224
     */
    private void shellSort(int[] arr) {
        //逐渐缩小增量
        for (int i = arr.length / 2; i > 0; i /= 2) {
            insertSortHelper(arr, i);
        }
    }

    /**
     * 归并排序
     *
     * 先划分，直到分成一个元素，再原路合并,合并时挨个比较头元素
     *
     * 时间复杂度：
     *      最好：O(N*logN)
     *      最坏：O(N*logN)
     *      平均：O(N*logN)
     *      每一层归并的时间复杂度:O(N)
     *      总共的层数：logN+1
     * 空间复杂度:
     *      O(N)
     * 稳定性：
     *      稳定
     */
    private void mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private void mergeSortHelper(int[] arr, int left, int right) {
        //left==right时，已经是单个元素，不需要划分
        if (left < right) {
            int mid = (left + right) >> 1;
            //递归划分，直到只有一个元素
            mergeSortHelper(arr, left, mid);
            mergeSortHelper(arr, mid + 1, right);

            //将上面划分的元素合并，合并后有序
            merge(arr, left, mid, right);
            System.out.println(Arrays.toString(arr));
        }
    }

    //合并划分的元素，挨个比较头元素即可，需要额外的辅助空间
    private void merge(int[] arr, int left, int mid, int right) {

        int startIndex = left;
        //左边数组的当前索引
        int leftIndex = left;
        //右边数组的当前索引
        int rightIndex = mid + 1;
        //辅助空间
        int[] arrHelper = Arrays.copyOfRange(arr, left, right + 1);

        while (leftIndex <= mid && rightIndex <= right) {
            //左边数组的头元素<右边数组的头元素
            //注意辅助空间的开头元素，要减去起始索引left（或者一开始直接复制整个arr,则不需要减去left）
            if (arrHelper[leftIndex - left] < arrHelper[rightIndex - left]) {
                arr[startIndex++] = arrHelper[leftIndex - left];
                leftIndex++;
            } else {
                arr[startIndex++] = arrHelper[rightIndex - left];
                rightIndex++;
            }
        }

        //如果左边数组还有剩余
        while (leftIndex <= mid) {
            arr[startIndex++] = arrHelper[leftIndex - left];
            leftIndex++;
        }

        //如果右边数组还有剩余
        while (rightIndex <= right) {
            arr[startIndex++] = arrHelper[rightIndex - left];
            rightIndex++;
        }

    }

    /**
     * 快速排序
     *
     * 1.选定枢纽元素（这里选最后一个元素）
     * 2.将小于枢纽元素的放到左边，大于枢纽元素的放到右边
     * 3.在左右两边重复进行1和2，直到只有1个元素
     *
     * 时间复杂度：
     *      最好：O(N*logN)
     *      平均：O(N*logN)
     *          每一层划分时间复杂度：O(N)
     *          平均层数：logN层
     *      最坏：O(N*N)
     *          最坏的时候就是已经正确排序的时候，每次枢纽元素都是最后一个元素,层数为N层
     *
     * 稳定性：
     *      不稳定
     *      如: 2前 2后 1前 1后 1枢纽
     *      交换后：
     *          1后 1前 2后 2前 1枢纽
     */
    private void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            //找到枢纽元素的索引
            int parti = partition(arr, left, right);
            //递归分成左右两边
            quickSort(arr, left, parti - 1);
            quickSort(arr, parti + 1, right);
        }
    }

    /**
     * 根据枢纽元素（这里选定最后一个元素为枢纽元素），将arr分成两部分，并返回枢纽元素的索引
     * 枢纽元素在这里被正确排序
     * 比枢纽元素小的，移到左边，大的移到右边，也就是交换
     */
    private int partition(int[] arr, int left, int right) {
        //i找比枢纽元素大的
        int i = left;
        //j找比枢纽元素小的
        int j = right - 1;

        while (true) {
            while (arr[i] < arr[right]) {
                i++;
            }
            while (arr[j] > arr[right]) {
                j--;
            }

            if (i > j) {
                break;
            }

            //交换，大的放右边，小的放左边
            swap(arr, i, j);
            i++;
            j--;
        }

        //最后将枢纽元素和i换位置，i的位置也就是枢纽元素的位置
        swap(arr, i, right);

        System.out.println(Arrays.toString(arr));
        return i;
    }

}
