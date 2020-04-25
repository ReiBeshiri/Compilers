push 0
push 5
push function0
push function1
push function2
lfp
push 5
push 3
lfp
stm
ltm
ltm
push -4
add
lw
js
lfp
push 1
lfp
stm
ltm
ltm
push -5
add
lw
js
add
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
lw
push -2
add
lw
add
stm
sra
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
stm
ltm
ltm
push -3
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

function2:
cfp
lra
push 0
lfp
lfp
push -2
add
lw
lfp
lw
stm
ltm
ltm
push -3
add
lw
js
stm
pop
sra
pop
pop
sfp
ltm
lra
js
