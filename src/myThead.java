import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class myThread extends Thread
{
   String filename;
   myThread(String fname, String tname)
   {
       super(tname);
       filename=fname;
   }
   public void run()
   {
       FileReader fr = null;
       try {
           fr = new FileReader(filename);
           int i;
           while((i=fr.read())!=-1)
           {
               Thread.sleep(100);
               System.out.println((char)i + " : "+getName());
       }
           fr.close();
       } catch (Exception e) {
           e.printStackTrace();
       }

   }
}
public class myThead {
public static void main(String args[]){
   myThread thread1 = new myThread("E:\\a.txt","Thread A");
myThread thread2 = new myThread("E:\\b.txt","Thread B");
thread1.start();
  thread2.start();
}
}