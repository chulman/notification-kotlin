package com.study.notification.common.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import kotlin.reflect.full.companionObject

/**
 * @author ray
 *
 * @see <a href="https://www.baeldung.com/kotlin-logging"> kotlin logging </a>
 */
class LoggerDelegate<in R : Any> : ReadOnlyProperty<R, Logger> {
    override fun getValue(thisRef: R, property: KProperty<*>) =
        getLogger(
            getClassForLogging(thisRef.javaClass)
        )
}

fun <T : Any> getClassForLogging(javaClass: Class<T>): Class<*> {
    return javaClass.enclosingClass?.takeIf {
        it.kotlin.companionObject?.java == javaClass
    } ?: javaClass
}

fun getLogger(forClass: Class<*>): Logger =
    LoggerFactory.getLogger(forClass)
