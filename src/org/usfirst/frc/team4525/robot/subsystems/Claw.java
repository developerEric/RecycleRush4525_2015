package org.usfirst.frc.team4525.robot.subsystems;

import org.usfirst.frc.team4525.robot.Piston;
import org.usfirst.frc.team4525.robot.RobotMap;
import org.usfirst.frc.team4525.robot.commands.XboxClawController;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Piston tilt = new Piston(RobotMap.tiltPosA, RobotMap.tiltPosB, false); // Moves up down
	private Piston claw = new Piston(RobotMap.gripPosA, RobotMap.gripPosB, false); // Grips/Ungrips
	
	public void tiltDown() {
		tilt.retract();
	}
	
	public void tiltUp() {
		tilt.extend();
	}
	
	public void grab() {
		claw.extend();
	}
	
	public void release() {
		claw.retract();
	}

    public void initDefaultCommand() {
    	tiltUp();
    	release();
    	
        // Set the default command for a subsystem here.
        setDefaultCommand(new XboxClawController());
    }
}

