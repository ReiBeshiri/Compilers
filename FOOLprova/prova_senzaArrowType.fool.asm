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
push function3
lfp
push 222
pop
push 3000
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
push 223
pop
push 150
push 150
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
push 3
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

function3:
cfp
lra
lfp
push 333
pop
push function2
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
push 222
pop
push 150
push 150
lfp
stm
ltm
ltm
push -2
add
lw
push -3
add
lw
js
add
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
pop
pop
sfp
ltm
lra
js
