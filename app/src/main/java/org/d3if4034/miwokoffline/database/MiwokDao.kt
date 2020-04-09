@file:Suppress("SpellCheckingInspection")

package org.d3if4034.miwokoffline.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MiwokDao {

    @Query("SELECT * FROM miwok")
    fun getMiwok(): LiveData<List<MiwokDatabaseModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(miwok: List<MiwokDatabaseModel>)

}