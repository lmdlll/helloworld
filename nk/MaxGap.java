/*25268 左右最值最大差
 基于贪心算法的思想
 这两个数中有一个肯定是数组的最大值。要使得差值最大，那么另一边的最大值应尽可能的小。
 假设最大值在左边，那么对于最大值右边的数组有很多种分法，每一种分法肯定都包含数组最后一个数字即A[n-1]。
 如果不取A[n-1]，取最后一个数字和最大值中间的任一数字A[i]。
 若A[i]大于A[n-1]，那还不如取最后一个数字；若最A[i] 小于A[n-1]，
 那右半边的最大值肯定不是A[i]，所以无论如何右半边取最右端数字。
 假设最大值在右边，同理左半边取最左端数字。
 只需用数组最大值减去数组两端较小的那个值即可。
*/
import java.util.*;
public class MaxGap {
public int findMaxGap(int[] A, int n)
{ int max=0;
for(int i=0;i<A.length;i++) { //找出数组中的最大值
if(A[i]>max)
max=A[i];
}
int ans1=max-A[0];
int ans2=max-A[n-1];
if(ans1>ans2)
return ans1;
else
}
}