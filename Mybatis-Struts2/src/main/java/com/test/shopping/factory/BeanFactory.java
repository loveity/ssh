package com.test.shopping.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author JUST-GO
 * 这是一个工厂的类。用于抽取dao或者action
 */
public class BeanFactory {
	/**
	 * 私有构造方法：不能让外面随便new对象
	 */
	private BeanFactory(){}
	private static Properties p = new Properties();
	private static Map<String, Object> beanMap = new HashMap<String, Object>();
	/**
	 * 这是静态代码块：只加载一次
	 */
	static{
		try {
			//类加载器。加载文件
			p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("bean.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 这里是获得一个接口对象
	 * @param <T>
	 * @return 接口对象形如IUserDao
	 */
	@SuppressWarnings("unchecked")
	public static <T> T newInstance(String className,Class<T> clzType){
		/**
		 * 步骤：①传入一个资源文件当中的名字，我们可以通过p拿到里面的权限路径
		 * 	        ②：通过反射拿到对应的对象
		 *    ③：返回对象
		 * 注意：可以进行避免强转就加泛型<T> T。传什么类型就返回什么类型的对象
		 *    可以限定必须是什么类型的，，，，
		 */
		
		try {
			//判断缓存中是否存在。存在就直接拿，不存在就通过反射
			Object obj = beanMap.get(className);
			if (obj==null) {
				//通过反射拿到对应的对象
				String clzname = p.getProperty(className);

				Class<?> clz = Class.forName(clzname);
				obj = clz.newInstance();
				if (!clzType.isInstance(obj)) {
					throw new RuntimeException("亲。类型错误了");
					
				}
				beanMap.put(className, obj);
			}
			return (T) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
