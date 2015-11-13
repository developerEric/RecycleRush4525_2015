package org.usfirst.frc.team4525.robot.commands;

import org.usfirst.frc.team4525.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Claw extends Command {

	
	
	public enum Position {
		GRIP,OPEN;
	}
	
	private Position setting;
	private boolean done = false;
	
    public Claw(Position setting) {
    	this.setting = setting;
    	requires(Robot.claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(setting == Position.GRIP) {
    		Robot.claw.grab();
    	} else {
    		Robot.claw.release();
    	}
    	this.end();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    	done = true;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
