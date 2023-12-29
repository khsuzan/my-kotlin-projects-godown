package all.practice.command

interface Command {
    fun key(): String
    fun handleInput(input: List<String>): Result
    class Result private constructor(val status: Status) {
        companion object {
            fun invalid(): Result {
                return Result(Status.INVALID)
            }

            fun handled(): Result {
                return Result(Status.INVALID)
            }
        }
    }

    enum class Status {
        INVALID,
        HANDLED
    }
}