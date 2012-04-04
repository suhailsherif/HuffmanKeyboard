import sys

def bfs(i):
 queue=[i]
 ret = ""
 while len(queue) > 0:
  if queue[0] in child.keys():
   queue.append(child[queue[0]][0])
   queue.append(child[queue[0]][1])
  else:
   ret=ret+queue[0]
  queue.remove(queue[0])
 return ret

array = []
for i in range(0, 29):
 a, b = sys.stdin.readline().split()
 if a == "space":
  a=" "
 array.append((float(b), a))
array.sort()
i=0
child = dict()
while len(array) > 1 :
 a, b = array[0], array[1]
 array.remove(a)
 array.remove(b)
 array.append((a[0]+b[0], i))
 child[i]=(a[1], b[1])
 print "Parent of", a[1], b[1], "is", i
 i=i+1
 array.sort()
print "int mLeftChild[] = {",
for j in range(0, i):
 if 30 < child[j][0]:
  print ord(child[j][0]), ",",
 else:
  print child[j][0], ",",
print "};"
print "int mRightChild[] = {",
for j in range(0, i):
 if 30 < child[j][1]:
  print ord(child[j][1]), ",",
 else:
  print child[j][1], ",",
print "};"
allPossibs = dict()
for j in range(0, i):
 allPossibs[j] = (bfs(child[j][0]), bfs(child[j][1]))
print "String mLeftPossibles[] = {",
for j in range(0, i):
 print "\""+allPossibs[j][0]+"\",",
print "};"
print "String mRightPossibles[] = {",
for j in range(0, i):
 print "\""+allPossibs[j][1]+"\",",
print "};"
