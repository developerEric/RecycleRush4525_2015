package org.usfirst.frc.team4525.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class XboxController {
	private DriverStation ds = OI.ds;
	private final int port;

	public enum Button {
		A(1),B(2),X(3),Y(4),BumperL(5),BumperR(6), Back(7), Start(8),LStickPush(9),RStickPush(10);
		private final int inputValue;
		
		Button(int inputValue) {
			this.inputValue = inputValue; 
		}
		public int get() {
			return inputValue;
		}
	}
	
	public enum Axis {
		LeftX(0),LeftY(1),TriggerL(2),TriggerR(3),RightX(4),RightY(5),dPadX(6),dPadY(7);
		private final int inputValue;
		
		Axis(int inputValue) {
			this.inputValue = inputValue;
		}
		public int get() {
			return inputValue;
		}
	}
	
	// Constructor
	public XboxController(int port) {
		super();
		this.port = port;
		ds = DriverStation.getInstance();
	}
	
	public boolean buttonPressed(Button buttonType) {
		return ((0x1 << (buttonType.get() - 1)) & ds.getStickButtons(port)) != 0;
	}
	
	public double axisPosition(Axis axisType) {
		return ds.getStickAxis(port, axisType.get());
	}
}
