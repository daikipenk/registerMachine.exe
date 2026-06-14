package parsingMethod

import utilityClasses.Token
import utilityClasses.TokenType

class Tokenizer {
    var row: Int = 0 // Current Line
    var column: Int = 0 // Current Character

    fun tokenize(chars: Sequence<Char>) : Sequence<Token> {
        return sequence<Token> {
            val currentToken = StringBuilder()
            var hasCommand: Boolean = false
            var ignore: Boolean = false

            for (i in chars) {
                when(i) {
                    '/' -> {ignore = true; column++}
                    ' ' -> {
                        if (ignore) {
                            column++
                            continue
                        }
                        else if (currentToken.isNotEmpty() && !hasCommand) {
                            yield(Token(TokenType.COMMAND, currentToken.toString(), row, column))
                            column++
                            currentToken.clear()
                            hasCommand = true
                        }
                        else if (currentToken.isNotEmpty()) {
                            yield(Token(TokenType.OPERAND, currentToken.toString(), row, column))
                            column++
                            currentToken.clear()
                        }
                        else {column++ }
                    }
                    ':' -> {yield(Token(TokenType.LABEL, currentToken.toString(), row, column))
                        column++
                        currentToken.clear()
                    }
                    '\r' -> { // This is before each new line
                        if (ignore) {
                            column++
                            continue
                        }
                        else if (currentToken.isNotEmpty() && !hasCommand) {
                            yield(Token(TokenType.COMMAND, currentToken.toString(), row, column))
                        }
                        else if(currentToken.isNotEmpty()) {
                            yield(Token(TokenType.OPERAND, currentToken.toString(), row, column))
                        }
                        currentToken.clear()
                    }
                    '\n' -> {
                        row++
                        column = 0
                        currentToken.clear()
                        hasCommand = false
                        ignore = false
                    }
                    else -> currentToken.append(i)
                }
            }
            if (currentToken.isNotEmpty() && !ignore) {
                if (!hasCommand) {
                    yield(Token(TokenType.COMMAND, currentToken.toString(), row, column))
                }
                else {
                    yield(Token(TokenType.OPERAND, currentToken.toString(), row, column))
                }
            }
        }
    }
}