# �б�ʹ��ʵ����

#�½�һ������
List=[10086,'�ƶ�@_@',[0,0,0]]  
#�����б���  
print (len(List))  
#��ӡ�±�Ϊ1�Ժ��
print (List[1:])  
#���б�����Ԫ��  
List.append('�����ƶ��������ð�~!')
print (len(List))
print (List)
List=List[:1]+['hi']+List[1:]
print (List)
#�����б�����һ��Ԫ��  
print List.pop(1)  
print (len(List),List)

