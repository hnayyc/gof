package com.hnayyc.gof.proxy.imoocjdk;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 实现灵活的JDK动态代理
 */
public class Proxy {

    //TODO Class<?> infce这个参数改成Class<?>[] intfcs才能与JDK的Proxy.newProxyInstance()函数一致。
    public static Object newProxyInstance(ClassLoader loader, Class<?> infce, InvocationHandler handler) throws Exception {
        String rt = "\r\n";  // Windows下换行符
        String className = "MyProxy";  // 通过这个测试证明，生成的代理类的类名不需要以$开头。

        String methodStr = "";
        for(Method m : infce.getMethods()) {
            methodStr += "	@Override "
                    + rt + "	public void " + m.getName() + "() { "
                    + rt + "        try{"
                    + rt + "            Method md = " + infce.getSimpleName() + ".class.getMethod(\"" + m.getName() + "\");"
                    + rt + "            h.invoke(this, md);"
                    + rt + "        } catch(Exception e) { e.printStackTrace(); }"
                    + rt + "	} ";
        }


        String str =   "package com.hnayyc.coffee.aop.jdk; "
                + rt + "import java.lang.reflect.Method;"
                + rt + "import com.hnayyc.coffee.aop.jdk.InvocationHandler;"
                + rt + "public class " + className + " implements " + infce.getSimpleName() + " { "  // 根据JDK对class文件命名规则改为$Proxy0
                + rt + "	public " + className + "(InvocationHandler h) { "  // 使用getSimpleName()代替getName()，因为getName()会把包命也打印出来。
                + rt + "		this.h = h; "
                + rt + "	} "
                + rt + "    private InvocationHandler h;"
                + rt + methodStr
                + rt + "} ";

        String fileName = System.getProperty("user.dir") + "/target/classes/com/hnayyc/coffee/aop/jdk/" + className + ".java";
        System.out.println(fileName);
        File file = new File(fileName);
        FileUtils.writeStringToFile(file, str);

        // 编译
        // 拿到编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // 文件管理者
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        // 获取文件
        Iterable units = fileMgr.getJavaFileObjects(fileName);
        // 编译任务
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
        // 进行编译
        t.call();
        fileMgr.close();

        // load到内存
//        ClassLoader cl = ClassLoader.getSystemClassLoader();
//        Class c = cl.loadClass("com.hnayyc.coffee.aop.jdk." + className);

        // 使用传入的loader参数load到内存
        Class c = loader.loadClass("com.hnayyc.coffee.aop.jdk." + className);
        System.out.println(c.getName());

        Constructor ctr = c.getConstructor(InvocationHandler.class);
        return ctr.newInstance(handler);
    }

    public static Object newProxyInstance(Class infce, InvocationHandler h) throws Exception {
        String rt = "\r\n";  // Windows下换行符
        String className = "MyProxy";  // 通过这个测试证明，生成的代理类的类名不需要以$开头。

        String methodStr = "";
        for(Method m : infce.getMethods()) {
            methodStr += "	@Override "
            + rt + "	public void " + m.getName() + "() { "
            + rt + "        try{"
            + rt + "            Method md = " + infce.getSimpleName() + ".class.getMethod(\"" + m.getName() + "\");"
            + rt + "            h.invoke(this, md);"
            + rt + "        } catch(Exception e) { e.printStackTrace(); }"
            + rt + "	} ";
        }

        String str =   "package com.hnayyc.coffee.aop.jdk; "
                + rt + "import java.lang.reflect.Method;"
                + rt + "import com.hnayyc.coffee.aop.jdk.InvocationHandler;"
                + rt + "public class " + className + " implements " + infce.getSimpleName() + " { "  // 根据JDK对class文件命名规则改为$Proxy0
                + rt + "	public " + className + "(InvocationHandler h) { "  // 使用getSimpleName()代替getName()，因为getName()会把包命也打印出来。
                + rt + "		this.h = h; "
                + rt + "	} "
                + rt + "    private InvocationHandler h;"
                + rt + methodStr
                + rt + "} ";

        String fileName = System.getProperty("user.dir") + "/target/classes/com/hnayyc/coffee/aop/jdk/" + className + ".java";
        System.out.println(fileName);
        File file = new File(fileName);
        FileUtils.writeStringToFile(file, str);

        // 编译
        // 拿到编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // 文件管理者
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        // 获取文件
        Iterable units = fileMgr.getJavaFileObjects(fileName);
        // 编译任务
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
        // 进行编译
        t.call();
        fileMgr.close();

        // load导内存
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Class c = cl.loadClass("com.hnayyc.coffee.aop.jdk." + className);
        System.out.println(c.getName());

        Constructor ctr = c.getConstructor(InvocationHandler.class);
        return ctr.newInstance(h);
    }
}
