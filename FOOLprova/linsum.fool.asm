push 0
lfp
push function0
lfp
push function2
lfp
push 2
lfp
push -4
add
lw
lfp
push -5
add
lw
js
print
halt

function0:
cfp
lra
lfp
push 7
push 5
lfp
push 2
add
lw
lfp
push 1
add
lw
js
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
push 111
pop
lfp
push 1
add
lw
push 111
pop
lfp
push 2
add
lw
add
push 111
pop
lfp
lw
push 1
add
lw
mult
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
lfp
push function1
lfp
push 111
pop
lfp
push -2
add
lw
lfp
push -3
add
lw
lfp
lw
push -2
add
lw
lfp
lw
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
