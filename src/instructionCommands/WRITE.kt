package instructionCommands

import Interpreter
import utilityClasses.Addressing
import utilityClasses.Operand

class WRITE (val machine: Interpreter, val opcode: Operand) : Command {
    val mem = machine.memory

    override fun execute() {
        when (opcode.addressing) {
            Addressing.immediate -> print(opcode.value.toChar())
            Addressing.direct -> print(mem.get(opcode.value).toChar())
            Addressing.indirect -> print(mem.get(mem.get(opcode.value)).toChar())
        }
    }
}