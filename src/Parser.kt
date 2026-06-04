import instructionCommands.Command
import utilityClasses.Instruction
import kotlin.io.println

class Parser (val machine: Machine) {
    fun parseFile(fileContent: List<String>) : List<Instruction> {
        val instructions: MutableList<Instruction> = mutableListOf()

        println(fileContent)

        return instructions
    }
}