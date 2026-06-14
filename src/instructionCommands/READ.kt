package instructionCommands

import Interpreter
import utilityClasses.Addressing
import utilityClasses.Operand

class READ (val machine: Interpreter, val opcode: Operand) : Command {
    val mem = machine.memory

    override fun execute() {
        require(opcode.addressing != Addressing.immediate) {"value is not a register!"}

        when (opcode.addressing) {
            Addressing.direct -> mem.set(opcode.value, machine.inputTape.next()) // .code transforms char into ASCII code
            Addressing.indirect -> mem.set(mem.get(opcode.value), machine.inputTape.next())
        }
    }
}