package com.jnote.thread.jvm;

public class RuntimeConstantPoolOOM2 {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("Ja").append("va").toString();
        System.out.println(str2.intern()==str2);

        String str3 = new StringBuilder("计算机").append("软件1").toString();
        System.out.println(str3.intern() == str3);

        String str4 = new StringBuilder("Ja").append("va1").toString();
        System.out.println(str4.intern()==str4);

        String str5 = new StringBuilder("Syste").append("m").toString();
        System.out.println(str5.intern()==str5);
    }
}
