package com.example.listviewpersonalizado;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H\'J!\u0010\t\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005H\'\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\r"}, d2 = {"Lcom/example/listviewpersonalizado/ProductoDao;", "", "delete", "", "producto", "Lcom/hugobelman/listviewpersonalizado/Producto;", "getAll", "Landroidx/lifecycle/LiveData;", "", "insertAll", "", "([Lcom/hugobelman/listviewpersonalizado/Producto;)V", "update", "app_debug"})
public abstract interface ProductoDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM productos")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.hugobelman.listviewpersonalizado.Producto>> getAll();
    
    @androidx.room.Insert()
    public abstract void insertAll(@org.jetbrains.annotations.NotNull()
    com.hugobelman.listviewpersonalizado.Producto... producto);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.hugobelman.listviewpersonalizado.Producto producto);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.hugobelman.listviewpersonalizado.Producto producto);
}