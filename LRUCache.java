//GFG https://practice.geeksforgeeks.org/problems/lru-cache/
class LRUCache
{
    static HashMap<Integer,DLL> map = new HashMap<>();
    static class DLL{
        int key,value;
        DLL next;
        DLL pre;
        DLL(int key,int value,DLL next,DLL pre)
        {
            this.key=key;
            this.value=value;
            this.next=next;
            this.pre=pre;
        }
    }
    static int capacity,size=0;
    static DLL head= new DLL(0,0,null,null);
    static DLL tail= new DLL(0,0,null,null);

    public void initializeLinkedList() {
        head.next = tail;
        tail.pre = head;
        this.size=0;
        this.map.clear();
    }
    LRUCache(int cap)
    {
        this.capacity=cap;
        initializeLinkedList();
    }

    //Function to return value corresponding to the key.
    public static int get(int key)
    {
        if(map.containsKey(key)==false)return -1;
        else
        {
            DLL refNode= map.get(key);
            //removeing the refNode
            refNode.pre.next=refNode.next;
            refNode.next.pre=refNode.pre;

            //placing it to the next of head
            refNode.pre=head;refNode.next=head.next;
            head.next.pre=refNode;head.next=refNode;

            return refNode.value;
        }
        
    }

    //Function for storing key-value pair.
    public static void set(int key, int value)
    {
        if(map.containsKey(key))
        {
            DLL refNode=map.get(key);
            refNode.pre.next=refNode.next;
            refNode.next.pre=refNode.pre;
            map.remove(key);
            size--;
        }
        else if(size>=capacity)
        {
            DLL refNode= tail.pre;
            //removing the last node;
            map.remove(refNode.key);
            tail.pre=refNode.pre;
            refNode.pre.next=tail;
            size--;
        }
        DLL newNode= new DLL(key,value,head.next,head);
        head.next.pre=newNode;head.next=newNode;
        map.put(key,newNode);
        size++;
    }
}