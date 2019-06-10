package com.jamesvanhallen.helsinkiwalker.extensions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001 B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u001e\u001a\u00020\u001fR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/jamesvanhallen/helsinkiwalker/extensions/Transaction;", "", "fm", "Landroidx/fragment/app/FragmentManager;", "fragment", "Landroidx/fragment/app/Fragment;", "type", "Lcom/jamesvanhallen/helsinkiwalker/extensions/Transaction$Type;", "(Landroidx/fragment/app/FragmentManager;Landroidx/fragment/app/Fragment;Lcom/jamesvanhallen/helsinkiwalker/extensions/Transaction$Type;)V", "addToBackStack", "", "getAddToBackStack", "()Z", "setAddToBackStack", "(Z)V", "enter", "", "getEnter", "()I", "setEnter", "(I)V", "exit", "getExit", "setExit", "popEnter", "getPopEnter", "setPopEnter", "popExit", "getPopExit", "setPopExit", "commit", "", "Type", "app_debug"})
public final class Transaction {
    private boolean addToBackStack;
    private int enter;
    private int exit;
    private int popEnter;
    private int popExit;
    private final androidx.fragment.app.FragmentManager fm = null;
    private final androidx.fragment.app.Fragment fragment = null;
    private final com.jamesvanhallen.helsinkiwalker.extensions.Transaction.Type type = null;
    
    public final boolean getAddToBackStack() {
        return false;
    }
    
    public final void setAddToBackStack(boolean p0) {
    }
    
    public final int getEnter() {
        return 0;
    }
    
    public final void setEnter(int p0) {
    }
    
    public final int getExit() {
        return 0;
    }
    
    public final void setExit(int p0) {
    }
    
    public final int getPopEnter() {
        return 0;
    }
    
    public final void setPopEnter(int p0) {
    }
    
    public final int getPopExit() {
        return 0;
    }
    
    public final void setPopExit(int p0) {
    }
    
    public final void commit() {
    }
    
    public Transaction(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentManager fm, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.NotNull()
    com.jamesvanhallen.helsinkiwalker.extensions.Transaction.Type type) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/jamesvanhallen/helsinkiwalker/extensions/Transaction$Type;", "", "(Ljava/lang/String;I)V", "ADD", "REPLACE", "app_debug"})
    public static enum Type {
        /*public static final*/ ADD /* = new ADD() */,
        /*public static final*/ REPLACE /* = new REPLACE() */;
        
        Type() {
        }
    }
}