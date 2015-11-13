package org.usfirst.frc.team4525.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// SYSTEM CONTROL SETTINGS ------------------>
	// DRIVE SETTINGS
	
	public final static int driveForwardBackward = XboxController.Axis.LeftY.get();
	public final static int driveLeftRight = XboxController.Axis.RightX.get();
	
	public final static int sprintDriveButton = XboxController.Button.A.get();
	public final static int stopDriveButton = XboxController.Button.B.get();
	
	public final static int winchMovingAxis = XboxController.Axis.LeftY.get();
	public final static int winchLRaxis = XboxController.Axis.RightY.get();
	
	public final static int clawGripTrigger = XboxController.Axis.TriggerR.get();
	public final static int clawReleaseTrigger = XboxController.Axis.TriggerL.get();
	public final static int clawTiltUpButton = XboxController.Button.X.get();
	public final static int clawTiltDownButton = XboxController.Button.B.get();
	
	// Xbox Controller Sensitivity
	public final static double controllerDeadband = 0.15,
					robotRotationDeadband = 0.15;
	
	// Speed Settings
	public final static double rotationSpeedMax = 0.9;
	public final static double notSprintSpeedCap = 0.8;
	
	// Controls Inverted
	public final static boolean controlsInvertXY = false;
	
	// PWM to RIO ------------------>
	// Motors
	public final static int motor_left1 = 0,
				motor_left2 = 1,
				motor_right1 = 2,
				motor_right2 = 3;
	
	public final static int motor_winchUD = 4,
						motor_winchLR = 5;
	
	// DIO Section
	
	public final static int limit_TopSwitch = 7,
						limit_BottomSwitch = 6,
						limit_FrontSwitch = 9,
						limit_BackSwitch = 8;
	
	// ANALOG TO RIO ------------------>
	// Gyro
	public final static int gyroIn = 0;
	
	// DIGITAL INPUT OUTPUT TO RIO ------------------>
	// Encoders
	
	// Wimch
	public final static int winchEncoderSignalA = 4, winchEncoderSignalB = 5;
	
	public final static double winchBrakePower = 0.005;
	
	public final static int encoderSignalA = 0,
				encoderSignalB = 1;
	public final static boolean reverseEncoder = false;
	public final static double encoderPulseMultiplier = 0.07; // 0.051
	
	// Winch Limits

	public final static int winch_bottomLimit = 6;
	public final static int winch_topLimit = 7;
	public final static int boom_forwardLimit = 8;
	public final static int boom_backwardsLimit = 9;
	
	/*
	 * 		boomFrontSwitch = new DigitalInput(9); // Front of boom
		boomBackSwitch = new DigitalInput(8); // End of boom
		boomTopSwitch = new DigitalInput(7); // Top of boom 
		boomBottomSwitch = new DigitalInput(6); // Bottom of Boom
	 */
	
	// PNEUMATICS
	// CLAW SOLENOIDS
	public final static int tiltPosA = 0,tiltPosB = 1;
	public final static int gripPosA = 2, gripPosB = 3;
	
}
