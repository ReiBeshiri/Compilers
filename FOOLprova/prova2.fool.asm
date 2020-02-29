push 0
push 0
push 1
push 0
push 1
beq label2
b label3
label2: 
push 0
b label4
label3: 
push 1
label4: 
push 1
beq label0
push 10
b label1
label0: 
push 45
label1: 
print
halt
