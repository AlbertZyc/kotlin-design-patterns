// 抽象产品族 - 按钮
interface Button {
    fun render(): String
}

// 具体产品族 - 浅色主题按钮
class LightButton : Button {
    override fun render(): String {
        return "Rendered a light-themed button"
    }
}

// 具体产品族 - 深色主题按钮
class DarkButton : Button {
    override fun render(): String {
        return "Rendered a dark-themed button"
    }
}

// 抽象产品族 - 文本框
interface TextBox {
    fun render(): String
}

// 具体产品族 - 浅色主题文本框
class LightTextBox : TextBox {
    override fun render(): String {
        return "Rendered a light-themed text box"
    }
}

// 具体产品族 - 深色主题文本框
class DarkTextBox : TextBox {
    override fun render(): String {
        return "Rendered a dark-themed text box"
    }
}

// 抽象工厂
interface UiComponentFactory {
    fun createButton(): Button
    fun createTextBox(): TextBox
}

// 具体工厂 - 浅色主题工厂
class LightThemeFactory : UiComponentFactory {
    override fun createButton(): Button {
        return LightButton()
    }

    override fun createTextBox(): TextBox {
        return LightTextBox()
    }
}

// 具体工厂 - 深色主题工厂
class DarkThemeFactory : UiComponentFactory {
    override fun createButton(): Button {
        return DarkButton()
    }

    override fun createTextBox(): TextBox {
        return DarkTextBox()
    }
}