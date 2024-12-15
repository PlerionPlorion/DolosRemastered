// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
  DigitalOutput cannon1;
  DigitalOutput cannon2;
  DigitalOutput cannon3;
  DigitalOutput cannon4;
  DigitalOutput cannon5;
  DigitalOutput cannon6;
  DigitalOutput power;
  DigitalOutput linUp;
  DigitalOutput linDown;
  /** Creates a new Pneumatics. */
  public Pneumatics() {
    cannon1 = new DigitalOutput(0);
    cannon2 = new DigitalOutput(1);
    cannon3 = new DigitalOutput(2);
    cannon4 = new DigitalOutput(3);
    cannon5 = new DigitalOutput(4);
    cannon6 = new DigitalOutput(5);
    power = new DigitalOutput(6);
    linUp = new DigitalOutput(7);
    linDown = new DigitalOutput(8);
    cannon1.set(true);
    cannon2.set(true);
    cannon3.set(true);
    cannon4.set(true);
    cannon5.set(true);
    cannon6.set(true);
    linDown.set(true);
    power.set(false);
    linUp.set(false);
  }
  /* DIO IS FLIPPED FALSE = TRUE */
  public void actuateSequentially() {

    cannon1.set(false);
    Timer.delay(0.25);
    cannon2.set(false);
    Timer.delay(0.25);
    cannon3.set(false);
    Timer.delay(0.25);
    cannon4.set(false);
    Timer.delay(0.25);
    cannon5.set(false);
    Timer.delay(0.25);
    cannon6.set(false);
    Timer.delay(0.25);
    Timer.delay(1.0);
    cannon1.set(true);
    Timer.delay(0.25);
    cannon2.set(true);
    Timer.delay(0.25);
    cannon3.set(true);
    Timer.delay(0.25);
    cannon4.set(true);
    Timer.delay(0.25);
    cannon5.set(true);
    Timer.delay(0.25);
    cannon6.set(true);

  }
  public void actuate1() {

    cannon1.set(false);
    Timer.delay(1);
    cannon1.set(true);

  }
  public void actuate2() {

    cannon2.set(false);
    Timer.delay(1);
    cannon2.set(true);
  }

  public void actuate3() {

    cannon3.set(false);
    Timer.delay(1);
    cannon3.set(true);

  }
  public void actuate4() {

    cannon4.set(false);
    Timer.delay(1);
    cannon4.set(true);

  }
  public void actuate5() {

    cannon5.set(false);
    Timer.delay(1);
    cannon5.set(true);

  }
  public void actuate6() {

    cannon6.set(false);
    Timer.delay(1);
    cannon6.set(true);

  }
  public void linearUp() {
    power.set(true);
    linUp.set(true);
    linDown.set(true);
  }
  public void linearDown() {
    linUp.set(true);
    power.set(false);
    linDown.set(false);
  }
  public void linearStop() {
    linDown.set(true);
    power.set(false);
    linUp.set(false);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
