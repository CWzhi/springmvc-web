package cn.shihua.ssm.duoxiancheng;


/**
 * 卖票    四个窗口
 * 			资源是同一个(票)   同时卖(并发)  动作一样(同时进行)
 * @author chenweizhi
 *
 * 2018年7月2日
 */
class Ticket implements Runnable{//只封装线程任务------------>卖票
	
	//private static int num=100;//静态实现数据共享
	private  int num=100;	
	
	Object obj=new Object();
	
	public void run(){
	
		sell();
	}
	
	public void sell(){
		
	/*	for (int i = num; num >0; i--) {
			//if(num>0){
				 
				System.out.println(Thread.currentThread().getName()+":"+num--);
				//continue;
			//}
			//break;
			
		}*/
		
		while(true){
			synchronized(obj){//此处的对象是object对象也行
				
				if(num>0){
					/*try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
					System.out.println(this.num--+"---------"+Thread.currentThread().getName());
				}else{
					break;
				}
			}
			
		}
		
		
	}
}

public class SellTickets {
	
	public static void main(String[] args) {
		
		Ticket tic0 = new Ticket();//100张票  创建一个线程任务对象.
		Ticket tic1= new Ticket();//100张票
		Ticket tic2 = new Ticket();//100张票
		Ticket tic3 = new Ticket();//100张票
		Thread t1 = new Thread(tic0);
		Thread t2 = new Thread(tic0); 
		Thread t3 = new Thread(tic0);
		Thread t4 = new Thread(tic0);
		t1.start();//一个线程开启四次  报线程Thread-0java.lang.IllegalThreadStateException
						//线程状态改变异常,已经开启了,不能再开启.
		t2.start();
		t3.start();
		t4.start();
		
	}

}
