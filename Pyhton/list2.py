# ��Ŀ���������һ������
# ˼·��ʹ�÷���reverse

if __name__ == '__main__':
    #����һ������
    ptr = []
    print type(ptr)
    j=int(input("����������:"))
    print('������%d������' %j)
    for i in range(j):
        num = int(raw_input())
        ptr.append(num)
    print ptr
    ptr.reverse()
    print ptr
