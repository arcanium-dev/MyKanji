package co.jp.arcanium.mykanji.android.core.di

import android.app.Application
import android.content.Context
import co.jp.arcanium.mykanji.database.KanjiDatabase
import co.jp.arcanium.mykanji.kanji.data.local.DatabaseDriverFactory
import co.jp.arcanium.mykanji.kanji.data.local.SqlDelightLocalKanjiDataSource
import co.jp.arcanium.mykanji.kanji.data.preferences.AndroidAppPreferences
import co.jp.arcanium.mykanji.kanji.domain.AppPreferences
import co.jp.arcanium.mykanji.kanji.domain.LocalKanjiDataSource
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MyKanjiModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideLocalKanjiDataSourceProvider(driver: SqlDriver): LocalKanjiDataSource {
        return SqlDelightLocalKanjiDataSource(database = KanjiDatabase(driver))
    }

    @Provides
    @Singleton
    fun provideAppPreferences(@ApplicationContext context: Context): AppPreferences {
        return AndroidAppPreferences(context)
    }

}