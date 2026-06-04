package instructionCommands

import Machine
import utilityClasses.Addressing
import utilityClasses.Operand

class WRITE (val machine: Machine, val opcode: Operand) : Command {
    val register = machine.memory.register

    override fun execute() {
        when (opcode.addressing) {
            Addressing.immediate -> print(opcode.value.toChar())
            Addressing.direct -> print(register[opcode.value].toChar())
            Addressing.indirect -> println(register[register[opcode.value]].toChar())
        }
    }
}