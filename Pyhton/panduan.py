class Person:
    def __init__(self):
        self.run()

    def run(self):
        n=int(input("请输入1-100之间的数字： "))
        if 1<=n<=100:
            print("你妹好漂亮^_^")
        else:
            print("你大爷好丑T_T")

if __name__=='__main__':
    P=Person()
