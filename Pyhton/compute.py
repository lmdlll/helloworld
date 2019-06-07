#运算符练习 042
#正常版
class C(int):
    def __add__(self,other):
        #如果不带前面的int强制类型转换，那么调用此方法会无限递归，无法正常计算出数据
        return int(self)+int(other)

    def __sub__(self,other):
        return int(self)-int(other)

#恶作剧
class B(int):
    def __add__(self,other):
        return int.__sub__(self,other)
    def __sub__(self,other):
        return int.__add__(self,other)

#闲的没事,猜想是会变成正确的运算还是无限循环，我猜是正确
    #猜想正确
class A(int):
    def __add__(self,other):
        return int.__add__(self,other)
    def __sub__(self,other):
        return int.__sub__(self,other)

if __name__=='__main__':
    a=C(3)
    b=C(5)
    print(a+b)
    print(a-b)

    a=B(2)
    b=B(4)
    print(a+b)
    print(a-b)

    a=A(4)
    b=A(2)
    print(a+b)
    print(a-b)
