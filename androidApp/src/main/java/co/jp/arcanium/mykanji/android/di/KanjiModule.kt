package co.jp.arcanium.mykanji.android.di

import android.app.Application
import android.content.Context
import co.jp.arcanium.mykanji.database.KanjiDatabase
import co.jp.arcanium.mykanji.feature_revision.domain.use_case.GetKanjiRevisionSet
import co.jp.arcanium.mykanji.kanji.data.local.DatabaseDriverFactory
import co.jp.arcanium.mykanji.kanji.data.local.SqlDelightLocalKanjiDataSource
import co.jp.arcanium.mykanji.kanji.data.preferences.AndroidAppPreferences
import co.jp.arcanium.mykanji.kanji.domain.AppPreferences
import co.jp.arcanium.mykanji.kanji.domain.LocalKanjiDataSource
import co.jp.arcanium.mykanji.kanji.domain.use_case.GetAllKanji
import co.jp.arcanium.mykanji.kanji.domain.use_case.InsertKanji
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object KanjiModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideKanjiDataSourceProvider(driver: SqlDriver): LocalKanjiDataSource {
        return SqlDelightLocalKanjiDataSource(database = KanjiDatabase(driver))
    }

    @Provides
    @Singleton
    fun provideAppPreferences(@ApplicationContext context: Context): AppPreferences {
        return AndroidAppPreferences(context)
    }

    @Provides
    fun provideGetAllKanjiUseCase(localKanjiDataSource: LocalKanjiDataSource): GetAllKanji {
        return GetAllKanji(localKanjiDataSource =localKanjiDataSource)
    }

    @Provides
    fun provideInsertKanjiUseCase(localKanjiDataSource: LocalKanjiDataSource): InsertKanji {
        return InsertKanji(localKanjiDataSource =localKanjiDataSource)
    }

    @Provides
    fun provideGetKanjiRevisionSetUseCase(
        localKanjiDataSource: LocalKanjiDataSource,
        appPreferences: AppPreferences
    ): GetKanjiRevisionSet {
        return GetKanjiRevisionSet(
            localKanjiDataSource = localKanjiDataSource,
            preferences = appPreferences
        )
    }
}