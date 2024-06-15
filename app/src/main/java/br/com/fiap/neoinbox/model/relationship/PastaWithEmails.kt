package br.com.fiap.neoinbox.model.relationship

import androidx.room.Embedded
import androidx.room.Relation
import br.com.fiap.neoinbox.model.Pasta
import br.com.fiap.neoinbox.model.Email

data class PastaWithEmails(
    @Embedded val pasta: Pasta,
    @Relation(
        parentColumn = "cod_pasta",
        entityColumn = "cod_pasta_fk"
    )
    val emails: List<Email>
)
