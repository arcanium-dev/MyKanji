package co.jp.arcanium.mykanji.kanji.data.local

import co.jp.arcanium.mykanji.database.KanjiDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(schema = KanjiDatabase.Schema, name = "kanji.db")
    }
}