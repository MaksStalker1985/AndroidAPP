package com.example.melodiesringer
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import androidx.core.os.persistableBundleOf
import java.lang.Exception
import com.example.melodiesringer.Database_Processor as Database_Processor


class Database_Processor : SQLiteOpenHelper(null,"mringer.db3", null,1) {

    private var musContent:MusicContent = TODO()
    private var values_names:Values = TODO()
    private var cells:TableCells = TODO()
    private val music_data = arrayOf<MusicContent>()
    val dbHelper = Database_Processor()

    private val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${values_names.TableName} (" +
                "${cells.IDCell} INTEGER PRIMARY KEY," +
                "${cells.NameCell} TEXT," +
                "${cells.PathCell} TEXT,"+
                "${cells.LengthCell} INTEGER," +
                "${cells.StartCell} INTEGER ," +
                "${cells.StopCell} INTEGER," +
                "${cells.ActiveCell} INTEGER)"

    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${values_names.TableName}"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    public fun writeData(data : MusicContent){
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(cells.NameCell,     data.SongName)
            put(cells.PathCell,     data.SongPath)
            put(cells.LengthCell,   data.SongLength)
            put(cells.StartCell,    data.StartTime)
            put(cells.StopCell,     data.StopTime)
            put(cells.ActiveCell,   data.IsActive)
        }
        db.insert(values_names.TableName, null,values)
    }
    public fun readData():Array<MusicContent> {
        val db = dbHelper.readableDatabase
        val projection = arrayOf(cells.IDCell, cells.NameCell, cells.PathCell, cells.LengthCell,cells.StartCell, cells.StopCell, cells.ActiveCell)
        val cursor = db.query(values_names.TableName,projection,null, null,null,null,null)
        val i = 0
        with(cursor){
            while (moveToNext()){
                try {
                    music_data[i].SongId = getInt(getColumnIndexOrThrow(cells.IDCell))
                    music_data[i].SongName = getColumnIndexOrThrow(cells.NameCell).toString()
                    music_data[i].SongPath = getColumnIndexOrThrow(cells.PathCell).toString()
                    music_data[i].SongLength = getInt(getColumnIndexOrThrow(cells.LengthCell))
                    music_data[i].StartTime = getInt(getColumnIndexOrThrow(cells.StartCell))
                    music_data[i].StopTime = getInt(getColumnIndexOrThrow(cells.StopCell))
                    music_data[i].IsActive = getInt(getColumnIndexOrThrow(cells.ActiveCell))
                }catch (e:Exception){

                }
            }
        }
       return music_data
    }
    public fun updateDB(name : String,startTime : Int, stopTime : Int ,status : Int){
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(cells.StartCell,    startTime)
            put(cells.StopCell,     stopTime)
            put(cells.ActiveCell,   status)
        }
        val selection = "${cells.NameCell} LIKE ?"
        val selectionArgs = arrayOf(name)
        try{
            db.update(
                values_names.TableName,
                values,
                selection,
                selectionArgs
            )
        }catch (e:Exception){

        }

    }

}