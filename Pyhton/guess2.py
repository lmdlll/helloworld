import random
print("��������Ϸ2��")
#�����������
sel=random.randint(1,100)
i=0
while i<5:
    flag=input("�����룺")
    guess=int(flag)
    if guess==sel:
        print("�¶���")
        print("û��������Ϸ�˳�")
        break
    #��ʼ��ʹ�õ���else if �����񱨴�ͨ�����飬Python���е�elif
    elif guess>sel:
        print("���ˣ��ٲ�")
    else:
        print("С�ˣ��ٲ�")
    #python��û��i++����
    i+=1
if i==5:
    print("�´�5�Σ���Ϸ����")
