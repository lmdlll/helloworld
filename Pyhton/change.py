# ��Ŀ���˽���ת��Ϊʮ����
 
if __name__ == '__main__':
    n = 0
    p = raw_input('������һ������:\n')
    for i in range(len(p)):
        n = n * 8 + ord(p[i]) - ord('0')
    print ("ת��Ϊʮ���Ƶ�����Ϊ%d " %n)
