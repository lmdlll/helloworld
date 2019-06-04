# -*- coding: utf-8 -*-
class C:
    def __init__(self):
        print("init方法被调用了~")
    #只有当全部引用对象都被删除，才会调用此方法
    def __del__(self):
        print("del调用~")

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
