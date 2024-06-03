import threading
from concurrent.futures import ThreadPoolExecutor

class Node:
    def __init__(self, data):
        self.data = data
        self.locked = False
        self.uid = None
        self.lock = threading.Lock()
        self.ancestors = []  # List to track ancestors
        self.descendants = []  # List to track descendants
        self.locked_descendants = set()  # Set to track locked descendants

class Narray:
    def __init__(self, n, child):
        self.lst = []
        self.status = {}
        self.child = child
        self.n = n

def lock(node_name, uid):
    node = solution.status[node_name]

    with node.lock:
        if node.locked or node.locked_descendants:
            return False
        node.locked = True
        node.uid = uid
        update_ancestor_flags(node, True)

    return True

def unlock(node_name, uid):
    node = solution.status[node_name]

    with node.lock:
        if not node.locked or node.uid != uid:
            return False

        # Unlock the node
        node.locked = False
        node.uid = None
        update_ancestor_flags(node, False)

    return True

def upgrade(node_name, uid):
    node = solution.status[node_name]

    with node.lock:
        if node.locked or not node.locked_descendants:
            return False

        if any_locked_descendant_has_same_uid(node, uid):
            unlock_descendants(node)
            node.locked = True
            node.uid = uid
            return True

        return False

def update_ancestor_flags(node, lock_flag):
    for ancestor in node.ancestors:
        with ancestor.lock:
            if lock_flag:
                ancestor.locked_descendants.add(node)
            else:
                ancestor.locked_descendants.discard(node)

def any_locked_descendant_has_same_uid(node, uid):
    return any(desc.locked and desc.uid == uid for desc in node.locked_descendants)

def unlock_descendants(node):
    for desc in node.locked_descendants:
        with desc.lock:
            desc.locked = False
            desc.uid = None
    node.locked_descendants.clear()

# Main execution
n = int(input())
cn = int(input())
apis = int(input())
solution = Narray(n, cn)

for i in range(n):
    place = input().strip()
    node = Node(place)
    solution.status[place] = node
    solution.lst.append(node)

# Establish ancestor and descendant relationships
for i in range(n):
    node = solution.lst[i]
    parent_index = (i - 1) // cn if i > 0 else None
    if parent_index is not None:
        parent = solution.lst[parent_index]
        parent.descendants.append(node)
        node.ancestors.append(parent)
        node.ancestors.extend(parent.ancestors)

queries = []
for _ in range(apis):
    op, place, uid = map(str, input().split())
    op = int(op)
    uid = int(uid)
    queries.append((op, place, uid))

def process_query(query):
    op, place, uid = query
    result = False
    if op == 1:
        result = lock(place, uid)
    elif op == 2:
        result = unlock(place, uid)
    elif op == 3:
        result = upgrade(place, uid)
    thread_name = threading.current_thread().name
    return (thread_name, query, result)

with ThreadPoolExecutor() as executor:
    futures = [executor.submit(process_query, query) for query in queries]
    res = [future.result() for future in futures]

for thread_name, query, result in res:
    print(f"Thread {thread_name}, Query {query}, Result {result}")