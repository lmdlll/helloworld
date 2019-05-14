# 题目：将一个数组逆序输出。
 
if __name__ == '__main__':
    a = [9,6,5,4,1]
    N = len(a) 
    print a
    for i in range(len(a) / 2):
        #交换
        a[i],a[N-1-i]=a[N-1-i],a[i]
    print a
#简单，代码量远低于其他编码语言
