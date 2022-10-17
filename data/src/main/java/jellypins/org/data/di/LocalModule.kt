package jellypins.org.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * packageName    : jellypins.org.data.di
 * fileName       : LocalModule
 * author         : syshinpins
 * date           : 2022/06/06
 * description    : Database 의존성 주입
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-06       syshinpins         최초 생성
 */
@InstallIn(SingletonComponent::class)
@Module
class LocalModule {

}