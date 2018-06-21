package com.yildizsoft.fatih.br

class MusicSaver {
    private var directoryName = "musics_app"
    private var fileName = "music.mp3"
    private var external: Boolean = false

    fun setFileName(fileName: String): MusicSaver {
        this.fileName = fileName
        return this
    }

    fun setExternal(external: Boolean): MusicSaver {
        this.external = external
        return this
    }

    fun setDirectoryName(directoryName: String): MusicSaver {
        this.directoryName = directoryName
        return this
    }
}