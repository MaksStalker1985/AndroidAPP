package com.example.melodiesringer

abstract class MusicContent {
    public abstract var SongName: String?
    public abstract var SongPath: String?
    public abstract var SongLength : Int?
    public abstract var SongId: Int?
    public abstract var StartTime: Int?
    public abstract var StopTime: Int?
    public abstract var IsActive : Int?

}

abstract class Values{
    public val spref = "melodies ringer"
    public val spref_name = "status"
    public val TableName = "MusicList"
    public val databaseName = "mringer.db3"
    public val reportName = "mringer.rpt"
    public val databaseVersion = 1
}
abstract class TableCells{
    public val IDCell = "ID"
    public val NameCell = "SongName"
    public val PathCell = "SongPath"
    public val LengthCell = "SongLength"
    public val StartCell = "StartTime"
    public val StopCell = "StopTime"
    public val ActiveCell = "IsCheck"
}