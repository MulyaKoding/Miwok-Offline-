package org.d3if4034.miwokoffline.work


import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import org.d3if4034.miwokoffline.database.MiwokDatabase
import org.d3if4034.miwokoffline.repository.MiwokRepository
import retrofit2.HttpException

@Suppress("SpellCheckingInspection")
class RefreshDataWork(
    appContext: Context, params: WorkerParameters
) : CoroutineWorker(appContext, params) {

    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }

    override suspend fun doWork(): Result {
        val database = MiwokDatabase.getInstance(applicationContext)
        val repository = MiwokRepository(database)

        return try {
            repository.refreshMiwok()
            Result.success()
        } catch (execption: HttpException) {
            Result.retry()
        }
    }
}