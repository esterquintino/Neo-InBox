package br.com.fiap.neoinbox.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.neoinbox.model.Conta
import br.com.fiap.neoinbox.model.Email
import br.com.fiap.neoinbox.model.Evento
import br.com.fiap.neoinbox.model.Pasta

@Database(entities = [Conta::class, Evento::class, Email::class, Pasta::class], version = 2)
abstract class NeoinboxDb : RoomDatabase() {

    abstract fun contaDao(): ContaDao
    abstract fun eventoDao(): EventoDao
    abstract fun emailDao(): EmailDao
    abstract fun pastaDao(): PastaDao

    companion object {

        private lateinit var instance: NeoinboxDb

        fun getDatabase(context: Context): NeoinboxDb {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        NeoinboxDb::class.java,
                        "neoinbox_db"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}