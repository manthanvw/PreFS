def helper(n,s,l):
    if(len(l)>1):
        l.pop((n+s-1)%len(l))
        return helper((n+s-1)% (len(l)+1) ,s,l)
    else: return l[0]
    
def leftOut(n,s):
    return helper(0,s,list(range(1,n+1)))
    
n,s = map(int,input().split())
print(leftOut(n,s))