package co.jp.arcanium.mykanji.kanji.domain

interface AppPreferences {
    fun getBoolean(key: String): Boolean?
    fun setBoolean(key: String, value: Boolean)
}