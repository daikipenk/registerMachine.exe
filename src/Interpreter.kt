import java.io.File
import utilityClasses.Instruction
import parsingMethod.Characterizer
import parsingMethod.Parser
import parsingMethod.Tokenizer
import utilityClasses.Token

class Interpreter(val filePath: File) {
    val program: List<Instruction> = listOf()

    fun interpret() : List<Instruction> {
        val characters: Sequence<Char> = Characterizer().convertToChar(filePath.readBytes())
        val tokens: Sequence<Token> = Tokenizer().tokenize(characters)
        return Parser().parse(tokens)
    }
}