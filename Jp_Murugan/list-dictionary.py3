a = ["A","B","C"]
b = [1,3,4]

ans ={}

for k in b:
	for v in a:
		ans[k] = v
		
print(str(ans))