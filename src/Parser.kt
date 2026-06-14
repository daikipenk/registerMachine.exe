/*
import instructionCommands.*
import utilityClasses.Addressing
import utilityClasses.Instruction
import utilityClasses.Operand

class Parser (val machine: Machine) {
    fun parseFile(fileContent: List<String>) : List<Instruction> {
        val program: MutableList<Instruction> = mutableListOf()

        for (i in fileContent) {
            val trimmed = i.substringBefore("//").trim().split(" ")
            if (trimmed[0].isBlank()) {continue} // just to prevent an empty line from crashing the machine
            var index: Int = 0

            while (true) {
                when (trimmed[index]) {
                    "LOAD" -> {
                        program.add(Instruction(LOAD(machine, findOpcode(trimmed[index + 1])), label(index, trimmed[0])))
                        break
                    }
                    "STORE" -> {
                        program.add(Instruction(STORE(machine, findOpcode(trimmed[index + 1])), label(index, trimmed[0])))
                        break
                    }
                    "ADD" -> {
                        program.add(Instruction(ADD(machine, findOpcode(trimmed[index + 1])), label(index, trimmed[0])))
                        break
                    }
                    "SUB" -> {
                        program.add(Instruction(SUB(machine, findOpcode(trimmed[index + 1])), label(index, trimmed[0])))
                        break
                    }
                    "MULT" -> {
                        program.add(Instruction(MULT(machine, findOpcode(trimmed[index + 1])), label(index, trimmed[0])))
                        break
                    }
                    "DIV" -> {
                        program.add(Instruction(DIV(machine, findOpcode(trimmed[index + 1])), label(index, trimmed[0])))
                        break
                    }
                    "READ" -> {
                        program.add(Instruction(READ(machine, findOpcode(trimmed[index + 1])), label(index, trimmed[0])))
                        break
                    }
                    "WRITE" -> {
                        program.add(Instruction(WRITE(machine, findOpcode(trimmed[index + 1])), label(index, trimmed[0])))
                        break
                    }
                    "JUMP" -> {
                        program.add(Instruction(JUMP(machine, trimmed[index + 1]), label(index, trimmed[0])))
                        break
                    }
                    "JGTZ" -> {
                        program.add(Instruction(JGTZ(machine, trimmed[index + 1]), label(index, trimmed[0])))
                        break
                    }
                    "JZERO" -> {
                        program.add(Instruction(JZERO(machine, trimmed[index + 1]), label(index, trimmed[0])))
                        break
                    }
                    "HALT" -> {program.add(Instruction(HALT(), label(index, trimmed[0]))); break}
                    else -> index += 1
                }
            }
        }
        return program;
    }

    fun label(index: Int, label: String) : String? {
        if (index != 0) {
            return label.removeSuffix(":")
        }
        else {
            return null
        }
    }

    fun findOpcode(opcode: String) : Operand{
        return when (opcode.first()) {
            '=' -> Operand(Addressing.immediate, opcode.split("=")[1].toInt()) // or I could use drop(1)
            '*' -> Operand(Addressing.indirect, opcode.split("*")[1].toInt())
            else -> Operand(Addressing.direct, opcode.toInt())
        }
    }
}
 */