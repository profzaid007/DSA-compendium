import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static class Node {
        int id;
        AtomicInteger lockedCount = new AtomicInteger(0);
        boolean isBusy;
        Node parent;
        HashSet<Node> lockedDescNodes;
        ArrayList<Node> childs;

        Node() {
            // this.id = id;
            // this.lockedCount = 0;
            this.isBusy = false;
            this.parent = null;
            this.lockedDescNodes = new HashSet<>();
            this.childs = new ArrayList<>();
        }

        Node(Node parent) {
            // this.id = id;
            // this.lockedCount = 0;
            this.isBusy = false;
            this.parent = parent;
            this.lockedDescNodes = new HashSet<>();
            this.childs = new ArrayList<>();
        }
    }

    private static Map<String, Node> stringToNode = new HashMap<String, Node>();

    private static class Tree {
        private static Set<Node> vis = new HashSet<Node>();

        private static void buildTree(String[] countries, int m) {
            Node root = new Node();
            stringToNode.put(countries[0], root);
            var q = new ArrayDeque<Node>();
            q.offer(root);
            int n = countries.length;
            int idx = 1;
            while (!q.isEmpty() && idx < n) {
                int sz = q.size();
                while (sz-- > 0) {
                    Node front = q.poll();
                    for (int i = 1; i <= m && idx < n; i++) {
                        Node newNode = new Node(front);
                        stringToNode.put(countries[idx++], newNode);
                        q.offer(newNode);
                        front.childs.add(newNode);
                    }
                }
            }
        }

        private static class Semaphore {
            Semaphore() {
            }

            public void wait(Node node) {
                // vis.add(node);
                while (node.lockedCount.get() == 0)
                    ;
                node.lockedCount.decrementAndGet();
            }

            public void signal(Node node) {
                node.lockedCount.incrementAndGet();
            }
        }

        private static Semaphore mutex = new Semaphore();

        public static boolean lockNode(Node node, int id) {
            // System.out.println(Thread.currentThread().getName() + " lock: " + vis.contains(node));
            vis.add(node);
            if (node.lockedCount.get() > 0 || node.lockedDescNodes.size() > 0) {
                vis.remove(node);
                // System.out.println(Thread.currentThread().getName() + " " + (node.lockedCount.get() > 0));
                return false;
            }
            // System.out.println("here");
            // loop through the ancestors to check if any of the ancestor is locked or not ,
            // and if locked return false
            var parent = node.parent;
            while (parent != null) {
                if (parent.lockedCount.get() > 0) {
                    vis.remove(node);
                    return false;
                }
                parent = parent.parent;
            }
            // System.out.println("here");
            if (node.isBusy == false) {
                node.lockedCount.incrementAndGet();
                if (node.lockedCount.get() >= 2) {
                    // System.out.println(Thread.currentThread().getName() + " ii " + System.currentTimeMillis());
                    node.lockedCount.decrementAndGet();
                    System.out.println(Thread.currentThread().getName() + " " + node.lockedCount.get());
                    vis.remove(node);
                    return false;
                }
            }
            // System.out.println(Thread.currentThread().getName() + " i " + System.currentTimeMillis());
            mutex.wait(node);

            // Critical Section starts

            node.isBusy = true;
            parent = node.parent;
            while (parent != null) {
                if (parent.lockedCount.get() > 0 || parent.lockedDescNodes.size() > 0 || vis.contains(parent)) {
                    node.lockedCount.decrementAndGet();
                    parent = node.parent;
                    while (parent != null) {
                        if (parent.lockedDescNodes.contains(node))
                            parent.lockedDescNodes.remove(node);
                        parent = parent.parent;
                    }
                    vis.remove(node);
                    return false;
                }
                parent.lockedDescNodes.add(node);
                parent = parent.parent;
            }
            node.isBusy = false;

            // Critical Sections ends

            mutex.signal(node);

            if (node.lockedCount.get() == 0) {
                node.lockedCount.set(1);;
            }
            node.id = id;
            return true;
        }

        public static boolean unlockNode(Node node, int id) {
            if (node.lockedCount.get() == 0 || node.id != id)
                return false;
            
            
            var parent = node.parent;
            while (parent != null) {
                parent.lockedDescNodes.remove(node);
                parent = parent.parent;
            }
            // node.lockedDescNodes.clear();
            node.lockedCount.set(0);
            node.id = 0;

            vis.remove(node); // before it was at last in the lock method (line 119)
            return true;
        }

        public static boolean upgradeNode(Node node, int id) {
            if (node.lockedCount.get() > 0 || node.lockedDescNodes.size() == 0)
                return false;

            var parent = node.parent;
            while (parent != null) {
                if (parent.lockedCount.get() > 0)
                    return false;
                parent = parent.parent;
            }
            for (var lockedChild : node.lockedDescNodes) {
                if (lockedChild.id != id)
                    return false;
            }
            for (var lockedChild : node.lockedDescNodes) {
                unlockNode(lockedChild, id);
            }
            
            return lockNode(node, id);
        }
    }

    
    static class QueryTask implements Runnable {
        private int query;
        private String node;
        private int id;
        // private String res;

        QueryTask(int query, String node, int id) {
            this.query = query;
            this.node = node;
            this.id = id;
            // this.res = res;
        }

        public void run() {
            // System.out.println(Thread.currentThread().getName());
            boolean ans = false;
            try {
                if (query == 1) {
                    ans = Tree.lockNode(stringToNode.get(node), id);
                } else if (query == 2) {
                    ans = Tree.unlockNode(stringToNode.get(node), id);
                } else {
                    ans = Tree.upgradeNode(stringToNode.get(node), id);
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName() + " : " + ans);
            // System.out.println(Thread.currentThread().getName() + " : " + ans);
        }
    }
    // The main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        Tree.buildTree(arr, m);
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int query = sc.nextInt();
            String node = sc.next();
            // String res = sc.next();
            int id = sc.nextInt();
            
            QueryTask task = new QueryTask(query, node, id);
            Thread th = new Thread(task, "query-" + (i + 1));
            th.start();
        }
        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sc.close();
    }
}