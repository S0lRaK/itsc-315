import java.net.*;
import java.io.*;
import java.lang.reflect.*;

public class MyLoader {
   public static void main (String argv[]) throws Exception {

      URLClassLoader loader = new URLClassLoader(new URL[] { new URL("http://199.116.235.55/") });
    
      // Load class from class loader. argv[0] is the name of the class to be loaded
      Class c = loader.loadClass (argv[0]);

      Method m = c.getMethod("main", new Class[] {argv.getClass() });
      m.setAccessible(true);
      int mods = m.getModifiers();
      if(m.getReturnType() != void.class || !Modifier.isStatic(mods) || !Modifier.isPublic(mods)) {
         throw new NoSuchMethodException("main");
      }
      try {
         m.invoke(null, new Object[] { argv });
      } catch(IllegalAccessException e) {
      }
   }
}