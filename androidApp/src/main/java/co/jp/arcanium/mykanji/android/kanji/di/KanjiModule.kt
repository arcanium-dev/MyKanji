package co.jp.arcanium.mykanji.android.kanji.di

import android.app.Application
import co.jp.arcanium.mykanji.database.KanjiDatabase
import co.jp.arcanium.mykanji.kanji.data.local.DatabaseDriverFactory
import co.jp.arcanium.mykanji.kanji.data.local.SqlDelightLocalKanjiDataSource
import co.jp.arcanium.mykanji.kanji.domain.LocalKanjiDataSource
import co.jp.arcanium.mykanji.kanji.domain.use_case.GetAllKanji
import co.jp.arcanium.mykanji.kanji.domain.use_case.InsertKanji
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideGetAllKanjiUseCase(localKanjiDataSource: LocalKanjiDataSource): GetAllKanji {
        return GetAllKanji(localKanjiDataSource =localKanjiDataSource)
    }

    @Provides
    fun provideInsertKanjiUseCase(localKanjiDataSource: LocalKanjiDataSource): InsertKanji {
        return InsertKanji(localKanjiDataSource =localKanjiDataSource)
    }
}