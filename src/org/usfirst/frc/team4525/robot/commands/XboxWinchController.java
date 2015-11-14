package org.usfirst.frc.team4525.robot.commands;

import org.usfirst.frc.team4525.robot.OI;
import org.usfirst.frc.team4525.robot.Robot;
import org.usfirst.frc.team4525.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class XboxWinchController extends Command {
	
    public XboxWinchController() {
        requires(Robot.winch);
        requires(Robot.limits);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    
    protected void execute() {
    	double posUD = OI.getMechStickAxis(RobotMap.winchMovingAxis)*-1;
    	double posLR = OI.getMechStickAxis(RobotMap.winchLRaxis);
    	
    	// Moving up and down
    	if (posUD < -0.75 || (Robot.limits.isOnGround() && posUD < 0)) {
    		Robot.winch.moveY(0);
    	} else if(Robot.winch.getBrake() < posUD && Robot.limits.canRise()) {
    		Robot.winch.moveY(posUD);
    	} else {
    		Robot.winch.brake();
    	}
    	// Moving left & right
    	if ((posLR > 0.75 || posLR < -0.75) && ((Robot.limits.canMoveForwards() && posLR < 0) || (Robot.limits.canMoveBackwards() && posLR > 0))){
    		Robot.winch.moveX(posLR);
    	} else {
    		Robot.winch.moveX(0);
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
