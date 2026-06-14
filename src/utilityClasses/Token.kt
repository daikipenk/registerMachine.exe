package utilityClasses

data class Token(val type: TokenType, val value: String, val row: Int, val column: Int) {}