package cn.shihua.ssm.duoxiancheng;

class demo01 extends Thread{
	
	//thread的构造函数有有带参的  即给线程命名的的构造函数
	
	private String name;
	demo01(String name){//子类的有参构造
		super(name);//给线程命名
		this.name=name;
	}
	
	
	public void run(){//父类里的run做什么呢和我没有关系,我只管自己的run逻辑
		
		
		xunhuan();	
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
			System.out.println(Thread.currentThread().getName()+"===="+name+"-----i="+i+getName());
			
		}
	}
	
}

public class Mainxiancheng {

	public static void main(String[] args) {
		
		//Thread thread = new Thread();//创建线程对象,这就是创建一个线程
									//创建线程的目的:开启一条执行路径
									//开启执行路劲的目的:让一部分代码和另一部分代码同时执行
									//这部分代码称之为任务
						//运行的指定代码就是该执行路径的任务.
	//创建一个子类对象,创建一线程
		demo01 d1 = new demo01("小明");
		demo01 d2 = new demo01("小红");
		
		//我开启了两个线程,这两个线程都调用run方法 
		
		d1.start();//函数执行的时候进栈,执行完毕后出栈
		d2.start();//线程开启执行,Java jvm调用该线程的run方法.
		//Thread currentThread = Thread.currentThread();
		//System.out.println(currentThread.getName());
		System.out.println(4/0);
		d1.stop();
		//下面实现小明和小红可同时执行的多线程
					//即小明执行的代码在一条路径上,小红执行的代码在另外一条路径中,则CPU可以在两个路径中做切换
		//即创建一个线程			
		for (int i = 0; i < 10; i++) {
			
			System.out.println("Hello World!----"+i+"----"+Thread.currentThread().getName());
		}
	}
}
