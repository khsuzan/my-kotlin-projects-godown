package all.practice.command

import javax.inject.Inject

class CommandRouter @Inject constructor(
    helloWorldCommand: HelloWorldCommand
) {

    private val commands: MutableMap<String, Command> = mutableMapOf<String, Command>()

    init {
        commands[helloWorldCommand.key()] = helloWorldCommand
    }

    fun route(input: String): Command.Result {
        val splitInput = split(input).ifEmpty { return invalidCommand(input) }
        val commandKey = splitInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)
        val args = splitInput.subList(1, splitInput.size)
        val result = command.handleInput(args)
        return if (result.status == Command.Status.INVALID) {
            invalidCommand(input)
        } else {
            result
        }
    }

    private fun invalidCommand(input: String): Command.Result {
        println(
            String.format(
                "couldn't understand \"%s\". please try again.",
                input
            )
        )
        return Command.Result.invalid()
    }

    companion object {
        private fun split(input: String): List<String> {
            return input.trim().split("\\s+")
        }
    }
}