#һ��ͼ���û������С��Ϸ

import easygui as g
import sys

while True:
    g.msgbox("hi����һ��ͼ���û������С��Ϸ��")

    msg = "��������Ҫ��ʲô��Ϸ�أ�"
    title = "С��Ϸ����"
    chooses=["coding","̸����","������ҫ","������"]
    choice=g.choicebox(msg,title,chooses)

    g.msgbox("����ѡ���ǣ�"+str(choice),"���")

    msg="��ϣ�����¿�ʼС��Ϸ�룿"
    title="��ѡ��"

    if g.ccbox(msg,title):
        pass
    else:
        sys.exit(0)
        
