package utilityClasses

data class Pointer(private var value: Int = 0) {
    fun set (newValue: Int) {
        require(value >= 0) {"Pointer must point to a positive/valid value"}
        value = newValue
    }

    fun getValue() : Int {
        return value
    }
}
