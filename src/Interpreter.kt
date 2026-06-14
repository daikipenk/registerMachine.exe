import utilityClasses.Input
import utilityClasses.Memory
import utilityClasses.Pointer
import java.io.File
import utilityClasses.Instruction
import parsingMethod.Characterizer

class Interpreter(val filePath: File, input: String) { // Could also be called the machine itself
    val inputTape = Input(input.toCharArray().toList())
    val memory = Memory()
    val pointer = Pointer()
    val program: List<Instruction> = listOf()

    fun interpret() {
        val characters: Sequence<Char> = Characterizer().convertToChar(filePath.readBytes())
        characters.forEach {print(it)}
    }
}