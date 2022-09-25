# ���似��

&emsp;&emsp;��̬����һ��ָ�����࣬����ȡ�����е����е����ݡ����ҽ��ֽ����ļ���װ�ɶ��󣬲����ֽ����ļ��е����ݶ���װ�ɶ����������ڲ�����Щ��Ա����˵�����似�����Զ�һ������н��ʡ�  
&emsp;&emsp;����ĺô���������ǿ�˳������չ�ԡ�

## ˫��ί�ɻ���

&emsp;&emsp;��һ����������յ�������ص������ʱ��������ֱ��ȥ����ָ�����࣬���ǰ��������ί�и��Լ��ĸ�������ȥ���ء�ֻ�и��������޷�����������ʱ�򣬲Ż��ɵ�ǰ�����������������ļ��ء�  
&emsp;&emsp;java��֧�ֵ�������� :

1. Bootstrap ClassLoader �����������  
   &emsp;&emsp;��Ҫ�������Java������⣬%JRE_HOME%\lib�µ�rt.jar��resources.jar��charsets.jar��class�ȡ�
2. Extention ClassLoader ��׼��չ�������  
   &emsp;&emsp;��Ҫ�������Ŀ¼%JRE_HOME%\lib\extĿ¼�µ�jar����class�ļ���
3. Application ClassLoader Ӧ���������  
   &emsp;&emsp;��Ҫ������ص�ǰӦ�õ�classpath�µ�������.
4. User ClassLoader �û��Զ����������  
   &emsp;&emsp;�û��Զ�����������,�ɼ���ָ��·����class�ļ�

����֮��Ĳ㼶��ϵ :  
<img alt="img.png" height="500" src="img.png" width="200"/> һ����Ϊ��һ������һ��ĸ���������

### ΪʲôҪʹ��˫��ί�ɻ���

&emsp;&emsp;����String�࣬����java.lang���µģ���������ί�е�BootStrap ClassLoader�У����ձ�BootStrap ClassLoader���ء�  
&emsp;&emsp;���û��Զ�����࣬Ҳ��ί�е�BootStrap ClassLoader�У�����BootStrap ClassLoader��������أ��ͻ�ί�е�Extension
ClassLoader�У�����Extension ClassLoaderҲ��������أ�������Application ClassLoader���ء�  
&emsp;&emsp;�������ĺô��� :

1. ���Է�ֹ����API���۸ģ���֤�˰�ȫ�ԡ�   
   &emsp;&emsp;������Ŀ¼�´���һ��java.lang�����������Զ���һ��String�࣬��ô�����ǵ���String��ʱ������õ��Զ����String�ࡣ
2. ��ֹ����ظ����ء�  
   &emsp;&emsp;һ����ֻ����һ������������м��ء�

**ע�� : �����d�����Ӽ��d�������^���P�S���ǽM���P�S**  
&emsp;&emsp;&emsp;**��ClassLoader��е�parentָ�򸸼��d����**

### ˫��ί�ɻ���ʵ��

Դ������ClassLoader���loadClass()�С�

```java
protected Class<?> loadClass(String name,boolean resolve)
		throws ClassNotFoundException
		{
synchronized (getClassLoadingLock(name)){
		// First, check if the class has already been loaded
		Class<?> c=findLoadedClass(name);
		if(c==null){
		long t0=System.nanoTime();
		try{
		if(parent!=null){
		c=parent.loadClass(name,false);
		}else{
		c=findBootstrapClassOrNull(name);
		}
		}catch(ClassNotFoundException e){
		// ClassNotFoundException thrown if class not found
		// from the non-null parent class loader
		}
		
		if(c==null){
		// If still not found, then invoke findClass in order
		// to find the class.
		long t1=System.nanoTime();
		c=findClass(name);
		
		// this is the defining class loader; record the stats
		PerfCounter.getParentDelegationTime().addTime(t1-t0);
		PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
		PerfCounter.getFindClasses().increment();
		}
		}
		if(resolve){
		resolveClass(c);
		}
		return c;
		}
		}
```

**���� :**

1. **���ж�������Ƿ���ع�**
2. **��û�м�������ø���������loadClass()�������м���**
3. **����������Ϊ����Ĭ��ʹ���������������Ϊ��������**
4. **����������ʧ�ܣ��׳�ClassNotFoundException�쳣���ٵ����Լ���findClass()�������м���**

## ��ļ��ع���

�������� :   
<img alt="img_2.png" height="400" src="img_2.png" width="550"/>

1. ����  
   ��Java����ֽ����ļ����ص������ڴ��У������ڴ��й�����Java��ԭ�ͣ���ģ����󣩡�
    1. ������ʱ��java������ļ��ز��� :
        1. �������ȫ������ȡ��Ķ�����������
        2. ������Ķ�����������Ϊ�������ڵ����ݽṹ
        3. ����java.lang.Class���ʵ������Ϊ�����������������ݵķ������
    2. ��ģ����class�ļ���λ��
        1. ��ģ�ʹ洢�ڷ�����
        2. class�ļ����ص�Ԫ�ռ�󣬻��ڶ��д���һ��Class�������ڷ�װ��λ�ڷ������ڵ����ݽṹ��ÿһ���඼��Ӧһ��Class����
           <img alt="img_1.png" height="400" src="img_1.png" width="300"/>
        3. ������ļ���  
           &emsp;&emsp;�����౾������������������𴴽���������jvm������ʱ������Ҫֱ�Ӵ����ģ����������Ԫ��������Ȼ��Ҫ�����������ȥ������  
           **����**
            1. ��������Ԫ���������������ͣ���ô��ѭ����ļ��ع��̵ݹ���غʹ�������A��Ԫ�����͡�
            2. jvmʹ��ָ����Ԫ�����ͺ�����ά���ഴ���µ������ࡣ
2. ����
    1. ��֤  
       &emsp;&emsp;ȷ��class�ļ����ֽ����а�������Ϣ���ϵ�ǰ��������󣬱�֤�����ص������ȷ�ԣ�����Σ�����������ȫ��  
       &emsp;&emsp;��Ҫ���� : �ļ���ʽ��֤��Ԫ������֤������������֤���ֽ�����֤��
    2. ׼��  
       &emsp;&emsp;Ϊ����������ڴ沢�����ø��������Ĭ�ϳ�ʼֵ������ֵ��  
       &emsp;&emsp;������final���ε�static����Ϊfinal�ڱ������ż�ͻ���䣬׼���׶λ���ʽ��ʼ����  
       &emsp;&emsp;���ﲻ��Ϊʵ�����������ʼ���������������ڷ������У���ʵ�����������Ŷ���һ����䵽java���С�
    3. ����  
       &emsp;&emsp;���ӿڣ��ֶκͷ����ķ�������ת��Ϊֱ�����á�  
       &emsp;&emsp;java�����Ϊÿһ���඼׼��һ�ŷ������������еķ����������У�����Ҫ����һ����ķ���ʱ��ֻҪ֪����������ڷ������ƫ������ͨ��������������������ת��Ϊֱ���������еķ������е�λ�ã����Ϳ���ֱ�ӵ��ø÷����ˡ�  
       &emsp;&emsp;����java������淶��û����ȷҪ������׶�һ��Ҫ����ִ�У���hotspot�У����ռ��أ���֤��׼���ͳ�ʼ����˳��ִ�У������ӽ׶εĽ�����������������jvmִ�����ʼ��֮����ִ�С�
3. ��ʼ��
    1. ��ʼ���׶ξ���ִ���๹��������`<clinit>()`�Ĺ��̡�
    2. �˷������趨�壬��javac�������Զ��ռ����е�����������ĸ�ֵ�����;�̬������е����ϲ�������
    3. ������������ָ������Դ�ļ��г��ֵ�˳��ִ�С�
    4. `<clinit>()`��ͬ����Ĺ�����������������������������ӽ��µ�<init>()����
    5. ��������и��࣬JVM�ᱣ֤�����`<clinit>()`ִ��ǰ�������`<clinit>()`�Ѿ�ִ����ϡ�
    6. ��������뱣֤һ�����`<clinit>()`�����ڶ��߳��±�ͬ��������

## User user = new User();�ļ���

![img_3.png](img_3.png)

## ����Ļ���ԭ��

&emsp;&emsp;�ڵ��õ�����ʱ�ͻ�ͨ������������ڴ��б���������Ϣ��ֻ��һ�ݣ���������ǻ�ȡ�������ڴ��е���Ϣ�����ԶԸ�����в�����

## ���似����������

```java
import java.lang.reflect.InvocationTargetException;

public class CreatingByReflex {
	
	public static void main(String[] args) {
	}
	
	/**
	 * ����Class����ķ�ʽ
	 * @throws ClassNotFoundException
	 */
	@Test
	public void test2() throws ClassNotFoundException {
		Class<Emaple> aClass1 = Emaple.class;
		Class<?> aClass = Class.forName("com/xiaoyi/Emaple.java");
	}
	
	/**
	 * ͨ��������
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 */
	@Test
	public void test1()
			throws InstantiationException, IllegalAccessException, NoSuchMethodException,
			InvocationTargetException {
		Emaple emaple1 = Emaple.class.getDeclaredConstructor().newInstance();
		Emaple emaple2 =
				Emaple.class.getDeclaredConstructor(Integer.class, String.class).newInstance(1, "hello");
	}

}
```

**˵��**  
&emsp;&emsp;����Java�в�����ʹ��ͨ��Class����ֱ�ӵ���newInstance()�����������Ƽ�ʹ���ȵ���getDeclaredConstructor()�ٵ���newInstance()
�������ڽ������������ж���ʹ���Ƽ��ķ�����

## �����ȡ��Ա����

### ����Ա���Ը�ֵ

```java
public class AssignForFlied {
	
	public static void main(String[] args)
			throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException,
			NoSuchMethodException, InvocationTargetException, InstantiationException {
		// ����Class����
		Class<?> clazz = Class.forName("com.xiaoyi.domain.Emaple");
		// ͨ������������Emapleʵ��
		Emaple emaple = (Emaple) clazz.getConstructor().newInstance();
		// ��ȡ��Ա����
		Field id = clazz.getDeclaredField("id");
		// ���÷���Ȩ��
		id.setAccessible(true);
		// ��ֵ
		id.set(emaple, 12);
		System.out.println(emaple.toString());
	}
}
```

**˵��**  
&emsp;&emsp;�ڸ�˽�еĳ�Ա���Ը�ֵ��ʱ��Ҫ������Ȩ�ޡ�����˽�з���Ҳ����ˡ�

### ���÷���

```java
public class InvokingMethod {
	public static void main(String[] args)
			throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
			InstantiationException, IllegalAccessException {
		// ����Class����
		Class<?> aClass = Class.forName("com.xiaoyi.domain.Emaple");
		// ����Emapleʵ��
		Emaple emaple = (Emaple) aClass.getDeclaredConstructor().newInstance();
		// ��ȡ����
		Method hello = aClass.getDeclaredMethod("hello", String.class);
		// ����Ȩ��
		hello.setAccessible(true);
		// ���÷���
		hello.invoke(emaple, "jet");
	}
}
```