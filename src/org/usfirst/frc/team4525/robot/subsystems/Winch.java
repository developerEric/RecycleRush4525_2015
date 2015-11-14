package org.usfirst.frc.team4525.robot.subsystems;

import org.usfirst.frc.team4525.robot.RobotMap;
import org.usfirst.frc.team4525.robot.commands.XboxWinchController;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Talon winchUD = new Talon(RobotMap.motor_winchUD);
	private Talon winchLR = new Talon(RobotMap.motor_winchLR);
	private Encoder encoder = new Encoder(RobotMap.winchEncoderSignalA, RobotMap.winchEncoderSignalB,false, EncodingType.k4X);
	
	private double brakePower;
	
	
	public enum ForwardBack {
		Forward(1),Backward(-1);
		
		private final double inputValue;
		
		ForwardBack(double inputValue) {
			this.inputValue = inputValue;
		}
		public double get() {
			return inputValue;
		}
	}
	
	// Up Down Movement
	
	public int yPosition() {
		return (int)encoder.getDistance();
	}
	
	public void resetY() {
		encoder.reset();
	}
	
	public void moveY(double speed){
		winchUD.set(speed);
	}
	
	
	// LR Movement
	
	public void moveX(double forwardback) {
		winchLR.set(forwardback);
	}
	
	// Brake
	
	public double brake() {
		if(!encoder.getStopped()) {
			if(!encoder.getDirection()) {
				brakePower += RobotMap.winchBrakePower;
			} else if(brakePower > 0) {
				brakePower -= RobotMap.winchBrakePower;
			}
		}
		moveY(brakePower);
		return brakePower;
	}
	
	public boolean tillBrake() {
		if(!encoder.getStopped()) {
			if(!encoder.getDirection()) {
				brakePower += (RobotMap.winchBrakePower*2);
			} else if(brakePower > 0) {
				brakePower -= (RobotMap.winchBrakePower*2);
			}
			moveY(brakePower);
		}
		return encoder.getStopped();
	}
	
	
	public double getBrake() {
		return brakePower;
	}
	
	public void setBrake(double power) {
		brakePower = power;
	}
	
	public void brakeOff() {
		brakePower = 0;
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new XboxWinchController());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

