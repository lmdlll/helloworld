# ���ĸ����֣�1��2��3��4������ɶ��ٸ�������ͬ�����ظ����ֵ���λ�������Ƕ��٣�
# 4*4*4
# �����������ڰ�λ��ʮλ����λ�����ֶ���1��2��3��4��������е����к���ȥ �����������������С�
class Print(object):
    def __init__(self):
        print('��ʼ��ӡ9*9�˷���')
        self.Count()
    
    def Count(self):
        count = 0
        #��λ
        for i in range(1,5):
            #ʮλ
            for j in range(1,5):
                #��λ
                for k in range(1,5):
                    count+=1
                    print(i,j,k)

        print(count)

if __name__=='__main__':
    pt=Print()
