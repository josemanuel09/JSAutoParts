package edu.ucne.jsautoimports.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import edu.ucne.jsautoimports.data.local.entities.CategoriaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoriaDao {
    @Upsert
    suspend fun save(categoriaEntity: CategoriaEntity)
    @Query("""
        SELECT * FROM Categorias
        WHERE categoriaId = :categoriaId
        LIMIT 1
    """)
    suspend fun getCategoria(categoriaId: Int): CategoriaEntity?
    @Delete
    suspend fun deleteCategoria(categoriaEntity: CategoriaEntity)
    @Query("SELECT * FROM Categorias")
    fun getCategorias(): Flow<List<CategoriaEntity>>
}