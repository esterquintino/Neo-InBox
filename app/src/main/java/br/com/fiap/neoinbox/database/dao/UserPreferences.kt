import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("user_prefs")

class UserPreferences(context: Context) {

    private val dataStore = context.dataStore

    companion object {
        val EMAIL_KEY = stringPreferencesKey("user_email")
        val SENHA_KEY = stringPreferencesKey("user_senha")
    }

    val userEmail: Flow<String?> = dataStore.data.map { preferences ->
        preferences[EMAIL_KEY]
    }

    val userSenha: Flow<String?> = dataStore.data.map { preferences ->
        preferences[SENHA_KEY]
    }

    suspend fun saveUser(email: String, senha: String) {
        dataStore.edit { preferences ->
            preferences[EMAIL_KEY] = email
            preferences[SENHA_KEY] = senha
        }
    }

    suspend fun clearUser() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }
}
