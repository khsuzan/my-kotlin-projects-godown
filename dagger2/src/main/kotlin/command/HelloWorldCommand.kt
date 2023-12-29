package all.practice.command

import javax.inject.Inject

class HelloWorldCommand @Inject constructor(): Command {

    override fun key(): String {
        return "hello"
    }

    override fun handleInput(input: List<String>): Command.Result {
        if(input.isNotEmpty()){
            return Command.Result.invalid()
        }
        println("world!")
        return Command.Result.handled()
    }
}