package org.buffer.android.core.di

import android.app.Application
import android.app.NotificationManager
import android.content.Context
import android.view.accessibility.AccessibilityManager
import com.google.gson.Gson
import dagger.BindsInstance
import dagger.Component
import org.buffer.android.cache.PublishDatabase
import org.buffer.android.cache.db.mapper.profile.TeamMemberEntityMapper
import org.buffer.android.remote_base.instagram.InstagramService
import org.buffer.android.remote_base.twitter.TwitterService
import org.buffer.android.core.di.module.ApiModule
import org.buffer.android.core.di.module.CacheModule
import org.buffer.android.core.di.module.ContextModule
import org.buffer.android.core.di.module.CoreBaseComponent
import org.buffer.android.core.di.module.DataModule
import org.buffer.android.core.di.module.FinishLaterModule
import org.buffer.android.core.di.module.ProfilesModule
import org.buffer.android.core.di.module.RemoteModule
import org.buffer.android.core.di.module.SettingsModule
import org.buffer.android.core.di.module.SnippetGroupsModule
import org.buffer.android.core.di.module.StoriesModule
import org.buffer.android.core.di.module.UpdatesModule
import org.buffer.android.core.di.module.UserModule
import org.buffer.android.core.di.module.ViewModelModule
import org.buffer.android.core.module.CoreModule
import org.buffer.android.core.util.CrashlyticsUtil
import org.buffer.android.data.PostExecutionThread
import org.buffer.android.data.RxEventBus
import org.buffer.android.data.ThreadExecutor
import org.buffer.android.data.composer.repository.ComposerRepository
import org.buffer.android.data.composer.store.ComposerStore
import org.buffer.android.data.config.source.ConfigRepository
import org.buffer.android.data.config.store.ConfigStore
import org.buffer.android.data.connect.repository.ConnectRepository
import org.buffer.android.data.feeds.FeedsRepository
import org.buffer.android.data.feeds.store.FeedsDataStore
import org.buffer.android.data.finishlater.repository.FinishLaterRepository
import org.buffer.android.data.media.interactor.MediaRepository
import org.buffer.android.data.media.repository.MediaCacheSource
import org.buffer.android.data.media.repository.MediaRemoteSource
import org.buffer.android.data.profiles.repository.ProfilesRepository
import org.buffer.android.data.profiles.store.ProfilesCache
import org.buffer.android.data.profiles.store.ProfilesRemote
import org.buffer.android.data.settings.store.SettingsStore
import org.buffer.android.data.snippets.repository.SnippetGroupsRepository
import org.buffer.android.data.snippets.store.SnippetGroupsStore
import org.buffer.android.data.stories.repository.StoriesRepository
import org.buffer.android.data.updates.interactor.GetUpdateById
import org.buffer.android.data.updates.repository.UpdatesRepository
import org.buffer.android.data.updates.store.UpdatesDataStore
import org.buffer.android.data.user.repository.UserRepository
import org.buffer.android.data.user.store.UserStore
import org.buffer.android.remote.AmazonService
import org.buffer.android.remote.BufferService
import org.buffer.android.remote_base.publish.BufferLegacyService
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [
    CoreModule::class
])
interface CoreComponent : CoreBaseComponent {

    @Component.Builder interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): CoreComponent
    }

    fun context(): Context
    fun threadExecutor(): ThreadExecutor
    fun postExecutionThread(): PostExecutionThread
}