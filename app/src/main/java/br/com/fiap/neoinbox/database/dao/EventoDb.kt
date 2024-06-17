package br.com.fiap.neoinbox.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.neoinbox.model.Evento

@Database(entities = [Evento::class], version = 1)
abstract class EventoDb : RoomDatabase() {

    abstract fun eventoDao(): EventoDao

    companion object {

        private lateinit var instance: EventoDb

        fun getDatabase(context: Context): EventoDb {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        EventoDb::class.java,
                        "evento_db"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}
