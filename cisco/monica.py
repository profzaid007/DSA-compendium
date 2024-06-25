def find(n, m, k, array):
    array.sort()
    i =0
    counter =0
    while i <n:
        j=i
        while j< n and (array[j]-array[i]<=m):
            j=j+1
        if j-i >=k:
            counter+=1
            i=j
        else:
            return -1
    return int(counter)

n= int(input())
m= int(input())
k = int(input())
array = list(map(int, input().split()))

result = find(n, m, k, array)
print(result)
