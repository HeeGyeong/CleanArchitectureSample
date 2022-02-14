package com.example.data.db.movie;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.data.model.movie.MovieEntity;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.Void;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MovieDao_Impl implements MovieDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MovieEntity> __insertionAdapterOfMovieEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllMovies;

  public MovieDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMovieEntity = new EntityInsertionAdapter<MovieEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `movie` (`actor`,`director`,`image`,`link`,`pubDate`,`subtitle`,`title`,`userRating`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MovieEntity value) {
        if (value.getActor() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getActor());
        }
        if (value.getDirector() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDirector());
        }
        if (value.getImage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getImage());
        }
        if (value.getLink() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLink());
        }
        if (value.getPubDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPubDate());
        }
        if (value.getSubtitle() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSubtitle());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTitle());
        }
        if (value.getUserRating() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUserRating());
        }
      }
    };
    this.__preparedStmtOfDeleteAllMovies = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM movie";
        return _query;
      }
    };
  }

  @Override
  public Completable insertMovies(final List<MovieEntity> movies) {
    return Completable.fromCallable(new Callable<Void>() {
      @Override
      public Void call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMovieEntity.insert(movies);
          __db.setTransactionSuccessful();
          return null;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public Completable deleteAllMovies() {
    return Completable.fromCallable(new Callable<Void>() {
      @Override
      public Void call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllMovies.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return null;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllMovies.release(_stmt);
        }
      }
    });
  }

  @Override
  public Single<List<MovieEntity>> getAllMovies() {
    final String _sql = "SELECT * FROM movie";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createSingle(new Callable<List<MovieEntity>>() {
      @Override
      public List<MovieEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfActor = CursorUtil.getColumnIndexOrThrow(_cursor, "actor");
          final int _cursorIndexOfDirector = CursorUtil.getColumnIndexOrThrow(_cursor, "director");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfLink = CursorUtil.getColumnIndexOrThrow(_cursor, "link");
          final int _cursorIndexOfPubDate = CursorUtil.getColumnIndexOrThrow(_cursor, "pubDate");
          final int _cursorIndexOfSubtitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfUserRating = CursorUtil.getColumnIndexOrThrow(_cursor, "userRating");
          final List<MovieEntity> _result = new ArrayList<MovieEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final MovieEntity _item;
            final String _tmpActor;
            if (_cursor.isNull(_cursorIndexOfActor)) {
              _tmpActor = null;
            } else {
              _tmpActor = _cursor.getString(_cursorIndexOfActor);
            }
            final String _tmpDirector;
            if (_cursor.isNull(_cursorIndexOfDirector)) {
              _tmpDirector = null;
            } else {
              _tmpDirector = _cursor.getString(_cursorIndexOfDirector);
            }
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            final String _tmpLink;
            if (_cursor.isNull(_cursorIndexOfLink)) {
              _tmpLink = null;
            } else {
              _tmpLink = _cursor.getString(_cursorIndexOfLink);
            }
            final String _tmpPubDate;
            if (_cursor.isNull(_cursorIndexOfPubDate)) {
              _tmpPubDate = null;
            } else {
              _tmpPubDate = _cursor.getString(_cursorIndexOfPubDate);
            }
            final String _tmpSubtitle;
            if (_cursor.isNull(_cursorIndexOfSubtitle)) {
              _tmpSubtitle = null;
            } else {
              _tmpSubtitle = _cursor.getString(_cursorIndexOfSubtitle);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpUserRating;
            if (_cursor.isNull(_cursorIndexOfUserRating)) {
              _tmpUserRating = null;
            } else {
              _tmpUserRating = _cursor.getString(_cursorIndexOfUserRating);
            }
            _item = new MovieEntity(_tmpActor,_tmpDirector,_tmpImage,_tmpLink,_tmpPubDate,_tmpSubtitle,_tmpTitle,_tmpUserRating);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Single<List<MovieEntity>> getMoviesByTitle(final String title) {
    final String _sql = "SELECT * FROM movie WHERE title LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (title == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, title);
    }
    return RxRoom.createSingle(new Callable<List<MovieEntity>>() {
      @Override
      public List<MovieEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfActor = CursorUtil.getColumnIndexOrThrow(_cursor, "actor");
          final int _cursorIndexOfDirector = CursorUtil.getColumnIndexOrThrow(_cursor, "director");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfLink = CursorUtil.getColumnIndexOrThrow(_cursor, "link");
          final int _cursorIndexOfPubDate = CursorUtil.getColumnIndexOrThrow(_cursor, "pubDate");
          final int _cursorIndexOfSubtitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfUserRating = CursorUtil.getColumnIndexOrThrow(_cursor, "userRating");
          final List<MovieEntity> _result = new ArrayList<MovieEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final MovieEntity _item;
            final String _tmpActor;
            if (_cursor.isNull(_cursorIndexOfActor)) {
              _tmpActor = null;
            } else {
              _tmpActor = _cursor.getString(_cursorIndexOfActor);
            }
            final String _tmpDirector;
            if (_cursor.isNull(_cursorIndexOfDirector)) {
              _tmpDirector = null;
            } else {
              _tmpDirector = _cursor.getString(_cursorIndexOfDirector);
            }
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            final String _tmpLink;
            if (_cursor.isNull(_cursorIndexOfLink)) {
              _tmpLink = null;
            } else {
              _tmpLink = _cursor.getString(_cursorIndexOfLink);
            }
            final String _tmpPubDate;
            if (_cursor.isNull(_cursorIndexOfPubDate)) {
              _tmpPubDate = null;
            } else {
              _tmpPubDate = _cursor.getString(_cursorIndexOfPubDate);
            }
            final String _tmpSubtitle;
            if (_cursor.isNull(_cursorIndexOfSubtitle)) {
              _tmpSubtitle = null;
            } else {
              _tmpSubtitle = _cursor.getString(_cursorIndexOfSubtitle);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpUserRating;
            if (_cursor.isNull(_cursorIndexOfUserRating)) {
              _tmpUserRating = null;
            } else {
              _tmpUserRating = _cursor.getString(_cursorIndexOfUserRating);
            }
            _item = new MovieEntity(_tmpActor,_tmpDirector,_tmpImage,_tmpLink,_tmpPubDate,_tmpSubtitle,_tmpTitle,_tmpUserRating);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
