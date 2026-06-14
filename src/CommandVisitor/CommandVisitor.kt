package CommandVisitor

import instructionCommands.*

interface CommandVisitor {
    fun visitADD(add: ADD)
    fun visitDIV(div: DIV)
    fun visitHALT(halt: HALT)
    fun visitJGTZ(jgtz: JGTZ)
    fun visitJUMP(jump: JUMP)
    fun visitJZERO(jzero: JZERO)
    fun visitLOAD(load: LOAD)
    fun visitMULT(mult: MULT)
    fun visitREAD(read: READ)
    fun visitSTORE(store: STORE)
    fun visitSUB(sub: SUB)
    fun visitWRITE(write: WRITE)
}