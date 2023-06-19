package com.xingquan.reference;

import java.lang.ref.*;
import java.lang.reflect.Field;

/**
 * java的引用测试，包括软引用、弱引用、幻象引用
 *
 *
 * 知识点：
 *  1、这几个引用对常量池中的数据不起作用，只能用于存放在堆中的对象，例如：DATA = "dataString"，GC后就不起作用。
 *
 *  2、软引用 -- SoftReference
 *      引用的对象不会在GC后立即回收，
 *      get()方法返回引用对象的数据；
 *      回收的时机暂不清楚，在内存不足的时候，会被回收，防止抛出OutOfMemoryError异常
 *      回收后引用对象会存放在ReferenceQueue队列中，然后队列数据也会被回收
 *  3、弱引用 -- WeakReference
 *      引用的对象会在GC后立即回收，
 *      get()方法返回引用对象的数据；
 *      回收后引用对象会存放在ReferenceQueue队列中，然后队列数据也会被回收
 *
 *  4、幻象引用 -- PhantomReference
 *      引用的对象会在GC后立即回收，
 *      get()方法返回null；
 *      回收后引用对象会存放在ReferenceQueue队列中，然后队列数据也会被回收
 *
 *  5、强引用 -- new Object()
 *      引用对象按照垃圾回收机制回收
 *      内存不足时，宁可抛出OutOfMemoryError异常，也不会被立即回收
 *
 * @author panjianghong
 * @created 2019-05-27 23:13:00
 */
public class ReferenceTest {

    public static volatile boolean FLAG;

    public static String DATA;


    ReferenceTest(ReferenceType referenceType) throws InterruptedException {
        FLAG = true;
        DATA = new String("dataString");

        //DATA = "dataString";


        Reference reference = null;

        ReferenceQueue<String> referenceQueue = new ReferenceQueue();

        switch (referenceType) {
            case SOFT_REFERENCE:
                reference = new SoftReference(DATA, referenceQueue);
                System.out.println("创建软引用");
                break;

            case WEAK_REFERENCE:
                reference = new WeakReference(DATA, referenceQueue);
                System.out.println("创建弱引用");
                break;

            case PHANTOM_REFERENCE:
                reference = new PhantomReference(DATA, referenceQueue);
                System.out.println("创建幻象引用");
                break;

            default:
                break;
        }

        /**
         * 循环取数据，查看对象的状态
         */
        Reference finalReference = reference;
        new Thread(){
           @Override
           public void run() {

               while (FLAG){
                   System.out.println("当前线程：" + Thread.currentThread().getName());

                   Object obj = referenceQueue.poll();

                   System.out.println("引用的数据: " + finalReference.get() + "\t队列的数据: " + obj);

                   if(null != obj) {
                       System.out.println("\n对象数据进入队列中");

                       try {
                          Field field = Reference.class.getDeclaredField("referent");
                          field.setAccessible(true);

                          Object data = field.get(finalReference);

                          System.out.println("队列中的数据：" + data);

                       } catch (Exception e) {
                           e.printStackTrace();
                       }

                   }

                   try {
                       Thread.currentThread().sleep(200);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

               }

           }
       }.start();



       Thread.currentThread().sleep(200);

       DATA = null;

       switch (referenceType) {
            case SOFT_REFERENCE:
                System.out.println("\n软引用GC----------");
                break;

            case WEAK_REFERENCE:
                System.out.println("\n弱引用GC----------");
                break;

            case PHANTOM_REFERENCE:
                System.out.println("\n幻象引用GC----------");
                break;

            default:
                break;
        }

       System.gc();

        Thread.currentThread().sleep(800);

        FLAG = false;

    }




    /**
     * 
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        new ReferenceTest(ReferenceType.SOFT_REFERENCE);
        Thread.currentThread().sleep(1000);
        System.out.println("\n\n\n");


        new ReferenceTest(ReferenceType.WEAK_REFERENCE);
        Thread.currentThread().sleep(1000);
        System.out.println("\n\n\n");


        new ReferenceTest(ReferenceType.PHANTOM_REFERENCE);
        Thread.currentThread().sleep(1000);

    }



}
