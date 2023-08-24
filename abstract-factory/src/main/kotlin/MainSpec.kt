// 抽象工厂
abstract class UiComponentFactorySpec {
    abstract fun create(): UiComponentFactory

    companion object {
        inline fun <reified T : UiComponentFactory> createFactory(): UiComponentFactory = when (T::class) {
            LightThemeFactory::class -> LightThemeFactory()
            LightThemeFactory::class -> LightThemeFactory()
            else -> throw IllegalArgumentException()
        }
    }
}