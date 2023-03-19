package co.jp.arcanium.mykanji.kanji.data.preferences

import android.content.Context
import co.jp.arcanium.mykanji.kanji.domain.AppPreferences
import com.russhwolf.settings.AndroidSettings

class AndroidAppPreferences(context: Context) : AppPreferences {
    private val settings = AndroidSettings.Factory(context).create("app_prefs")

    override fun getBoolean(key: String): Boolean? {
        return settings.getBooleanOrNull(key = key)
    }

    override fun setBoolean(key: String, value: Boolean) {
        settings.putBoolean(key = key, value = value)
    }

    override fun getInt(key: String): Int? {
        return settings.getIntOrNull(key = key)
    }

    override fun setInt(key: String, value: Int) {
        settings.putInt(key = key, value = value)
    }

    override fun getString(key: String): String? {
        return settings.getStringOrNull(key = key)
    }

    override fun setString(key: String, value: String) {
        settings.putString(key = key, value = value)
    }
}