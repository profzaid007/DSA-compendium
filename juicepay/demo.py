import threading
from concurrent.futures import ThreadPoolExecutor

class Node:
    def __init__(self, data):
        self.data = data
        self.locked = False
        self.uid = None
        self.lock = threading.Lock()

class Narray:
    def __init__(self, n, child):
        self.lst = []
        self.status = {}
        self.child = child
        self.n = n

def lock(node_name, uid):
    node_index = solution.status[node_name]
    node = solution.lst[node_index]

    with node.lock:
        
        if node.locked:
            return False

        if any(solution.lst[child_index].locked for child_index in get_descendants(node_index)):
            return False
        
        
        node.locked = True
        node.uid = uid
    
    return True

def unlock(node_name, uid):
    node_index = solution.status[node_name]
    node = solution.lst[node_index]

    with node.lock:
        
        if not node.locked or node.uid != uid:
            return False
        
        
        node.locked = False
        node.uid = None
    
    return True

def upgrade(node_name, uid):
    node_index = solution.status[node_name]
    node = solution.lst[node_index]

    with node.lock:
        
        if node.locked or not any(solution.lst[child_index].locked for child_index in get_descendants(node_index)):
            return False
        
        
        for child_index in get_descendants(node_index):
            child_node = solution.lst[child_index]
            if child_node.locked and child_node.uid == uid:
                
                for desc_index in get_descendants(node_index):
                    desc_node = solution.lst[desc_index]
                    if desc_node.locked:
                        desc_node.locked = False
                        desc_node.uid = None
                
                node.locked = True
                node.uid = uid
                return True
        
        return False


def get_descendants(node_index):
    descendants = []
    queue = [node_index]
    m = solution.child

    while queue:
        current = queue.pop(0)
        for child_index in range(current * m + 1, current * m + m + 1):
            if child_index < solution.n:
                descendants.append(child_index)
                queue.append(child_index)
    
    return descendants


n = int(input())
cn = int(input())
apis = int(input())
solution = Narray(n, cn)

for i in range(n):
    place = input()
    node = Node(place)
    solution.status[node.data] = i
    solution.lst.append(node)

queries = []
for _ in range(apis):
    op, place, uid = map(str, input().split())
    op = int(op) 
    import threading

class Node:
    def __init__(self,str):
        self.str = str
        self.is_locked = False
        self.id = 0
        self.parent = None
        self.des_locked = 0
        self.child = []
        self.lock = threading.Lock()
        self.dsc_lock_list = []

def lock(node, id):
    
    if node.is_locked or node.des_locked >0:
        return False
    
    path_to_root = []
    current = node
    while current:
        if not current.lock.acquire(blocking=False):
            for cur in reversed(path_to_root):
                cur.lock.release()
            return False
        path_to_root.append(current)
        current = current.parent
    try:
        node.is_locked = True
        node.id = id
        path_to_root.pop()

        for cur in reversed(path_to_root):
            cur.des_locked +=1
            cur.dsc_lock_list.append(node)
            cur.lock.release()
    finally:
        node.lock.release()
    return True

def unlock(node, id):
    if not node.is_locked or node.id != id:
        return False

    path_to_root =[]
    current = node
    while current:
        if not current.lock.acquire(blocking=False):
            for cur in reversed(path_to_root):
                cur.lock.release()
            return False
        path_to_root.append(current)
        current = current.parent
    try:
        node.is_locked = False
        node.id = 0

        path_to_root.pop()

        for cur in reversed(path_to_root):
            cur.des_locked -=1
            cur.dsc_lock_list.remove(node)
            cur.lock.release()
    finally:
        node.lock.release()
    return True

def upgrade(node, id):
    if node.is_locked or node.des_locked ==0:
        return False

    path_to_root = []

    current = node
    while current:
        if not current.lock.acquire(blocking=False):
            for cur in reversed(path_to_root):
                cur.lock.release()
            return False
        path_to_root.append(current)
        current = current.parent
    
    try:
        arr = node.dsc_lock_list

        if len(arr) ==0:
            path_to_root.pop()
            for cur in reversed(path_to_root):
                cur.lock.release()
            return False        
        
        for child in arr:
            child.lock.acquire()
            try:
                if not child.is_locked or child.id != id:
                    for cur in reversed(path_to_root):
                        cur.lock.release()
                    return False
            finally:
                child.lock.release()
        for child in arr:
            child.lock.acquire()
            try:
                child.is_locked = False
                child.id = 0
                parent = child.parent
                while parent!=node:
                    parent.des_locked -=1
                    parent.dsc_lock_list.remove(child)
                    parent = parent.parent
            finally:
                child.lock.release()
        node.is_locked = True
        node.id = id

        path_to_root.pop()
        while path_to_root:
            cur = path_to_root.pop()
            cur.des_locked -= len(arr)
            for child in a:
                cur.dsc_lock_list.remove(child)
            cur.dsc_lock_list.append(node)
            cur.lock.release()
    finally:
        node.lock.release()
    return True


def main():
    n = int(input())
    k = int(input())
    q = int(input())

    dict_map={}

    entries = [input() for _ in range(n)]
    src = Node(entries[0])
    dict_map[entries[0]] = src
    queue = [src]


    ptr =1

    while queue and ptr < n:
        l = len(queue)
        for _ in range(l):
            buff = queue.pop(0)
            for i in range(1,k+1):
                if ptr >=n:
                    break
                curr = Node(entries[ptr])
                curr.parent = buff
                dict_map[entries[0]] = curr
                buff.child.append(curr)
                queue.append(curr)
                ptr+=1
    def query(val,node,id):
        nonlocal dict_map

        res = False
        if val ==1:
            res = lock(dict_map[node],id)
        elif val ==2:
            res = unlock(dict_map[node],id)
        elif val ==3:
            res = upgrade(dict_map[node],id)
        print(res)

    
    threads = []

    for _ in range(q):
        val, node, id = map(str, input().split())
        id = int(id)
        task = threading.Thread(target=query,args=(val,node,id))
        threads.append(task)
        task.start()
    
    for thread in threads:
        thread.join()

main()

uid = int(uid)
queries.append((op, place, uid))

def process_query(query):
    op, place, uid = query
    if op == 1:
        return lock(place, uid)
    elif op == 2:
        return unlock(place, uid)
    elif op == 3:
        return upgrade(place, uid)

with ThreadPoolExecutor() as executor:
    futures = [executor.submit(process_query, query) for query in queries]
    res = [future.result() for future in futures]

for result in res:
    if result==True:
        print("true")
    else:
        print("false")

