package org.usfirst.frc.team4525.robot.commands;

import org.usfirst.frc.team4525.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClawTilt extends Command {

	public enum Position {
		UP,DOWN;
	}
	
	private Position pos;
	private boolean done = false;
	
    public ClawTilt(Position pos) {
    	requires(Robot.claw);
    	
    	this.pos = pos;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (pos == Position.UP) {
    		Robot.claw.tiltUp();
    	} else {
    		Robot.claw.tiltDown();
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
