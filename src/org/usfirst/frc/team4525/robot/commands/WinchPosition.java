package org.usfirst.frc.team4525.robot.commands;

import org.usfirst.frc.team4525.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class WinchPosition extends Command {

	private int movetopos;
	private boolean moveUp = true;
	
	private boolean complete = false;
	
    public WinchPosition(int pos) {
    	requires(Robot.winch);
    	
    	this.movetopos = pos;
    	if(Robot.winch.yPosition() > pos) {
    		moveUp = false;
    	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.winch.brakeOff();
    	SmartDashboard.putString("Winch Position: ", Integer.toString(Robot.winch.yPosition()));
    	if(moveUp && Robot.winch.yPosition() < movetopos) {
    		Robot.winch.moveY(1);
    	} else if(!moveUp && Robot.winch.yPosition() > movetopos) {
    		Robot.winch.moveY(0);
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
    	//obot.winch.tillBrake();
    	complete = true;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
