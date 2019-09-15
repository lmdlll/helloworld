package work.Sorts;

class Function{
    //插入排序，时间复杂度：O(N^2) 空间复杂度：O(1)  稳定
    public static void InsertSort(int[] data){
        for (int i=1; i<data.length; i++){
            int key = data[i];
            int end = i-1;
            while (end>=0 && data[end]>key){
                data[end+1] = data[end];
                end--;
            }
            data[end+1] = key;
        }
    }

    //希尔排序，时间复杂度：O(N^1.3)  空间复杂度：O(1)  不稳定
    public static void ShellSort(int[] data){
        int gap = data.length;
        while (gap>1){
            gap = gap/3+1;
            for (int i=gap; i<data.length; i+=gap){
                int key = data[i];
                int end = i-gap;
                while (end>=0 && data[end]>key){
                    data[end+gap] = data[end];
                    end -= gap;
                }
                data[end+gap] = key;
            }
        }
    }

    //选择排序，时间复杂度：0(n^2) 空间复杂度：O(1) 不稳定
    public static void SelectSort(int[] data){
        for (int i=0; i<data.length; i++) {
            int falg = i;
            for (int j = i; j < data.length; j++) {
                if (data[falg] > data[j]) {
                    falg = j;
                }

            }
            if (falg != i) {
                int tmp = data[i];
                data[i] = data[falg];
                data[falg] = tmp;
            }
        }
    }

    //堆排序， 时间复杂度：O(nlogn) 空间复杂度：O(1) 不稳定
    public static void HeapSort(int[] data){
        //首先要建堆，要排升序，建大堆
        for(int i=(data.length-1-1)/2; i>=0; i--){
            //从最后一个非叶子节点，逆序向下调整
            AdjuestHeap(data,i,data.length);
        }
        //建好堆后，将第一个数字与最后一个进行交换
        for (int i=data.length-1; i>=0; i--){
            int tmp = data[i];
            data[i] = data[0];
            data[0] = tmp;
            AdjuestHeap(data,0,i);
        }
    }
    //向下调整
    public static void AdjuestHeap(int[] data,int root,int len){
        //从根的左节点开始
        for (int i=root*2+1; i<len; i=i*2+1){
            if(i+1<len && data[i+1]> data[i]){
                i++;
            }
            if(data[root]<data[i]){
                int tmp = data[root];
                data[root] = data[i];
                data[i] = tmp;
                root = i;
            }else {
                break;
            }
        }
    }

    //快速排序，时间复杂度：O(nlogn) 空间复杂度：O(1) 不稳定
    public static void QuickSort(int[] data,int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = FindMid(data, left, right);
        QuickSort(data, left, mid - 1);
        QuickSort(data, mid, right);

    }
    public static int FindMid(int[] data,int left, int right){
        int start = left;
        int end = right;
        int key = data[right];
        while (start<end){
            while (start<end && data[start]<=key){
                start++;
            }
            if(start==end){
                break;
            }
            data[end] = data[start];
            while (start<end && data[end]>key){
                end--;
            }
            if(start==end){
                break;
            }
            data[start] = data[end];
        }
        data[start] = key;
        return start;
    }




}

public class DetailSort {
    public static void main(String[] args) {
        int[] data = new int[]{9,1,3,5,4,2,0,-1,-2,-1};
        Function f = new Function();
        int[] a = new int[data.length];
        System.arraycopy(data,0,a,0,data.length);
        f.InsertSort(a);
        for (int i: a) {
            System.out.print(i+" ");
        }
        System.out.println();

        System.arraycopy(data,0,a,0,data.length);
        f.ShellSort(a);
        for (int i: a) {
            System.out.print(i+" ");
        }
        System.out.println();

        System.arraycopy(data,0,a,0,data.length);
        f.SelectSort(a);
        for (int i: a) {
            System.out.print(i+" ");
        }
        System.out.println();

        System.arraycopy(data,0,a,0,data.length);
        f.HeapSort(a);
        for (int i: a) {
            System.out.print(i+" ");
        }
        System.out.println();

        System.arraycopy(data,0,a,0,data.length);
        f.QuickSort(a,0,a.length-1);
        for (int i: a) {
            System.out.print(i+" ");
        }
        System.out.println();




    }
}
