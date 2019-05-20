package jvm;


import java.io.*;

/**
 * @author tangkun
 * @date 2019-04-27
 */
public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    private String path;

    public MyTest16(String classLoaderName){
        //将系统类加载当做该类加载器的父类加载器
        super();
        this.classLoaderName = classLoaderName;
    }

     public MyTest16(ClassLoader parent, String classLoaderName){
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        MyTest16 loader1 = new MyTest16("loader1");
      // loader1.setPath("D:\\workspace\\tank\\jvm\\out\\production\\classes");
        loader1.setPath("D:\\workspace\\tank\\datastructure\\out\\");
        Class<?> clazz = loader1.loadClass("jvm.Test");
        Object o = clazz.newInstance();
        System.out.println(o.getClass().getClassLoader());

        System.out.println(o);
       // test(loader1);

    }

    private byte[] loadClassData(String name){

        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        try{
            //this.classLoaderName = this.classLoaderName.replace(".", "/");

            is = new FileInputStream(new File(this.path + name.replace(".", "/") + fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            //while (-1 != (is.read())){
            while (-1 != (ch = is.read())){
                baos.write(ch);
            }

            data = baos.toByteArray();
        }catch (Exception ex){
         ex.printStackTrace();
        }finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return data;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] data = this.loadClassData(className);
        return this.defineClass(className, data, 0, data.length);
    }





}
