#��Ŀ����һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�С���ӳ����������£���ÿ��������һ�����ӣ�
#    �������Ӷ���������ÿ���µ���������Ϊ���٣� 
# ʵ�ʣ�1,1,2,3,5,8,13,21������
# ʵ����쳲���������
'''
main(){
    long f1,f2;
    int i;
    f1=f2=1;
    for(i=1;i<=20;i++){
        printf("%12ld %12ld",f1,f2);
        printf("\n");
������  f1=f1+f2; 
        f2=f1+f2; 
��}
}
'''
#forѭ��
def feb1(n):
    if n<=0:
        print("error input")
        return 0
    elif n<=2:
        return 1
    f1 = 1
    f2 = 1
    #��Ϊf1��f2�Ѿ��ǵ�һ���£�����i�ķ�Χ�ǣ�1��n-1��
    for i in range(1,n-1):
        re = f1 + f2
        f1,f2 = f2,re
    return re

#�ݹ�
def feb2(n):
    if n<=0:
        print("error input")
        return 0
    elif n<=2:
        return 1
    return feb2(n-1)+feb2(n-2)


number = int(input("������һ�������� "))
result1=feb1(number)
result2=feb2(number)
print ("forѭ�������%d" %result1)
print ("�ݹ�����%d" %result2)
