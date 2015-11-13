package org.usfirst.frc.team4525.robot.commands;

import org.usfirst.frc.team4525.robot.OI;
import org.usfirst.frc.team4525.robot.Robot;
import org.usfirst.frc.team4525.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class XboxClawController extends Command {

    public XboxClawController() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(OI.getMechButtonPressed(RobotMap.clawTiltUpButton)) {
    		Robot.claw.tiltUp();
    	} else if (OI.getMechButtonPressed(RobotMap.clawTiltDownButton)) {
    		Robot.claw.tiltDown();
    	}
    	
    	if(OI.getMechStickAxis(RobotMap.clawGripTrigger) > 0.75) {
    		Robot.claw.grab();
    	} else if (OI.getMechStickAxis(RobotMap.clawReleaseTrigger) > 0.75) {
    		Robot.claw.release();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.claw.release();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
