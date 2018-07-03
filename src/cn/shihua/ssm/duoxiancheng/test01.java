package cn.shihua.ssm.duoxiancheng;

public class test01  extends Object{
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("hehehe");
		
		super.finalize();
	}
	
	public static void main(String[] args) {
		
		new test01();
		new test01();
		//System.gc();//这个方法不会立刻让垃圾回收器启动,是在告诉垃圾回收器,你需要启动.
						//垃圾回收器什么时候启动时它说了算
		new test01();
		System.gc();
		new test01();
		//System.gc();//运行垃圾回收器.(启动垃圾回收器)
					//直接走的是对象复写回收垃圾的方法
					//垃圾回收器启动之后,就会调用对象的finalize()方法,将对象进行回收.
		
		//垃圾回收器启动之后就会开启一个线程,和主线程(main函数的线程)来竞争CPU的资源,来执行各自的程序
		//CPU通过时间片机制来讲分配资源的使用权,这个分配是随机的,不知道先获取到CPU资源,来执行程序
		
		//注意:当jvm 结束时,他会强制结束这个进程所在的内存区域,即Java.exe这个程序被结束进程了,垃圾回收器即使没有回收完垃圾也不会执行啦
		
		//线程的任务一结束,线程就接收了,主线程结束了.
		
		//仅仅是主线程结束了,jvm的其他的线程还没有结束,还在运行.
		
		
		//总结:主线程一结束,虚拟机不一定结束.jvm中还有其他的线程还在运行中.
		 
	}

}
