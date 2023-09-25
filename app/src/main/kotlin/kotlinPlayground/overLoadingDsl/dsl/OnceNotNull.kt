package kotlinPlayground.overLoadingDsl.dsl

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun <T> onceNotNull() = object : ReadWriteProperty<Any?, T> {
    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        if (value == null) {
            throw IllegalStateException("${property.name} is not initialized")
        }
        return value!!
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        if (this.value != null) {
            throw IllegalStateException("${property.name} is already initialized")
        }
        this.value = value
    }
}
