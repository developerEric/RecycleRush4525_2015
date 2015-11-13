package org.usfirst.frc.team4525.robot.commands;

import org.usfirst.frc.team4525.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveSpin extends Command {

	private int degrees;
	private double speed;
	
	private double left,right;
	
	
	// Positive value goes right
	// Negative value to the left
	
    public DriveSpin(int degrees, double speed) {
    	requires(Robot.drive);
    	requires(Robot.pos);
    	
    	this.degrees = degrees;
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.pos.reset();
    	if(speed < 0) speed = speed*-1;
    	calculateLeftRight();
    }
    
    private void calculateLeftRight() {
    	if(degrees < 0) {
    		left = speed;
    		right = -speed;
    	} else {
    		left = -speed;
    		right = speed;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(speed > 0.35 && (degrees < 0 && Robot.pos.angle() + 20 < degrees)||(degrees > 0 && Robot.pos.angle() + 20 > degrees)){
    		speed = 0.35;
    		calculateLeftRight();
    	}
    	if(!(degrees > 0 && Robot.pos.angle() > degrees) && !(degrees < 0 && Robot.pos.angle() < degrees)) {
    		Robot.drive.tankDrive(left, right);
    	} else {
    		this.end();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
