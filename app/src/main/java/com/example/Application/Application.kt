package block5

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import java.lang.Exception

@RequiresApi(Build.VERSION_CODES.O)
fun main() {

    val user1 = User(1, "Alexander", 33, Type.FULL)

    println(user1.startTime)
    Thread.sleep(1000)
    println(user1.startTime)


    val spisok : MutableList<User> = mutableListOf(user1)

    // здесь чтобы добавить через apply должен
    // конструктор с дефолтными полями быть

    spisok.add(User().apply {
        id = 2
        name = "Ekaterina"
        age = 37
        type = Type.FULL })

    spisok.add(User().apply {
        id = 3
        name = "Mariya"
        age = 3
        type = Type.DEMO })

    spisok.add(User().apply {
        id = 4
        name = "Andrey"
        age = 52
        type = Type.FULL })

    spisok.add(User().apply {
        id = 5
        name = "Darya"
        age = 1
        type = Type.DEMO })

    // выводим наш список User
    for (elem in spisok) {
        println(elem.name)
    }

    // список по type = FULL
    println()
    var spisokWithFull : List<User> = spisok.filter { it.type == Type.FULL }
    for (fullTypeElement in spisokWithFull) {
        println(fullTypeElement.name)
    }

    // преобразование в список имен
    println()
    var spisokName = spisok.map { it.name } // возвращаем имя каждого пользователя
    println(spisokName.first())
    println(spisokName.last())

    // проверка функции-расширения (проверка возраста)
    try {
        spisok.get(2).starsheOrNot()
    } catch (e: Exception) {
        println("Ошибка обработана")
    }



    // inline функция, которая принимает updateCash
    // и проверка на возраст, будет авторизовывать пользователя по возрасту
    println("---------------------")
    spisok.get(2).auth({ updateCash() })


    // изолированный класс и наследники (пункт 12, 13)
    doAction(action = Action.Registration())
    doAction(action = Action.Login(spisok.get(1)))

}


// реализация анонимного объекта
var anonimObjectAvtorizaciya = object : AuthCallBack {

    override fun authSuccess() {
        println("Авторизация успешна!")
    }

    override fun authFailed() {
        println("Авторизация неудачна. Попробуйте еще раз!")
    }

}


// функция расширения класса (проверка возраста)
fun User.starsheOrNot() {
    if (this.age > 18) {
        println("Пользователю больше 18 лет")
    } else {
        throw Exception()
    }
}

// функция обновления кеша
fun updateCash() {
    println("Кеш обновлен")
}















