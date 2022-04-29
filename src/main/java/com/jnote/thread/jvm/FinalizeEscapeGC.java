package com.jnote.thread.jvm;

/**
 * @author bobwang
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;
    /**
     * @title 
     * @description 
     * @author admin 
     * @updateTime 2021/5/24 下午12:00 
     * @throws 
     */
    public void isAlive() {
        System.out.println("yes , i am still alive");
    }
    /**
     * @title 
     * @description 
     * @author admin 
     * @updateTime 2021/5/24 下午12:00 
     * @throws 
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no , i am dead");

        }
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no , i am dead 2 ");
        }
    }

}
