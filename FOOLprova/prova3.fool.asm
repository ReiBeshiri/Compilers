push 0
push 0
push function0
push function1
push 0
lfp
lfp
push -7
add
lw
lfp
push -5
add
lw
lfp
push -2
add
lw
lfp
push -5
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
print
halt

function0:
cfp
lra
lfp
push 2
push 1
lfp
stm
ltm
ltm
push 1
add
lw
js
lfp
push 3
add
lw
add
lfp
push 2
push 1
lfp
stm
ltm
ltm
push 4
add
lw
js
add
lfp
push 6
add
lw
add
stm
sra
pop
pop
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
push 1
add
lw
lfp
push 2
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
