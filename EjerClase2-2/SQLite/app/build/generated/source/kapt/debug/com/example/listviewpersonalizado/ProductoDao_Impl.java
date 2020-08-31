package com.example.listviewpersonalizado;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.hugobelman.listviewpersonalizado.Producto;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ProductoDao_Impl implements ProductoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Producto> __insertionAdapterOfProducto;

  private final EntityDeletionOrUpdateAdapter<Producto> __deletionAdapterOfProducto;

  private final EntityDeletionOrUpdateAdapter<Producto> __updateAdapterOfProducto;

  public ProductoDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProducto = new EntityInsertionAdapter<Producto>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `productos` (`nombre`,`precio`,`descripcion`,`uid`) VALUES (?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Producto value) {
        if (value.getNombre() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNombre());
        }
        stmt.bindDouble(2, value.getPrecio());
        if (value.getDescripcion() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescripcion());
        }
        stmt.bindLong(4, value.getUid());
      }
    };
    this.__deletionAdapterOfProducto = new EntityDeletionOrUpdateAdapter<Producto>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `productos` WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Producto value) {
        stmt.bindLong(1, value.getUid());
      }
    };
    this.__updateAdapterOfProducto = new EntityDeletionOrUpdateAdapter<Producto>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `productos` SET `nombre` = ?,`precio` = ?,`descripcion` = ?,`uid` = ? WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Producto value) {
        if (value.getNombre() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNombre());
        }
        stmt.bindDouble(2, value.getPrecio());
        if (value.getDescripcion() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescripcion());
        }
        stmt.bindLong(4, value.getUid());
        stmt.bindLong(5, value.getUid());
      }
    };
  }

  @Override
  public void insertAll(final Producto... producto) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProducto.insert(producto);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Producto producto) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfProducto.handle(producto);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Producto producto) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfProducto.handle(producto);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Producto>> getAll() {
    final String _sql = "SELECT * FROM productos";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"productos"}, false, new Callable<List<Producto>>() {
      @Override
      public List<Producto> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
          final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final List<Producto> _result = new ArrayList<Producto>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Producto _item;
            final String _tmpNombre;
            _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            final double _tmpPrecio;
            _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
            final String _tmpDescripcion;
            _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
            final int _tmpUid;
            _tmpUid = _cursor.getInt(_cursorIndexOfUid);
            _item = new Producto(_tmpNombre,_tmpPrecio,_tmpDescripcion,_tmpUid);
            _result.add(_item);
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
}
