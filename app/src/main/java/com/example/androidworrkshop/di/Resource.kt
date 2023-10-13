package com.example.androidworrkshop.di

data class Resource<out T>(
    val status: Status, val data: T?, val message: String? = null, val error: Exception? = null
) {
    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }
    companion object {
        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }
        fun <T> error(error: Exception? = null, message: String? = null, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, message, error = error)
        }
    }
}
