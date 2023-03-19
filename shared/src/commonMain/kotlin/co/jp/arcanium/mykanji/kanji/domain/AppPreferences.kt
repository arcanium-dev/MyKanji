package co.jp.arcanium.mykanji.kanji.domain

interface AppPreferences {
    fun getBoolean(key: String): Boolean?
    fun setBoolean(key: String, value: Boolean)
    fun getInt(key: String): Int?
    fun setInt(key: String, value: Int)
    fun getString(key: String): String?
    fun setString(key: String, value: String)
}