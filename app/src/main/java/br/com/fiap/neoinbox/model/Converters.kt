package br.com.fiap.neoinbox.model

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromTipoPasta(value: TipoPasta): String {
        return value.name
    }

    @TypeConverter
    fun toTipoPasta(value: String): TipoPasta {
        return TipoPasta.valueOf(value)
    }
}