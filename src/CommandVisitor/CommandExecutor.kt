package CommandVisitor

import instructionCommands.*
import utilityClasses.Addressing
import utilityClasses.Input
import utilityClasses.Instruction
import utilityClasses.Memory
import utilityClasses.Pointer

class CommandExecutor(val inputTape: Input, val program: List<Instruction>) : CommandVisitor {
    val pointer = Pointer()
    val mem = Memory()
    var haltProgram: Boolean = false

    fun run() {
        while (pointer.getValue() < program.size && !haltProgram) {
            program[pointer.getValue()].command.accept(this)
        }
    }

    override fun visitADD(add: ADD) {
        when (add.opcode.addressing) {
            Addressing.immediate -> mem.set(0, mem.get(0) + add.opcode.value)
            Addressing.direct -> mem.set(0, mem.get(0) + mem.get(add.opcode.value))
            Addressing.indirect -> mem.set(0, mem.get(0) + mem.get(mem.get(add.opcode.value)))
        }
        pointer.set(pointer.getValue() + 1)
    }

    override fun visitSUB(sub: SUB) {
        when (sub.opcode.addressing) {
            Addressing.immediate -> mem.set(0, mem.get(0) - sub.opcode.value)
            Addressing.direct -> mem.set(0, mem.get(0) - mem.get(sub.opcode.value))
            Addressing.indirect -> mem.set(0, mem.get(0) - mem.get(mem.get(sub.opcode.value)))
        }
        pointer.set(pointer.getValue() + 1)
    }

    override fun visitMULT(mult: MULT) {
        when (mult.opcode.addressing) {
            Addressing.immediate -> mem.set(0, mem.get(0) * mult.opcode.value)
            Addressing.direct -> mem.set(0, mem.get(0) * mem.get(mult.opcode.value))
            Addressing.indirect -> mem.set(0, mem.get(0) * mem.get(mem.get(mult.opcode.value)))
        }
        pointer.set(pointer.getValue() + 1)
    }

    override fun visitDIV(div: DIV) {
        when (div.opcode.addressing) {
            Addressing.immediate -> mem.set(0, mem.get(0) / div.opcode.value)
            Addressing.direct -> mem.set(0, mem.get(0) / mem.get(div.opcode.value))
            Addressing.indirect -> mem.set(0, mem.get(0) / mem.get(mem.get(div.opcode.value)))
        }
        pointer.set(pointer.getValue() + 1)
    }

    override fun visitJGTZ(jgtz: JGTZ) {
        if (mem.get(0) > 0) {
            var succeeded: Boolean = false
            for (i in 0..program.size-1) {
                if (program[i].label == jgtz.opcode) {
                    pointer.set(i)
                    succeeded = true
                    break
                }
            }
            if (!succeeded) throw Exception("Label not found!")
        }
        else {pointer.set(pointer.getValue() + 1)}
    }

    override fun visitJUMP(jump: JUMP) {
        var succeeded: Boolean = false
        for (i in 0..program.size-1) {
            if (program[i].label == jump.opcode) {
                pointer.set(i)
                succeeded = true
                break
            }
        }
        if (!succeeded) throw Exception("Label not found!")
    }

    override fun visitJZERO(jzero: JZERO) {
        if (mem.get(0) == 0) {
            var succeeded: Boolean = false
            for (i in 0..program.size-1) {
                if (program[i].label == jzero.opcode) {
                    pointer.set(i)
                    succeeded = true
                    break
                }
            }
            if (!succeeded) throw Exception("Label not found!")
        }
        else {pointer.set(pointer.getValue() + 1)}
    }

    override fun visitLOAD(load: LOAD) {
        when (load.opcode.addressing) {
            Addressing.immediate -> mem.set(0, load.opcode.value)
            Addressing.direct -> mem.set(0, mem.get(load.opcode.value))
            Addressing.indirect -> mem.set(0, mem.get(mem.get(load.opcode.value)))
        }
        pointer.set(pointer.getValue() + 1)
    }

    override fun visitREAD(read: READ) {
        require(read.opcode.addressing != Addressing.immediate) {"value is not a register!"}

        when (read.opcode.addressing) {
            Addressing.direct -> mem.set(read.opcode.value, inputTape.next()) // .code transforms char into ASCII code
            Addressing.indirect -> mem.set(mem.get(read.opcode.value), inputTape.next())
        }
        pointer.set(pointer.getValue() + 1)
    }

    override fun visitSTORE(store: STORE) {
        require(store.opcode.addressing != Addressing.immediate) {"value is not a register!"}

        when (store.opcode.addressing) {
            Addressing.direct -> mem.set(store.opcode.value, mem.get(0))
            Addressing.indirect -> mem.set(mem.get(store.opcode.value), mem.get(0))
        }
        pointer.set(pointer.getValue() + 1)
    }

    override fun visitWRITE(write: WRITE) {
        when (write.opcode.addressing) {
            Addressing.immediate -> print(write.opcode.value.toChar())
            Addressing.direct -> print(mem.get(write.opcode.value).toChar())
            Addressing.indirect -> print(mem.get(mem.get(write.opcode.value)).toChar())
        }
        pointer.set(pointer.getValue() + 1)
    }

    override fun visitHALT(halt: HALT) {
        println()
        haltProgram = true
    }
}