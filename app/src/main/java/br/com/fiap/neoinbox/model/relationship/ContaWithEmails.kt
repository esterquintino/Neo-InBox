package br.com.fiap.neoinbox.model.relationship

import androidx.room.Embedded
import androidx.room.Relation
import br.com.fiap.neoinbox.model.Conta
import br.com.fiap.neoinbox.model.Email

data class ContaWithEmails(
    @Embedded val conta: Conta,
    @Relation(
        parentColumn = "cod_conta",
        entityColumn = "cod_conta_fk"
    )
    val emails: List<Email>
)
