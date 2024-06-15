package br.com.fiap.neoinbox.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.neoinbox.model.Conta

@Database(entities = [Conta::class], version = 1)
abstract class ContaDb : RoomDatabase() {

    abstract fun contaDao(): ContaDao

    companion object {

        private lateinit var instance: ContaDb

        fun getDatabase(context: Context): ContaDb {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        ContaDb::class.java,
                        "conta_db"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}