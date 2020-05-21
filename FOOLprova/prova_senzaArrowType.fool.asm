push 0
push 800
lfp
push 333
pop
push function1
push 222
pop
lfp
lfp
push 111
pop
push 1111
pop
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
push 441
pop
lfp
push 111
pop
push 1111
pop
push 1
add
lw
lfp
push 111
pop
push 1111
pop
push 2
add
lw
add
lfp
push 111
pop
lw
push 1111
pop
push 1
add
lw
add
push 442
pop
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
push 333
pop
push function0
push 441
pop
push 222
pop
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
push 442
pop
stm
push 888
pop
pop
pop
sra
pop
pop
sfp
ltm
lra
js
