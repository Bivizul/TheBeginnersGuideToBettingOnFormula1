package com.bivizul.thebeginnersguidetobettingonformula1.util

sealed class Resserv<T>(
    val data: T? = null,
    val message: String? = null,
) {
    class LoadingR<T> : Resserv<T>()
    class SuccessR<T>(data: T?) : Resserv<T>(data = data)
    class ErrorR<T>(message: String?) : Resserv<T>(message = message)
}
