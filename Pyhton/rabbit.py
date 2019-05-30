#题目：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月，后每个月又生一对兔子，
#    假如兔子都不死，问每个月的兔子总数为多少？ 
# 实际：1,1,2,3,5,8,13,21………
# 实际是斐波那契数列
'''
main(){
    long f1,f2;
    int i;
    f1=f2=1;
    for(i=1;i<=20;i++){
        printf("%12ld %12ld",f1,f2);
        printf("\n");
　　　  f1=f1+f2; 
        f2=f1+f2; 
　}
}
'''
#for循环
def feb1(n):
    if n<=0:
        print("error input")
        return 0
    elif n<=2:
        return 1
    f1 = 1
    f2 = 1
    #因为f1与f2已经是第一二月，所以i的范围是（1，n-1）
    for i in range(1,n-1):
        re = f1 + f2
        f1,f2 = f2,re
    return re

#递归
def feb2(n):
    if n<=0:
        print("error input")
        return 0
    elif n<=2:
        return 1
    return feb2(n-1)+feb2(n-2)


number = int(input("请输入一个整数： "))
result1=feb1(number)
result2=feb2(number)
print ("for循环结果：%d" %result1)
print ("递归结果：%d" %result2)
