package main.kotlin

/**
 * 懒加载
 */
object Singleton {
    // 对象的初始化逻辑
}

/**
 * 懒汉式 线程安全版
 */
class SingletonLazy private constructor() {
    companion object {
        val instance: SingletonLazy by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            SingletonLazy()
        }
    }
}

/**
 * 懒汉式 通过 @Synchronized实现
 */
class SingletonSync private constructor() {
    companion object {
        private var instance: SingletonSync? = null
            get() {
                if (field == null) {
                    field = SingletonSync()
                }
                return field
            }

        @Synchronized
        fun get(): SingletonSync {
            return instance!!
        }
    }
}
/**
 * 通过枚举来实现
 */
enum class SingletonEnum {
    INSTANCE;

    fun doSomething() {
        // ...
    }
}

/**
 * 带参数
 */
class SingletonParam private constructor(val parameter: String) {
    companion object {
        @Volatile
        private var instance: SingletonParam? = null

        fun getInstance(parameter: String) = instance ?: synchronized(this) {
            instance ?: SingletonParam(parameter).also { instance = it }
        }
    }
}
/**
 * 带参数的Singleton Holder
 */
open class SingletonHolder<out T, in A>(private val block: (A) -> T) {
    @Volatile
    private var instance: T? = null

    fun getInstance(param: A): T =
        instance ?: synchronized(this) {
            instance ?: block(param).apply {
                instance = this
            }
        }
}
/**
 * 带参数的Singleton Holder 继承
 */
class SingletonTest private constructor(str: String) {
    companion object : SingletonHolder<SingletonTest, String>(::SingletonTest)
}

