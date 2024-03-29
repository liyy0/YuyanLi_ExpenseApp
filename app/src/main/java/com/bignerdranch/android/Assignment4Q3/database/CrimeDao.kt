package com.bignerdranch.android.Assignment4Q3.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.bignerdranch.android.Assignment4Q3.Crime
import kotlinx.coroutines.flow.Flow
import java.sql.Date
import java.util.UUID

@Dao
interface CrimeDao {
    @Query("SELECT * FROM crime")
    fun getCrimes(): Flow<List<Crime>>

    @Query("SELECT * FROM crime WHERE id=(:id)")
    suspend fun getCrime(id: UUID): Crime

    //select based on category and date
    @Query("SELECT * FROM crime WHERE category=(:category) AND date=(:date)")
    fun getSearchCrime(category: String, date: Date): Flow<List<Crime>>

    @Update
    suspend fun updateCrime(crime: Crime)

    @Insert
    suspend fun addCrime(crime: Crime)
}
