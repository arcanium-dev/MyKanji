package co.jp.arcanium.mykanji.android.revision.di

import co.jp.arcanium.mykanji.feature_revision.domain.use_case.GetKanjiRevisionSet
import co.jp.arcanium.mykanji.kanji.domain.AppPreferences
import co.jp.arcanium.mykanji.kanji.domain.LocalKanjiDataSource
import co.jp.arcanium.mykanji.kanji.domain.use_case.GetAllKanji
import co.jp.arcanium.mykanji.kanji.domain.use_case.InsertKanji
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RevisionModule {

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

    @Provides
    fun provideGetAllKanjiUseCase(localKanjiDataSource: LocalKanjiDataSource): GetAllKanji {
        return GetAllKanji(localKanjiDataSource =localKanjiDataSource)
    }

    @Provides
    fun provideInsertKanjiUseCase(localKanjiDataSource: LocalKanjiDataSource): InsertKanji {
        return InsertKanji(localKanjiDataSource =localKanjiDataSource)
    }
}