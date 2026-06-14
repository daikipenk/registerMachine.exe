package instructionCommands

import Interpreter
import utilityClasses.Addressing
import utilityClasses.Operand

class SUB (val machine: Interpreter, val opcode: Operand) : Command {
    val mem = machine.memory

    override fun execute() {
        when (opcode.addressing) {
            Addressing.immediate -> mem.set(0, mem.get(0) - opcode.value)
            Addressing.direct -> mem.set(0, mem.get(0) - mem.get(opcode.value))
            Addressing.indirect -> mem.set(0, mem.get(0) - mem.get(mem.get(opcode.value)))
        }
    }
}