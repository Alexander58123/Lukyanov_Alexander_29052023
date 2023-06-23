package block5

interface AuthCallBack {

    fun authSuccess(): Unit

    fun authFailed(): Unit
}