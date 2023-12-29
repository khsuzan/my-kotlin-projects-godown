package all.practice.di

import all.practice.command.CommandRouter
import dagger.Component

@Component
interface CommandRouterFactory {
    fun router(): CommandRouter
}