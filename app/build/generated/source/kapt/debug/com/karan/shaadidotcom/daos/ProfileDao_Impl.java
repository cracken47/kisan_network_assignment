package com.karan.shaadidotcom.daos;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.karan.shaadidotcom.model.MatchStatus;
import com.karan.shaadidotcom.model.Profile;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ProfileDao_Impl implements ProfileDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Profile> __insertionAdapterOfProfile;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStatus;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ProfileDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProfile = new EntityInsertionAdapter<Profile>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `profile_table` (`uuid`,`name`,`age`,`gender`,`city`,`state`,`thumbnail`,`index`,`match_status`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Profile value) {
        if (value.getUuid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUuid());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getAge());
        if (value.getGender() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGender());
        }
        if (value.getCity() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCity());
        }
        if (value.getState() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getState());
        }
        if (value.getThumbnail() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getThumbnail());
        }
        stmt.bindLong(8, value.getIndex());
        stmt.bindLong(9, value.getMatchStatus());
      }
    };
    this.__preparedStmtOfUpdateStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE profile_table SET match_status = ? WHERE uuid = ? ";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM profile_table";
        return _query;
      }
    };
  }

  @Override
  public Object insertAll(final List<Profile> profiles, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfProfile.insert(profiles);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object updateStatus(final String uuid, final int newStatus,
      final Continuation<? super Unit> p2) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStatus.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, newStatus);
        _argIndex = 2;
        if (uuid == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, uuid);
        }
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfUpdateStatus.release(_stmt);
        }
      }
    }, p2);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public Object getAll(final Continuation<? super List<Profile>> p0) {
    final String _sql = "SELECT * FROM profile_table ORDER BY `index` ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<Profile>>() {
      @Override
      public List<Profile> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
          final int _cursorIndexOfThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnail");
          final int _cursorIndexOfIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "index");
          final int _cursorIndexOfMatchStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "match_status");
          final List<Profile> _result = new ArrayList<Profile>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Profile _item;
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            final String _tmpGender;
            _tmpGender = _cursor.getString(_cursorIndexOfGender);
            final String _tmpCity;
            _tmpCity = _cursor.getString(_cursorIndexOfCity);
            final String _tmpState;
            _tmpState = _cursor.getString(_cursorIndexOfState);
            final String _tmpThumbnail;
            _tmpThumbnail = _cursor.getString(_cursorIndexOfThumbnail);
            final int _tmpIndex;
            _tmpIndex = _cursor.getInt(_cursorIndexOfIndex);
            final int _tmpMatchStatus;
            _tmpMatchStatus = _cursor.getInt(_cursorIndexOfMatchStatus);
            _item = new Profile(_tmpUuid,_tmpName,_tmpAge,_tmpGender,_tmpCity,_tmpState,_tmpThumbnail,_tmpIndex,_tmpMatchStatus);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }

  @Override
  public Object getWithMatchStatus(final Continuation<? super List<MatchStatus>> p0) {
    final String _sql = "SELECT uuid, match_status FROM profile_table WHERE match_status != 0 ORDER BY `index` ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<MatchStatus>>() {
      @Override
      public List<MatchStatus> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
          final int _cursorIndexOfMatchStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "match_status");
          final List<MatchStatus> _result = new ArrayList<MatchStatus>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final MatchStatus _item;
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            final int _tmpMatchStatus;
            _tmpMatchStatus = _cursor.getInt(_cursorIndexOfMatchStatus);
            _item = new MatchStatus(_tmpUuid,_tmpMatchStatus);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }
}
