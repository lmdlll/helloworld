class Game:
    def __init__(self):
        print('---------------------�Ұ�python֮������Ϸ--------------')
        self.play()

    def play(self):
        #input��python��һ�����ú���
        temp = input("������һ�����֣�������֮���Ĭ����")
        #temp��һ���ַ������ͣ�ת��Ϊ����
        guess = int(temp)
        if guess==8 :
            print("Ŷ��������")
            #������python����꣬�����Ĵ�����ܻᵼ�´���Ĵ���������c���������ţ�
            print("����û����")
        else:
            print("��������֮��û��Ĭ��")
        print("��Ϸ����")

# BIF==Built-in function

if __name__=='__main__':
    g=Game()

    
