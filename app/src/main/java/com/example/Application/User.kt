package block5

import android.os.Build
import androidx.annotation.RequiresApi
import java.lang.Exception
import java.time.LocalTime


@RequiresApi(Build.VERSION_CODES.O)
class User(var id: Int = -1, var name: String? = null, var age: Int = -1, var type: Type? = null){
    val startTime : String by lazy { LocalTime.now().toString() }


// inline функция, которая принимает функцию updateCash
// вот здесь не понял как метод коллбека authSuccess сделать
// Сергей, здесь нужна твоя помощь
inline fun auth(mes: () -> Unit) {

    try {
        this.starsheOrNot()
        anonimObjectAvtorizaciya.authSuccess()
        mes()
    } catch (e: Exception) {
        anonimObjectAvtorizaciya.authFailed()
    }


    }

}