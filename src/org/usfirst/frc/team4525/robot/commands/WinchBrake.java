package org.usfirst.frc.team4525.robot.commands;

import org.usfirst.frc.team4525.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WinchBrake extends Command {

	private boolean kill = false;
	
    public WinchBrake() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.winch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.winch.brake();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return kill;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	kill = true;
    }
}
