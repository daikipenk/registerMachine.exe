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
            for (i in chars) {
                when(i) {
                    ' ' -> {
                        if (currentToken.isNotEmpty() && !hasCommand) {
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
                    '\n' -> {
                        if (currentToken.isNotEmpty() && !hasCommand) {
                            yield(Token(TokenType.COMMAND, currentToken.toString(), row, column))
                        }
                        else if(currentToken.isNotEmpty()) {
                            yield(Token(TokenType.OPERAND, currentToken.toString(), row, column))
                        }

                        row++
                        column = 0
                        currentToken.clear()
                        hasCommand = false
                    }
                    else -> currentToken.append(i)
                }
            }
        }
    }
}