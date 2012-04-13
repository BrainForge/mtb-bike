package com.KernelLover.mtb.async;

public interface IAsyncCallback {
    // ===========================================================
    // Methods
    // ===========================================================
 
    public abstract void workToDo();
 
    public abstract void onComplete();
}