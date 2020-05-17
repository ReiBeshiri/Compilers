push 0
lfp
push 333
pop
push function0
lfp
push 333
pop
push function1
lfp
push 223
pop
push 37
lfp
push 112
pop
push -4
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
push -2
add
lw
lfp
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
push 223
pop
push 27
push 17
lfp
stm
ltm
ltm
push 1
add
lw
lfp
push 0
add
lw
js
lfp
push 111
pop
push 3
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
push 111
pop
push 1
add
lw
lfp
push 111
pop
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
