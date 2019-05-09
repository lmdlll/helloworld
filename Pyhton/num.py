# 有四个数字：1、2、3、4，能组成多少个互不相同且无重复数字的三位数？各是多少？
# 4*4*4
# 分析：可填在百位、十位、个位的数字都是1、2、3、4。组成所有的排列后再去 掉不满足条件的排列。
class Print(object):
    def __init__(self):
        print('开始打印9*9乘法表')
        self.Count()
    
    def Count(self):
        count = 0
        #百位
        for i in range(1,5):
            #十位
            for j in range(1,5):
                #个位
                for k in range(1,5):
                    count+=1
                    print(i,j,k)

        print(count)

if __name__=='__main__':
    pt=Print()
