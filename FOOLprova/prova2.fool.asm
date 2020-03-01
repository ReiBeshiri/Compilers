push 0
push 0
push 1
push 2
push 3
beq label5
push 0
b label6
label5: 
push 1
label6: 
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
push 44
push 3
sub
label1: 
print
halt
