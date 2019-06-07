
#关于构造与析构
class C:
    def __init__(self):
        print("init方法被调用了~")
    #只有当全部引用对象都被删除，才会调用此方法
    def __del__(self):
        print("del调用~")

class B(str):
    def __new__(cls,string):
        print("先使用new方法~")
        string=string.upper()
        return str.__new__(cls,string)

class A:
    def __init__(self):
        print("先使用init方法~")
        
    def __new__(cls):
        print("先使用new方法~")
        return str.__new__(cls)

if __name__=='__main__':
    c1=C
    c1=C()
    #init方法被调用了~
    c2=c1
    c3=c2
    del c1
    del c2
    del c3
    #del调用~
    print()
    #这里有错误~，暂时未改出来
    b1=B("Hello world!")
    print(b1)

    a1=A()
    print(a1)
    #先使用new方法~ 
