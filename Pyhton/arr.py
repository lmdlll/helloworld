# ��Ŀ����һ���������������
 
if __name__ == '__main__':
    a = [9,6,5,4,1]
    N = len(a) 
    print a
    for i in range(len(a) / 2):
        #����
        a[i],a[N-1-i]=a[N-1-i],a[i]
    print a
#�򵥣�������Զ����������������
