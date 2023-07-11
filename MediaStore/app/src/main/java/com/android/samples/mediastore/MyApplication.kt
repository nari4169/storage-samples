package com.android.samples.mediastore

import android.app.Activity
import android.app.Application
import android.content.ContentResolver
import android.content.ContentUris
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import java.util.Date
import java.util.concurrent.TimeUnit

class MyApplication : Application() {

    // Example method that performs a query on the MediaStore.Images table
    fun performImageQuery(activity: Activity) {
        // Check if the user has granted access to the required directory
        val uriPermission = activity.contentResolver.persistedUriPermissions.find {
            it.uri == EXTERNAL_STORAGE_URI
        }

        if (uriPermission == null) {
            // No access granted, request it
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
            activity.startActivityForResult(intent, PERMISSION_REQUEST_CODE)
        } else {
            // Access granted, perform the query
            executeImageQuery(activity.contentResolver, uriPermission.uri)
        }
    }

    // Handle the permission request result
    fun handleActivityResult(activity: Activity, requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PERMISSION_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            // User granted access, persist the permission and perform the query
            val treeUri = data.data
            if (treeUri != null) {
                activity.contentResolver.takePersistableUriPermission(
                    treeUri,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                )
                executeImageQuery(activity.contentResolver, treeUri)
            }
        } else {
            // Permission denied or no data received, handle accordingly (e.g., show a message)
            Toast.makeText(this@MyApplication, getString(R.string.dontPermission), Toast.LENGTH_SHORT).show()
        }
    }

    // Execute the image query
    private fun executeImageQuery(contentResolver: ContentResolver, treeUri: Uri) {
        val images = mutableListOf<MediaStoreImage>()

        // Content URI for querying images in the MediaStore
        val imagesUri: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        // Projection defines the columns you want to retrieve from the query
        val projection = arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.DATE_ADDED,
        )

        // Selection specifies the criteria for the query (optional)
        val selection = "${MediaStore.Images.Media.SIZE} >= ?"
        val selectionArgs = arrayOf("1000") // Example: Images with size >= 100000 bytes

        // Sort order for the query results (optional)
        val sortOrder = "${MediaStore.Images.Media.DATE_ADDED} DESC"

        // Create a document URI from the tree URI
        val documentUri = DocumentsContract.buildDocumentUriUsingTree(treeUri,
            DocumentsContract.getTreeDocumentId(treeUri))

        contentResolver.query(
            MediaStore.Images.Media.INTERNAL_CONTENT_URI,
            projection,
            selection,
            selectionArgs,
            sortOrder
        )?.use { cursor ->
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
            val dateModifiedColumn =
                cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_ADDED)
            val displayNameColumn =
                cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)

            Log.e("TAG", "Found ${cursor.count} images")

            while (cursor.moveToNext()) {

                // Here we'll use the column indexs that we found above.
                val id = cursor.getLong(idColumn)
                val dateModified =
                    Date(TimeUnit.SECONDS.toMillis(cursor.getLong(dateModifiedColumn)))
                val displayName = cursor.getString(displayNameColumn)

                /**
                 * 이것은 가장 까다로운 부분 중 하나입니다.
                 *
                 * 이미지에 액세스하고 있기 때문에(사용하여
                 * [MediaStore.Images.Media.EXTERNAL_CONTENT_URI], 이를 사용하겠습니다.
                 * 기본 URI로 이미지의 ID를 추가합니다.
                 *
                 * 이것은 [MediaStore.Video]로 작업할 때와 완전히 동일한 방법이며
                 * [MediaStore.Audio]도 마찬가지입니다. `Media.EXTERNAL_CONTENT_URI`가 무엇이든
                 * 아이템을 얻기 위한 쿼리가 기본이고, ID는 받을 문서입니다.
                 * 거기에 요청하십시오.
                 */

                val contentUri = ContentUris.withAppendedId(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    id
                )

                val image = MediaStoreImage(id, displayName, dateModified, contentUri)
                images += image

                // For debugging, we'll output the image objects we create to logcat.
                Log.e("TAG", "Added image: $image")
            }
        }
    }

    companion object {
        private const val PERMISSION_REQUEST_CODE = 123
        private val EXTERNAL_STORAGE_URI: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
    }

}