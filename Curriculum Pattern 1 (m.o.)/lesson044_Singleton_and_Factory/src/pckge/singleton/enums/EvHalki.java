package pckge.singleton.enums;

public class EvHalki implements Runnable {

	Robot robot;
	
	public void robotCagir() {
		robot = Robot.ROBOT;
		robot.calis();
	}

	@Override
	public void run() {
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		robotCagir();
	}
	
}
