package br.com.fiap.neoinbox.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.neoinbox.model.Email

@Dao
interface EmailDao {

    @Insert
    fun criarEmail(email: Email): Long

    @Delete
    fun excluirEmail(email: Email): Int

    @Update
    fun editarEmail(email: Email): Int

    @Query("SELECT * FROM tbl_email WHERE cod_email = :codEmail AND cod_conta_fk = :codContaFK")
    fun verEmail(codEmail: Long, codContaFK: Long): Email

    @Query("SELECT * FROM tbl_email WHERE cod_conta_fk = :codContaFK ORDER BY dt_email, hr_email ASC")
    fun verTodosOsEmails(codEmail: Long, codContaFK: Long): List<Email>

    @Query("SELECT * FROM tbl_email WHERE cod_conta_fk = :codContaFK AND cod_pasta_fk = :codPastaFK ORDER BY dt_email, hr_email ASC")
    fun verPasta(codEmail: Long, codContaFK: Long, codPastaFK: Long): List<Email>

//    fun verRascunhos(codEmail: Long, codContaFK: Long): List<Email>
//    fun verEnviados(codEmail: Long, codContaFK: Long): List<Email>
//    fun verFavoritos(codEmail: Long, codContaFK: Long): List<Email>
//    fun verLixeira(codEmail: Long, codContaFK: Long): List<Email>
//    fun verSpam(codEmail: Long, codContaFK: Long): List<Email>

}