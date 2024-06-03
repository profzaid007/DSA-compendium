import threading
from collections import deque
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
    if node.is_locked or node.des_locked > 0:
        return False
    
    path_to_root = deque()
    current = node
    while current:
        if not current.lock.acquire(blocking=False):
            while path_to_root:
                cur = path_to_root.pop()
                cur.lock.release()
            return False
        path_to_root.append(current)
        current = current.parent
    
    try:
        node.is_locked = True
        node.id = id
        path_to_root.pop()

        while path_to_root:
            cur = path_to_root.pop()
            cur.des_locked += 1
            cur.dsc_lock_list.append(node)
            cur.lock.release()
    finally:
        node.lock.release()
    
    return True

def unlock(node, id):
    if not node.is_locked or node.id != id:
        return False

    path_to_root = deque()
    current = node
    while current:
        if not current.lock.acquire(blocking=False):
            while path_to_root:
                path_to_root.pop().lock.release()
            return False
        path_to_root.append(current)
        current = current.parent

    try:
        node.is_locked = False
        node.id = 0

        path_to_root.pop()
        while path_to_root:
            cur = path_to_root.pop()
            cur.des_locked -= 1
            cur.dsc_lock_list.remove(node)
            cur.lock.release()
    finally:
        node.lock.release()

    return True

def upgrade(node, id):
    if node.is_locked or node.des_locked == 0:
        return False

    path_to_root = deque()
    current = node
    while current:
        if not current.lock.acquire(blocking=False):
            while path_to_root:
                path_to_root.pop().lock.release()
            return False
        path_to_root.append(current)
        current = current.parent
    
    try:
        a = node.dsc_lock_list

        if len(a) == 0:
            path_to_root.pop()
            while path_to_root:
                path_to_root.pop().lock.release()
            return False

        for child in a:
            child.lock.acquire()
            try:
                if not child.is_locked or child.id != id:
                    path_to_root.pop()
                    while path_to_root:
                        path_to_root.pop().lock.release()
                    return False
            finally:
                child.lock.release()

        node.des_locked = 0

        for child in a:
            child.lock.acquire()
            try:
                child.is_locked = False
                child.id = 0
                parent = child.parent
                while parent != node:
                    parent.des_locked -= 1
                    parent.dsc_lock_list.remove(child)
                    parent = parent.parent
            finally:
                child.lock.release()

        node.is_locked = True
        node.id = id
        
        path_to_root.pop()
        while path_to_root:
            cur = path_to_root.pop()
            cur.des_locked -= len(a) - 1
            cur.dsc_lock_list = [n for n in cur.dsc_lock_list if n not in a]
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

if __name__ == "__main__":
    main()
