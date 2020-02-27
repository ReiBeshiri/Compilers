push 0
push 5
push 2
add
push function0
lfp
push 8
lfp
push -2
add
lw
lfp
stm
ltm
ltm
push -3
add
lw
js
push 1
beq label2
push 10
b label3
label2: 
push 5
label3: 
print
halt

function0:
cfp
lra
lfp
push 2
add
lw
lfp
push -2
add
lw
lfp
push 1
add
lw
bleq label0
push 0
b label1
label0: 
push 1
label1: 
stm
pop
sra
pop
pop
pop
sfp
ltm
lra
js
