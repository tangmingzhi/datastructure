package iterview;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author tangkun
 * @date 2019-01-30
 */
public class SerializableSingleton implements Serializable {

    private static final long serialVersionUID = 1L;

    //内部类
    private static class MySingletonHandler{
        private static SerializableSingleton instance = new SerializableSingleton();
    }

    private SerializableSingleton(){}

    public static SerializableSingleton getInstance() {
        return MySingletonHandler.instance;
    }

    //该方法在反序列化时会被调用，该方法不是接口定义的方法，有点儿约定俗成的感觉
    protected Object readResolve() throws ObjectStreamException {
        System.out.println("调用了readResolve方法！");
        return MySingletonHandler.instance;
    }
}

