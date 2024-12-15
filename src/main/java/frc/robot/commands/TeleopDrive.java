// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Drive;

public class TeleopDrive extends Command {
  private Drive drive;
  DoubleSupplier ySpeedSup;
  DoubleSupplier zRotationSup;
  /** Creates a new TeleopDrive. */
  public TeleopDrive(Drive drive, DoubleSupplier ySpeedSup, DoubleSupplier zRotationSup) {
    this.drive = drive;
    this.ySpeedSup = ySpeedSup;
    this.zRotationSup = zRotationSup;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double ySpeedVal = MathUtil.applyDeadband(ySpeedSup.getAsDouble(), Constants.stickDeadband);
    double zRotationVal = MathUtil.applyDeadband(zRotationSup.getAsDouble(), Constants.stickDeadband);
    drive.drive(ySpeedVal, zRotationVal);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
