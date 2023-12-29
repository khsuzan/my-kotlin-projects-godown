package all.practice

import all.practice.command.Command
import all.practice.di.DaggerCommandRouterFactory
import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    val commandRouterFactory = DaggerCommandRouterFactory.create()

    val commandRouter = commandRouterFactory.router()

    while (scanner.hasNextLine()) {
        val unused: Command.Result = commandRouter.route(scanner.nextLine())
    }
}