import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;
public class Main{
    static class Node{
        String str;
        boolean isLocked;
        int id;
        Node parent;
        int des_locked;
        ArrayList<Node> child = new ArrayList<>();
        ReentrantLock lock = new ReentrantLock();
        ArrayList<Node> dsc_lockList = new ArrayList<>();
        Node(String s){
            this.str = s;
        }
    }
    
    static boolean lock(Node node, int id) {
        
        if (node.isLocked || node.des_locked > 0) {
            return false;
        }
        Deque<Node> pathToRoot = new ArrayDeque<>();
        Node current = node;
        while (current != null) {
            if (!current.lock.tryLock()) {
                
                while (!pathToRoot.isEmpty()) {
                    Node cur = pathToRoot.removeLast();
                    cur.lock.unlock();
                }
                return false;
            }
            pathToRoot.push(current);
            current = current.parent;
        }
    
        try {
            node.isLocked = true;
            node.id = id;
            pathToRoot.removeLast();
           

            while (!pathToRoot.isEmpty()) {
                Node cur = pathToRoot.pop();
                cur.des_locked += 1;
                cur.dsc_lockList.add(node);
                cur.lock.unlock();
            }
        } finally {
           
            node.lock.unlock();
        }
    
        return true;
    }
    
   
    static boolean unlock(Node node, int id) {
        if (!node.isLocked || node.id != id) {
            return false;
        }

        Deque<Node> pathToRoot = new ArrayDeque<>();
        Node current = node;
        while (current != null) {
            if (!current.lock.tryLock()) {
               
                while (!pathToRoot.isEmpty()) {
                    pathToRoot.pop().lock.unlock();
                }
                return false;
            }
            pathToRoot.push(current);
            current = current.parent;
        }

        try {
            node.isLocked = false;
            node.id = 0;
           
            pathToRoot.removeLast();
            while (!pathToRoot.isEmpty()) {
                Node cur = pathToRoot.pop();
                cur.des_locked -= 1;
                cur.dsc_lockList.remove(node);
                cur.lock.unlock();
            }
        } finally {
           
            node.lock.unlock();
        }

        
        return true;
    }

   
    static boolean upgrade(Node node, int id) {
        if (node.isLocked || node.des_locked == 0) {
            return false;
        }

        Deque<Node> pathToRoot = new ArrayDeque<>();
        Node current = node;
        while (current != null) {
            if (!current.lock.tryLock()) {
               
                while (!pathToRoot.isEmpty()) {
                    pathToRoot.pop().lock.unlock();
                }
                return false;
            }
            pathToRoot.push(current);
            current = current.parent;
        }
        
        try {
            ArrayList<Node> a = node.dsc_lockList;
            
            if (a.size() == 0) {
                
                pathToRoot.removeLast();
                while (!pathToRoot.isEmpty()) {
                    pathToRoot.pop().lock.unlock();
                }
                return false;
            }
            for (Node child : a) {
                child.lock.lock();
                try {
                    if (!child.isLocked || child.id != id) {
                        
                        pathToRoot.removeLast();
                        while (!pathToRoot.isEmpty()) {
                            pathToRoot.pop().lock.unlock();
                        }
                        return false;
                    }
                } finally {
                    child.lock.unlock();
                }
            }    
            node.des_locked = 0;
            
            for (Node child : a) {
                child.lock.lock();
                try {
                    child.isLocked = false;
                    child.id = 0;
                    Node parent = child.parent;
                    while (parent != node) {
                        parent.des_locked -= 1;
                        parent.dsc_lockList.remove(child);
                        parent = parent.parent;
                    }
                } finally {
                    child.lock.unlock();
                }
            }

            node.isLocked = true;
            node.id = id;
            
            pathToRoot.removeLast(); 
            while (!pathToRoot.isEmpty()) {
                Node cur = pathToRoot.pop();
                cur.des_locked -= a.size() - 1;
                cur.dsc_lockList.removeAll(a);
                cur.dsc_lockList.add(node);
                cur.lock.unlock();
            }
        } finally {

            node.lock.unlock();
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int q = scn.nextInt();

        HashMap<String, Node> hash = new HashMap<>();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.next();
        }

        Node root = new Node(arr[0]);
        hash.put(arr[0], root);

        Queue<Node> que = new LinkedList<>();
        que.add(root);

        int index = 1;
        while (que.size() > 0 && index < n) {
            int size = que.size();
            while (size-- > 0) {
                Node rem = que.remove();
                for (int i = 1; i <= k && index < n; i++) {
                    Node newNode = new Node(arr[index]);
                    newNode.parent = rem;
                    hash.put(arr[index], newNode);
                    rem.child.add(newNode);
                    que.add(newNode);
                    index += 1;
                }
            }
        }


        class QueryTask implements Runnable {
            private int val;
            private String str;
            private int id;

            public QueryTask(int val, String str, int id) {
                this.val = val;
                this.str = str;
                this.id = id;
            }

            public void run() {
                boolean ans = false;
                if (val == 1) {
                    ans = lock(hash.get(str), id);
                } else if (val == 2) {
                    ans = unlock(hash.get(str), id);
                } else if (val == 3) {
                    ans = upgrade(hash.get(str), id);
                }
                System.out.println(ans);

            }
        }


        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int val = scn.nextInt();
            String str = scn.next();
            int id = scn.nextInt();

            QueryTask task = new QueryTask(val, str, id);
            Thread thread = new Thread(task, "Query: "+val+" "+str+" "+id);
            threads.add(thread);
        }


        for (Thread thread : threads) {
            try {
                thread.start();
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scn.close();
    }
    
}
    


