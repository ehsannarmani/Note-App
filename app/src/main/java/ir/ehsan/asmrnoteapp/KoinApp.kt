package ir.ehsan.asmrnoteapp

import android.app.Application
import androidx.room.Room
import ir.ehsan.asmrnoteapp.database.NoteDatabase
import ir.ehsan.asmrnoteapp.repositories.NoteRepo
import ir.ehsan.asmrnoteapp.repositories.NoteRepoImpl
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module

class KoinApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(module {
                single {
                    Room
                        .databaseBuilder(this@KoinApp, NoteDatabase::class.java, "db")
                        .build()
                }
                single {
                    NoteRepoImpl(database = get())
                } bind NoteRepo::class
            })
        }
    }
}