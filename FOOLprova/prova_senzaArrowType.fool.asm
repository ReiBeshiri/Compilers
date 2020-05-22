push 0
push 800
lfp
push function1
lfp
lfp
push -2
add
lw
lfp
push -3
add
lw
lfp
push -4
add
lw
js
print
halt

function0:
cfp
lra
lfp
push 1
add
lw
lfp
push 2
add
lw
add
lfp
lw
push 1
add
lw
add
stm
sra
pop
pop
pop
sfp
ltm
lra
js

function1:
cfp
lra
lfp
push function0
lfp
push 700
push 500
lfp
push -2
add
lw
lfp
push -3
add
lw
js
stm
pop
pop
sra
pop
pop
sfp
ltm
lra
js
