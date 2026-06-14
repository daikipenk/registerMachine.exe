package parsingMethod

import instructionCommands.*
import utilityClasses.Addressing
import utilityClasses.Instruction
import utilityClasses.Operand
import utilityClasses.Token
import utilityClasses.TokenType

class Parser {
    fun parse(tokens: Sequence<Token>) : List<Instruction> {
        val program: MutableList<Instruction> = mutableListOf()
        val strings = listing(tokens)

        for (i in strings) {
            val currentCommand: Command

            if (i[1] != "HALT") {
                if (i[2] == null) {
                    throw Exception("Expected OPERAND")
                }
            }

            // Getting COMMAND
            when (i[1]) {
                null -> throw Exception("Expected COMMAND in ${i}")
                "HALT" -> program.add(Instruction(i[0], HALT()))
                "ADD" -> program.add(Instruction(i[0], ADD(getOperand(i[2]))))
                "SUB" -> program.add(Instruction(i[0], SUB(getOperand(i[2]))))
                "DIV" -> program.add(Instruction(i[0], DIV(getOperand(i[2]))))
                "MULT" -> program.add(Instruction(i[0], MULT(getOperand(i[2]))))
                "JGTZ" -> program.add(Instruction(i[0], JGTZ(i[2].toString())))
                "JUMP" -> program.add(Instruction(i[0], JUMP(i[2].toString())))
                "JZERO" -> program.add(Instruction(i[0], JZERO(i[2].toString())))
                "LOAD" -> program.add(Instruction(i[0], LOAD(getOperand(i[2]))))
                "READ" -> program.add(Instruction(i[0], READ(getOperand(i[2]))))
                "STORE" -> program.add(Instruction(i[0], STORE(getOperand(i[2]))))
                "WRITE" -> program.add(Instruction(i[0], WRITE(getOperand(i[2]))))
                else -> throw Exception("Unknown command: '${i[1]}'")
            }
        }
        return program
    }

    private fun getOperand(instruction: String?) : Operand {
        when (instruction?.first()) {
            null -> throw Exception("Expected OPERAND")
            '=' -> return Operand(Addressing.immediate, instruction.drop(1).toInt())
            '*' -> return Operand(Addressing.indirect, instruction.drop(1).toInt())
            else -> return Operand(Addressing.direct, instruction.toInt())
        }
    }

    private fun listing(tokens: Sequence<Token>) : List<Array<String?>> {
        val finalList: MutableList<Array<String?>> = mutableListOf()
        var currentRow: Int = 0
        var tempInstruction: Array<String?> = arrayOfNulls(3)

        for (i in tokens) {
            if (i.row != currentRow) {
                for (j in tempInstruction) {
                    if (j != null) {
                        finalList.add(tempInstruction)
                        tempInstruction = arrayOfNulls(3)
                        break
                    }
                }
                currentRow = i.row
            }

            when (i.type) {
                TokenType.LABEL -> tempInstruction[0] = i.value
                TokenType.COMMAND -> tempInstruction[1] = i.value
                TokenType.OPERAND -> tempInstruction[2] = i.value
            }
        }

        if (tempInstruction.any { it != null }) { // This does the same as the for loop but much compact & checks for the last instruction
            finalList.add(tempInstruction)
        }
        return finalList
    }
}