package amazon;
import java.io.BufferedInputStream;
import java.util.*;

public class GoodRanger {

    static TreeMap<Long,Character> map=new TreeMap<Long,Character>();

    static class node{
        long b;
        long a;
        long c;
        public node(long b,long a,long c){
            this.b=b;
            this.a=a;
            this.c=c;
        }
    }
    static Map<String,node> set=new HashMap<String,node>();

    static long sum=0;

    public static node[] getAffected(long query){

        node[] affected=new node[2];
        Long b=map.ceilingKey(query);
        Long a;
        if(b==null)
            a=map.floorKey(query);
        else
            a=map.floorKey(b-1);
        if(b==null && a!=null){
            Long temp=map.floorKey(a-1);
            if(temp==null)
                 temp=0L;

            affected[0]=new node(temp+1,a,N);
        }else if(a==null && b!=null){
           // System.out.println("b"+b);
            // 4

            Long temp=map.ceilingKey(b+1);
            if(temp==null){
                temp=N+1;
            }
            affected[0]=new node(1,b,temp-1);
        }else{
            //c a d b g
            Long c=map.floorKey(a-1);
            if(c==null)
                c=0L;
            Long g=map.ceilingKey(b+1);
            if(g==null)
                g=N+1;
            affected[0]=new node(c+1,a,b-1);
            affected[1]=new node(a+1,b,g-1);
        }
        return affected;
     }
    public static long getAnswer(long query){

        if(set.values().size()==0) {
            node n=   new node(1, query, N);
            set.put(n.toString(), n);
            map.put(query,'Y');
            sum=1+N;
            return 1 + N;
        }

        Map<String,node> nMAP=new HashMap<>();
        node[] affected=getAffected(query);

        for(node ent:affected){
            if(ent!=null){
                if(query>=ent.b && query<=ent.c) {

                    node n1;
                    node n2;
                    if (ent.a < query) {
                        n1 = new node(ent.b, ent.a, query - 1);

                        n2 = new node(ent.a + 1, query, ent.c);

                    } else {
                        n1 = new node(ent.b, query, ent.a - 1);

                        n2 = new node(query + 1, ent.a, ent.c);

                    }
                    if(nMAP.get(n1)==null)
                        nMAP.put(n1.toString(),n1);
                    if(nMAP.get(n2)==null)
                        nMAP.put(n2.toString(),n2);

                }
            }
        }

        for(node n:affected) {
            if(n!=null) {
                sum = sum - n.b - n.c;
                set.remove(n.toString());
            }
        }
        map.put(query,'Y');
        for(node n:nMAP.values()) {
            sum=sum+n.b+n.c;
            set.put(n.toString(), n);
        }
        return sum;
    }

    static long N=0;
    public static void main(String args[]){

        try(Scanner sc=new Scanner(new BufferedInputStream(System.in))){

            N=sc.nextLong();
            long query=sc.nextLong();

            StringBuffer buffer=new StringBuffer();

            while(query-- > 0){
                long d=sc.nextLong();
                long answer=getAnswer(d);
                buffer.append(answer+"\n");
            }
            System.out.println(buffer.toString());

        }
    }




}