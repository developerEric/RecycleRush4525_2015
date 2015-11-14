package org.usfirst.frc.team4525.robot.commands;

import org.usfirst.frc.team4525.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ExtendBoom extends Command {

	public enum Position {
		Full_Forwards, Full_Backwards;
	}
	
	private Position pos;
	
	private boolean complete = false;
	
    public ExtendBoom(Position pos) {
    	requires(Robot.winch);
    	requires(Robot.limits);
    	
    	this.pos = pos;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Set the brake if we're above ground
    	if(!Robot.limits.isOnGround()) Robot.winch.brake();

    	if(pos == Position.Full_Backwards && Robot.limits.canMoveBackwards()) {
    		Robot.winch.moveX(1);
    	} else if(pos == Position.Full_Forwards && Robot.limits.canMoveForwards()) {
    		Robot.winch.moveX(-1);
    	} else {
    		this.end();
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return complete;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.winch.moveX(0);
    	complete = true;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.winch.moveX(0);
    }
}
