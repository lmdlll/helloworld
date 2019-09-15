package work.Sorts;

class ReviewSort{
    //插入排序  时间复杂度：O(n^2)  空间复杂度：O(1)  稳定
    /**
     * 1、首先比较数组的前两个数据，并排序；
     * 2、比较第三个元素与前两个排好序的数据，并将第三个元素放入适当的位置；
     * 3、比较第四个元素与前三个排好序的数据，并将第四个元素放入适当的位置;
     * 4、…… 直至把最后一个元素放入适当的位置。
     *
     * 例子：
     * {4,5,1,2,8,6,7,3,10,9} 
     * 取无序区间的第一个，从右向左扫描有序区间比较，方括号内可视为有序区间。 
     * 第一次：[4],5,1,2,8,6,7,3,10,9 
     * 第二次：[4,5],1,2,8,6,7,3,10,9 
     * 第三次：[1,4,5],2,8,6,7,3,10,9 
     * 第四次：[1,2,4,5],8,6,7,3,10,9 
     * 第五次：[1,2,4,5,8],6,7,3,10,9 
     * 第六次：[1,2,4,5,6,8],7,3,10,9 
     * 第七次：[1,2,4,5,6,7,8],3,10,9 
     * 第八次：[1,2,3,4,5,6,7,8],10,9 
     * 第九次：[1,2,3,4,5,6,7,8,10],9
     * 第十次：[1,2,3,4,5,6,7,8,9,10] 
     */
    public static void insertSort(int[] data){
        for(int i=1; i<data.length; i++){
            int pos = data[i];
            int start = i-1;
            while (start>=0 && data[start]>pos){
                data[start+1] = data[start];
                start--;
            }
            data[start+1] = pos;
        }
    }

    //希尔排序  时间复杂度：O(n^2)  空间复杂度：O(1) 不稳定
    public static void ShellSort(int[] data){
        int gap = data.length;
        while (gap>1) {
            gap = gap / 3 + 1;
            for (int i=gap; i<data.length; i++){
                int pos = data[i];
                int start = i-gap;
                while (start>=0 && pos<data[start]){
                    data[start+gap] = data[start];
                    start -= gap;
                }
                data[start+gap] = pos;
            }
        }
    }

    //选择排序  时间复杂度：O(n^2)   空间复杂度：O(1)  不稳定
    /**
     * 对于给定的一组记录，经过第一轮比较后得到最大的记录，然后将该记录的位置与最后一个记录的位置交换；
     * 接着对不包括最后一个记录以外的其他记录进行第二次比较，得到最大记录并与倒数二个位置记录交换；
     * 重复该过程，直到进行比较的记录只剩下一个为止。
     */
    //先排最大的
    public static void SelectSort1(int[] data){
        for (int i=0; i<data.length; i++){
            int max = 0;
            for (int j=0; j<data.length-i; j++){
                if(data[max]<data[j]){
                    max = j;
                }
            }
            if(max!=data.length-1-i){
                int tmp = data[data.length-1-i];
                data[data.length-1-i] = data[max];
                data[max] = tmp;
            }
        }
    }

    //先排最小的
    public static void SelectSort2 (int[] data) {
        for(int i=0; i<data.length; i++){
            int min = i;
            for (int j=i; j<data.length; j++){
                if(data[min]>data[j]){
                    min = j;
                }
            }
            if(min!=i){
                int tmp = data[i];
                data[i] = data[min];
                data[min] = tmp;
            }
        }
    }

    //堆排序（从小到大，所以建大根堆）  时间复杂度：O(nlogn) 空间复杂度：O(1)  不稳定
    //建大根堆
    public static void adjustHeap(int[] arr,int root,int length){
        int temp = arr[root];//先取出当前元素i
        //从i结点的左子结点开始，也就是2i+1处开始
        for(int k=root*2+1; k<length; k=k*2+1){
            //如果左子结点小于右子结点，k指向右子结点
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if(arr[k] >temp){
                arr[root] = arr[k];
                root = k;
            }else{
                break;
            }
        }
        arr[root] = temp;//将temp值放到最终的位置
    }
    //排序：  parent：n   leftchild：n*2+1    rightchild：n*2+2
    public static void HeapSort(int[] data){
        //1.构建大根堆
        for(int i=(data.length-1-1)/2; i>=0; i--){
            //从最后一个非叶子节点，逆序向下调整
            adjustHeap(data,i,data.length);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=data.length-1; j>0; j--){
            //将堆顶元素与末尾元素进行交换
            int tmp = data[j];
            data[j] = data[0];
            data[0] = tmp;
            //重新对堆进行调整
            adjustHeap(data,0,j);
        }
    }

    //冒泡排序 时间复杂度：O(n^2) 空间复杂度：O(1)  稳定
    public static void BubbleSort(int[] data){
        for (int i=0; i<data.length; i++){
            int flag = 0;
            for(int j=1; j<data.length-i; j++){
                if(data[j-1]>data[j]){
                    int tmp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = tmp;
                    flag =1;
                }
            }
            if(flag==0){
                return;
            }
        }

    }

    //快速排序     时间复杂度：O(nlogn) 空间复杂度:O(logn) 不稳定
    //找一个基准值，小的放左边，大的放右边
    public static void QuickSort(int[] data,int left, int right){
        if(left>=right){
            return;
        }
        int mid = FindMid(data,left,right);
        QuickSort(data,left,(mid-1));
        QuickSort(data,mid,right);
    }
    public static int FindMid(int[] data,int left, int right){
        int pos=data[right];
        int start = left;
        int end = right;
        while (start<end){
            while (start<end && data[start]<=pos){
                start++;
            }
            if(start==end){
                break;
            }
            data[end] = data[start];
            while (start<end && data[end]>pos){
                end--;
            }
            if (start==end){
                break;
            }
            data[start] = data[end];
        }
        data[start] = pos;
        return start;
    }


    //归并排序
    public static void MergeSort(int[] data){


    }


    //疑问：java中的Arrays.sort中用什么排序？
    /**
     * Arrays.sort()方法，
     * 如果数组长度大于等于286且连续性好的话，就用归并排序，
     * 如果大于等于286且连续性不好的话就用双轴快速排序。
     * 如果长度小于286且大于等于47的话就用双轴快速排序，
     * 如果长度小于47的话就用插入排序
     */

    //堆排序
    public static void heapSort(int[] arr){
        for (int i=(arr.length-2)/2; i>=0; i--){
            //建堆
            adjustheap(arr,i,arr.length);
        }
        for(int i=arr.length-1; i>=0; i--) {
            int max = arr[0];
            arr[0] = arr[i];
            arr[i] = max;
            adjustheap(arr,0, i);
        }
    }

    private static void adjustheap(int[] arr, int root, int length) {
        if((root*2+1)>length){
            return;
        }
        for (int i=root*2+1; i<length; i=2*i+1){
            int max = i;
            if(i+1<length && arr[i]<arr[i+1]){
                max++;
            }
            if(arr[root]<arr[max]){
                int value = arr[root];
                arr[root] = arr[max];
                arr[max] = value;
                root = max;
            }
        }
    }


}

public class Sort {
    public static void main(String[] args) {
        int[] data = new int[]{1,2,10,5,40,3,-1,-10};
        ReviewSort sort = new ReviewSort();
//        sort.insertSort(data);
//        sort.SelectSort1(data);
     //   sort.SelectSort2(data);
//        sort.HeapSort(data);
//        sort.BubbleSort(data);
//        sort.QuickSort(data,0,data.length-1);
        sort.heapSort(data);
    }
}
