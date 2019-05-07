class PrintTable(object):
    '''打印九九乘法表'''
    def __init__(self):
        print('开始打印9*9乘法表')
        self.print99()
    def print99(self):
        #for(int i=1; i<10; i++){
        #   for(int j=1; j<=i; j++){
        #       print('%d*'+i+'%d='+j+(i*j)+' ');
        #   }
        #   println();
        #}

        for i in range(1,10):
            for j in range(1,i+1):
                print('%dx%d=%2s ' %(i,j,i*j))
            print('\n')


if __name__=='__main__':
    pt=PrintTable()
