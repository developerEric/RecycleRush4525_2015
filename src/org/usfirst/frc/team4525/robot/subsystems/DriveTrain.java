
package org.usfirst.frc.team4525.robot.subsystems;

//import java.awt.Robot;

import org.usfirst.frc.team4525.robot.RobotMap;
import org.usfirst.frc.team4525.robot.commands.DriveWithXbox;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

	private Victor l1,l2,
				r1,r2;
	// Inversions
	
	// Dependances
	
	// Are we having two or four motors?!?
	private boolean quadMotorDrive = false;
	
	// System Variables;
	
	private boolean sprint = false;
	private boolean brakes = false;
	//
	// Axis'
	public enum AxisType {
		X_LeftRight,Y_UpDown;
	}
	
	public DriveTrain() {
		// Create super constructor
		super();
		//
		//
		l1 = new Victor(RobotMap.motor_left1);
		r1 = new Victor(RobotMap.motor_right1);
		if(RobotMap.motor_left2 != -1 && RobotMap.motor_right2 != -1) {
			l2 = new Victor(RobotMap.motor_left2);
			r2 = new Victor(RobotMap.motor_right2);
			quadMotorDrive = true;
		}
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithXbox());
    }
    
    private boolean isDeadband(double raw, AxisType axis) {
    	if(raw < 0) raw = raw*-1;
    	if(axis == AxisType.Y_UpDown) {
    		if(raw < RobotMap.controllerDeadband) return true;
    	} else if(axis == AxisType.X_LeftRight) {
    		if(raw < RobotMap.robotRotationDeadband) return true;
    	}
    	return false;
    }

	public void arcadeDrive(double offset, double power) {
		double leftSpeed, rightSpeed;
		
		// Check for deadbands
		if(isDeadband(power, AxisType.Y_UpDown)) power = 0;
		if(isDeadband(offset, AxisType.X_LeftRight)) offset = 0;
		
		if(!sprint) power = power*RobotMap.notSprintSpeedCap;
		
		/* Make the controller corispondent to the direction of motors:
		 * The controller is inverted anyways, so...
		 */
		if (RobotMap.controlsInvertXY) {
			power = power*-1;
			offset = offset*-1;
		}
		
		// Calculate Left/Right motor power values:
		if (power > 0) {
			if (offset > 0) {
				leftSpeed = power - offset;
				rightSpeed = Math.max(power, offset);
			} else {
				leftSpeed = Math.max(power, -offset);
				rightSpeed = power + offset; // could overflow 1
			}
		} else {
			if (offset > 0) {
				leftSpeed = -Math.max(-power, offset);
				rightSpeed = power + offset;
			} else {
				leftSpeed = power - offset;
				rightSpeed = -Math.max(-power, -offset);
			}
		}
		setLeft(leftSpeed);
		setRight(rightSpeed);
	}
	
	public void tankDrive(double left, double right) {
		setLeft(left);
		setRight(right);
	}
	
	private void setLeft(double value) {
		if(brakes) value = 0;
		l1.set(value);
		if(quadMotorDrive)  l2.set(value);
	}

	private void setRight(double value) {
		if(brakes) value = 0;
		r1.set(value);
		if(quadMotorDrive)  r2.set(value);
	}
	
	// OTHER METHODS
	
	public void setBrake(boolean apply) {
		brakes = apply;
	}
	
	public void setSprint(boolean apply) {
		sprint = apply;
	}
	
}

