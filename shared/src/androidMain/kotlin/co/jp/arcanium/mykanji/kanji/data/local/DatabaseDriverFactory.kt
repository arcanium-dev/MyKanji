package co.jp.arcanium.mykanji.kanji.data.local

import android.content.Context
import co.jp.arcanium.mykanji.database.KanjiDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = KanjiDatabase.Schema,
            context = context,
            name = "kanji.db"
        )
    }
}