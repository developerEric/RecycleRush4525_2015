package org.usfirst.frc.team4525.robot.subsystems;

import org.usfirst.frc.team4525.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Limits extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private DigitalInput forwards_limit = new DigitalInput(RobotMap.boom_forwardLimit);
	private DigitalInput backwards_limit = new DigitalInput(RobotMap.boom_backwardsLimit);
	private DigitalInput upwards_limit = new DigitalInput(RobotMap.winch_topLimit);
	private DigitalInput floor = new DigitalInput(RobotMap.winch_bottomLimit);
	
	// Limit Switches  return true when NOT PRESSED

	public boolean isOnGround() {
		return !floor.get();
	}
	
	public boolean canRise() {
		return upwards_limit.get();
	}
	
	public boolean canMoveForwards() {
		return forwards_limit.get();
	}
	
	public boolean canMoveBackwards() {
		return backwards_limit.get();
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

