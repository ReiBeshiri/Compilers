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
push 333
pop
push function2
lfp
push 222
pop
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
push 112
pop
push -2
add
lw
lfp
push -3
add
lw
lfp
stm
ltm
ltm
push -6
add
lw
push -7
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
push 441
pop
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
mult
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

function2:
cfp
lra
push 441
pop
lfp
push 223
pop
push 270
push 130
lfp
stm
ltm
ltm
push 1
add
lw
push 777
pop
js
lfp
push 223
pop
push 10
push 10
lfp
stm
ltm
ltm
push 3
add
lw
push 777
pop
js
add
push 442
pop
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
