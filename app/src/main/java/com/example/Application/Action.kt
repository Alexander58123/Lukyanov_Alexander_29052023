package block5

import android.os.Build
import androidx.annotation.RequiresApi


sealed class Action {
    class Registration() : Action()
    class Login(var user: User) : Action()
    class Logout() : Action()
}


@RequiresApi(Build.VERSION_CODES.O)
fun doAction(action: Action) {

    when(action) {
        is Action.Registration -> println("Идет процесс регистрации")
        is Action.Logout -> println("Вышли из системы")
        is Action.Login -> action.user.auth { ::updateCash }
    }
}
