package cn.shihua.ssm.duoxiancheng;

class Demo implements Runnable{
	
	
	
	private String name;
	Demo(String name){//子类的有参构造
		
		this.name=name;
	}
	
	//实现接口的run方法
	public void run(){//里面封装的是线程任务
		xunhuan();	//线程任务
	}
	 
	public void xunhuan(){
		
		//System.out.println(4/0);
		for (int i = 0; i < 10; i++) {
			//this .getName()  获取当前线程名称  demo是thread的子类,具备父类的方法
			//只是获取的是对象的名字,	
			
			//获取当前运行时线程的名称
					//首先得获取运行时的线程对象Thread.currentThread()
					//由获得的线程对象获得线程的对象的名称
			//Thread.currentThread().getName()获取当前线程,并获取其名称
			//此处的name是成员变量的name,没有给他赋值
			//getName()是获得当前创建线程对象的名字
			System.out.println(Thread.currentThread().getName()+"===="+name+"-----i="+i);
			
		}
	}
	
}

public class ImplementsRunnablejiekou {

	public static void main(String[] args) {
		
		Demo d = new Demo("命名");//创建demo对象,demo对象可以调用run方法
		
		//线程构造实例化任务
		//runnable接口类型的对象中封装了线程任务
		Thread t1 = new Thread(d);//创建线程对象
		Thread t2 = new Thread(d);
		
		//调用之前线程得有任务.
		t1.start();//执行线程任务
		t2.start();
		//Demo d1 = new Demo("小明");//不是线程对象
		//Demo d2 = new Demo("小红");//直接创建的对象不是线程对象
		//d1.start();
		//d2.start();
		for (int i = 0; i < 10; i++) {
			
			System.out.println("Hello World!----"+i+"----"+Thread.currentThread().getName());
		}
	}
}
