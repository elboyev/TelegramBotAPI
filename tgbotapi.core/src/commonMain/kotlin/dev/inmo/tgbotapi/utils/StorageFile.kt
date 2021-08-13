package dev.inmo.tgbotapi.utils

import com.benasher44.uuid.uuid4
import io.ktor.utils.io.*
import io.ktor.utils.io.core.ByteReadPacket
import io.ktor.utils.io.core.Input
import kotlinx.serialization.Serializable

/**
 * Information about file for [StorageFile]
 *
 * @param contentType Raw type like "application/json"
 * @param fileName This filename will be used in telegram system as name of file
 */
@Serializable
data class StorageFileInfo(
    val fileName: String
) {
    @Deprecated("This constructor is redundant. Use constructor without mime type")
    constructor(
        contentType: String,
        fileName: String
    ): this(fileName)

    /**
     * This methods is required for random generation of name for keeping warranties about unique file name
     */
    fun generateCustomName() = "${uuid4()}.${fileName.fileExtension}"
}

/**
 * Contains info about file, which potentially can be sent to telegram system.
 *
 * @param storageFileInfo Information about this file
 * @param inputSource Lambda which able to allocate [Input] for uploading/manipulating data
 *
 * @see StorageFileInfo
 * @see asStorageFile
 */
data class StorageFile(
    val storageFileInfo: StorageFileInfo,
    private val inputSource: () -> Input
) {
    val input: Input
        get() = inputSource()
}

@Deprecated("This constructor is redundant. Use constructor without mime type")
@Suppress("NOTHING_TO_INLINE")
inline fun StorageFile(
    fileName: String,
    bytes: ByteArray,
    mimeType: MimeType
) = StorageFile(
    StorageFileInfo(fileName)
) {
    ByteReadPacket(bytes)
}

@Suppress("NOTHING_TO_INLINE")
inline fun StorageFile(
    fileName: String,
    bytes: ByteArray
) = StorageFile(
    StorageFileInfo(fileName)
) {
    ByteReadPacket(bytes)
}

@Suppress("NOTHING_TO_INLINE")
suspend inline fun StorageFile(
    fileName: String,
    byteReadChannel: ByteReadChannel
) = StorageFile(
    StorageFileInfo(fileName),
    byteReadChannel.asInput().let { { it } }
)

@Suppress("NOTHING_TO_INLINE", "unused")
inline fun ByteArray.asStorageFile(
    fileName: String
) = StorageFile(fileName, this)

@Deprecated("This constructor is redundant. Use constructor without mime type")
@Suppress("NOTHING_TO_INLINE", "unused")
inline fun ByteArray.asStorageFile(
    fileName: String,
    mimeType: MimeType
) = asStorageFile(fileName)

@Suppress("NOTHING_TO_INLINE", "unused")
suspend inline fun ByteReadChannel.asStorageFile(
    fileName: String
) = StorageFile(fileName, this)

@Suppress("NOTHING_TO_INLINE", "unused")
suspend inline fun ByteReadChannelAllocator.asStorageFile(
    fileName: String
) = this.invoke().asStorageFile(fileName)
