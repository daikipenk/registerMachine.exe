package instructionCommands

import Machine
import utilityClasses.Addressing
import utilityClasses.Operand

class DIV (val machine: Machine, val opcode: Operand) : Command {
    val register = machine.memory.register

    override fun execute() {
        when (opcode.addressing) {
            Addressing.immediate -> register[0] /= opcode.value
            Addressing.direct -> register[0] /= register[opcode.value]
            Addressing.indirect -> register[0] /= register[register[opcode.value]]
        }
    }
}