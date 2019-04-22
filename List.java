package Node;


interface ListI{
    //增
    boolean AddHead(Object data);
    boolean AddTail(Object data);

    //删
    boolean removeHead();
    boolean removeTail();
    boolean remove(Object obj);

    //查
    int find(Object data);
    Object search(int index);
    boolean Add1(int index,Object data);   //指定下标后添加新结点
    boolean Add2(Object obj,Object data);   //指定数据后面添加新结点
    //改
    Object set(int index, Object data);

    //清空链表
    boolean clear();
    //长度
    int Size();
    //转化为数组
    Object[] toArray();
    //打印
    void Print();

}


class ListImpl implements ListI{

    public class Node{
        private Object data;
        private Node next;
        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Object getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    @Override
    public boolean AddHead(Object data) {
        Node node = new Node(data,null);
        Node hea = this.head;
        if(hea!=null){
            node.next = hea;
        }else {
            this.tail = hea;
        }
        this.head = node;
        this.size++;
        return false;
    }

    @Override
    public boolean AddTail(Object data) {
        Node head = this.head;
        Node end = this.tail;
        Node newnode = new Node(data,null);
        if(head!=null){
            end.next = newnode;
        }
        else {
            this.head = newnode;
        }
        this.tail = newnode;
        size++;
        return true;
    }

    @Override
    public boolean removeHead() {
        Node hea = this.head;
        this.head = hea.next;
        hea.data = null;
        hea.next = null;
        this.size--;
        return true;
    }

    @Override
    public boolean removeTail() {
        Node node = this.head;
        Node tail = this.tail;
        while (node.next != this.tail){
            node = node.next;
        }
        tail.data = null;
        this.tail = node;
        node.next = null;
        this.size--;
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        Node node = this.head;
        if(node.data==obj){
            removeHead();
            return true;
        }
        while (node.next.data != obj){
            node = node.next;
        }
        if(node.next == this.tail){
            removeTail();
            return true;
        }else {
            Node n = node.next;
            node.next = n.next;
            n.next = null;
            n.data = null;
            this.size--;
        }
        return true;
    }

    @Override
    public int find(Object data) {
        Node node = this.head;
        for(int k=0; k<this.size; k++){
            if(data.equals(node.data)){
                //强调：必须是data.equals(node.data)，防止data数据为空出现错误
                return k;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public Object search(int index) {
        if(index>this.size){
            return null;
        }
        Object[] data = toArray();
        return data[index];
    }

    //指定下标后面添加新结点
    @Override
    public boolean Add1(int index, Object data) {
        if(index>this.size){
            return false;
        }
        Object ndata = search(index);
        Add2(ndata,data);
        return true;
    }


    @Override
    public boolean Add2(Object obj, Object data) {
        Node newnode = new Node(data,null);
        Node node = this.head;
        for(;node!=null; node=node.next){
            if(obj.equals(node.data)) {
                if (node == this.tail) {
                    node.next = newnode;
                    this.tail = newnode;
                    this.size++;
                    return true;
                } else {
                    newnode.next = node.next;
                    node.next = newnode;
                    this.size++;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object data) {
        if(index>this.size){
            return false;
        }
        Node node = this.head;
        for(int i=0; i<this.size; i++){
            if(index==i){
                node.data = data;
                return true;
            }
        }
        return null;
    }

    @Override
    public boolean clear() {
        Node node = this.head;
        Node tmp = node;
        while (node.next!=null){
            tmp = node.next;
            node.next = null;
            node.data = null;
            node = tmp;
            this.size--;
        }
        return true;
    }

    @Override
    public int Size() {
        return this.size;
    }

    @Override
    public Object[] toArray() {
        Node headp = this.head;
        Object[] data = new Object[this.size];
        int i=0;
        while (headp!=null){
            data[i] = headp.data;
            i++;
            headp = headp.next;
        }
        return data;
    }

    @Override
    public void Print() {
        Object[] data = this.toArray();
        for (Object i:data) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

}



public class List {
    public static void main(String[] args) {
        ListImpl listo = new ListImpl();
        listo.AddTail(0);
        listo.AddTail(0);
        listo.AddTail(0);
        listo.AddTail(0);
        listo.AddHead(0);
        listo.Print();
//        listo.remove(2);
//        listo.Add1(1,9);
//        listo.Print();
//        listo.removeTail();
//        listo.clear();
//        listo.Print();
    }

}
