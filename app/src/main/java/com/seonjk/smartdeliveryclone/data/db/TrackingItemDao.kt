package com.seonjk.smartdeliveryclone.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.seonjk.smartdeliveryclone.data.entity.TrackingItem
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackingItemDao {

    @Query("SELECT * FROM TrackingItem")
    fun allTrackingItem(): Flow<List<TrackingItem>>

    @Query("SELECT * FROM TrackingItem")
    suspend fun getAll(): List<TrackingItem>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: TrackingItem)

    @Delete
    suspend fun delete(item: TrackingItem)
}