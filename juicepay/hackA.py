class Tree:
    def __init__(self):
        self.il = False
        self.id =0
        self.parent = None
        self.des =0;
        self.child =[]
def lock(node, _id):
    if node.il:
        return False
    if node.des >0:
        return False
    par = node.parent
    while par:
        if par.il:
            return False
        par = par.parent;
    par = node.parent
    # nodepar = par
    # nodechild = False
    while par:
        par.des +=1
        par = par.parent
    node.il = True
    node.id = _id
    return True
def unlock(node,_id):
    if not node.il or node.id != _id:
        return False
    par = node.parent
    while par:
        par.des-=1
        par = par.parent
    node.il = False
    return True
def get_descend(node, a, _id):
    if not node:
        return True
    if node.il:
        if _id != node.id:
            return False
        else:
            a.append(node)
    b =[]
    if node.des ==0:
        return True
    for i in node.child:
        if not get_descend(i,a,_id):
            b.append(0)
            return False
    return True

def upgrade(node,_id):
    if node.il or node.des ==0:
        return False
    a = []

    check = get_descend(node,a,_id)
    if not check:
        return False
    for i in a:
        unlock(i,_id)
    node.il = True;
    node.id = _id
    return True
def checkCorrect(node,val):
    if(node == None):
        return
    elif(node.id<=0):
        return False
    elif(node.id>val):
        return False
    else:
        return True

if __name__ == '__main__':
    n = int(input())
    k = int(input())
    q = int(input())
    dict_map = {}

    entries = [input() for _ in range(n)]
    src = Tree()
    dict_map[entries[0]] = src
    queue = [src]
    ptr =1

    while queue and ptr <n:
        l = len(queue)
        while l>0:
            buff = queue.pop(0)
            for i in range(1,k+1):
                if ptr <n:
                    curr = Tree()
                    curr.parent = buff
                    dict_map[entries[ptr]] = curr
                    buff.child.append(curr)
                    queue.append(curr)
                    ptr+=1
            l -=1
    for _ in range(q):
        op, _node, _id = map(str, input().split())
        _id = int(_id)
        res = False
        if op =='1':
            res = lock(dict_map[_node],_id)
        elif op =='2':
            res = unlock(dict_map[_node],_id)
        elif op =='3':
            res = upgrade(dict_map[_node],_id)
        if res == True:
            print("true")
        else:
            print("false")
        